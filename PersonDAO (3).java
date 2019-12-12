package global.sesec.person.dao;


import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import global.sesec.person.vo.Person;


/**
 * DB관련 처리 클래스
 */
public class PersonDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	
	//회원정보 저장
	public void insertPerson(Person p) {
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			mapper.insertPerson(p);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}

	//번호를 전달받아 회원정보 삭제
	public void deletePerson(int n) {
		SqlSession ss = null;
		try {
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			mapper.deletePerson(n);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}

	//회원번호와 나이를 전달받아 해당 회원의 나이를 수정
	public int updatePerson(Person p) {
		int cnt = 0;
		SqlSession ss = null;
		try {
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			cnt = mapper.updatePerson(p);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}		
		return cnt;
	}
	
	//회원의 번호를 전달받아 정보를 리턴
	public Person selectPerson(int n) {
		SqlSession ss = null;
		Person p = null;
		try {
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			p = mapper.selectPerson(n);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}		
		return p;
	}
	
	
	//회원의 이름으로 검색
	public ArrayList<Person> selectPersonByName(String n) {
		SqlSession ss = null;
		ArrayList<Person> list = null;
		try {
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			list = mapper.selectPersonByName(n);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}		
		return list;
	}	
	
	
	
	
	
	
	
	
}
