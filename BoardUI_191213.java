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
				case 0: 
					System.out.println("���α׷��� �����մϴ�.");
					return;		//����
			}//switch
	
		}//while
	
	}//BoardUI()
	
	//�� �޴��� ���� ��ɵ�
	public int printMainMenu()
	{	
		System.out.println();
		System.out.println("[�Խ���]");
		System.out.println("1. �۾���");
		System.out.println("2. �� �б�");
		System.out.println("3. �� ��� ����");
		System.out.println("0. ����");
		int m = 0;
		
		while(true)
		{
			try
			{
				System.out.print("��ȣ ���� > ");
				m = scan.nextInt();
				if(m < 0 || m > 3)
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
	
	public void write()
	{
		//ID, ����, �� ������ �Է¹޾� BoardVO��ü�� �����ؼ� DAO�� ����
		String id, title, contents;
		
		System.out.println("[�۾���]");
		scan.nextLine();
		while(true)
		{
			try
			{
				System.out.print("�ۼ���ID > ");
				id = scan.nextLine();
				System.out.print("���� > ");
				title = scan.nextLine();
				System.out.print("�� ���� > ");
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
		}
		else
		{
			System.out.println("���� ����");
		}
		System.out.println();
		
	}//write()
	
	public void read()
	{
		//���� �� ��ȣ�� �Է¹޾� DAO�� �����Ͽ� �ش� ��ȣ�� �� ������ BoardVO��ü�� ���Ϲ޾� ���
		System.out.println("[�� �б�]");
		BoardVO vo;
		while(true)
		{
			try
			{
				System.out.print("��ȣ > ");
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
		}
		System.out.println();
		
	}//read()
	
	
	
	public void list()
	{
		// DAO�� ��û�Ͽ� ��ü �� ������  List�� ���Ϲ޾� ���
		System.out.println("[�� ��� ����]");
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
		
	}//list()
	
	

}//class BoardUI 
