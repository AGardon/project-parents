package com.xiaoyi.utils;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 王艺翔
 * @description SwaggerConfig
 * @date 2022/10/19 18:00
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github <a href="https://github.com/AGarden">...</a>
 */
@Slf4j
public class MD5Utils {
  public static String md5(String source) {

    // 1.判断 source 是否有效
    if (source == null || source.length() == 0) {
      // 2.如果不是有效的字符串抛出异常
      throw new RuntimeException("字符串不可为空");
    }
    try {
      // 3.获取 MessageDigest 对象
      String algorithm = "md5";
      MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
      // 4.获取明文字符串对应的字节数组
      byte[] input = source.getBytes();
      // 执行加密
      byte[] output = messageDigest.digest(input);
      // 6.创建 BigInteger 对象
      int signNum = 1;
      BigInteger bigInteger = new BigInteger(signNum, output);
      // 7.按照 16 进制将 bigInteger 的值转换为大写字符串
      int radix = 16;
      return bigInteger.toString(radix).toUpperCase();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {
    String salt = "644064";
    String userPwd = "123456";
    String newPwd = MD5Utils.md5(userPwd + salt);

    System.out.println(newPwd);
    // 在线MD5 破解工具 https://www.cmd5.com/
  }
}
