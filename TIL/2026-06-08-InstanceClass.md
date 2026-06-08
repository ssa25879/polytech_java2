# 2026 06 08 인스턴스와 클래스

----

## 오브젝트 도출

1. 오브젝트가 가지고 있을법한 **"속성"** 이나 **"동작"** 을 종류와 내용으로 정리
2. 가상 세계에 도출, 동작시키리

## 용어 정리

- **오브젝트** (Object) : 현실의 모든 객체
- **클래스** (Class) : 오브젝트를 가상세계 용도로 구체화 한 것
- **인스턴스** (Instance) : 클래스를 활용해 메모리상에 구현한 것

---

## 클래스 정의 효과

1. 정의한 클래스로 인스턴스 생성 가능
2. 생선한 인스턴르르 넣을 수 있는 새로운 변수의 타입이 이용 가능해짐 (Hero 클래스 정의 시 Hero 타입의 변수 생성 가능)

---

## 클래스명과 멤버변수명의 명명 규칙

- 클래스
    - 명사로 명명
    - 단어 맨 처음은 대문자로 (ex. Hero, MosterInfo 등)
- 필드
    - 명사
    - 최초 이외의 단어의 맨 처음은 대문자 (ex. level, items, itemList)
- 메서드
    - 동사
    - 최초 이외의 단어의 맨 처음은 대문자 (ex. attack, findWeakPoint)

---

정리
====

### 인스턴스와 클래스

- 인스턴스와 클래스는 다른것!
- 가상세계에서 활동하는것은 인스턴스(오브젝트)
- 생성 툴이 클래스

### 필드, 메서드

- 클래스에서는 속성 - 필드 , 동작 - 메서드로 선언
- final은 상수 선언
- this는 자기 자신의 인스턴스를 뜻하는 키워드

### 클래스타입 변수

- 클래스 정의시 클래스타입 변수 생성가능 (ex. Cleric클래스 생성하면 Cleric cleric = new Cleric(); 으로 변수선언 가능
- 클래스 타입 변수는 그 클래스의 인스턴스를 담을 수 있음

### 인스턴스화

- new 클래스명(); 을 사용하여 인스턴스 생성
- 변수에 인스턴스가 담겨있을 때, 변수명.필드명 / 변수명.메서드명()으로

---

### 기억 안나던거

1. **메모리** - 휘발성 저장공간
2. **Disk** - 비휘발성 저장공간
3. **리터럴** - "문자열", '문자', 숫자 등

---

### 과제

1. Cleric 클래스를 만듬
2. selfAid() 메서드 추가
    - mp를 5소모하고 hp를 maxHP로
3. pray(N) 메서드 추가
    - N + (0 ~ 2) 만큼 현재 mp 증가를 시킬때 증가량을 반환
    - maxMP초과시 maxMP까지만 회복 가능한 로직 구현

---

### 발생 이슈

- 신규 클래스 작성했을 때, 한글 출력이 깨지는 오류 (����) 발생
- Run -> Edit configurations... -> Templates -> VM options 에 아래 옵션 추가하여 해결

```
-Dfile.encoding=UTF-8
-Dsun.stdout.encoding=UTF-8
-Dsun.stderr.encoding=UTF-8
```

- 새로운 모듈 만들 때.
    - `The output path is not specified for module game` 오류 발생
    - 해결방법
        1. File -> Project Structure...
        2. 왼쪽 Modules 선택
        3. 모듈 이름 (상황에서는 game) 선택
        4. Paths 탭에서 경로 지정
        5. Apply -> OK ----- Apply 꼭 눌러야함
- Compiler output 경로 지정 안하면 다른 모듈이 실행 안됨
    - Project Structure -> Project 탭에서 지정하니 해결
- 이미 있는 이름의 모듈이라 생성이 안 될 경우
    1. settings.gradle 확인 후 수정
    2. File -> Project Structure... 이동
    3. 왼쪽 Modules 선택
    4. 이미 있는 이름이라 나온 모듈 선택 후 Delete
    5. Apply -> OK
