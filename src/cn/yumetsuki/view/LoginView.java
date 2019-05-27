package cn.yumetsuki.view;

import cn.yumetsuki.framework.runner.Navigator;
import cn.yumetsuki.framework.util.InputUtil;
import cn.yumetsuki.framework.util.ViewLogger;
import cn.yumetsuki.framework.view.AbstractCommandView;
import cn.yumetsuki.manager.AuthManager;
import cn.yumetsuki.model.UserModel;
import cn.yumetsuki.status.PresetStatus;
import cn.yumetsuki.status.Response;

public class LoginView extends AbstractCommandView {

    AuthManager manager = new AuthManager();

    @Override
    public void onRunning() {
        ViewLogger.title("登录");
        String username = InputUtil.input("请输入用户名: ");
        String password = InputUtil.input("请输入密码: ");
        Response<UserModel> response = manager.login(username, password);
        if (response.getCode() == 0) {
            tip("登录成功！");
            Navigator.pop(this);
        } else if (response.getCode() == PresetStatus.AuthError.code){
            error(PresetStatus.AuthError.message);
            Navigator.pop(this);
        }
    }
}
