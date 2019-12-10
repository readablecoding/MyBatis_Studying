package test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.vo.Person;

/**
 * DB관련 처리 클래스
 */
public class PersonDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	//SqlSessionFactory를 부른다.MybatisConfig.getSqlSessionFactory()메소드 . static 메소드
	
	//회원정보 저장
	public void insertPerson(Person p) 
	{
		SqlSession ss = null;	
		
		try {
			ss = factory.openSession(); //세션 시작
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper는 실제 실행되는 코드가 들어있는 곳
			mapper.insertPerson(p); //저장할 데이터 넘김. 호출
			ss.commit();	//commit 하면 하나의 세션이 끝남.
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}
	
	//번호를 전달받아 회원정보 삭제
	public void deletePerson(int n) 
	{
		SqlSession ss = null;	
		
		try {
			ss = factory.openSession(); //세션을 연다.
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper는 실제 실행되는 코드가 들어있는 곳
			mapper.deletePerson(n); //n이라는 숫자를 넘겨 deletePerson 메소드 호출
			ss.commit();	//commit 하면 하나의 세션이 끝남.
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}


}
