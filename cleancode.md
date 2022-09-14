# Clean Code

# 2. 의미 있는 이름

우리는 변수, 함수, 인수, 클래스, 패키지, 파일 등 모든 것에 이름을 붙인다. 

이름을 잘 지으면 편하다. 이름을 잘 짓는 간단한 규칙은??

### 의도를 분명히 밝히기

코드의 **함축성 :** 코드 맥락이 코드 자체에 명시적으로 드러나야 한다.

```c
public List<int[]> getThem() {
	List<int[]> list1 = new ArrayList<int[]>();
	for (int[] x : theList)
		if (x[0] == 4)
			list1.add(x);
	return list1;
}
```

코드가 하는 일을 짐작하기 어렵다. 코드 맥락이 코드 자체에 명시적으로 드러나야 한다.

```c
public List<Cell> getFlaggedCells() {
	List<Cell> flaggedCells = new ArrayList<Cell>();
	for (Cell cell : gameBoard)
		if (cell.isFlagged())
			flaggedCells.add(cell);
	return flaggedCells;
	}
```

좋은 이름은 코드를 더 명확하게 해준다.

### 의미 있게 구분하기

연속적인 숫자를 덧붙인 이름은 아무 의미가 없다.

```c
public static void copyChars(char a1[], char a2[]) {
	for (int i = 0; i < a1.length; i++) {
		a2[i] = a1[i];
	}
}
```

함수 인수 이름으로 source와 destination을 사용한다면 코드 읽기가 훨씬 더 쉬워진다.

### 발음하기 쉽고, 검색하기 쉬운 이름을 사용하기

### 클래스 이름, 객체 이름 : 명사나 명사구

### 메서드 이름 : 동사나 동사구

접근자Accessor, 변경자Mutator, 조건자Predicate는 표준에 따라 값 앞에 get, set, is를 붙인다.

### 재미난 이름보다 명료한 이름을 선택하라.

### 한 개념에 한 단어를 사용하라

메서드 이름은 독자적이고 일관적이어야 한다. 그래야 주석을 뒤져보지 않고도 프로그래머가 올바른 메서드를 선택한다.

### 의미 있는 맥락을 추가하라

### 불필요한 맥락을 없애라

일반적으로는 짧은 이름이 긴 이름보다 좋다. 단, 의미가 분명한 경우에 한해서다. 이름에 불필요한 맥락을 추가하지 않도록 주의한다.

⇒ 우리들 대다수는 자신이 짠 클래스 이름과 메서드 이름을 모두 암기하지 못한다. 우리는 문장이나 문단처럼 읽히는 코드를 작성하는 데 집중해야 한다.

## 3. 함수

읽기 쉽고 이해하기 쉬운 코드는 무엇일까? 의도를 분명히 표현하는 함수를 어떻게 구현할 수 있을까? 함수에 어떤 속성을 부여해야 처음 읽는 사람이 프로그램 내부를 직관적으로 파악할 수 있을까?

### 작게 만들어라!

모든 함수가 2줄, 3줄, 4줄 정도로, 각 함수가 너무도 명백하게 각 함수가 이야기 하나를 표현해야한다.

### 한 가지만 해라!

⇒ **함수는 한 가지를 해야 한다. 그 한 가지를 잘 해야 한다. 그 한 가지만을 해야 한다.**

- 함수당 추상화 수준을 하나로!
  - 함수 내 모든 문장의 추상화 수준이 동일해야 한다.
  - 한 함수 내에 추상화 수준을 섞으면 코드를 읽는 사람이 헷갈린다.
  - 근본 개념과 세부사항을 뒤섞기 시작하면, 깨어진 창문처럼 사람들이 함수에 세부사항을 점점 더 추가한다.

### 내려가기 규칙

코드는 위에서 아래로 이야기5처럼 읽혀야 좋다. 한 함수 다음에는 추상화 수준이 한 단계 낮은 함수가 온다. 즉, 위에서 아래로 프로그램을 읽으면 함수 추상화 수준이 한 번에 한 단계씩 낮아진다.

### 서술적인 이름을 사용하라!

- 이름이 길어도 괜찮다.
  - 길고 서술적인 이름이 짧고 어려운 이름보다 좋다.
  - 길고 서술적인 이름이 길고 서술적인 주석보다 좋다.
  - 함수 이름을 정할 때는 여러 단어가 쉽게 읽히는 명명법을 사용한다. 그런 다음, 여러 단어를 사용해 함수 기능을 잘 표현하는 이름을 선택한다.
