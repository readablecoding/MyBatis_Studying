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