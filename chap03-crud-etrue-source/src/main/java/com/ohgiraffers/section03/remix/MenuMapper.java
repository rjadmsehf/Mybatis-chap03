package com.ohgiraffers.section03.remix;



import java.util.List;


public interface MenuMapper {



    List<MenuDTO> selectAllmemnu();

        //필기 위에서 만든 results 결과 재사용하는 방법
MenuDTO selectMenuByCode(int code);

    int insertMenu(MenuDTO menu);

    int updateMenu(MenuDTO menuDTO);

    int deleteMenu(int del);
}
