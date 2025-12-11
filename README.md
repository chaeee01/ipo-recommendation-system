## 📌 프로젝트 소개
사용자 조건(경쟁률, 공모가, 시장, 산업군, 날짜 범위 등)을 기반으로 공모주(IPO)를 추천해주는 웹 서비스입니다.  
Spring Boot + MySQL 기반으로 구현되었으며, 직관적인 UI를 통해 원하는 조건으로 손쉽게 필터링할 수 있습니다.

---

## 🛠 기술 스택 (Tech Stack)
- **Backend**: Spring Boot 3.x, Spring Web, Spring Data JPA  
- **Frontend**: Thymeleaf, HTML/CSS, Bootstrap  
- **Database**: MySQL 8.x  
- **Tools**: IntelliJ IDEA, MySQL Workbench, Git/GitHub  

---

- **Controller**: 사용자 요청 처리  
- **Service**: 검색 조건 적용 및 정렬 로직  
- **Repository**: JPA로 DB 데이터 조회  
- **Entity**: DB 매핑 객체  
- **MySQL**: IPO / Company / Underwriter 저장  

---

## ▶ 실행 방법 (Spring Boot)

1. **프로젝트 클론**

2. **MySQL 생성**
```sql
CREATE DATABASE ipo_db;
```
3. **application.properties 설정**
```properties   
spring.datasource.url=jdbc:mysql://localhost:3306/ipo_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
4. **IntelliJ에서 실행**
DemoApplication.java 선택 → Run
실행 후 브라우저에서 접속
(http://localhost:8080)

🗄 DB 복원 방법 (SQL Import)
1. MySQL Workbench 실행
2. 좌측 SCHEMAS에서 ipo_db 선택
3. 상단 메뉴 → Server → Data Import
4. Import from Self-Contained File 선택

→ export된 SQL 파일 선택 (ipo_db_export.sql 등)

5. "Default Target Schema"를 ipo_db로 맞추기
6. Start Import 클릭

→ Company, Underwriter, IPO 테이블과 모든 데이터 자동 복원





