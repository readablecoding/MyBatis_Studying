package test.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources; 
import org.apache.ibatis.session.SqlSessionFactory;  //mybatis ���� Ŭ����
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis�� ȯ�� ���� �а� ��ü ����
 */
public class MybatisConfig 
{
	private static SqlSessionFactory sqlSessionFactory; //static ���� ����, �ܺο��� ���� ���ϰ� �ϳ��� �������

	static //MybatisConfig Ŭ������ �ε��� �� �������� ��. �ʱ�ȭ ��. ���α׷� ���� �� ������ ó�� �� �ѹ� static{}����
	{
		String resource = "mybatis-config.xml";		//Mybatis ȯ�漳�� ���� �б�. src ��ο� ����.
		
		try 
		{
			Reader reader = Resources.getResourceAsReader(resource); 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); //��ü �����
			reader.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() // �θ��� Ŭ������ �޼ҵ��
	{
		return sqlSessionFactory;
	}
}
