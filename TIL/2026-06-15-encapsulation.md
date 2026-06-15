# 2026-06-15 캡슐화

## 과제 피드백

- `    Cleric() {
        throw new IllegalArgumentException("스탯을 입력하지 않은 클레릭은 생성될 수 없습니다.");
    }
` 같은 생성할 수 없어야 하는 경우에는 예외를 던지기 보다 생성자를 만들지 않고 그냥 두는게 낫다.

---

## 캡슐화란

- 실수로 속성을 덮어씌우던가, 잘못된 조작을 하는 등의 휴먼에러를 방지하기 위해 정해진 방법으로만 접근하도록 하는 것
- 사용 이유
    - 객체 내부 데이터를 함부로 변경하는 것을 방지
    - 코드의 안정성을 향상
    - 유지보수 용이

## 클래스에 대한 액세스 제어

- 클래스의 액세스 제어 지정방법과 범위

| 이름              | 기술 방법  | 접근 가능 범위            | 제한  |
|-----------------|--------|---------------------|-----|
| package private | 작성안함   | 자신과 같은 패키지에 소속된 클래스 | 엄격  |
| public          | public | 모든 클래스              | 느슨함 |

- non-public 클래스 특징
    - 클래스의 이름은 소스 파일 명과 달라도 됨
    - 1개의 소스 파일에 여러 클래스를 선언 할 수 있음

## 멤버 지정 정석

- 필드는 기본적으로 private
- 메서드는 기본적으로 public

## 클래스 지정 정석

- 이유가 없다면 public

## 멤버에 따른 액세스 제어

| 제한 범위   | 명칭                  | 설정 방법         | 접근범위                             |
|---------|---------------------|---------------|----------------------------------|
| 엄격함     | private             | 선언 앞에 private | 자기 자신 클래스                        |
| 비교적 엄격함 | package private(기본) | (작성 안함)       | 같은 패키지에 소속된 클래스                  |
| 비교적 느슨함 | protected           | protected     | 자신과 같은 패키지 소속 or 자신을 상속받은 자식 클래스 |
| 느슨함     | public              | public        | 모든 클래스                           |

## getter / setter

- 메서드를 경유한 필드 조작
    - getter : 읽기 전용을 구현
    - setter : 쓰기 전용을 구현 (잘 안씀)
- 사용하는 이유
    - Read Only, Write Only 제작 가능
    - 클래스의 내부 설계를 자유롭게 변경 가능
    - 필드로의 접근을 검사할 수 있음

> 샘플코드
> ```java
> public class Hero {
>   private int hp;
>   // getter 예시
>   public int getHP() {
>       return hp;
>   }
>   // setter 예시
>   public void setHP(int hp) {
>       this.hp = hp;
>   }
> }
> ```

## 정리

### 캡슐화 개요

- 멤버나 클래스로의 접근을 제어할 수 있음
- 필드에 "존재할 수 없는 값"이 들어가지 않도록 제어

### 멤버 접근 지정

- private 지정된 멤버는 동일 클래스내에서만 접근 가능
- package private(지정 안함) 멤버는 동일 패키지 내의 클래스에서만 접근 가능
- public 지정된 멤버는 모든 클래스에서 접근 가능

### 클래스 접근 지정

- package private (연산자 없음) 선언된 클래스는 동일 패키지내의 클래스에서만 접근 가능
- public 지정된 클래스는 모든 클래스에서 접근 가능

### 정석

- 클래스 : public
- 메서드 : public
- 필드 : private
- 필드에 접근을 위해 getter / setter 준비
- setter 내부에서는 타당성 검사를 수행

## 컬렉션 - 자료구조

- List : 순서대로 쌓여있음 (아이템의 중복 허용)
    - ArrayList는 데이터가 쌓이면 중간 삽입/삭제가 느려질 수 있음
- Map : Key와 Value의 쌍으로 저장(dictionary와 비슷함)
    - 읽기가 빠른편
- Set : 중복을 허용하지 않는 집합
    - 검색 속도가 평균적으로 빠름
    - 저장 순서를 보장하지 않아 실행할 때 마다 출력이 다를 수 있음.

## 컬렉션에서는 기본형 취급 불가

- ArrayList<int>는 불가능
- ArrayList<Integer> 가능

## 배열과 ArrayList 비교

```java
// @formatter:off
// 배열 생성
String[] names = new String[3];

// 3인의 이름 추가
names[0]="홍길동";
names[1]="한석봉";
names[2]="신사임당";

// ArrayList 생성
ArrayList<String> name = new ArrayList<String>();

// 3인 이름 추가
name.add("홍길동");
name.add("한석봉");
name.add("신사임당");

// 탐색 방법 비교
// 배열
for(int i = 0; i < names.length; i++) {
    System.out.println(names[i]);    
}

// ArrayList
for(int i = 0; i < name.size(); i++) {
     System.out.println(name.get(i));    
}

// 둘 다 가능
for(String string: name) {
    System.out.println(string);    
}
// @formatter:on
```

## Iterator

- 리스트의 요소 하나씩을 가리키는 객체

```java
// @formatter:off
// ArrayList 생성
ArrayList<String> names = new ArrayList<>();

// 3인 이름 추가
names.add("홍길동");
names.add("한석봉");
names.add("신사임당");

Iterator<String> it = names.iterator();

while(it.hasNext()) {
    String name = it.next();
    System.out.println(name);
}
// @formatter:on
```

