package cn.yumetsuki.framework.view;

import cn.yumetsuki.framework.util.SystemLogger;
import cn.yumetsuki.framework.util.ViewLogger;

/**
 * 抽象命令行view，完成基本View的操作，定义如何开始和跳出view
 * */
public abstract class AbstractCommandView implements CommandView {

    private boolean isRunning = false;

    abstract public void onRunning();

    @Override
    public void start() {
        isRunning = true;
        while (isRunning) {
            onRunning();
        }
    }

    @Override
    public void exit() {
        isRunning = false;
    }

    @Override
    public void exitSystem() {
        System.exit(0);
    }

    /**
     * 给子类用于打印提示的方法，这里用到了运行时反射的知识Class<*>获取类名
     * */
    protected void tip(String text) {
        SystemLogger.log(this.getClass().getSimpleName(), text);
    }

    protected void error(String text) {
        SystemLogger.error(this.getClass().getSimpleName(), text);
    }
}
