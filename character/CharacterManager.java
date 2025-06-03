package demo2.character;

import demo2.action.ActionType;
import demo2.action.ActionEffect;

// 이전: 캐릭터 파트 GameManager //
public class CharacterManager {
    // 변수 선언
    private Character player;

    // 실행 코드에서 CharacterManeger.createCharacter(캐릭터 선택(0,1), 이름); 필요
    /* 1: 체력캐 / 그 외: 똑똑캐  */
    // 캐릭터 생성
    public void createCharacter(int choice, String name) {
        if (choice == 1) {
            player = new StrongCharacter(name);
        } else {
            player = new SmartCharacter(name);
        }
    }

    // 액션 효과 적용 메서드
    public void applyEffect(ActionType type) {
        // 캐릭터가 생성되지 않음
        if (player == null) {
            System.out.println("[System] 캐릭터가 없습니다.");
            return;
        }

        // 경험치, 체력 변동 및 캐릭터 정보 출력
        ActionEffect effect = player.getEffect(type);   // 직접 선택
        player.gainExp(effect.getExpChange());
        player.changeEnergy(effect.getEnergyChange());

        printStatus();

        // 퇴학, 게임 종료
        if (player.isDroppedOut()) {
            System.out.println("\n[System] 체력이 0이 되어 퇴학당했습니다. 게임 종료.");
        }

        // 졸업, 게임 종료
        if (player.getGrade() >= 5) {
            System.out.println("\n[System] 4학년을 마치고 졸업했습니다. 축하합니다!");
        }
    }

    // 캐릭터 정보 출력
    public void printStatus() {
        if (player != null) {
            player.printStatus();
        }
    }
}

