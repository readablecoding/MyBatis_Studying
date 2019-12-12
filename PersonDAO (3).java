package global.sesec.person.dao;


import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import global.sesec.person.vo.Person;


/**
 * DB���� ó�� Ŭ����
 */
public class PersonDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü
	
	//ȸ������ ����
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

	//��ȣ�� ���޹޾� ȸ������ ����
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

	//ȸ����ȣ�� ���̸� ���޹޾� �ش� ȸ���� ���̸� ����
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
	
	//ȸ���� ��ȣ�� ���޹޾� ������ ����
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
	
	
	//ȸ���� �̸����� �˻�
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
