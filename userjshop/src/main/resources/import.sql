

-- 계정
insert into ACCOUNT (ID, EMAIL, ADDRESS, AUTHORITY, CREATE_DATE, GENDER, MODIFIED_DATE,NAME,PASSWORD,LOGIN_TYPE) VALUES ('testid01','email0235@naver.com','관리자 집주소01~~~', 'MANAGER', current_timestamp(), 'MAN', current_timestamp(), '관리자01', 'testpass01','USERJSHOP');
insert into ACCOUNT (ID, EMAIL, ADDRESS, AUTHORITY, CREATE_DATE, GENDER, MODIFIED_DATE,NAME,PASSWORD,LOGIN_TYPE) VALUES ('id01','email01@naver.com','관리자 집주소02~~~~~', 'MANAGER', current_timestamp(), 'MAN', current_timestamp(), '관리자02', 'pass01','USERJSHOP');
insert into ACCOUNT (ID, EMAIL, ADDRESS, AUTHORITY, CREATE_DATE, GENDER, MODIFIED_DATE,NAME,PASSWORD,LOGIN_TYPE) VALUES ('id02','email03@naver.com','사용자 집주소01~', 'BUYER', current_timestamp(), 'WOMAN', current_timestamp(), '사용자01', 'pass02','USERJSHOP');
insert into ACCOUNT (ID, EMAIL, ADDRESS, AUTHORITY, CREATE_DATE, GENDER, MODIFIED_DATE,NAME,PASSWORD,LOGIN_TYPE) VALUES ('id03','email04@naver.com','사용자 집주소02~...', 'BUYER', current_timestamp(), 'NOTVERIFIABLE', current_timestamp(), '사용자02', 'pass3','USERJSHOP');
insert into ACCOUNT (ID, EMAIL, ADDRESS, AUTHORITY, CREATE_DATE, GENDER, MODIFIED_DATE,NAME,PASSWORD,LOGIN_TYPE) VALUES ('1','email04@naver.com','사용자 집주소03~...', 'BUYER', current_timestamp(), 'NOTVERIFIABLE', current_timestamp(), '사용자03', '1','USERJSHOP');


-- 상품
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('totoro', '토토로~', '<p><img src="/categoryImg/test_img_01.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_01.jpg', '30000', current_timestamp(), current_timestamp());
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('totoro', '토토로~2', '<p><img src="/categoryImg/test_img_02.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_02.jpg', '40000', current_timestamp(), current_timestamp());
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('daraiflower', '드라이플라워1', '<p><img src="/categoryImg/test_img_04.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_04.jpg', '60000', current_timestamp(), current_timestamp());
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('daraiflower', '드라이플라워2', '<p><img src="/categoryImg/test_img_03.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_03.jpg', '60000', current_timestamp(), current_timestamp());
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('daraiflower', '드라이플라워3', '<p><img src="/categoryImg/test_img_04.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_04.jpg', '60000', current_timestamp(), current_timestamp());
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('daraiflower', '드라이플라워4', '<p><img src="/categoryImg/test_img_03.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_03.jpg', '50000', current_timestamp(), current_timestamp());
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('totoro', '토토로2', '<p><img src="/categoryImg/test_img_01.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_01.jpg', '160000', current_timestamp(), current_timestamp());
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('totoro', '토토로3', '<p><img src="/categoryImg/test_img_02.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_02.jpg', '160000', current_timestamp(), current_timestamp());
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('totoro', '토토로4', '<p><img src="/categoryImg/test_img_01.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_01.jpg', '150000', current_timestamp(), current_timestamp());
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('totoro', '토토로5', '<p><img src="/categoryImg/test_img_02.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_02.jpg', '140000', current_timestamp(), current_timestamp());
insert into PRODUCT (CATEGORY, TITLE, CONTENTS, IMG, PRICE, CREATE_DATE, MODIFIED_DATE) VALUES ('totoro', '토토로7', '<p><img src="/categoryImg/test_img_01.jpg"><br style="clear:both;">&nbsp;</p>', '/categoryImg/test_img_01.jpg', '130000', current_timestamp(), current_timestamp());


-- 댓글
--insert into COMMENT (CONTENTS, SCORE, ACCOUNT_ID, PRODUCT_NUMBER, CREATE_DATE, MODIFIED_DATE) VALUES ('contents~~', '5', 'id01', '1', current_timestamp(), current_timestamp());
--insert into COMMENT (CONTENTS, SCORE, ACCOUNT_ID, PRODUCT_NUMBER, CREATE_DATE, MODIFIED_DATE) VALUES ('contents~~', '5', 'id02', '1', current_timestamp(), current_timestamp());

-- 주문
--insert into Orders (ACCOUNT_ID, PRODUCT_NUMBER, AMOUNT, CREATE_DATE, MODIFIED_DATE) VALUES ('id01', '3', '3',current_timestamp(), current_timestamp());
--insert into Orders (ACCOUNT_ID, PRODUCT_NUMBER, AMOUNT, CREATE_DATE, MODIFIED_DATE) VALUES ('testid01', '1', '5',current_timestamp(), current_timestamp());
--insert into Orders (ACCOUNT_ID, PRODUCT_NUMBER, AMOUNT, CREATE_DATE, MODIFIED_DATE) VALUES ('testid01', '5', '7',current_timestamp(), current_timestamp());