## Set

- 중복 값을 허용하지 않음
- get() 메서드는 제공하지 않아 필요시 Iterator / for each 사용
- List의 contains 보다 압도적으로 빠름

```java
// 코드 예시
// @formatter:off
// Set 생성
Set<String> colors = new HashSet<>();

// 값 삽입
colors.add("Red");
colors.add("Green");
colors.add("Blue");

// 중복된 값 삽입
colors.add("Red");

System.out.println(colors.size()); // 실행 시 3 출력
// @formatter:on
```

## Map

- Key : Value 의 쌍으로 이루어진 요소를 담음
- Key의 중복은 허용되지 않음

```java
// 예시
// @formatter:off
// Map 생성
Map<String, Integer> cities = new HashMap<>();

// 키와 값 삽입
// 삽입 시 (map의 이름).put(Key, Value) 로 작성
cities.put("서울시", 977);
cities.put("수원시", 124);
cities.put("부산시", 342);

// get(Key)로 Value를 가져옴
int seoul = cities.get("서울시");

// remove(Key)로 값을 삭제
cities.remove("서울시");

// put(Key, Value) 로 갱신 가능
cities.put("수원시", 130);

// 저장된 값을 하나씩 얻기
// HashMap은 순서를 보장하지 않아, 매번 출력 순서가 다를 수 있음.
for(String key: cities.keySet()) {
    int value = cities.get(key);
    System.out.println(key + "인구는 " + value + "만");
}

// @formatter:on
```

## 기초 자료구조

### 동적 배열

- 배열의 크기가 고정되지 않고, 필요에 따라 늘어나는 배열 구조
    - `int[] array = new int[5]` 식으로 선언한다면 3칸까지만 사용할 수 있으나
    - `ArrayList<Integer> array = new ArrayList<>();` 로 선언한다면, 내부적으로 공간을 늘려가며 관리함
- ArrayList가 Java의 대표적인 동적 배열.
- 인덱스로 빠르게 접근할 수 있지만, 중간 삽입/삭제가 많다면 비효율적일 수 있음.

### 연결 리스트

- 각 데이터가 다음 데이터의 위치를 참조하며 연결된 자료구조
- 배열처럼 연속되는 메모리 공간에 저장되는 것이 아니라, 각각의 요소가 따로 존재함
- 각 요소를 노드라 부름
    - [데이터 / 다음주소] -> [데이터 / 다음주소] ...
- 특징
    - 인덱스로 바로 접근이 힘듬
    - 중간 삽입/삭제가 비교적 빠름
    - LinkedList 가 Java에서 대표적인 연결 리스트 구조

### 스택 (Stack)

- LIFO(Last In First Out) 후입선출 구조
- push : 데이터를 스택 맨 위에 넣음
- pop : 맨위의 데이터를 스택에서 꺼냄
- peek : 맨 위 데이터를 확인
- Ctrl + Z 같은 기능 구현할때 사용.

### 큐 (Queue)

- FIFO(First In First Out) 선입선출 구조
- offer() : 데이터를 큐 맨 뒤에 추가
- poll() : 맨 앞 데이터를 꺼내고 제거
- peek() : 맨 앞 데이터를 확인
- 작업 요청 순서 처리 할 때 사용

#### 배열을 이용한 큐 특징

- 배열 크기가 고정되어 있음
- front와 rear 위치를 직접 관리
    - 예시
        - 삽입시 rear 위치에 저장 후 rear 증가
        - 삭제시 front 위치의 값을 꺼낸 후 front 증가
- 단순 배열 Queue 사용시 앞쪽 공간이 비어도 재사용이 힘들어 원형 큐를 사용하기도 함

#### 리스트를 이용한 큐 특징

- 배열 크기를 미리 지정하지 않아도 됨
- 데이터가 추가될 때마다 공간 사용 가능
- front, rear를 직접 관리하지 않아도 됨
- 하지만 배열보다 메모리 사용량이 클 수 있음

---

## 배운점

- 캡슐화를 통해 휴먼 에러를 방지하는 방법을 알게됨
- setter를 통해 조건에 맞는 값을 받아들일 수 있는 방법을 알게됨
- 연산자 없이 선언하는 클래스가 정확히 어디에서 접근 할 수 있는지 알게됨
- IntelliJ IDE에서 저장시 포맷(정렬)을 막기 위해 //@formatter:off 과 //@formatter:on을 적절히 사용해야 형식이 원하는대로 고정될 수 있음을 알게됨.
- 자바의 컬렉션인 List<T>, Set<T>, Queue<T>, Map<Key, Value>에 대해 학습함
- 각각 C# 에서의 List<T>, HashSet<T>, Queue<T>, Dictionary<Key, Value> 와 유사한 역할을 수행
- Java에서는 foreach가 없지만 향상된 for문을 사용하여 비슷하게 구현 가능

| 언어   | 사용문법      | 예시                                   |
|------|-----------|--------------------------------------|
| Java | 향상된 for문  | `for(String key: cities.keySet())`   |
| C#   | foreach 문 | `foreach(string key in cities.Keys)` |


