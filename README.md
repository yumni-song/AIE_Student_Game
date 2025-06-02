# 인공지능공학부생 키우기 게임 

---

### 1. [Character.java]
   - void printStatus() : 현재 캐릭터 정보 출력
   - void gainExp(int amount) : 경험치 증가 (amount: 변화값)
   - void changeEnergy(int amount) : 체력 변화
   - boolean isDroppedOut() : 체력이 0인지?
   - int getGrade() : 현재 몇 학년인지
   - abstract ActionEffect getEffect(ActionType type) : (추상 class) 수업, 과제, 알바 선택지 구별 -> ActionType에 PARTTIME(알바) 타입 추가 필요
---  
### 2. [SmartCharacter.java]
   - SmartCharacter(String name) : 시작 능력치 설정
   - ActionEffect getEffect(ActionType type) : type에 따라 경험치,체력 증감값 다르게 반영
---
### 3. [StrongCharacter.java]
   - StrongCharacter(String name) : 시작 능력치 설정
   - ActionEffect getEffect(ActionType type) ; type에 따라 경험치,체력 증감값 다르게 반영
---
### 4. [CharacterManager.java]
   - void createCharacter(int choice, String name) : 캐릭터 생성 (캐릭터 종류 선택, 캐릭터 이름)
   - void applyEffect(ActionType type) : 액션 효과 적용
       - 캐릭터가 생성되지 X 경우 처리
       - 경험치, 체력 변동
       - 현재 캐릭터 정보 출력
       - 체력이 다 되었을 경우 퇴학 (게임 종료)
       - 4학년을 마쳤을 경우 졸업 (게임 종료)
   - void printStatus() : 캐릭터 정보 출력
---   
### 5. [Main.java] (Main은 테스트를 위한 임시 코드 / 현재 사용 X)'

