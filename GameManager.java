package Character;

import java.util.Scanner;

public class GameManager {
    // 변수 선언
    private Character player;
    private Scanner scanner = new Scanner(System.in);

    public void start() {   // 처음 캐릭터 생성
        System.out.println("======== 대학생 키우기 게임 ========");
        System.out.println("1. 튼튼한 캐릭터 (체력↑, 경험치↓)");
        System.out.println("2. 똑똑한 캐릭터 (체력↓, 경험치↑)");
        System.out.print("캐릭터를 선택하세요: ");

        // 캐릭터 이름 설정
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

    private void gameLoop() {   // 게임 진행
        while (!player.isDroppedOut() && player.getGrade() < 5) {
            player.printStatus();
            System.out.println("\n1. 과제하기");
            System.out.println("2. 공부하기");
            System.out.println("3. 알바하기");
            System.out.println("0. 종료");
            System.out.print("행동을 선택하세요: ");

            // 게임 내 선택지에 따른 결과 실행
            int action = scanner.nextInt();
            switch (action) {
                case 1:     // 수업듣기
                    player.lecture();
                    break;
                case 2:     // 과제하기
                    player.study();
                    break;
                case 3:     // 알바하기
                    player.work();
                    break;
                case 0:     // 게임 종료
                    System.out.println("\n[System] 게임을 종료합니다.");
                    return;
                default:    // 잘못된 입력
                    System.out.println("\n[System] 잘못된 선택입니다.");
            }

            if (player.isDroppedOut()) {    // 퇴학, 게임 종료
                System.out.println("\n[System] 체력이 0이 되어 퇴학당했습니다. 게임 종료.");
            }

            if (player.getGrade() >= 5) {   // 졸업, 게임 종료
                System.out.println("\n[System] 4학년을 마치고 졸업했습니다. 축하합니다!");
            }
        }
    }
}
