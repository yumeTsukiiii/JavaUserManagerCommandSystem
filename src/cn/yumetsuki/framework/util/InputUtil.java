package cn.yumetsuki.framework.util;

import java.util.Scanner;

public class InputUtil {

    public static Scanner scanner = new Scanner(System.in);

    public static String input(String tip) {
        System.out.print(tip);
        return input();
    }

    public static String input() {
        return scanner.next();
    }

    public static int receiveInt(String tip) {
        System.out.print(tip);
        return receiveInt();
    }

    public static int receiveInt() {
        return scanner.nextInt();
    }

}
