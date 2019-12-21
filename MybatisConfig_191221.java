package board.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources; 
import org.apache.ibatis.session.SqlSessionFactory;  
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis의 환경 설정 읽고 객체 생성
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
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); //객체 만들기
			reader.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() // 부를때 클래스명 메소드명, 처음 부를 때 객체를 호출. 그다음부터는 주소만 리턴
	{
		return sqlSessionFactory;
	}
}