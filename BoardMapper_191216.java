package global.sesoc.board.dao;

import java.util.ArrayList;

import global.sesoc.board.vo.BoardVO;

/**
 * Mapper XML�� SQL�� ��� �޼��� ����
 */
public interface BoardMapper 
{ 
	//�� ����
	public int writeBoard(BoardVO b); 
	
	//�� 1�� �б�
	public BoardVO readBoard(int n);		

	//��� �� �б�
	public ArrayList<BoardVO> listBoard();
	
	//�� ����
	public int deleteBoard(int n);
	
	//�� ����
	public int updateBoard(BoardVO b);
	
	
	//interface�� �ȿ� �߻�޼ҵ尡 ��� �ִ�. ������ ���� �����Ű�� �޼ҵ尡 �ƴϴ�.
	//mybatis�� ���� �� ���ش�.
	//�츮�� �� ���� sql�� ����α�.
	//�� �������̽��� �޼ҵ� �̸�, ����, ���� Ÿ���� �����صд�.
	//BoardMapper.java�� BoardMapper.xml�� ����� �ִ�.
}

