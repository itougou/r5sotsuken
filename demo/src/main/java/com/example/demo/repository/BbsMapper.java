package com.example.demo.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Bbs;
/**
 * BBS Mapper  （BBSテーブルのアクセスとJavaのロジックを結びつけるクラス）
 */
@Mapper
public interface BbsMapper {

    void add( Bbs bbs );
    List<Bbs> findMany();
}