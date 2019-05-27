package cn.yumetsuki.dao;

import cn.yumetsuki.entities.User;
import cn.yumetsuki.framework.util.FileUtil;
import cn.yumetsuki.model.UserModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 该类提供User文件的访问
 * */
public class UserDao {

    private String filePath = "out/production/JavaUserManagerCommandSystem/cn/yumetsuki/file/User.txt";

    public UserModel getUserByAuth(String username, String password) {

        //此处用了java8的流(Stream)及其操作符，以及lambda表达式(匿名函数)
        //这一段代码的意思是，读取文件中的所有行，转化称User实体，再选出username和password对应相等的User
        List<User> userList = FileUtil.readLines(filePath).stream()
                .map(this::formatUserFromString)
                .filter(item -> item.getUsername().equals(username)
                && item.getPassword().equals(password))
                .collect(Collectors.toList());

        if (userList.size() == 1) {
            UserModel model = new UserModel();
            model.setNickname(userList.get(0).getNickname());
            model.setUsername(userList.get(0).getUsername());
            return model;
        }
        return null;
    }

    public void addUser(String username, String password, String nickname) {

        List<User> userList = FileUtil.readLines(filePath).stream()
                .map(this::formatUserFromString)
                .filter(item -> item.getUsername().equals(username))
                .collect(Collectors.toList());

        if (userList.size() != 0) {
            throw new RuntimeException("用户已存在");
        }

        String userString = username + "#" + password + "#" + nickname;
        FileUtil.appendLine(filePath, userString);
    }

    /**
     * 分割字符串来生成User实例
     * */
    private User formatUserFromString(String userString) {
        User user = new User();
        String[] userInfoArr = userString.split("#");
        user.setUsername(userInfoArr[0]);
        user.setPassword(userInfoArr[1]);
        user.setNickname(userInfoArr[2]);
        return user;
    }

}
