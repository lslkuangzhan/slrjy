package top.slrjy.edu.Config;

public class Result<T> {
    private String message;
    public int resultCode;
    public T data;
    public Result(String message,T data) {
        this.resultCode = 0;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}
