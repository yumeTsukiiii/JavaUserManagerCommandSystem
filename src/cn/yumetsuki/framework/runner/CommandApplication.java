package cn.yumetsuki.framework.runner;

import cn.yumetsuki.framework.view.CommandView;

/**
 * 做了个简单的封装只是为了让这个应用看起来更牛皮
 * */
public class CommandApplication {

    public static <T extends CommandView> void runApplication(T view) {
        if (view != null) {
            view.start();
        }
    }
}
