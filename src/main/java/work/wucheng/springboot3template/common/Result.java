package work.wucheng.springboot3template.common;

import lombok.Data;

/**
 * 统一返回结果类
 * @param <T>
 */
@Data
public class Result<T>{
    private T data;
    private String message;
    private Integer code;

    public static <T> Result<T> success(String message){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        return result;
    }
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setData(data);
        result.setMessage("success");
        return result;
    }

    public static <T> Result<T> success(String message,T data){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> error(String message){
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }
}
