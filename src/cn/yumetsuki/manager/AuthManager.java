package cn.yumetsuki.manager;

import cn.yumetsuki.dao.UserDao;
import cn.yumetsuki.model.UserModel;
import cn.yumetsuki.status.PresetStatus;
import cn.yumetsuki.status.Response;

/**
 * 该类用作逻辑封装
 * */
public class AuthManager {

    private UserDao userDao = new UserDao();

    /**
     * 用户登录
     * */
    public Response<UserModel> login(String username, String password) {
        UserModel model = userDao.getUserByAuth(username, password);
        Response<UserModel> response = new Response<>();
        if (model != null) {
            response.setCode(PresetStatus.Success.code);
            response.setData(model);
        } else {
            response.setCode(PresetStatus.AuthError.code);
        }
        return response;
    }

    /**
     * 用户注册
     * */
    public Response<String> register(String username, String password, String nickname) {
        Response<String> response = new Response<>();
        try {
            userDao.addUser(username, password, nickname);
            response.setCode(PresetStatus.Success.code);
            response.setData("注册成功");
        } catch (RuntimeException e) {
            response.setCode(PresetStatus.UserExist.code);
            response.setData(PresetStatus.UserExist.message);
        }
        return response;
    }

}