- 서술적인 이름을 사용하면 개발자 머릿속에서도 설계가 뚜렷해지므로 코드를 개선하기 쉬워진다.
- 이름을 붙일 때는 일관성이 있어야 한다.
  - 모듈 내에서 함수 이름은 같은 문구, 명사, 동사를 사용한다.
  - includeSetupAndTeardownPages, includeSetupPages, includeSuiteSetupPage, includeSetupPage 등

### 함수 인수

함수에서 이상적인 인수 개수는 0개(무항)다. 다음은 1개(단항)고, 다음은 2개(이항)다. 3개(삼항)는 가능한 피하는 편이 좋다. 4개 이상(다항)은 사용하면 안 된다.

- 단항 형식
  - 인수에 질문을 던지는 경우 : boolean fileExists(“MyFile”)
  - 인수를 뭔가로 변환해 결과를 반환하는 경우 : InputStream fileOpen(“MyFile”)
  - 이벤트 함수 : passwordAttemptFailedNtimes(int attempts) / 조심해서 사용!
  - 이외 경우는 가능한 피한다.
- 플래그 인수 : 추하다.
- 이항 함수
  - 위험이 따른다는 사실을 이해하고 가능하면 단항함수로 바꾸도록 애써야 한다.
- 삼항 함수 : 신중히 고려하라.

- 인수 객체
  - 인수가 2-3개 필요하다면 일부를 독자적인 클래스 변수로 선언할 가능성
- 동사와 키워드
  - 함수와 인수가 동사/명사 쌍 : writeField(name)
  - 키워드 추가 : assertExpectedEqualsActual(expected, actual)

### 부수 효과를 일으키지 마라!

예상치 못하게 클래스 변수를 수정한다. 때로는 함수로 넘어온 인수나 시스템 전역 변수를 수정한다. 어느 쪽이든 교활하고 해로운 거짓말이다.

### 명령과 조회를 분리하라!

함수는 뭔가를 수행하거나 뭔가에 답하거나 둘 중 하나만 해야 한다. 둘 다 하면 혼란을 초래한다.

```c
public boolean set(String attribute, String value);

if (set("username", "unclebob"))...
```

독자 입장에서 코드를 읽어보면, “username”이 “unclebob”으로 설정되어 있는지 확인하는 코드인지,  아니면 “username”을 “unclebob”으로 설정하는 코드인지 분간하기 어렵다. 

함수를 구현한 개발자는 “set”을 동사로 의도했다. 하지만 if 문에 넣고 보면 형용사로 느껴진다. 해결책은 명령과 조회를 분리해 혼란을 애초에 뿌리뽑는 방법이다.

```c
if (attributeExists("username")) {
	setAttribute("username", "unclebob");
	...
}
```

### 오류 코드보다 예외를 사용하라!

```c
if (deletePage(page) == E_OK)
```

여러 단계로 중첩되는 코드를 야기한다. 오류 코드를 반환하면 호출자는 오류 코드를 곧바로 처리해야 한다는 문제에 부딪힌다.

오류 코드 대신 예외를 사용하면 오류 처리 코드가 원래 코드에서 분리되므로 코드가 깔끔해진다.

```c
try {
	deletePage(page);
	registry.deleteReference(page.name);
	configKeys.deleteKey(page.name.makeKey());
}
catch (Exception e) {
	logger.log(e.getMessage());
}
```

하지만 try/catch 블록은 코드 구조에 혼란을 일으키며, 정상 동작과 오류처리 동작을 뒤섞으므로 별도 함수로 뽑아낸다. 

```c
public void delete(Page page) {
	try {
		deletePageAndAllReferences(page);
	}
	catch (Exception e) {
		logError(e);
	}
}

private void deletePageAndAllReferences(Page page) throws Exception {
	deletePage(page);
	registry.deleteReference(page.name);
	configKeys.deleteKey(page.name.makeKey());
}
private void logError(Exception e) {
	logger.log(e.getMessage());
}
```

실제로 페이지를 제거하는 함수는 deletePageAndAllReferences다. deletePageAndAllReferences 함수는 예외를 처리하지 않는다. 정상 동작과 오류 처리 동작을 분리하면 코드를 이해하고 수정하
기 쉬워진다.

- 오류 처리도 한 가지 작업이다.

오류를 처리하는 함수는 오류만 처리해야 마땅하다.

### 반복하지 마라!

중복은 소프트웨어에서 모든 악의 근원이다.

→ 모든 함수를 짤 때, 처음부터 탁 잘 짜지는 코드는 없다.