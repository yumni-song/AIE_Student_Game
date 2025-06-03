package demo2.shop;

import java.util.ArrayList;
import java.util.List;

/*
    - 상점에서 판매할 고정 아이템들을 리스트로 제공하는 클래스
    - 음식 3종, 옷 2종 등 고정 아이템을 list로 만들어 반환
    - UI에서 상점 아이템 버튼을 생성할 때 이 리스트를 사용하면 될 것 같아요!
*/

//상점에 등록된 기본 아이템 목록
public class ItemData {

    public static List<Item> getShopItems(){
        List<Item> list = new ArrayList<>();

        //음식 3종류
        list.add(new Item("물",10,10,ItemType.FOOD)); //경험치 -10, 체력회복량 +10 으로 설정
        list.add(new Item("순두부컵밥",10,20,ItemType.FOOD)); //경험치 -10, 체력회복량 +20 으로 설정
        list.add(new Item("아삿추",10,20,ItemType.FOOD)); //경험치 -10, 체력회복량 +20 으로 설정

        //옷 2종류
        list.add(new Item("과잠",30,0,ItemType.CLOTH));
        list.add(new Item("후드티",30,0,ItemType.CLOTH));

        return list;
    }


}

