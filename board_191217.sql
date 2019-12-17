--�Խ��� �� ����
CREATE TABLE BOARD(
    NUM         NUMBER PRIMARY KEY,             --�۹�ȣ
    ID           VARCHAR2(20) NOT NULL,         --�ۼ��� ID
    TITLE        VARCHAR2(200) NOT NULL,        --����
    CONTENTS    VARCHAR2(2000) NOT NULL,        --����
    INPUTDATE   DATE DEFAULT SYSDATE,           --�ۼ��ð� -> ����Ǵ� ������ �ð����� ����Ͻú���, �Է� ���ϸ� ����Ʈ�� ����ð� ��
    HITS        NUMBER DEFAULT 0,               --��ȸ��
    LIKES       NUMBER DEFAULT 0                --��õ��
);

--�Խ��� �� ��ȣ�� ����� ������ ->��ȣ�� �����´�.
CREATE SEQUENCE BOARD_SEQ;
--�Խ��� �� ���� ��       
INSERT INTO BOARD(NUM, ID, TITLE, CONTENTS) VALUES (BOARD_SEQ.NEXTVAL, '123', '����', '����');
INSERT INTO BOARD(NUM, ID, TITLE, CONTENTS) VALUES (BOARD_SEQ.NEXTVAL, '123', '�ȳ�', '�������̳�');
INSERT INTO BOARD(NUM, ID, TITLE, CONTENTS) VALUES (BOARD_SEQ.NEXTVAL, '555', '����', '�ɽ��ϳ�');
INSERT INTO BOARD(NUM, ID, TITLE, CONTENTS) VALUES (BOARD_SEQ.NEXTVAL, '789', '������', '����־�');
INSERT INTO BOARD(NUM, ID, TITLE, CONTENTS) VALUES (BOARD_SEQ.NEXTVAL, '666', '���ڳ�', '���� �ϰ� �ͳ�');
---> BOARD_SEQ.NEXTVAL�� ������ ��ȣ�� 1�� �þ��. ��ȣ�� �ٽ� �ǵ��� �� ����.