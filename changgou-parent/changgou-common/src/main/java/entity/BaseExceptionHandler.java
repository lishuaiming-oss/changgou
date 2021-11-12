package entity;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李帅明
 * @version 1.0
 * @date 2021/11/12 15:34
 */
@ControllerAdvice
public class BaseExceptionHandler {

    /*
    *  异常处理
    *  @Params e
    *  @return
    * */

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
