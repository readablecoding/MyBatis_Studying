package global.sesec.person.ui;

import java.util.ArrayList;
import java.util.Scanner;

import global.sesec.person.dao.PersonDAO;
import global.sesec.person.vo.Person;

public class PersonMain {

	public static void main(String[] args) {
		//DB���� ó���� ����ϴ� Ŭ������ ��ü ����
		PersonDAO dao = new PersonDAO();
		
		//DAO��ü�� �޼ҵ带 �̿��Ͽ� ������ ó��
		
		//�˻��� ȸ���� ��ȣ�� �Է¹޴´�
		//�˻��Ѵ�
		//����� ������ "�ش� ��ȣ�� ȸ���� �����ϴ�." ��� ���
		//����� ������ "��ȣ : 1 �̸� : ȫ�浿  ����: 20" �������� ���
		Scanner scan = new Scanner(System.in);
/*		System.out.print("�˻��� ȸ�� ��ȣ : ");
		int num = scan.nextInt();
		
		Person p = dao.selectPerson(num);
		if (p == null) {
			System.out.println("ȸ���� �����ϴ�.");
		}
		else {
			System.out.print("��ȣ:" + p.getNum() + " ");
			System.out.print("�̸�:" + p.getName() + " ");
			System.out.println("����:" + p.getAge());
		}*/
		
		System.out.print("�˻��� �̸� : ");
		String name = scan.next();
		
		ArrayList<Person> list = dao.selectPersonByName(name);
		
		if () {
			System.out.println("�ش�Ǵ� ȸ���� �����ϴ�.");
		}
		else {
			System.out.println(list);
		}
		
		
		
		
		
		
		
		
		
//		Person pe;
//		pe = new Person();
//		pe.setNum(2);
//		pe.setAge(20);
//		
//		int n = dao.updatePerson(pe);
//		if (n != 0) {
//			System.out.println("�����Ǿ����ϴ�.");
//		}
//		else {
//			System.out.println("�ش� ȸ���� �����ϴ�.");
//		}

	}

}

