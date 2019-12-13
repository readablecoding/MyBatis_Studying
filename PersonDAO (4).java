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
	public int insertPerson(Person p) 
	{
		SqlSession ss = null;
		int cnt = 0;
		try 
		{
			ss = factory.openSession(); //세션을 연다. 나중에 commit 또는 rollback 한다
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper는 실제 실행되는 코드가 들어있는 곳
			cnt = mapper.insertPerson(p); //저장할 데이터 넘김. 호출
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
	
	}//insertPerson()
	
	//번호를 전달받아 회원정보 삭제
	public int deletePerson(int n) 
	{
		SqlSession ss = null;
		int cnt = 0;
		try 
		{
			ss = factory.openSession(); //세션을 연다.
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper는 실제 실행되는 코드가 들어있는 곳
			cnt = mapper.deletePerson(n); //n이라는 숫자를 넘겨 deletePerson 메소드 호출
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
		return cnt;
	}//deletePerson()
	
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
		
	}//updatePerson()
	
	//회원의 번호를 전달받아 정보를 리턴
	public Person selectPerson(int n)
	{
		SqlSession ss = null;
		Person p = null;
		try
		{
			ss = factory.openSession(); //세션 열기
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper 인터페이스의 mapper 객체 생성
			p = mapper.selectPerson(n); //p 안에 Person객체(번호,이름,나이)가 들어오거나 해당번호가 없으면 null이 온다.
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
		return p;
	}
	
	public ArrayList<Person> selectPersonByName(String s)
	{
		SqlSession ss = null;
		ArrayList<Person> list = new ArrayList<Person>();
		try
		{
			ss = factory.openSession(); //세션 열기
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper 인터페이스의 mapper 객체 생성
			list = mapper.selectPersonByName(s); 
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
		return list;	
	}
	
	public ArrayList<Person> selectPersonAll()
	{
		SqlSession ss = null;
		ArrayList<Person> list = new ArrayList<Person>();
		try
		{
			ss = factory.openSession(); //세션 열기
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper 인터페이스의 mapper 객체 생성
			list = mapper.selectPersonAll(); 
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
		return list;	
	}
	
}

