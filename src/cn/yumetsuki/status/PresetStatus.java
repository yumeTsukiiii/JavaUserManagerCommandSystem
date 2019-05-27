package cn.yumetsuki.status;

public enum  PresetStatus {

    Success(0, ""),
    AuthError(-100, "用户名或密码错误"),
    UserExist(-101, "用户已存在");

    private PresetStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code;
    public String message;
}
