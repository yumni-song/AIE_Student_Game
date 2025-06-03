# 인공지능공학부생 키우기 게임

### 수정사항

오류 없이 만들어주신 패키지들 실행해 보려고 다음과 같은 사항을 바꿨습니다.

- action, shop 패키지에서 `DemoStatusManager` import 해오는 걸 `Character` import로 변경  
- ui 패키지의 Clock 부분을 일단 주석 처리함  
- character에서 `PARTTIME` 정의하셔서 오류 없애기 위해 일단 `ActionType` 클래스에 `PARTTIME`을 추가하였습니다. 미니게임에서 이 enum 타입은 삭제하셔도 좋고 사용하셔도 괜찮습니다!  
-character클래스 에 있는 변수 접근을 위해 getter, setter를 추가하였습니다!
-shopEffect에서는 character.getExp(), character.setExp(newExp)로 받아오면 되게 하였습니다!
- *shop에서 이미지가 안 보이는 건 제가 이미지 경로 설정을 잘못해서 그럴 수도 있습니다!(이미지 경로만 잘 되면 실행 될 것 같습니다!)*

