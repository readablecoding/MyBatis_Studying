package test.dao;

import java.util.ArrayList;

import test.vo.Person;

/**
 * Mapper XML의 SQL문 사용 메서드 정의
 */
public interface PersonMapper 
{ 
	//Person객체 저장
	public int insertPerson(Person p); //insert, delete, update는 int로 리턴, 처리한 행 개수 보여줌, 잘못되면 리턴이 0이다.
	//번호로 행 삭제
	public int deletePerson(int n);		
	
	//interface는 안에 추상메소드가 들어 있다. 내용이 없고 실행시키는 메소드가 아니다.
	//mybatis가 일을 다 해준다.
	//우리가 할 일은 sql문 적어두기.
	
	
}
