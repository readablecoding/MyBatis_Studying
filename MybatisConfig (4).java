package global.sesoc.person.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources; 
import org.apache.ibatis.session.SqlSessionFactory;  //mybatis 관련 클래스
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis의 환경 설정 읽고 객체 생성
 */
public class MybatisConfig 
{
	private static SqlSessionFactory sqlSessionFactory; //static 변수 선언, 외부에서 접근 못하고 하나만 만들어짐

	static //MybatisConfig 클래스가 로딩될 때 지나가는 곳. static 초기화 블럭. 프로그램 시작 시 무조건 처음 딱 한번 static{}실행
	{
		String resource = "mybatis-config.xml";		//Mybatis 환경설정 파일인 mybatis-config.xml 읽기. src 경로에 저장.
		
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
