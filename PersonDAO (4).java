package global.sesoc.person.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import global.sesoc.person.vo.Person;

/**
 * DB���� ó�� Ŭ����
 */
public class PersonDAO 
{
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü
	//SqlSessionFactory�� �θ���.MybatisConfig.getSqlSessionFactory()�޼ҵ� . static �޼ҵ�
	
	//ȸ������ ����
	public int insertPerson(Person p) 
	{
		SqlSession ss = null;
		int cnt = 0;
		try 
		{
			ss = factory.openSession(); //������ ����. ���߿� commit �Ǵ� rollback �Ѵ�
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			cnt = mapper.insertPerson(p); //������ ������ �ѱ�. ȣ��
			ss.commit();	//commit �ϸ� �ϳ��� ������ ����. commit�� �ؾ� �����Ϳ� �ݿ��� �ȴ�.
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //���� �޽��� ���
		}
		finally 
		{			
			if (ss != null) ss.close();	//������ ���� �� ���ܰ� �߻� �ϰų� ���ϰų� ������ �ݵ��� finally�� ����
			
		}
		return cnt;
	
	}//insertPerson()
	
	//��ȣ�� ���޹޾� ȸ������ ����
	public int deletePerson(int n) 
	{
		SqlSession ss = null;
		int cnt = 0;
		try 
		{
			ss = factory.openSession(); //������ ����.
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			cnt = mapper.deletePerson(n); //n�̶�� ���ڸ� �Ѱ� deletePerson �޼ҵ� ȣ��
			ss.commit();	//commit �ϸ� �ϳ��� ������ ����.
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
	
	//ȸ����ȣ�� ���̸� ���޹޾� �ش� ȸ���� ���̸� ����
	public int updatePerson(Person p)
	{
		int cnt = 0;
		SqlSession ss = null;
		try
		{
			ss = factory.openSession(); //���� ����
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper �������̽��� mapper ��ü ����
			cnt = mapper.updatePerson(p); //������ �� ������ ������. ���� ���ϸ� 0, �ƴϸ� ��ģ �� ������ ����
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
	
	//ȸ���� ��ȣ�� ���޹޾� ������ ����
	public Person selectPerson(int n)
	{
		SqlSession ss = null;
		Person p = null;
		try
		{
			ss = factory.openSession(); //���� ����
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper �������̽��� mapper ��ü ����
			p = mapper.selectPerson(n); //p �ȿ� Person��ü(��ȣ,�̸�,����)�� �����ų� �ش��ȣ�� ������ null�� �´�.
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
			ss = factory.openSession(); //���� ����
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper �������̽��� mapper ��ü ����
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
			ss = factory.openSession(); //���� ����
			PersonMapper mapper = ss.getMapper(PersonMapper.class); //PersonMapper �������̽��� mapper ��ü ����
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

