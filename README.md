# JBS 쇼핑몰 (개인 프로젝트) (url : http://jbs95.xyz)


## 개발 기간 
* 2017.08.03 ~ 2017.10.11

## 개발 동기 
* 

## 개발 목적 
* 

## 개발 환경
* 백 엔드 : Spring Boot (SpringDataJPA)
* DB 	 : H2 
* 빌드	 : Maven
* 서버	 : 카페 24 Tomcat JSP광호스팅
* 프론트 엔드 : Bootstrap、mustache, AJAX
* 기타 api : 네이버 로그인, 카카오 로그인, 네이버 스마트 에디터
* 툴 : spring-tool-suite(이클립스 계열)


## 메인 화면
* 


## 개발 스타일
* 


## 테이블 구조
| ACCOUNT 테이블(계정관련)|||
| :-----: | :-: |:-: |
| ID(PK)	|아이디		|VARCHAR(255) NOT NULL	|
| ADDRESS	|주소		|VARCHAR(255)		|
| AUTHORITY	|권한		|VARCHAR(255)		|
| EMAIL		|이메일		|VARCHAR(255)		|
| GENDER	|성별		|VARCHAR(255)		|
| LOGIN_TYPE	|회원가입 타입	|VARCHAR(255)		|
| NAME		|이름		|VARCHAR(255)		|
| PASSWORD	|비번		|VARCHAR(255)		|
| CREATE_DATE	|정보 만든시간	|TIMESTAMP(23, 10)	|
| MODIFIED_DATE	|정보수정 시간	|TIMESTAMP(23, 10)	|

| COMMENT 테이블(댓글관련)|||
| :-----: | :-: |:-: |
| NUMBER(PK)	|댓글 코드	| INTEGER(10) NOT NULL	|
| CONTENTS	|내용		| CLOB(2147483647)	|
| ACCOUNT_ID(FK)|작성자		| VARCHAR(255)		|
| PRODUCT_NUMBER(FK)|상품 번호	| INTEGER(10)		|
| CREATE_DATE	|정보 만든시간	|TIMESTAMP(23, 10)	|
| MODIFIED_DATE	|정보수정 시간	|TIMESTAMP(23, 10)	|

| ORDERS 테이블(주문관련)|||
| :-----: | :-: |:-: |
| CODE(PK)	|주문 코드	| INTEGER(10) NOT NULL	|
| AMOUNT	|주문 수량	| INTEGER(10) NOT NULL	|
| ACCOUNT_ID(FK)|주문자		| VARCHAR(255)		|
| PRODUCT_NUMBER(FK)|상품 번호	| INTEGER(10)	|
| CREATE_DATE	|정보 만든시간	|TIMESTAMP(23, 10)	|
| MODIFIED_DATE	|정보수정 시간	|TIMESTAMP(23, 10)	|


| PRODUCT 테이블(상품관련)|||
| :-----: | :-: |:-: |
| NUMBER(PK)	|상품코드		| INTEGER(10) NOT NULL	|
| CATEGORY	|카테고리		| VARCHAR(255)		|
| CONTENTS	|내용			| CLOB(2147483647)	|
| IMG		|썸네일이미지경로	| VARCHAR(255)		|
| PRICE		|가격			| INTEGER(10)		|
| TITLE		|제목			| VARCHAR(255) NOT NULL	|
| CREATE_DATE	|정보 만든시간		|TIMESTAMP(23, 10)	|
| MODIFIED_DATE	|정보수정 시간		|TIMESTAMP(23, 10)	|





