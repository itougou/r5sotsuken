package com.example.demo.entity;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 * チャット Entity　（CHATテーブルの1件分のデータの入れ物）
 */
@Data
@Getter
@Setter
public class Chat {
    public Chat(Long id, String name, String talk, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.talk = talk;
		this.talkDate = createDate;
	}
    public Chat(String name, String talk, Date createDate) {
		super();
		this.name = name;
		this.talk = talk;
		this.talkDate = createDate;
	}
	/**
     * ID
     */
    private Long id;
    /**
     * 名前
     */
    private String name;
    /**
     * 発言内容
     */
    private String talk;
    /**
     * 登録日時
     */
    private Date talkDate;

}