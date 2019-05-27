package cn.yumetsuki.framework.util;

public class ViewLogger {

    public static void title(String title) {
        System.out.println("***********" + title + "**********");
    }

    public static void content(String content) {
        System.out.println(content);
    }

    public static void footer(String footer) {
        System.out.println("**********" + footer + "**********");
    }
}
