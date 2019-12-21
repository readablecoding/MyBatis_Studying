package board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import board.vo.BoardVO;

public interface BoardMapper 
{
	//쓰기
	public int write(BoardVO vo);
	//읽기
	public ArrayList<BoardVO> read(int n);	
	//수정
	public int update(BoardVO vo);	
	//삭제
	public int delete(int n);
	//검색
	public ArrayList<BoardVO> search(HashMap<String, Object> map);
}
