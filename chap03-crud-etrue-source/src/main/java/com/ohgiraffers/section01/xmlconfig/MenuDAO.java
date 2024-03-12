package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.selectAllMenu");   // 필기 selectList 는 누군가 구현한메소드임

    }

    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {

        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);


    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int update(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.update("MenuMapper.update", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int code) {

        return sqlSession.delete("MenuMapper.delete",code);

    }


}