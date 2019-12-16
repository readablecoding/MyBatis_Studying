package global.sesoc.board.ui;

import java.util.ArrayList;
import java.util.Scanner;

import global.sesoc.board.dao.BoardDAO;
import global.sesoc.board.vo.BoardVO;

//Board ������ �����ȭ�� �κ�
public class BoardUI 
{
	//BoardUI ȣ����ڸ��� ���۵Ǵ� �κ�
	Scanner scan = new Scanner(System.in);
	BoardDAO dao = new BoardDAO();		//���߿� ���� ����
	BoardVO vo = null;
	ArrayList<BoardVO> list = null;

	public BoardUI()
	{
		//�ݺ������� �޴� ���, ��ȣ ���� ��
		while(true)
		{
			int menu = printMainMenu();
			switch(menu)
			{
				case 1: 
					write(); 	//�۾���
					break;		
				case 2: 
					read();		//�� �б�
					break;		
				case 3: 
					list();		//�� ��� ����
					break;		
				case 4:
					delete();	//�� ����
					break;
				case 5:
					update();
					break;
				case 0: 
					System.out.println("���α׷��� �����մϴ�.");
					return;		//����
			}//switch
	
		}//while
	
	}//BoardUI()
	
	//�� �޴��� ���� ��ɵ�
	public int printMainMenu()
	{	
		System.out.println("[�Խ���]");
		System.out.println("1. �� ����");
		System.out.println("2. �� 1�� �б�");
		System.out.println("3. ��� �� �б�");
		System.out.println("4. �� ����");
		System.out.println("5. �� ����");
		System.out.println("0. ����");
		int m = 0;
		
		while(true)
		{
			try
			{
				System.out.print("��ȣ ���� > ");
				m = scan.nextInt();
				if(m < 0 || m > 5)
				{
					continue;
				}
			}
			catch(Exception e)
			{
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
				scan.nextLine();
				continue;
			}
			break;
		}//while
		System.out.println();
		return m;	
		
	}//printMainMenu()
	
	
	//�� �޴��� ���� ��ɵ�
	
	//�� ����
	public void write()
	{
		//ID, ����, �� ������ �Է¹޾� BoardVO��ü�� �����ؼ� DAO�� ����
		String id, title, contents;
		
		System.out.println("[�� ����]");
		scan.nextLine();
		while(true)
		{
			try
			{
				System.out.print("�ۼ���ID > ");
				id = scan.nextLine();
				System.out.print("���� > ");
				title = scan.nextLine();
				System.out.print("���� > ");
				contents = scan.nextLine();
			}
			catch(Exception e)
			{
				System.out.println("�߸� �Է��߽��ϴ�.�ٽ� �Է��ϼ���");
				scan.nextLine();
				continue;
			}
			break;
		}
		
		BoardVO vo = new BoardVO(id, title, contents);
		int cnt = dao.writeBoard(vo);	//dao Ŭ������ ����.
		if(cnt == 1)
		{
			System.out.println("����Ǿ����ϴ�.");
			System.out.println();
		}
		else
		{
			System.out.println("���� ����");
			System.out.println();
		}
		System.out.println();
		
	}//write()
	
	//�� 1�� �б�
	public void read()
	{
		//���� �� ��ȣ�� �Է¹޾� DAO�� �����Ͽ� �ش� ��ȣ�� �� ������ BoardVO��ü�� ���Ϲ޾� ���
		System.out.println("[�� 1�� �б�]");
		while(true)
		{
			try
			{
				System.out.print("���� ��ȣ > ");
				int n = scan.nextInt();
				vo = dao.readBoard(n);
			}
			catch(Exception e)
			{
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���");
				scan.nextLine();
				continue;
			}
			break;
		}
			
		if(vo == null)
		{
			System.out.println("���� �������� �ʽ��ϴ�.");
			
		}
		else
		{
			System.out.print("�ۼ��� ID: " + vo.getId() + ", ");
			System.out.print("����: " + vo.getTitle() + ", ");
			System.out.print("����: " + vo.getContents());
			System.out.println();
		}
		System.out.println();
		
	}//read()
	
	
	//��� �� �б�
	public void list()
	{
		// DAO�� ��û�Ͽ� ��ü �� ������  List�� ���Ϲ޾� ���
		System.out.println("[��� �� �б�]");
		list = dao.listBoard();
		
		if(list == null || list.size() == 0)
		{
			System.out.println("���� �������� �ʽ��ϴ�.");
		}
		else
		{
			for(int i = 0 ; i < list.size(); i++)
			{
				System.out.print("��ȣ: " + list.get(i).getNum() + ", ");
				System.out.print("�ۼ��� ID: " + list.get(i).getId() + ", ");
				System.out.print("����: " + list.get(i).getTitle() + ", ");
				System.out.print("����: " + list.get(i).getContents());
				System.out.println();	
			}
		}
		System.out.println();
		
	}//list()
	
	//�� ����
	public void delete()
	{
		System.out.println("[�� ����]");
		int n;
		int cnt = 0;
		while(true)
		{
			try
			{
				System.out.print("������ ��ȣ > ");
				 n= scan.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
				scan.nextLine();
				continue;
			}
			break;
		}
		cnt = dao.deleteBoard(n);
		if(cnt == 0)
		{
			System.out.println("�ش�Ǵ� ��ȣ�� ���� �����ϴ�.");
		}
		else
		{
			System.out.println("�����Ǿ����ϴ�.");
		}
		System.out.println();
	}
	
	//�� ����
	public void update()
	{
		System.out.println("[�� ����]");
		int num;
		int cnt = 0;
		String title, contents;
		
		while(true)
		{
			try
			{
				System.out.print("������ ��ȣ > ");
				num = scan.nextInt();
				System.out.print("���� > ");
				scan.nextLine();
				title = scan.nextLine();
				System.out.print("���� > ");
				contents = scan.nextLine();				
			}
			catch(Exception e)
			{
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
				scan.nextLine();
				continue;
			}
			break;
		}
		
		BoardVO vo = new BoardVO();
		vo.setNum(num);
		vo.setTitle(title);
		vo.setContents(contents);
		 
		//BoardVo vo = new BoardVO(num, title, contents); -> �ϳ��� �ذ��ϴ� ���, �״�� BoardVO�� ������ ������ ��
		
		
		cnt = dao.updateBoard(vo);
		if(cnt == 0)
		{
			System.out.println("�ش��ϴ� ��ȣ�� ���� �����ϴ�.");
			System.out.println();
		}
		else
		{
			System.out.println("�����Ǿ����ϴ�.");
			System.out.println();
		}
		System.out.println();
	}

}//class BoardUI 
