package cn.yumetsuki.view;

import cn.yumetsuki.framework.runner.Navigator;
import cn.yumetsuki.framework.util.InputUtil;
import cn.yumetsuki.framework.util.ViewLogger;
import cn.yumetsuki.framework.view.AbstractCommandView;
import cn.yumetsuki.manager.AuthManager;
import cn.yumetsuki.model.UserModel;
import cn.yumetsuki.status.PresetStatus;
import cn.yumetsuki.status.Response;

public class RegisterView extends AbstractCommandView {

    AuthManager manager = new AuthManager();

    @Override
    public void onRunning() {
        ViewLogger.title("注册");
        String username = InputUtil.input("请输入用户名: ");
        String password = InputUtil.input("请输入密码: ");
        String nickname = InputUtil.input("请输入昵称: ");
        Response<String> response = manager.register(username, password, nickname);
        if (response.getCode() == 0) {
            tip("注册成功！");
            Navigator.pop(this);
        } else if (response.getCode() == PresetStatus.UserExist.code){
            error(PresetStatus.UserExist.message);
            Navigator.pop(this);
        }
    }
}
