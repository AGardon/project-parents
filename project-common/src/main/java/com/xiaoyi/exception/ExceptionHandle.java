package com.xiaoyi.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 王艺翔
 * @description ExceptionHandle
 * @date 2022/10/18 17:54
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@ControllerAdvice
public class ExceptionHandle {
  @ExceptionHandler(value = Exception.class)
  public String exceptionHandler(Exception e) {
    System.out.println("未知异常！原因是:" + e);
    return e.getMessage();
  }
}
