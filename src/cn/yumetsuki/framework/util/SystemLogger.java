package cn.yumetsuki.framework.util;

import java.io.PrintStream;

public class SystemLogger {

    public static void log(String tag, String text) {
        println(tag, text, System.out);
    }

    public static void error(String tag, String text) {
        println(tag, text, System.err);
    }

    private static void println(String tag, String text, PrintStream out) {
        out.println("[" + tag + "]" + ": " + text);
    }
}
