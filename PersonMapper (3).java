package global.sesec.person.dao;

import java.util.ArrayList;

import global.sesec.person.vo.Person;

/**
 * Mapper XML의 SQL문 사용 메서드 정의
 */
public interface PersonMapper {
	//Person객체 저장
	public int insertPerson(Person p);
	//번호로 행 삭제
	public int deletePerson(int n);
	//번호로 나이 수정
	public int updatePerson(Person p);
	//번호로 회원 검색
	public Person selectPerson(int n);
	//이름으로 회원 검색
	public ArrayList<Person> selectPersonByName(String n);
}











