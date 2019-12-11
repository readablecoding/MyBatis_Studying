package global.sesoc.person.ui;

import global.sesoc.person.dao.PersonDAO;
import global.sesoc.person.vo.Person;

public class PersonMain {

	public static void main(String[] args) 
	{
		//DB���� ó���� ����ϴ� Ŭ������ ��ü ����
		PersonDAO dao = new PersonDAO(); //PersonDAO ��ü ����
		
		//DAO��ü�� �޼ҵ带 �̿��Ͽ� ������ ó��
		//-> vo��ü�� ��� ������. PersonDAO Ŭ������ �̿��Ѵ�. public int�� ������ �� ������ ����
		Person pe;
		pe = new Person(); 
		pe.setNum(2);
		pe.setAge(100);
		dao.updatePerson(pe);
		
		int n = dao.updatePerson(pe);
		if(n != 0)
		{
			System.out.println("�����Ǿ����ϴ�.");
		}
		else
		{
			System.out.println("�ش� ȸ���� �����ϴ�.");
		}
		
	}

}
