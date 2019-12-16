package global.sesoc.board.dao;

import java.util.ArrayList;

import global.sesoc.board.vo.BoardVO;

/**
 * Mapper XML의 SQL문 사용 메서드 정의
 */
public interface BoardMapper 
{ 
	//글 저장
	public int writeBoard(BoardVO b); 
	
	//글 1개 읽기
	public BoardVO readBoard(int n);		

	//모든 글 읽기
	public ArrayList<BoardVO> listBoard();
	
	//글 삭제
	public int deleteBoard(int n);
	
	//글 수정
	public int updateBoard(BoardVO b);
	
	
	//interface는 안에 추상메소드가 들어 있다. 내용이 없고 실행시키는 메소드가 아니다.
	//mybatis가 일을 다 해준다.
	//우리가 할 일은 sql문 적어두기.
	//이 인터페이스는 메소드 이름, 인자, 리턴 타입을 설정해둔다.
	//BoardMapper.java는 BoardMapper.xml과 연결돼 있다.
}

