package tech.washmore;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Parameter;
import tech.washmore.autocode.core.CodeMaker;

/**
 * Goal which touches a timestamp file.
 *
 * @goal code
 * @phase process-sources
 */
public class CodeMojo extends AbstractMojo {
    @Parameter(property = "config")
    private String config;

    public void execute() throws MojoExecutionException {
        try {
            System.out.println("config:" + config);
            CodeMaker.generate(System.getProperty("user.dir") + "/config.json");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
