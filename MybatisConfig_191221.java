package board.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources; 
import org.apache.ibatis.session.SqlSessionFactory;  
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis�� ȯ�� ���� �а� ��ü ����
 */
public class MybatisConfig 
{
	private static SqlSessionFactory sqlSessionFactory; 

	static 
	{
		String resource = "mybatis-config.xml";		
		
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

	public static SqlSessionFactory getSqlSessionFactory() // �θ��� Ŭ������ �޼ҵ��, ó�� �θ� �� ��ü�� ȣ��. �״������ʹ� �ּҸ� ����
	{
		return sqlSessionFactory;
	}
}