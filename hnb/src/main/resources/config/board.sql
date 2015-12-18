CREATE TABLE THEME(
	THEME_NO NUMBER,
	THEME_NAME VARCHAR2(30),
	CONSTRAINT THEME_PK PRIMARY KEY(THEME_NO)
);
CREATE TABLE BOARD(
	RCD_NO NUMBER,
	GRP_NO NUMBER,
	THEME_NO NUMBER,
	USR_NAME VARCHAR2(30),
	USR_MAIL VARCHAR2(30),
	USR_SUBJECT VARCHAR2(30),
	USR_CONTENT VARCHAR2(1000),
	USR_PASS VARCHAR2(30),
	USR_FILE_NAME VARCHAR2(30),
	USR_FILE_SIZE VARCHAR2(30),
	USR_DATE VARCHAR2(30),
	USR_REFER NUMBER,
	RCD_LEVEL NUMBER,
	RCD_ORDER NUMBER,
	CONSTRAINT BOARD_PK PRIMARY KEY(RCD_NO),
	CONSTRAINT BOARD_FK_THEME FOREIGN KEY(THEME_NO) REFERENCES THEME(THEME_NO)
);
INSERT INTO THEME(THEME_NO, THEME_NAME)
VALUES (SEQ.NEXTVAL, '회원관리'); -- 시퀀스 : 141
INSERT INTO THEME(THEME_NO, THEME_NAME)
VALUES (SEQ.NEXTVAL, '자유게시판'); -- 시퀀스 : 142
SELECT * FROM THEME;