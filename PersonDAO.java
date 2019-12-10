package test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.vo.Person;

/**
 * DB���� ó�� Ŭ����
 */
public class PersonDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü
	//SqlSessionFactory�� �θ���.MybatisConfig.getSqlSessionFactory()�޼ҵ� . static �޼ҵ�
	
	//ȸ������ ����
	public void insertPerson(Person p) 
	{
		SqlSession ss = null;	
		
		try {
			ss = factory.openSession(); //���� ����
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			mapper.insertPerson(p); //������ ������ �ѱ�. ȣ��
			ss.commit();	//commit �ϸ� �ϳ��� ������ ����.
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}
	
	//��ȣ�� ���޹޾� ȸ������ ����
	public void deletePerson(int n) 
	{
		SqlSession ss = null;	
		
		try {
			ss = factory.openSession(); //������ ����.
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			mapper.deletePerson(n); //n�̶�� ���ڸ� �Ѱ� deletePerson �޼ҵ� ȣ��
			ss.commit();	//commit �ϸ� �ϳ��� ������ ����.
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}


}
