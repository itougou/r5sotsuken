package com.example.demo.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Chat;
/**
 * 顧客情報 Mapper  （CHATテーブルのアクセスとJavaのロジックを結びつけるクラス）
 */
@Mapper
public interface ChatMapper {

    void add( Chat chat);
    List<Chat> findMany();
}