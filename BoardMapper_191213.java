package global.sesoc.board.dao;

import java.util.ArrayList;

import global.sesoc.board.vo.BoardVO;

/**
 * Mapper XML의 SQL문 사용 메서드 정의
 */
public interface BoardMapper 
{ 
	//글쓰기
	public int writeBoard(BoardVO b); 
	
	//글 읽기
	public BoardVO readBoard(int n);		

	//글 목록 보기
	public ArrayList<BoardVO> listBoard();
	
	//interface는 안에 추상메소드가 들어 있다. 내용이 없고 실행시키는 메소드가 아니다.
	//mybatis가 일을 다 해준다.
	//우리가 할 일은 sql문 적어두기.
	
}

