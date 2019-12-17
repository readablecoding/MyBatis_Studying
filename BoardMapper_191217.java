package global.sesoc.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import global.sesoc.board.vo.BoardVO;

/**
 * Mapper XML의 SQL문 사용 메서드 정의
 */
public interface BoardMapper 
{ 
	//글 저장
	public int writeBoard(BoardVO b); 
	
	//글 1개 읽기 또는 글 전체 보기
	public ArrayList<BoardVO> readBoard(int n);		

	//전체 글 보기
	public ArrayList<BoardVO> listBoard();
	
	//글 삭제
	public int deleteBoard(int n);
	
	//글 수정
	public int updateBoard(BoardVO b);
	
	//글 검색
	public ArrayList<BoardVO> searchBoard(HashMap<String, Object> map);
	
	
	//interface는 안에 추상메소드가 들어 있다. 내용이 없고 실행시키는 메소드가 아니다.
	//mybatis가 일을 다 해준다.
	//우리가 할 일은 sql문 적어두기.
	//이 인터페이스는 메소드 이름, 인자, 리턴 타입을 설정해둔다.
	//BoardMapper.java는 BoardMapper.xml과 연결돼 있다.
}

