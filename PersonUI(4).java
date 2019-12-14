package global.sesoc.person.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import global.sesoc.person.dao.PersonDAO;
import global.sesoc.person.vo.Person;

public class PersonUI 
{
	//DB관련 처리를 담당하는 클래스의 객체 생성
	PersonDAO dao = new PersonDAO(); //PersonDAO 객체 생성
	//값 입력받기
	Scanner scan = new Scanner(System.in); 
	//리스트 설정
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
		System.out.println("1.입력");
		System.out.println("2.삭제");
		System.out.println("3.수정");
		System.out.println("4.번호로 검색");
		System.out.println("5.이름으로 검색");
		System.out.println("6.모든 회원 검색");
		System.out.println("0.프로그램 종료");
		
		int n = 0;
		while(true)
		{
			try
			{
				System.out.print("번호 선택 > ");
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
		
		System.out.println("[입력]");
		Person p;
		String name;
		int age;
		
		System.out.print("이름 > ");
		name = scan.next();
		System.out.print("나이 > ");
		age = scan.nextInt();
		p = new Person(name, age);
	
		int cnt = dao.insertPerson(p);
		if(cnt != 0)
		{
			System.out.println("입력되었습니다.");
		}
		else
		{
			System.out.println("입력 실패");
		}
	}
	
	public void delete()
	{
		
		System.out.println("[삭제]");
		int n = 0;
		while(true)
		{	
			try
			{
				System.out.print("번호 입력> ");
				n = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
				continue;
			}
			break;
		}
		
		//번호가 기존에 있으면 삭제, 없으면 삭제 못함
		
		int cnt = dao.deletePerson(n);
		if(cnt != 0)
		{
			System.out.println("삭제되었습니다.");
		}
		else
		{
			System.out.println("삭제 실패");
		}

	}

	public void update()
	{
		
		
		//DAO객체의 메소드를 이용하여 데이터 처리
		//-> vo객체에 담아 보내기. PersonDAO 클래스를 이용한다. public int로 수정한 행 개수를 리턴
		/*
		Person pe;
		pe = new Person(); 
		pe.setNum(2);
		pe.setAge(100);
		dao.updatePerson(pe);
		*/
		
		System.out.println("[수정]");
		int num, age;
		String name;
		
		while(true)
		{
			try
			{
				System.out.print("바꿀 번호> ");
				num = scan.nextInt();	
				System.out.print("바꿀 이름> ");
				scan.nextLine();
				name = scan.nextLine();
				System.out.print("바꿀 나이> ");
				age = scan.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("잘못 입력했습니다.");
				scan.nextLine();
				continue;
				
			}
			break;
		}
			
		
		Person p = new Person(name, age);
		
		int n = dao.updatePerson(p);
		
		if(n != 0)
		{
			System.out.println("수정되었습니다.");
		}
		else
		{
			System.out.println("해당 회원이 없습니다.");
		}
		
		
	}
	
	
	public void searchByNum()
	{
	
		//DAO객체의 메소드를 이용하여 데이터 처리
		
		//검색할 회원의 번호를 입력받는다
		System.out.println("[번호로 회원 검색]");
		int n; 
		Person p;
		System.out.print("검색할 번호 > "); 
		n = scan.nextInt(); 
		p = dao.selectPerson(n);	
		 
		//검색한다
		//결과가 없으면 "해당 번호의 회원이 없습니다." 라고 출력
		if(p == null)
		{
			System.out.println("해당 번호의 회원이 없습니다.");
		}
		//결과가 있으면 "번호 : 1 이름 : 홍길동 나이 : 20" 형식으로 출력
		else
		{
			System.out.print("번호 : " + p.getNum() + " "); 
			System.out.print("이름 : " + p.getName() + " ");
			System.out.print("나이 : " + p.getAge());	
		}
		
	
		
	}
	
	public void searchByName()
	{
		
		 
		//이름으로 회원 검색
		System.out.println("[이름으로 회원 검색]");
		System.out.print("검색할 이름 > ");
		String name = scan.next();
		list = dao.selectPersonByName(name);
		
		//null인지 물어보려면 먼저 물어봐야 한다. 안 그러면 nullpointerException 나옴
		//and, or 넣을 때는 null을 먼저 넣어야 nullPointerException이 안나옴
		if(list == null || list.size() == 0 ) //list가 null이면 앞부분하고 넘어감.그 안에 저장된 객체 수가 0이면 회원이 없다는 것
		{
			System.out.println("해당 회원이 없습니다.");
		}
		else
		{
			for(int i = 0; i < list.size(); i++)
			{
				System.out.print("번호 : " + list.get(i).getNum() + " ");
				System.out.print("이름 : " + list.get(i).getName() + " ");
				System.out.print("나이 : " + list.get(i).getAge());
				System.out.println();
			}
			//System.out.println(list);
		}
		
		
		
	}
	
	public void searchAll()
	{
		
		System.out.println("[모든 회원 검색]");
		list = dao.selectPersonAll();
		
		//null인지 물어보려면 먼저 물어봐야 한다. 안 그러면 nullpointerException 나옴
		//and, or 넣을 때는 null을 먼저 넣어야 nullPointerException이 안나옴
		if(list == null || list.size() == 0 ) //list가 null이면 앞부분하고 넘어감.그 안에 저장된 객체 수가 0이면 회원이 없다는 것
		{
			System.out.println("해당 회원이 없습니다.");
		}
		else
		{
			System.out.println(list);
		}
		
		
	}
	
	public void end()
	{
		
		System.out.println("프로그램을 종료합니다.");	
		
	}
	
}
