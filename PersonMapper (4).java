package global.sesoc.person.dao;

import java.util.ArrayList;

import global.sesoc.person.vo.Person;

/**
 * Mapper XML의 SQL문 사용 메서드 정의
 */
public interface PersonMapper 
{ 
	//Person객체 저장
	public int insertPerson(Person p); //insert, delete, update는 int로 리턴, 처리한 행 개수 보여줌, 잘못되면 리턴이 0이다.
	//-> Person 타입의 p를 인수로 받는 insertPerson 메소드로 int형으로 리턴. 리턴이 0이면 실패한 것
	//-> PersonMapper에서 쓰는 것과 맞아야 한다.
	
	//번호로 행 삭제
	public int deletePerson(int n);		
	
	//번호로 나이 수정
	public int updatePerson(Person p); // PersonMapper.xml에서 일을 처리하고 돌아옴 그것을 도로 PersonDAO로 보냄
	
	//번호로 회원 검색
	public Person selectPerson(int n); // Mapper.xml에서 id는 selectPerson, parameter는 int n, result tpye은 Person
	
	//이름으로 회원 검색
	public ArrayList<Person> selectPersonByName(String s); //리턴 타입은 Person 객체가 담긴 ArrayList
	
	//모든 회원 보기
	public ArrayList<Person> selectPersonAll();
	
	//interface는 안에 추상메소드가 들어 있다. 내용이 없고 실행시키는 메소드가 아니다.
	//mybatis가 일을 다 해준다.
	//우리가 할 일은 sql문 적어두기.
	
}
