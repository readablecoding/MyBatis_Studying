package global.sesoc.person.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import global.sesoc.person.vo.Person;

/**
 * DB관련 처리 클래스
 */
public class PersonDAO 
{
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	//SqlSessionFactory를 부른다.MybatisConfig.getSqlSessionFactory()메소드 . static 메소드
	
	//회원정보 저장
	public void insertPerson(Person p) 
	{
		SqlSession ss = null;	
		
		try 
		{
			ss = factory.openSession(); //세션을 연다. 나중에 commit 또는 rollback 한다
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper는 실제 실행되는 코드가 들어있는 곳
			mapper.insertPerson(p); //저장할 데이터 넘김. 호출
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
	}
	
	//번호를 전달받아 회원정보 삭제
	public void deletePerson(int n) 
	{
		SqlSession ss = null;	
		
		try 
		{
			ss = factory.openSession(); //세션을 연다.
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper는 실제 실행되는 코드가 들어있는 곳
			mapper.deletePerson(n); //n이라는 숫자를 넘겨 deletePerson 메소드 호출
			ss.commit();	//commit 하면 하나의 세션이 끝남.
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (ss != null) ss.close();
		}
	}
	
	//회원번호와 나이를 전달받아 해당 회원의 나이를 수정
	public int updatePerson(Person p)
	{
		int cnt = 0;
		SqlSession ss = null;
		try
		{
			ss = factory.openSession(); //세션 열기
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper 인터페이스의 mapper 객체 생성
			cnt = mapper.updatePerson(p); //수정한 행 개수를 리턴함. 수정 못하면 0, 아니면 고친 행 개수를 리턴
			ss.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ss != null)
				ss.close();
		}
		
		return cnt;
		
	}
	


}
