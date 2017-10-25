

## JBS 쇼핑몰 (개인 프로젝트) (url : http://jbs95.xyz)

## 개발 기간 
* 2017.08.03 ~ 2017.10.11

## 개발 동기 
* youTube에 올라온 [박재성이라는 웹 개발자가 강의]( https://www.youtube.com/watch?v=JUKehW-c484&index=1&list=PLqaSEyuwXkSppQAjwjXZgKkjWbFoUdNXC)한 자바 웹 애플리케이션 과정을 듣게된후 Spring boot,JPA를 사용

한 빠른 개발에 즐거움을 느끼기 되어 호기심에 만들어 보게 되었다.

## 개발 목적 
* sns로그인을 통한 간편한 로그인 방식과 단순하고 작은 쇼핑몰을 만들어보고 생산성이 높은 Spring boot를 사용해서 

빠른 개발을 해보고싶었다.

## 개발 환경
* 백 엔드 : Spring Boot (SpringDataJPA)
* DB 	 : H2 
* 빌드	 : Maven
* 서버	 : Ubuntu 14.04
* 프론트 엔드 : Bootstrap、mustache, AJAX
* 기타 api : 네이버 로그인, 카카오 로그인, 네이버 스마트 에디터
* 툴 : spring-tool-suite(이클립스)

## 개발 스타일
* 최대한 코드에 주석을 많이 남기려고 노력한다. ( 인수인계를 위하여..)

## 화면
* 메인 화면 (pc웹, 모바일)

![1](http://postfiles12.naver.net/MjAxNzEwMTZfMTc0/MDAxNTA4MTYzMjc5NzY2.6ou7zFsyVdgboL4GD5HImyq8BCTrftIq9e3xsnlBj9Ag.6FNabfqnDIjYDY0-enzVZmRtvVSESI7VAQpJeJ3X92og.JPEG.awef5643f/1.1.JPG?type=w1)

* 로그인 화면 (pc웹, 모바일)

![2](http://postfiles13.naver.net/MjAxNzEwMTZfNiAg/MDAxNTA4MTYzMjgwMDAx.HuNY_-ktHg6LTj1UX1RBXOYqysIZXKoks652qys92kwg.4ueUNZnl_3cktqcZd20XCJmyESgmCb3QLP3qpEuINtMg.JPEG.awef5643f/3.JPG?type=w1)

* 카테고리 화면 (pc웹, 모바일)

![3](http://postfiles5.naver.net/MjAxNzEwMTZfNjIg/MDAxNTA4MTY1NzYyMjY4.W1u1Yy5bXYDA0yiFKF0evUEghH2bqPc7Vtkwxb_Su5Ig.pvL-_Ap3ceSoxduYh7NUEmkmFu032cbgEtSSOaClwGYg.JPEG.awef5643f/5.JPG?type=w1)


* 상품 등록 화면 (pc웹)

![4](http://postfiles12.naver.net/MjAxNzEwMTZfMyAg/MDAxNTA4MTY1NzYyNDI1.62pHtIDz-ehGeVWdOdL7UkkURuED-UZx759xye3WE30g.NEgCKIc8flGPVVSe7NUdNOD8r8I5wJLU-Ays4j5kACcg.JPEG.awef5643f/8.JPG?type=w1)


상품 썸네일 처리 코드  
 설명) 상품관련 데이터를 저장할때 상품 내용에 등록된 첫번째 이미지를 가져와 썸네일로 지정

	```

	// 내용 값 저장할때 썸네일 이미지도 함께 지정
	public void setContents(String contents) {
		this.contents = contents;
		this.img = findByImg(contents);
	}

	// 글에서 이미지 파일이 있을경우 썸네일 지정(상품 내용에 있는 첫번째 이미지를 썸내일로 지정한다.)
	private String findByImg(String imgFind) {
		int startImgFind = imgFind.indexOf("<img src=");
		if (startImgFind > 0) {
			imgFind = imgFind.substring(startImgFind + 10);
			int endImgFind = imgFind.indexOf("\"");
			imgFind = imgFind.substring(0, endImgFind);
		} else {
			// 상품 이미지가 없을 경우 썸내일 파일 주소
			imgFind = "/img/noImg.jpg";
		}
		return imgFind;
	}

	```

* 상품 보기 화면(pc웹)

![5](http://postfiles12.naver.net/MjAxNzEwMTZfMTkx/MDAxNTA4MTY1NzYyNjA4.9IjltBhHkxj4KykBfjsqz8EGX67-87S9sE17ZI9b6ukg.p4kwwatNANw2aVsj1JUzqpBWL5Csw1asL2DYH_ZUuTUg.JPEG.awef5643f/9.JPG?type=w1)

* 관리 화면( 왼쪽은 관리자 로그인 화면, 오른쪽은 회원 로그인 화면)

![6](http://postfiles9.naver.net/MjAxNzEwMTZfNjMg/MDAxNTA4MTY1NzYyODAw.j8J8GEA73zF13kFbjVsd6ECXS0M9XRPBpxNDDuCwo14g.OxRWexcUOTbWmgpqi3XLFbOefnUvrvJBbQabCc2LUE8g.JPEG.awef5643f/10.JPG?type=w1)

## 테이블 구조
| ACCOUNT 테이블(계정관련)|||
| :-----: | :-: |:-: |
| ID **`(PK)`**	|아이디		|VARCHAR(255) NOT NULL	|
| ADDRESS	|주소		|VARCHAR(255)		|
| AUTHORITY	|권한		|VARCHAR(255)		|
| EMAIL		|이메일		|VARCHAR(255)		|
| GENDER	|성별		|VARCHAR(255)		|
| LOGIN_TYPE	|회원가입 타입	|VARCHAR(255)		|
| NAME		|이름		|VARCHAR(255)		|
| PASSWORD	|비번		|VARCHAR(255)		|
| CREATE_DATE	|정보만든 시간	|TIMESTAMP	|
| MODIFIED_DATE	|정보수정 시간	|TIMESTAMP	|

| COMMENT 테이블(댓글관련)|||
| :-----: | :-: |:-: |
| NUMBER **`(PK)`**	|댓글 코드	| INTEGER(10) NOT NULL	|
| CONTENTS	|내용		| CLOB	|
| ACCOUNT_ID **`(FK)`**|작성자		| VARCHAR(255)		|
| PRODUCT_NUMBER **`(FK)`**|상품 번호	| INTEGER(10)		|
| CREATE_DATE	|정보만든 시간	|TIMESTAMP	|
| MODIFIED_DATE	|정보수정 시간	|TIMESTAMP	|

| ORDERS 테이블(주문관련)|||
| :-----: | :-: |:-: |
| CODE **`(PK)`**	|주문 코드	| INTEGER(10) NOT NULL	|
| AMOUNT	|주문 수량	| INTEGER(10) NOT NULL	|
| ACCOUNT_ID **`(FK)`**|주문자		| VARCHAR(255)		|
| PRODUCT_NUMBER **`(FK)`**|상품 번호	| INTEGER(10)	|
| CREATE_DATE	|정보만든 시간	|TIMESTAMP	|
| MODIFIED_DATE	|정보수정 시간	|TIMESTAMP	|


| PRODUCT 테이블(상품관련)|||
| :-----: | :-: |:-: |
| NUMBER **`(PK)`**	|상품코드		| INTEGER(10) NOT NULL	|
| CATEGORY	|카테고리		| VARCHAR(255)		|
| CONTENTS	|내용			| CLOB	|
| IMG		|썸네일이미지경로	| VARCHAR(255)		|
| PRICE		|가격			| INTEGER(10)		|
| TITLE		|제목			| VARCHAR(255) NOT NULL	|
| CREATE_DATE	|정보만든 시간		|TIMESTAMP	|
| MODIFIED_DATE	|정보수정 시간		|TIMESTAMP	|
