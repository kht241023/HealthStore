
# MySQL 사용자 및 데이터베이스 설정

이 문서는 MySQL에서 새로운 사용자를 생성하고, 데이터베이스를 설정하는 방법을 설명한다.
## 0. 데이터베이스 및 사용자 생성을 위해 mySql 접속
```sql
mysql -u root -p
비밀번호 : kht1234
```
cmd(명령 프롬포트) 창 접속하여 mysql 접속하기

## 1. 데이터베이스 및 사용자 생성
```sql
CREATE USER 'testkht'@'%' IDENTIFIED BY 'kht1234';
```
### 1.1 데이터베이스 생성
다음 명령을 실행하여 `testdb`라는 새로운 데이터베이스를 생성

```sql
CREATE DATABASE testdb;
```
```
ERROR 1007 (HY000): Can't create database 'testdb'; database exists
가 뜰 경우 testdb 가 존재한다는 의미 이므로 1.2.2 로 이동하여 권한 부여 진행
```

### 1.2 사용자 생성 및 권한 부여
새로운 사용자의 ID와 비밀번호는 다음과 같다.

- **사용자명:** `testkht`
- **비밀번호:** `kht1234`

#### 1.2.1 사용자 생성
데이터베이스 및 사용자 생성에서 생성 진행

#### 1.2.2 권한 부여
새로운 사용자 `testkht`에게 `testdb` 데이터베이스에 대한 모든 권한 부여

```sql
GRANT ALL PRIVILEGES ON testdb.* TO 'testkht'@'%';
```

#### 1.2.3 변경 사항 적용
```sql
FLUSH PRIVILEGES;
```

---

## 2. 운동 프로그램 테이블 (`health_programs`) 생성 및 데이터 입력
### 2.0 데이터베이스 접속
다음 SQL을 실행하여 `testdb` 데이터베이스 접속

```sql
USE testdb;
```

### 2.1 테이블 생성
다음 SQL을 실행하여 `health_programs` 테이블을 생성

```sql
CREATE TABLE health_programs (
    health_program_id INT AUTO_INCREMENT PRIMARY KEY,  -- 운동 프로그램 ID
    program_name VARCHAR(100) NOT NULL,               -- 프로그램 이름
    program_type VARCHAR(50) NOT NULL,                -- 프로그램 유형 (유산소, 근력 등)
    workout_duration INT NOT NULL,                    -- 운동 시간 (분)
    intensity_level VARCHAR(20) NOT NULL,             -- 강도 (초급/중급/고급)
    program_description TEXT NOT NULL,                -- 프로그램 설명
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- 생성 일시
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 업데이트 일시
);
```

### 2.2 데이터 삽입
다음 SQL을 실행하여 기본 운동 프로그램 데이터를 삽입

```sql
INSERT INTO health_programs (
    program_name, 
    program_type, 
    workout_duration, 
    intensity_level, 
    program_description, 
    created_at, 
    updated_at
) VALUES 
('기초 러닝', '유산소', 30, '초급', '초보자를 위한 가벼운 러닝 프로그램.', NOW(), NOW()),
('인터벌 러닝', '유산소', 40, '중급', '속도 조절을 통한 체력 향상 러닝 프로그램.', NOW(), NOW()),
('장거리 러닝', '유산소', 60, '고급', '장거리를 뛰며 지구력을 향상시키는 프로그램.', NOW(), NOW()),
('상체 근력 운동', '근력', 40, '중급', '덤벨과 바벨을 활용한 상체 근력 강화 프로그램.', NOW(), NOW()),
('하체 근력 강화', '근력', 45, '중급', '스쿼트, 런지 등 하체를 집중적으로 단련.', NOW(), NOW()),
('풀업 마스터', '근력', 30, '고급', '자신의 체중을 활용한 상체 강화 프로그램.', NOW(), NOW()),
('기초 요가', '유연성', 60, '초급', '몸을 유연하게 만들고 정신을 안정시키는 요가.', NOW(), NOW()),
('파워 요가', '유연성', 50, '중급', '근력과 유연성을 동시에 기르는 강도 높은 요가.', NOW(), NOW()),
('필라테스 코어', '유연성', 45, '중급', '코어 근육을 강화하는 필라테스 프로그램.', NOW(), NOW()),
('크로스핏 베이직', '복합', 45, '중급', '유산소와 근력 운동을 조화롭게 구성.', NOW(), NOW()),
('부트캠프 스타일', '복합', 50, '고급', '군대식 훈련 프로그램을 기반으로 한 강도 높은 운동.', NOW(), NOW()),
('스포츠 컨디셔닝', '복합', 60, '중급', '운동선수 컨디셔닝을 위한 트레이닝.', NOW(), NOW()),
('핸드스탠드 트레이닝', '복합', 45, '고급', '균형과 근력을 동시에 키우는 프로그램.', NOW(), NOW()),
('트램폴린 피트니스', '복합', 55, '초급', '트램폴린을 활용하여 재미있게 운동하는 프로그램.', NOW(), NOW());
```

### 2.3 데이터 조회
테이블의 모든 데이터를 조회하려면 다음 SQL을 실행

```sql
SELECT * FROM health_programs;
```

---

## 3. MySQL 접속 방법
MySQL CLI 또는 MySQL Workbench를 사용하여 `testkht` 사용자로 `testdb` 데이터베이스에 접속하려면 다음 명령을 실행

```sh
mysql -u testkht -p -h [서버주소] testdb
```

비밀번호 입력 시 `kht1234`를 입력하면 접속할 수 있다.

