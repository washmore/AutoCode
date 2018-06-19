package tech.washmore.autocode.core.generator.base;

import tech.washmore.autocode.core.config.ConfigManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Washmore
 * @version V1.0
 * @summary 将生成的代码写入文件的工具类
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/15
 */
public class AutoCodeFileWriter {

    public static void writeStringToFile(String parent, String fileName, String content, boolean overwrite) throws IOException {
        File dic = new File(parent);
        if (!dic.exists()) {
            dic.mkdirs();
        }

        File file = new File(dic, fileName);
        if (!overwrite && file.exists()) {
            return;
        }

        file.createNewFile();

        OutputStream ops = new FileOutputStream(file);
        ops.write(content.toString().getBytes());
        ops.flush();
        ops.close();
        System.out.println("\t输出文件:" + file.getPath().replace(new File(ConfigManager.getConfig().getProject().getPath()).getPath(), ""));

    }
}
