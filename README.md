# 문자열 덧셈 계산기

입력한 문자열에서 숫자를 추출하여 더하는 '문자열 덧셈 계산기'를 구현한다.  
기본 구분자와 커스텀 구분자를 통해 여러 숫자를 입력할 수 있으며,  
잘못된 입력에 대해서는 `IllegalArgumentException`을 발생시킨 후 프로그램을 종료한다.

---

## 기능 목록

### 🍀 기본 기능
- [x] 기본 구분자(쉼표 `,` 또는 콜론 `:`)로 숫자를 분리하여 합산
- [x] 빈 문자열 입력 시 `0` 반환
- [x] 숫자 하나 입력 시 해당 숫자 그대로 반환
- [x] `//`와 `\n` 사이에 위치하는 문자 1개를 커스텀 구분자로 지정
  - 예: `"//;\n1;2;3"` → `6`


### 🍀 예외 처리
- [x] 숫자가 아닌 값 입력 시 `IllegalArgumentException` 발생 (`"유효하지 않은 숫자입니다: abc"`)
- [x] 음수 입력 시 `IllegalArgumentException` 발생 (`"음수는 허용되지 않습니다: -1"`)
- [x] 커스텀 구분자 형식이 잘못된 경우 `IllegalArgumentException` 발생 (`"잘못된 커스텀 구분자 형식입니다: //?\1?2"`)

---

## 설계 개요

### ⭐ 아키텍처
본 프로젝트는 MVC 패턴을 기반으로 구성되며 각 역할을 다음과 같이 분리하였다.

| 레이어 | 클래스 | 책임 |
|--------|---------|--------|
| app | `Application` | 프로그램 실행 시작점 (`main()`) |
| controller | `StringCalculatorController` | 입력 → 계산 → 출력 흐름 제어 |
| view | `InputView`, `OutputView` | 콘솔 입출력 담당 |
| domain | `StringCalculator`, `DelimiterProcessor`, `NumberParser` | 핵심 계산 및 파싱 로직 |


### ⭐ 책임 분리 (SRP 적용)

| 구성 요소 | 책임 |
|-----------|--------|
| `DelimiterProcessor` | 입력 문자열에서 구분자를 분석하고, 해당 구분자를 기준으로 토큰화 |
| `NumberParser` | 토큰을 정수로 변환하고, 음수 및 숫자 형식 유효성 검증 |
| `StringCalculator` | DelimiterProcessor와 NumberParser를 조합하여 전체 문자열을 계산하는 **도메인 서비스** 역할 수행 |
| `Controller` | 입력 → 계산 → 출력 흐름 제어 (View와 Domain 연결) |
| `View` | 사용자 입력 수집 및 결과 출력 (콘솔 I/O 전담) |


---

## 실행 예시
```commandline
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```
```commandline
덧셈할 문자열을 입력해 주세요.
//;\n1;2;3
결과 : 6
```
```commandline
덧셈할 문자열을 입력해 주세요.
1,-2,3
Exception in thread "main" java.lang.IllegalArgumentException: 음수는 허용되지 않습니다: -2
```
```commandline
덧셈할 문자열을 입력해 주세요.
1,a,2
Exception in thread "main" java.lang.IllegalArgumentException: 유효하지 않은 숫자입니다: a
```

---

## 예외 발생 정책
- 잘못된 입력값이 들어온 경우 `IllegalArgumentException`을 던지고 애플리케이션은 종료된다.
- 예외 처리의 책임은 **입력 검증 역할이 있는 Parser/DelimiterProcessor 내부에서 수행**한다.  
  Controller는 예외를 잡지 않고 그대로 전달함으로써 프로그램 흐름을 종료한다.