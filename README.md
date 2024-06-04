### ★ 학생관리 프로그램 구현 관계도  

![학생관리 프로그램_마인드맵](https://github.com/kth232/team3_project2_2/assets/136600208/0b0a8fc9-6e44-438f-a406-73558b5e5598)
<br>  

---
## \* Global 건드리면 커피 돌리기(필요한 경우 6인의 허가를 받아야함)

### 상수 정의 예시!
```
enum Class StudentManagement {
  STSELECT
  STUPDATE
}

enum Class GradeManagement {
  GRSELECT
  GRUPDATE
}
```
---

### DB 테이블 별 컬럼명 정의 예시  
\* 관리자 테이블과 학생 테이블은 공통 테이블  
\* 과목명은 자바, 리액트  
\* 반은 502, 503호
#### 성적, 등급, 출결, 학급 테이블은 담당한 사람이 각자 테이블 만들고 CREATE문 공유할 것!  
<br>

<관리자> 테이블  
| ID | PW | Name | Job(직책) | SignUpDate(가입일)|
|---|:---|:---|:---|:---|
| user01 | 1234 | kim | manager | 2024-06-02 |
<br>

<학생> 테이블  
| Name | Class(반) | Subject(과목) |  Adress(주소) | PhoneNumber(전화번호) |
|---|:---|:---|:---|:---|
| lee | 502 | java | 서울 마포구 | 010-0000-0000 |  
<br>
  
<성적> 테이블 &ensp; ->등급 테이블과 연결  
| Name | Class(반) | Subject(과목) |  Score(점수) | Grade(등급) |
|---|:---|:---|:---|:---|
| lee | 502 | java | 88 | B |
<br>

<등급> 테이블  
|Score(점수) | Grade(등급)|
|---|:---|
| 90점 이상 | A |
| 80점 이상 | B |
<br>  

<출결> 테이블 &ensp; ->필요할 경우 다른 테이블 추가 생성할 것  
| Name | Class(반) | 월 |  화 | 수 | 목 | 금 |
|---|:---|:---|:---|:---|:--|:--|
| lee | java | 출석 | 결석 | 출석 | 출석 | 출석 |
<br>  

<학급> 테이블  
| Subject(과목) | Class(반) | 개설일 | 수료일 | 학급 상태 |
|---|:---|:---|:---|:---|
| java | 502 | 2024-03-19 | 2024-9-30 | 수업 진행 |
