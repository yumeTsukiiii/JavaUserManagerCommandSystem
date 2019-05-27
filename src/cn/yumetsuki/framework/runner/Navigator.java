package cn.yumetsuki.framework.runner;

import cn.yumetsuki.framework.view.CommandView;

/**
 * 该类做的事情其实和CommandApplication一样，但提供了导航器的抽象
 * */
public class Navigator {

    public static <T extends CommandView> void push(T view) {
        if (view != null) {
            view.start();
        }
    }

    public static <T extends CommandView> void pop(T view) {
        if (view != null) {
            view.exit();
        }
    }
}
