package test.ui;

import java.util.ArrayList;

import test.dao.PersonDAO;
import test.vo.Person;

public class TestMain 
{
	public static void main(String[] args) 
	{
		
		PersonDAO dao = new PersonDAO(); //PersonDAO ��ü�� ����, vo�� ���� �Ǿ�� ��,dao�� ������ ����ҿ� �����ϴ� Ŭ������
		
		 int num = 1; //1�̶�� ���ڸ� ���� ȸ���� �����ϰ� �ʹ�.
		 dao.deletePerson(num);
		
		
		
		//�Է�
		//Person pe;
		//pe = new Person("��ö��", 30); //Person Ŭ������ VO Ŭ������ ���� ��� ��
		//dao.insertPerson(pe);	//dao�� insertPerson �޼ҵ忡 ���� �ѱ�
			
	}
}
