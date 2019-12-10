package test.ui;

import java.util.ArrayList;

import test.dao.PersonDAO;
import test.vo.Person;

public class TestMain 
{
	public static void main(String[] args) 
	{
		
		PersonDAO dao = new PersonDAO(); //PersonDAO 객체를 만듦, vo는 값을 실어가는 것,dao는 데이터 저장소와 소통하는 클래스명
		
		 int num = 1; //1이라는 숫자를 가진 회원을 삭제하고 싶다.
		 dao.deletePerson(num);
		
		
		
		//입력
		//Person pe;
		//pe = new Person("김철수", 30); //Person 클래스는 VO 클래스로 값을 담는 것
		//dao.insertPerson(pe);	//dao의 insertPerson 메소드에 값을 넘김
			
	}
}
