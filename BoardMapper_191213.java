package global.sesoc.board.dao;

import java.util.ArrayList;

import global.sesoc.board.vo.BoardVO;

/**
 * Mapper XML�� SQL�� ��� �޼��� ����
 */
public interface BoardMapper 
{ 
	//�۾���
	public int writeBoard(BoardVO b); 
	
	//�� �б�
	public BoardVO readBoard(int n);		

	//�� ��� ����
	public ArrayList<BoardVO> listBoard();
	
	//interface�� �ȿ� �߻�޼ҵ尡 ��� �ִ�. ������ ���� �����Ű�� �޼ҵ尡 �ƴϴ�.
	//mybatis�� ���� �� ���ش�.
	//�츮�� �� ���� sql�� ����α�.
	
}

