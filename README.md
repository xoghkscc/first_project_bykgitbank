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
