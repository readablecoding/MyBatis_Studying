--게시판 글 정보
CREATE TABLE BOARD(
    NUM         NUMBER PRIMARY KEY,             --글번호
    ID           VARCHAR2(20) NOT NULL,         --작성자 ID
    TITLE        VARCHAR2(200) NOT NULL,        --제목
    CONTENTS    VARCHAR2(2000) NOT NULL,        --내용
    INPUTDATE   DATE DEFAULT SYSDATE,           --작성시간 -> 저장되는 순간의 시간으로 년월일시분초, 입력 안하면 디폴트로 현재시간 들어감
    HITS        NUMBER DEFAULT 0,               --조회수
    LIKES       NUMBER DEFAULT 0                --추천수
);

--게시판 글 번호에 사용할 시퀀스 ->번호만 내놓는다.
CREATE SEQUENCE BOARD_SEQ;
--게시판 글 저장 예       
INSERT INTO BOARD(NUM, ID, TITLE, CONTENTS) VALUES (BOARD_SEQ.NEXTVAL, '123', '제목', '내용');
INSERT INTO BOARD(NUM, ID, TITLE, CONTENTS) VALUES (BOARD_SEQ.NEXTVAL, '123', '안녕', '오랜만이네');
INSERT INTO BOARD(NUM, ID, TITLE, CONTENTS) VALUES (BOARD_SEQ.NEXTVAL, '555', '뭐해', '심심하네');
INSERT INTO BOARD(NUM, ID, TITLE, CONTENTS) VALUES (BOARD_SEQ.NEXTVAL, '789', '게임해', '재미있어');
INSERT INTO BOARD(NUM, ID, TITLE, CONTENTS) VALUES (BOARD_SEQ.NEXTVAL, '666', '좋겠네', '나도 하고 싶네');
---> BOARD_SEQ.NEXTVAL할 때마다 번호가 1씩 늘어난다. 번호를 다시 되돌릴 수 없다.