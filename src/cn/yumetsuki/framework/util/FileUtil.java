package cn.yumetsuki.framework.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> readLines(String filePath) {
        return readLines(new File(filePath));
    }

    /**
     * 该方法从文件中读取所有行并转换为List
     * */
    public static List<String> readLines(File file)  {
        try {
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file)
                    )
            );
            String s;
            while ((s = reader.readLine()) != null) {
                lines.add(s);
            }
            reader.close();
            return lines;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 该方法向文件中添加一行至末尾
     * */
    public static void appendLine(String filePath, String line) {
        File file = new File(filePath);
        try {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file, true)
                    )
            );
            writer.newLine();
            writer.append(line);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
