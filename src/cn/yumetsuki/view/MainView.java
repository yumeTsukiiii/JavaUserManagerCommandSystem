package cn.yumetsuki.view;

import cn.yumetsuki.framework.runner.Navigator;
import cn.yumetsuki.framework.util.InputUtil;
import cn.yumetsuki.framework.util.ViewLogger;
import cn.yumetsuki.framework.view.AbstractCommandView;

public class MainView extends AbstractCommandView {

    @Override
    public void onRunning() {
        ViewLogger.title("欢迎来到用户管理系统");
        try {
            String tipString = "1. 登录" + "\n"
                    + "2. 注册" + "\n"
                    + "0. 返回上一页" + "\n"
                    + "-1. 退出";
            ViewLogger.content(tipString);
            int input = InputUtil.receiveInt("请输入操作: ");
            switch (input) {
                case -1: exitSystem();
                case 0:
                    exit();
                    break;
                case 1:
                    Navigator.push(new LoginView());
                    break;
                case 2:
                    Navigator.push(new RegisterView());
                    break;
                default:
                    error("请输入对应操作!");
            }
        } catch (NumberFormatException e) {
            error("请输入数字!");
        }
    }
}
