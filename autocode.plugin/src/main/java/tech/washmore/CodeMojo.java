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
     * @parameter expression="${config}" default-value="config.json"
     */
    private String config;

    public void execute() throws MojoExecutionException {
        try {
            String configPath = System.getProperty("user.dir") + "/" + config;
            System.out.println("configPath:" + configPath);
            CodeMaker.generate(configPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
