package com.example.demo.entity;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * BBSEntity　（BBSテーブルの1件分のデータの入れ物）
 */
@Data
@Getter
@Setter
public class Bbs {
	//フィールド
	private int id;
	private String name;
	private String text;
	private Date time;
	
	//コンストラクタ

	public Bbs(int id, String name, String text, Date time) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
		this.time = time;
	}
	public Bbs(String name, String text, Date time) {
		super();
		this.name = name;
		this.text = text;
		this.time = time;
	}
	
}
