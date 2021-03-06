package cn.yumetsuki.status;

/**
 * 该类用来给前方调用传递成果或者错误信息
 * */
public class Response<T> {

    private int code;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
