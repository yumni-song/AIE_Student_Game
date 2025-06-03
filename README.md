# main 패키지
- 게임 흐름 제어를 담당하는 패키지입니다.
- `action`, `character`, `ui` 패키지와 연결하였습니다.

---
|클래스|설명|
|------|-------|
|`GameManager`|전체 흐름 제어 - `main` 함수 포함|

---
수정사항
- 종료 메시지를 위한 부분을 수정했습니다.
- 이 과정에서 character 패키지의 `CharacterManager`에 추가한 내용이 있어서 함께 업로드했습니다.<br>
  -> `applyEffect()`가 void형이기 때문에 결과를 `GameManager`에 직접 반환할 수가 없어서 일단 `CharacterManager`가 `GameManager`를 생성자에서 넘겨받는 형식으로 구현하였습니다.
