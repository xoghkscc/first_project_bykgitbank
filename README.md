# POS기 프로젝트
## 0_개요
중 대형 마트에서 사용하고 있는 POS기기를 구현할 목적으로 개발하였다. POS기기를 통해 물품의 계산뿐만이 아니라 재고 관리, 회원 관리, 직원 관리, 배달 관리 등 다양한 역할을 할 수 있도록 개발하였다. 
## 1_개발환경
  * OS : window 10
  * 개발언어 : java
  * DB : oracle
  * Tool : eclipse
  * 외부 라이브러리 : jdbc(ojdbc8.jar), jdatepicker-1.3.2.jar, HikariCP-4.0.3.jar
## 2_Usecase Diagram
![Usecase Diagram](https://user-images.githubusercontent.com/82793713/124924225-2fd0c900-e036-11eb-9cd9-f1c41cbdda8b.jpg)
## 3_ER Diagram
![ER diagram](https://user-images.githubusercontent.com/82793713/124924220-2e9f9c00-e036-11eb-9e07-889593f5db2d.png)
## 4_HikariCP
  * HIKARI를 이용해 connection pool를 관리하였습니다
```C
public class HikariCP {
	HikariDataSource ds;
	public HikariCP() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@3.35.52.40:1521:xe");//AWS EC2 서버이다
		config.setUsername("first_project");
		config.setPassword("secret");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds = new HikariDataSource(config);
	}
	public HikariDataSource getHikariDataSource() {
		return ds;
	}
}
```
## 5_화면
### 5.1_로그인
![image](https://user-images.githubusercontent.com/82793713/124926059-10d33680-e038-11eb-8cba-3f284577c430.png)
#### 아이디: test, 비밀번호: 1234
### 5.2_메인화면
![image](https://user-images.githubusercontent.com/82793713/124926259-46781f80-e038-11eb-8f6e-53208edd8bae.png)
### 5.3_계산화면
![image](https://user-images.githubusercontent.com/82793713/126889210-c0a626e5-c326-47c1-9e8e-8be926ed60e7.png)
1.  물품번호를 입력하게 되면 해당하는 품목이 나타남
```C
SELECT * FROM Products WHERE PRODUCT_ID = "검색한 품목번호";
```
2.  전화번호를 입력하면 해당하는 회원정보가 나타남
```C
SELECT * FROM member_informations WHERE members_id = “검색한 전화번호”

```
3.  회원의 포인트를 사용할 수 있음
![image](https://user-images.githubusercontent.com/82793713/126889347-ab15f24f-34ec-49e2-9b38-ffd5854f8f96.png)
4. 배달 버튼을 누르면 배달 여부를 확인할 수 있음
5.  결제 버튼을 누르면 결제DB, 재고DB, 회원DB, 배달DB에 관련 정보가 반영됨
```C
INSERT INTO DELIVERY VALUES (배달번호, 회원번호, 결제금액, ‘N’)-배달DB에 배달내역 반영

INSERT INTO SALES (sales_num, sales_id, payment_type, sales_time, point_score, product_id, number_of_sales) VALUES (결제번호, 결제id, 결제타입, sysdate, 회원번호, 포인트, 물건번호, 물건개수)-결제DB의 결제내역 반영

UPDATE PRODUCTS SET gram = gram - (구매한 무게) WHERE product_id = 물건번호 혹은
UPDATE PRODUCTS SET stocks = stocks - (구매한 개수) WHERE product_id = 물건번호 -재고DB의 재고 반영

UPDATE MEMBER_INFORMATIONS SET members_point = members_point + 수정할 포인트 WHERE members_id = 멤버id-회원DB 포인트 반영
```
6.  영수증출력을 누르면 구매내역을 볼 수 있음
7.  환불버튼을 누르면 환불처리가 되며 결제DB, 재고DB, 회원DB, 배달DB에 관련 정보가 반영됨
```C
IDELETE FROM delivery WHERE delivery_id = 배달id-배달DB의 배달기록 삭제

UPDATE sales SET POINT_SCORE=0, DELIVERY_ID= null, REFUND = 'Y', number_of_sales = 0  WHERE sales_id = 결제번호-결제DB 결제내역 수정

UPDATE PRODUCTS SET gram = gram - -(구매한 무게) WHERE product_id = 물건번호 혹은
UPDATE PRODUCTS SET stocks = stocks - -(구매한 개수) WHERE product_id = 물건번호-재고DB의 재고개수 롤백

UPDATE MEMBER_INFORMATIONS SET members_point = members_point + -수정할 포인트 WHERE members_id = 멤버id-회원DB의 포인트 롤백
```
### 5.4_회원화면
![image](https://user-images.githubusercontent.com/82793713/126889724-762ca474-9429-4f5b-b206-f6643748abf4.png)
1.  검색란에 아무 것도 입력안하고 검색을 누르게 되면 모든 회원정보가 출력됩니다. 
2.  회원 정보 검색란에 전화 번호 뒷자리를 입력하게 되면 회원 정보가 검색됩니다.
3.  검색한 회원의 산 품목을 조회하고 싶으면 회원 정보를 클릭하게 되면 물품별 조회할 것인지 날짜별 조회할 것인지 창이 뜨게 됩니다. 
그 중에서 물품별 조회를 누르고 검색할 물품을 입력하게 되면 고객이 산 물품이 창에 표시 됩니다
```C
SELECT * FROM sales Inner Join products USING(product_id) WHERE (product_name LIKE \’ + product_name + “\’ OR product_name = \’”+product_name + “\’) AND members_id + MemberSearchFrame.id;
```
고객이 산 날짜별 조회를 하고 싶으면 날짜별 조회를 클릭하고 조회할 날짜를 입력하고 검색을 누르게 되면 날짜별로 산 물품이 조회되게 됩니다.
```C
SELECT * FROM sales Inner Join products USING(product_id) WHERE sales_time LIKE \’”+sales_time + “\’ AND members_id = “ + MemberSearchFrame.id;
```
4.  회원등록
```C
INSERT INTO member_informations VALUES(members_id_seq.nextval, 이름, 주소, 연락처, 0)
```
5.  회원수정
```C
SELECT * FROM member_informations WHERE members_phonenumber LIKE 번호뒷자리
```
6.  회원삭제
```C
DELETE FROM member_informations WHERE members_id = 삭제할 회원id
```
### 5.5_재고화면
![image](https://user-images.githubusercontent.com/82793713/126889865-41b379e2-ab5b-4cae-a7bd-bd750a4f345a.png)
1.  Jdatepicker를 사용하여 달력 모양을 나타냈음
2.  재고관리
```C
SELECT * FROM PRODUCTS WHERE (expiration_date BETWEEN '" + startDate2 + "' and '" + endDate2 +“')" + endSql
```
3.  품목등록
```C
INSERT INTO PRODUCTS VALUES(sequenceID, name, productType, price+, expiryDay, event, discountRate, origin, stock, weight, salesType, cost)
```
4.  폼목수정
```C
INSERT INTO PRODUCTS VALUES(sequenceID, name, productType, price, expiryDay, event, discountRate, origin, stock, weight, salesType, cost)
```
5.  품목주문
#### 품목 주문 창에서는 주문을 원하는 품목의 항목을 작성한 후에 주문 버튼을 클릭하면 해당 품목의 주문양을 적을 수 있는 팝업창이 뜨게되고, 입력을 완료하면 주문완료 팝업창이 뜬다
6.  대분류 조회
#### 품목을 대분류를 통해 조회하고자 할 때 사용되며,  사용자가 대분류를 추가하게 될 경우에 대분류 조회 프레임 내의 버튼이 자동적으로 추가될 수 있도록 설계하였음
7.  유통기한 조회
#### 유통기한 조회에서는 사용자가 원하는 남은 유통기한의 범위를 설정 한 후에, 검색버튼을 누르면, 테이블에 범위에 해당하는 품목들을 조회 할 수 있는 프레임이다
![image](https://user-images.githubusercontent.com/82793713/126890273-b93f0cb4-d9d8-4edf-b6f2-72a5d925485a.png)
8.  유통기한 폐기
#### 유통기한이 지난 품목이 테이블에 올라오게 되며, 폐기를 원하는 품목을 선택헀을 때, 폐기를 하겠냐는 팝업창이  뜨게 되고, Yes 버튼을 누르면 폐기가 완료되고,  DB에서 해당 품목 삭제
9.  행사 관리
* 이벤트 등록
* 이벤트 수정
* 이벤트 품목현황
10. 원가 및 마진율 조회
```C
SELECT * FROM PRODUCTS INNER JOIN (SELECT product_id,(product_price - COST) AS 순이익 FROM PRODUCTS) USING(product_id)
```
### 5.5_매장화면
![image](https://user-images.githubusercontent.com/82793713/126890385-b535b64c-3047-4b9b-b4f7-e40c2b27a01b.png)
1.  직원 정보 수정
```C
UPDATE employee SET employee_name=＇직원이름', job_id=‘직원id＇, phone_number=＇전화번호＇, positions=＇근무형태', duty_hours=근무시간, email=＇이메일＇, salary=월급 WHERE employee_id = 수정할 직원 id
```
2.  직원 등록
```C
INSERT INTO employee(직원id, 직원 이름, 직책id, 전화번호, 근무형태, 근무시간, email, 월급)
```
3.  날짜별 매출 조회

![image](https://user-images.githubusercontent.com/82793713/126890418-7af12df4-5c63-49af-b5ee-ce70039165e5.png)
```C
SELECT product_id, product_name, number_of_sales FROM sales INNER JOIN products USING ( product_id ) WHERE to_date(sales_time, 'yy/mm/dd') = to_date('"+date2+"', 'yy/mm/dd')
```
4.  품목별 매출 조회
```C
SELECT sales_time, number_of_sales FROM sales WHERE product_id = "+product_id
```
### 5.6_배달화면
![image](https://user-images.githubusercontent.com/82793713/126890441-8a349cc9-196d-4b07-9b4c-a95c6e154b2c.png)
1.  배달 현황 조회
```C
select DISTINCT DELIVERY_ID, MEMBERS_NAME, PAYMENT, MEMBERS_PHONENUMBER, TO_DATE(SALES_TIME, 'YY/MM/DD') as Sales_time,  DELIVERY_CHECK from delivery INNER JOIN member_informations USING (members_id) LEFT OUTER JOIN SALES USING (DELIVERY_ID) order by DELIVERY_ID 
```
2. 배달 여부 업데이트 
```C
UPDATE delivery SET delivery_check = 'Y 혹은 N' WHERE delivery_id = 업데이트하고자 하는 배달id 
```
