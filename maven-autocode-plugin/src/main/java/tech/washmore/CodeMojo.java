package tech.washmore;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import tech.washmore.autocode.core.CodeMaker;

/**
 * Goal which touches a timestamp file.
 *
 * @goal code
 * @phase process-sources
 */
public class CodeMojo extends AbstractMojo {
    /**
     * @parameter expression="${configLocation}"
     */
    private String configLocation;

    public void execute() throws MojoExecutionException {
        try {
            if (configLocation == null) {
                configLocation = System.getProperty("user.dir") + "/config.json";
            }
            System.out.println("configPath:" + configLocation);
            CodeMaker.generate(configLocation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
