package com.example.demo.dto;
import java.io.Serializable;

import lombok.Data;
/**
 * ログインフォームからの　リクエストパラメータの入れ物
 */
@Data
public class LoginRequest implements Serializable {
  /**
   * ユーザー名
   */
	  //private Long id;
	  private String name;
}