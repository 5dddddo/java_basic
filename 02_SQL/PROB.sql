--users 테이블 생성 구문 
  --   id          
    -- password   
     --name        
    -- role     

CREATE TABLE USERS (

	ID VARCHAR2(12) CONSTRAINT USERS_PK PRIMARY KEY,
	PASSWORD VARCHAR2(15) CONSTRAINT PSWD_NN NOT NULL,
	NAME VARCHAR2(10),
	ROLE VARCHAR2(10)

);

--board 테이블 생성 구문 
--     seq          
--     title        
--     content      
--     regdate     
--     cnt         
--     userid    

CREATE TABLE BOARD(

	SEQ NUMBER(10) CONSTRAINT SEQ_PK PRIMARY KEY,
	TITLE VARCHAR2(10) CONSTRAINT TITLE_NN NOT NULL,
	CONTENTS VARCHAR2(10) CONSTRAINT CONTENTS_NN NOT NULL,
	REGDATE DATE DEFAULT SYSDATE,
	CNT NUMBER(10) CONSTRAINT CNT_NN UNIQUE,
	USERID VARCHAR2(12) CONSTRAINT UID_FK REFERENCES USERS

);

--회원등록
INSERT INTO USERS(ID, PASSWORD, NAME, ROLE) 
	VALUES ('KKK', 'PPPPP12', 'KIM', 'WORRIOR');
--회원정보수정
UPDATE USERS SET NAME = 'PAUL' WHERE ID = 'KKK';
UPDATE USERS SET PASSWORD = 'PAUL' WHERE ID = 'KKK';
UPDATE USERS SET ROLE = 'CAL' WHERE ID = 'KKK';
--로그인

--
--게시판 글등록
CREATE SEQUENCE CNT;
INSERT INTO BOARD(SEQ, TITLE, CONTENTS, REGDATE, CNT, USERID)
	VALUES((SELECT 
				NVL(MAX(SEQ), 0)+1 FROM BOARD
			), 'JLJLJL', 'MLSJLFL', SYSDATE, CNT.NEXTVAL, 'KKK');
--글수정
UPDATE BOARD SET TITLE = 'PPPPPPP' 
	WHERE USERID = 'KKK';
	
UPDATE BOARD SET CONTENTS = 'ccccccc' 
	WHERE USERID = 'KKK';
	
--게시판 글 삭제

DELETE FROM BOARD WHERE SEQ = 1 AND USERID = 'KKK';

--
--데이터검색(Query)
SELECT CONTENTS FROM BOARD WHERE CONTENTS LIKE '%c%';
SELECT * FROM BOARD WHERE USERID LIKE '%K%';
--전체 등록글 수
SELECT MAX(CNT) FROM BOARD;
--사용자별 등록글수 
SELECT COUNT(B.SEQ)  
FROM USERS U, BOARD B
WHERE U.ID = B.USERID;
--월별개시글수
SELECT COUNT(SEQ)
FROM BOARD
WHERE TO_CHAR(REGDATE,'MM') LIKE '03';
--사용자별 게시글 검색
SELECT * FROM BOARD WHERE USERID LIKE '%K%';
--제목으로 게시글 검색
SELECT CONTENTS FROM BOARD WHERE CONTENTS LIKE '%c%';

     










