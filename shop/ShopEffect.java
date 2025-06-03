package demo2.shop;

import demo2.character.Character;

public class ShopEffect {

    //아이템 구매 시 플레이어의 경험치, 체력을 적용하는 메서드
    public static boolean applyItemEffect(Character character, Item item) {

        int currentExp = character.getExp();
        int currentHp = character.getEnergy();

        int price = item.getPrice();
        int value = item.getValue();

        if (currentExp < price){
            System.out.println("경험치가 부족합니다");
            return false;
        }

        int newExp = currentExp - price;
        int newHp = currentHp;

        if (item.getType() == ItemType.FOOD){
            newHp += value;
            System.out.println(item.getName() + "을 먹고 체력" + value + "회복!");
        } else if(item.getType() == ItemType.CLOTH){
            System.out.println(item.getName() + "을 입었습니다!");
        }

        // 상태 업데이트
        character.setExp(newExp);
        character.setEnergy(newHp);

        return true;
    }
}
