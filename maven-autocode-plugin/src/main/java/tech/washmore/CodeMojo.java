package tech.washmore;

import com.alibaba.fastjson.JSON;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import tech.washmore.autocode.core.CodeMaker;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
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

            if (configLocation == null) {
                configLocation = System.getProperty("user.dir") + "/config.json";
            }
            System.out.println("configPath:" + configLocation);
            CodeMaker.generateFromFileWithPluginClassLoader(configLocation, newLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
