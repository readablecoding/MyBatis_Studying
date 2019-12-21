package board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import board.vo.BoardVO;

public interface BoardMapper 
{
	//����
	public int write(BoardVO vo);
	//�б�
	public ArrayList<BoardVO> read(int n);	
	//����
	public int update(BoardVO vo);	
	//����
	public int delete(int n);
	//�˻�
	public ArrayList<BoardVO> search(HashMap<String, Object> map);
}
