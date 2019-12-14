package global.sesoc.person.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import global.sesoc.person.dao.PersonDAO;
import global.sesoc.person.vo.Person;

public class PersonUI 
{
	//DB���� ó���� ����ϴ� Ŭ������ ��ü ����
	PersonDAO dao = new PersonDAO(); //PersonDAO ��ü ����
	//�� �Է¹ޱ�
	Scanner scan = new Scanner(System.in); 
	//����Ʈ ����
	ArrayList<Person> list;

	public PersonUI() 
	{
		while(true)
		{
			int m = this.menuPrint();
			switch(m)
			{
				case 1:
					insert();
					break;
				case 2:
					delete();
					break;
				case 3:
					update();
					break;
				case 4:
					searchByNum();
					break;
				case 5:
					searchByName();
					break;
				case 6:
					searchAll();
					break;
				case 0:
					end();
					return;
			}
		}
	}
	
	public int menuPrint()
	{
		System.out.println("[Person]");
		System.out.println("1.�Է�");
		System.out.println("2.����");
		System.out.println("3.����");
		System.out.println("4.��ȣ�� �˻�");
		System.out.println("5.�̸����� �˻�");
		System.out.println("6.��� ȸ�� �˻�");
		System.out.println("0.���α׷� ����");
		
		int n = 0;
		while(true)
		{
			try
			{
				System.out.print("��ȣ ���� > ");
				n = scan.nextInt();
				if(n < 0 || n > 6)
				{
					continue;
				}
			}
			catch(Exception e)
			{
				scan.nextLine();
				continue;
			}
			break;
		}
		return n;	
	}
	
	public void insert()
	{
		
		System.out.println("[�Է�]");
		Person p;
		String name;
		int age;
		
		System.out.print("�̸� > ");
		name = scan.next();
		System.out.print("���� > ");
		age = scan.nextInt();
		p = new Person(name, age);
	
		int cnt = dao.insertPerson(p);
		if(cnt != 0)
		{
			System.out.println("�ԷµǾ����ϴ�.");
		}
		else
		{
			System.out.println("�Է� ����");
		}
	}
	
	public void delete()
	{
		
		System.out.println("[����]");
		int n = 0;
		while(true)
		{	
			try
			{
				System.out.print("��ȣ �Է�> ");
				n = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
				continue;
			}
			break;
		}
		
		//��ȣ�� ������ ������ ����, ������ ���� ����
		
		int cnt = dao.deletePerson(n);
		if(cnt != 0)
		{
			System.out.println("�����Ǿ����ϴ�.");
		}
		else
		{
			System.out.println("���� ����");
		}

	}

	public void update()
	{
		
		
		//DAO��ü�� �޼ҵ带 �̿��Ͽ� ������ ó��
		//-> vo��ü�� ��� ������. PersonDAO Ŭ������ �̿��Ѵ�. public int�� ������ �� ������ ����
		/*
		Person pe;
		pe = new Person(); 
		pe.setNum(2);
		pe.setAge(100);
		dao.updatePerson(pe);
		*/
		
		System.out.println("[����]");
		int num, age;
		String name;
		
		while(true)
		{
			try
			{
				System.out.print("�ٲ� ��ȣ> ");
				num = scan.nextInt();	
				System.out.print("�ٲ� �̸�> ");
				scan.nextLine();
				name = scan.nextLine();
				System.out.print("�ٲ� ����> ");
				age = scan.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("�߸� �Է��߽��ϴ�.");
				scan.nextLine();
				continue;
				
			}
			break;
		}
			
		
		Person p = new Person(name, age);
		
		int n = dao.updatePerson(p);
		
		if(n != 0)
		{
			System.out.println("�����Ǿ����ϴ�.");
		}
		else
		{
			System.out.println("�ش� ȸ���� �����ϴ�.");
		}
		
		
	}
	
	
	public void searchByNum()
	{
	
		//DAO��ü�� �޼ҵ带 �̿��Ͽ� ������ ó��
		
		//�˻��� ȸ���� ��ȣ�� �Է¹޴´�
		System.out.println("[��ȣ�� ȸ�� �˻�]");
		int n; 
		Person p;
		System.out.print("�˻��� ��ȣ > "); 
		n = scan.nextInt(); 
		p = dao.selectPerson(n);	
		 
		//�˻��Ѵ�
		//����� ������ "�ش� ��ȣ�� ȸ���� �����ϴ�." ��� ���
		if(p == null)
		{
			System.out.println("�ش� ��ȣ�� ȸ���� �����ϴ�.");
		}
		//����� ������ "��ȣ : 1 �̸� : ȫ�浿 ���� : 20" �������� ���
		else
		{
			System.out.print("��ȣ : " + p.getNum() + " "); 
			System.out.print("�̸� : " + p.getName() + " ");
			System.out.print("���� : " + p.getAge());	
		}
		
	
		
	}
	
	public void searchByName()
	{
		
		 
		//�̸����� ȸ�� �˻�
		System.out.println("[�̸����� ȸ�� �˻�]");
		System.out.print("�˻��� �̸� > ");
		String name = scan.next();
		list = dao.selectPersonByName(name);
		
		//null���� ������� ���� ������� �Ѵ�. �� �׷��� nullpointerException ����
		//and, or ���� ���� null�� ���� �־�� nullPointerException�� �ȳ���
		if(list == null || list.size() == 0 ) //list�� null�̸� �պκ��ϰ� �Ѿ.�� �ȿ� ����� ��ü ���� 0�̸� ȸ���� ���ٴ� ��
		{
			System.out.println("�ش� ȸ���� �����ϴ�.");
		}
		else
		{
			for(int i = 0; i < list.size(); i++)
			{
				System.out.print("��ȣ : " + list.get(i).getNum() + " ");
				System.out.print("�̸� : " + list.get(i).getName() + " ");
				System.out.print("���� : " + list.get(i).getAge());
				System.out.println();
			}
			//System.out.println(list);
		}
		
		
		
	}
	
	public void searchAll()
	{
		
		System.out.println("[��� ȸ�� �˻�]");
		list = dao.selectPersonAll();
		
		//null���� ������� ���� ������� �Ѵ�. �� �׷��� nullpointerException ����
		//and, or ���� ���� null�� ���� �־�� nullPointerException�� �ȳ���
		if(list == null || list.size() == 0 ) //list�� null�̸� �պκ��ϰ� �Ѿ.�� �ȿ� ����� ��ü ���� 0�̸� ȸ���� ���ٴ� ��
		{
			System.out.println("�ش� ȸ���� �����ϴ�.");
		}
		else
		{
			System.out.println(list);
		}
		
		
	}
	
	public void end()
	{
		
		System.out.println("���α׷��� �����մϴ�.");	
		
	}
	
}
