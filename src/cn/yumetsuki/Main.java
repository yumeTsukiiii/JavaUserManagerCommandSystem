package cn.yumetsuki;

import cn.yumetsuki.framework.runner.CommandApplication;
import cn.yumetsuki.view.MainView;

public class Main {

    public static void main(String[] args) {
        CommandApplication.runApplication(new MainView());
    }
}
