// 4. 아이템 사용 시 캐릭터에 적용되는 효과 처리
package shop;

/*
    - 아이템 구매 시 실제로 플레이어 상태에 효과를 적용하는 클래스
    - 경험치가 충분한지 확인하고, 체력 회복 또는 착용 메시지를 출력
    - FOOD는 경험치 차감 후 체력 회복, CLOTH는 경험치 차감 후 착용 처리
*/


import character.DemoStatusManager;

public class ShopEffect {

    //아이템 구매 시 플레이어의 경험치, 체력을 적용하는 메서드
    public static boolean applyItemEffect(DemoStatusManager character, Item item) {

        //Character 객체에서 exp,hp 불러오기
        int currentExp = character.getExp();
        int currentHp = character.getHp();

        //Shop의 물건들 가격(경험치), 체력 회복량 불러오기 
        int price = item.getPrice();
        int value = item.getValue();


        //경험치가 부족해 구매가 어려운 경우
        if (currentExp < price){
            System.out.println("경험치가 부족합니다");
            return false;
        }


        //적용할 새로운 경험치, 체력량
        int newExp = currentExp ;
        int newHp = currentHp ;


        //구매,체력 회복 과정
        if (item.getType() == ItemType.FOOD){
            newExp -= price;
            newHp += value;
            System.out.println(item.getName() + "을 먹고 체력" + value + "회복!");
        }else if(item.getType() == ItemType.CLOTH){
            newExp -= price;
            System.out.println(item.getName() + "을 입었습니다!");
        }

        //Character 객체에 적용
        character.updateStatus(newExp,newHp);
        return true;
    }
    }