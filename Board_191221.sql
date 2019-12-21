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