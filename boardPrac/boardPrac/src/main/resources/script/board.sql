-- Sequence 생성
CREATE SEQUENCE seq_board;

-- Table 생성
CREATE TABLE tbl_board
(
	bno			number(10),
	title		varchar2(200) NOT NULL,
	content		varchar2(2000) NOT NULL,
	writer		varchar2(50) NOT NULL,
	regdate		DATE DEFAULT sysdate,
	updatedate	DATE DEFAULT sysdate
);

-- Primary Key 생성
ALTER TABLE tbl_board ADD CONSTRAINT PK_BOARD PRIMARY KEY(bno);

SELECT * FROM tbl_board;

INSERT INTO tbl_board(bno, title, content, writer)
VALUES (seq_board.nextval, '테스트 제목', '테스트 내용', 'admin' );
