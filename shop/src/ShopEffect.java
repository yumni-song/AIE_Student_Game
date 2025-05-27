package shop;

import character.Player; //이름은 임시

/*
    - 아이템 구매 시 실제로 플레이어 상태에 효과를 적용하는 클래스
    - 경험치가 충분한지 확인하고, 체력 회복 또는 착용 메시지를 출력
    - FOOD는 경험치 차감 후 체력 회복, CLOTH는 경험치 차감 후 착용 처리
*/


public class ShopEffect {

    //아이템 사용시 플레이어에게 효과를 적용하는 함수
    public static boolean applyItemEffect(Player player,Item item){

        //음식 구매 시 상태 변화
        if (item.getType() == shop.ItemType.FOOD) {
            
            if (player.getExp() >= item.getPrice()) { //이름은 chracter에서 어떤 거 쓰이는지에 따라 달라질 것 같아요
                player.changeExp(-item.getPrice());
                player.changeHealth(item.getHealthRestore());
                System.out.println(item.getName() + "먹고 체력" + item.getHealthRestore());
                return true;
            }
            //경험치가 부족할 때
            else {
                System.out.println("경험치가 부족합니다.");
                return false;
            }
        }

        //옷 구매 시 상태 변화
        else if (item.getType() == shop.ItemType.CLOTH){
            if(player.getExp() >= item.getPrice()){
                player.changeExp(-item.getPrice());
                System.out.println(item.getName() + "을(를) 입었습니다! 멋진데요?");
                return true;
            }
            
            //경험치가 부족할 때
            else{
                System.out.println("경험치가 부족해서 옷을 구매할 수 없습니다.");
                return false;
            }
            }

        return false;
    }
}
