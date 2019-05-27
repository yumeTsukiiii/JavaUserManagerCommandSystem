package cn.yumetsuki.framework.view;

/**
 * 一个命令行View，代表一个接受输入和跳出输入的状态
 * */
public interface CommandView {
    /**
     * View自启动方法
     * */
    void start();

    /**
     * View自关闭方法
     * */
    void exit();

    /**
     * 退出系统
     * */
    void exitSystem();
}
