package com.example.demo.dto;
import java.io.Serializable;

import lombok.Data;
/**
 * ReactNativeからの BBS書き込み　リクエストパラメータの入れ物
 */
@Data
public class BbsAddRequest implements Serializable {
  /**
   * ユーザー名
   */
	  //private Long id;
	  private String name;
	  private String text;
}