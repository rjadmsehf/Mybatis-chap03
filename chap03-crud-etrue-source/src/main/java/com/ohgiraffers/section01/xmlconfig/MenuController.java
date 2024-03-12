package com.ohgiraffers.section01.xmlconfig;

import org.w3c.dom.xpath.XPathResult;

import java.util.List;
import java.util.Map;

/* 필기
    Controller 의 역할
    view 즉 현재는 Application 에서 사용자가 입력한 정보를 파라미터 형태로 전달을 받으면
    전달 받은 값들을 검증하고나 추가적인 정보가 필요한 경우 가공을 한 뒤,
    service 쪽을로 전달하기 위한 인스턴스를 담고 서비스의 비지니스 로직을 담당하는 method 를 호출한다.
    또한 호출한 수행 결과를 반환 받아 어떠한 뷰를 다시 사용자에게 보여줄 것인지 결정하는 역할을 한다.
 */
public class MenuController {


    private final MenuService menuService;
    private final PrintResult printResult;
    public MenuController(){
        this.menuService = new MenuService();
        this.printResult =new PrintResult();
    }
    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        if (menuList != null){
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }


    public void selectMenuByCode(Map<String, String> parameter) {

        // 필기 사용자가 String 타입으로 입력 한 값을 서버 측에서 int 로 파싱
        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO menu = menuService.selectMenuByCode(code);
        if (menu != null){
            printResult.printMenu(menu);
        }else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registMenu(Map<String, String> parameter) {

        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu =new MenuDTO();

        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if (menuService.registMenu(menu)){
            printResult.printSuccessMessage("insert");
        }else {
            printResult.printErrorMessage("insert");
        }

    }


    public void updateMenu(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
        MenuDTO menu = new MenuDTO();

        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if(menuService.updatemenu(menu)){
            printResult.printSuccessMessage("update");
        }else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));


        if (menuService.deletemenu(code)){
            printResult.printErrorMessage("delete");
        }else {
            printResult.printErrorMessage("delete");
        }
    }
}
