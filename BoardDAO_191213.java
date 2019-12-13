package global.sesoc.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import global.sesoc.board.dao.MybatisConfig;
import global.sesoc.board.dao.BoardMapper;
import global.sesoc.board.vo.BoardVO;



public class BoardDAO 
{
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	//SqlSessionFactory를 부른다.MybatisConfig.getSqlSessionFactory()메소드 . static 메소드
	
	//글쓰기
	public int writeBoard(BoardVO vo) 
	{
		SqlSession ss = null;
		int cnt = 0;
		try 
		{
			ss = factory.openSession(); //세션을 연다. 나중에 commit 또는 rollback 한다
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //PersonMapper는 실제 실행되는 코드가 들어있는 곳
			cnt = mapper.writeBoard(vo); //저장할 데이터 넘김. 호출
			ss.commit();	//commit 하면 하나의 세션이 끝남. commit을 해야 데이터에 반영이 된다.
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //에러 메시지 출력
		}
		finally 
		{			
			if (ss != null) ss.close();	//세션이 있을 때 예외가 발생 하거나 안하거나 세션을 닫도록 finally에 넣음
			
		}
		return cnt;

	}//writeBoard
	
	
	
	//글 읽기
	public BoardVO readBoard(int n) 
	{
		SqlSession ss = null;
		BoardVO vo = null;
		try 
		{
			ss = factory.openSession(); //세션을 연다. 나중에 commit 또는 rollback 한다
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //PersonMapper는 실제 실행되는 코드가 들어있는 곳
			vo = mapper.readBoard(n); //저장할 데이터 넘김. 호출
			ss.commit();	//commit 하면 하나의 세션이 끝남. commit을 해야 데이터에 반영이 된다.
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //에러 메시지 출력
		}
		finally 
		{			
			if (ss != null) ss.close();	//세션이 있을 때 예외가 발생 하거나 안하거나 세션을 닫도록 finally에 넣음
				
		}
		return vo;
	}//readBoard
		
	//글 목록 보기
	public ArrayList<BoardVO> listBoard() 
	{
		SqlSession ss = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>(); 
		try 
		{
			ss = factory.openSession(); //세션을 연다. 나중에 commit 또는 rollback 한다
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //PersonMapper는 실제 실행되는 코드가 들어있는 곳
			list = mapper.listBoard(); //저장할 데이터 넘김. 호출
			ss.commit();	//commit 하면 하나의 세션이 끝남. commit을 해야 데이터에 반영이 된다.
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //에러 메시지 출력
		}
		finally 
		{			
			if (ss != null) ss.close();	//세션이 있을 때 예외가 발생 하거나 안하거나 세션을 닫도록 finally에 넣음
				
		}
		return list;
		
	}//listBoard	
	
}//class BoardDAO