package Character;

import java.util.Scanner;

public class GameManager {
    private Character player;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("======== 대학생 키우기 게임 ========");
        System.out.println("1. 튼튼한 캐릭터 (체력↑, 경험치↓)");
        System.out.println("2. 똑똑한 캐릭터 (체력↓, 경험치↑)");
        System.out.print("캐릭터를 선택하세요: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 개행 제거
        System.out.print("캐릭터의 이름을 입력하세요: ");
        String name = scanner.nextLine();

        if (choice == 1) {
            player = new StrongCharacter(name);
        } else {
            player = new SmartCharacter(name);
        }

        gameLoop();
    }

    private void gameLoop() {
        while (!player.isDroppedOut() && player.getGrade() < 5) {
            player.printStatus();
            System.out.println("\n1. 공부하기");
            System.out.println("2. 휴식하기");
            System.out.println("3. 관리자 테스트(exp + 350)");
            System.out.println("0. 종료");
            System.out.print("행동을 선택하세요: ");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    player.study();
                    break;
                case 2:
                    player.rest();
                    break;
                case 3:     // test
                    player.gainExp(350);
                    break;
                case 0:
                    System.out.println("\n[System] 게임을 종료합니다.");
                    return;
                default:
                    System.out.println("\n[System] 잘못된 선택입니다.");
            }

            if (player.isDroppedOut()) {
                System.out.println("\n[System] 체력이 0이 되어 퇴학당했습니다. 게임 종료.");
            }

            if (player.getGrade() >= 5) {
                System.out.println("\n[System] 4학년을 마치고 졸업했습니다. 축하합니다!");
            }
        }
    }
}
