package global.sesoc.person.ui;

import global.sesoc.person.dao.PersonDAO;
import global.sesoc.person.vo.Person;

public class PersonMain {

	public static void main(String[] args) 
	{
		//DB관련 처리를 담당하는 클래스의 객체 생성
		PersonDAO dao = new PersonDAO(); //PersonDAO 객체 생성
		
		//DAO객체의 메소드를 이용하여 데이터 처리
		//-> vo객체에 담아 보내기. PersonDAO 클래스를 이용한다. public int로 수정한 행 개수를 리턴
		Person pe;
		pe = new Person(); 
		pe.setNum(2);
		pe.setAge(100);
		dao.updatePerson(pe);
		
		int n = dao.updatePerson(pe);
		if(n != 0)
		{
			System.out.println("수정되었습니다.");
		}
		else
		{
			System.out.println("해당 회원이 없습니다.");
		}
		
	}

}
