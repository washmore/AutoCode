package tech.washmore;

import com.alibaba.fastjson.JSON;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import tech.washmore.autocode.core.CodeMaker;
import tech.washmore.autocode.core.generator.base.AutoCodeFileWriter;
import tech.washmore.autocode.model.config.Config;
import tech.washmore.autocode.model.config.Db;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;

/**
 * Goal which touches a timestamp file.
 *
 * @goal code
 * @phase process-sources
 * @requiresDependencyResolution runtime
 */
public class CodeMojo extends AbstractMojo {
    /**
     * @parameter expression="${configLocation}"
     */
    private String configLocation;
    /**
     * @parameter expression="${databaseDriver}"
     */
    private String databaseDriver;
    /**
     * @parameter expression="${databaseUrl}"
     */
    private String databaseUrl;
    /**
     * @parameter expression="${databaseTablePrefix}" default-value=""
     */
    private String databaseTablePrefix;
    /**
     * @parameter expression="${databaseUsername}"
     */
    private String databaseUsername;
    /**
     * @parameter expression="${databasePassword}" default-value=""
     */
    private String databasePassword;

    /**
     * @parameter default-value="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;


    public void execute() throws MojoExecutionException {
        try {


            List runtimeClasspathElements = project.getRuntimeClasspathElements();
            URL[] runtimeUrls = new URL[runtimeClasspathElements.size()];
            for (int i = 0; i < runtimeClasspathElements.size(); i++) {
                String element = (String) runtimeClasspathElements.get(i);
                runtimeUrls[i] = new File(element).toURI().toURL();
            }
            URLClassLoader newLoader = new URLClassLoader(runtimeUrls,
                    Thread.currentThread().getContextClassLoader());

            if (databaseDriver != null) {
                Config config = new Config();
                String base = project.getModel().getGroupId() + "." + project.getModel().getArtifactId();
                Db db = config.getDb();
                db.setUrl(databaseUrl);
                db.setDriver(databaseDriver);
                db.setUsername(databaseUsername);
                db.setPassword(databasePassword);
                if (databaseTablePrefix != null) {
                    db.setTableNamePrefix(Arrays.asList(databaseTablePrefix.split(",")));
                }
                config.getDataFile().getMapper().setPath("mappers");
                config.getDataFile().getDao().setPackageName(base + ".dao");
                config.getDataFile().getService().setPackageName(base + ".service");
                config.getModel().setPackageName(base + ".model");
                CodeMaker.generateFromJsonWithPluginClassLoader(JSON.toJSONString(config), newLoader);
                AutoCodeFileWriter.writeStringToFile(
                        System.getProperty("user.dir"),
                        "config.json",
                        JSON.toJSONString(config, true),
                        true);
            } else {
                if (configLocation == null) {
                    configLocation = System.getProperty("user.dir") + "/config.json";
                }
                System.out.println("configPath:" + configLocation);
                CodeMaker.generateFromFileWithPluginClassLoader(configLocation, newLoader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
