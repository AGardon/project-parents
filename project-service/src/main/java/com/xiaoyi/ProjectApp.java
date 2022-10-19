package com.xiaoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @description ${NAME}
 * @author 王艺翔
 * @date ${DATE} ${TIME}
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@EnableOpenApi
@SpringBootApplication
public class ProjectApp {
  public static void main(String[] args) {
    SpringApplication.run(ProjectApp.class);
  }
}
