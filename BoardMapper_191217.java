package global.sesoc.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import global.sesoc.board.vo.BoardVO;

/**
 * Mapper XML�� SQL�� ��� �޼��� ����
 */
public interface BoardMapper 
{ 
	//�� ����
	public int writeBoard(BoardVO b); 
	
	//�� 1�� �б� �Ǵ� �� ��ü ����
	public ArrayList<BoardVO> readBoard(int n);		

	//��ü �� ����
	public ArrayList<BoardVO> listBoard();
	
	//�� ����
	public int deleteBoard(int n);
	
	//�� ����
	public int updateBoard(BoardVO b);
	
	//�� �˻�
	public ArrayList<BoardVO> searchBoard(HashMap<String, Object> map);
	
	
	//interface�� �ȿ� �߻�޼ҵ尡 ��� �ִ�. ������ ���� �����Ű�� �޼ҵ尡 �ƴϴ�.
	//mybatis�� ���� �� ���ش�.
	//�츮�� �� ���� sql�� ����α�.
	//�� �������̽��� �޼ҵ� �̸�, ����, ���� Ÿ���� �����صд�.
	//BoardMapper.java�� BoardMapper.xml�� ����� �ִ�.
}

