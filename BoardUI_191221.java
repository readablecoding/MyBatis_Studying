package board.ui;

import java.util.ArrayList;
import java.util.Scanner;

import board.dao.BoardDAO;
import board.vo.BoardVO;

public class BoardUI {
	Scanner scan = new Scanner(System.in);
	BoardDAO dao = new BoardDAO();
	
	//������
	public BoardUI() {
		while(true)
		{
			int n = menuPrint();
			
			switch(n)
			{
				case 1:
					write();
					break;
				case 2:
					read();
					break;
				case 3:
					update();
					break;
				case 4:
					delete();
					break;
				case 5:
					search();
					break;
				case 0:
					end();
					return;
			}//case	
		}//while
	}
	
	//�޴�
	public int menuPrint()
	{
		
		System.out.println("[�Խ���]");
		System.out.println("1. ����");
		System.out.println("2. �б�");
		System.out.println("3. ����");
		System.out.println("4. ����");
		System.out.println("5. �˻�");
		System.out.println("0. ����");
		System.out.println();
		int n;
		
		while(true)
		{
			try
			{
				System.out.print("���� > ");
				n = scan.nextInt();
				if(n < 0 || n > 5)
				{
					System.out.println("0 ~ 5 �߿� �����ϼ���.");
				}
			}
			catch(Exception e)
			{
				System.out.println("���ڸ� �Է��ϼ���.");
				scan.nextLine();
				continue;
			}
			break;
		}	
		return n;
	}
	
	public void write()
	{
		System.out.println("[����]");
		
		scan.nextLine();
		String id, title, contents;	
		
		while(true)
		{
			try
			{
				System.out.print("id > ");
				id = scan.nextLine();
				System.out.print("���� > ");
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
		vo.setId(id);
		vo.setTitle(title);
		vo.setContents(contents);
		int cnt = dao.write(vo);
		
		if(cnt == 1)
		{
			System.out.println("���� ����Ǿ����ϴ�.");
		}
		else
		{
			System.out.println("���� �����߽��ϴ�.");
		}
	}
	
	public void read()
	{
		System.out.println("[�б�]");
		
		ArrayList<BoardVO> list = null;
		
		int n = numberSelection();
		
		list = dao.read(n);
		if(list == null || list.size() == 0)
		{
			System.out.println("���� �������� �ʽ��ϴ�.");
		}
		else
		{
			for(BoardVO vo : list)
			{
				System.out.println(vo);
			}
		}
		
	}
	
	public void update()
	{
		System.out.println("[����]");
		
		String title, contents;
		int cnt = 0;
		int num = numberSelection();
		scan.nextLine();
		System.out.print("���� > ");
		title = scan.nextLine();
		System.out.print("���� > ");
		contents = scan.nextLine();


		BoardVO vo = new BoardVO(num, title, contents);
		
		cnt = dao.update(vo);
		
		
		if(cnt == 0)
		{
			System.out.println("���� �������� �ʽ��ϴ�.");
		}
		else
		{
			System.out.println("���� �߽��ϴ�.");
		}
		
		
	}
	
	public void delete()
	{
		System.out.println("[����]");
	
		int cnt = 0;	
		int n = numberSelection();
		cnt = dao.delete(n);
		if(cnt != 0)
		{
			System.out.println("�����Ǿ����ϴ�.");
		}
		else
		{
			System.out.println("���� �����߽��ϴ�.");
		}
			
	}
	
	public void search()
	{
		System.out.println("[�˻�]");
		System.out.println("1.����");
		System.out.println("2.����");
		int type;
		String word;
		ArrayList<BoardVO> list = null;
		
		while(true)
		{
			try
			{
				System.out.print("��ȣ > ");
				type = scan.nextInt();
				if(type < 1 || type > 2)
				{
					System.out.println("1�� 2�߿��� �����ϼ���.");
				}
			}
			catch(Exception e)
			{
				System.out.println("���ڸ� �Է��ϼ���.");
				scan.nextLine();
				continue;
			}	
			break;
		}
		scan.nextLine();
		System.out.print("�˻��� > ");
		word = scan.nextLine();
		list = dao.search(type, word);
		if(list == null || list.size() == 0)
		{
			System.out.println("�˻� ����� �����ϴ�.");
		}
		else
		{
			for(BoardVO vo : list)
			{
				System.out.println(vo);
			}
		}
	}
	
	public void end()
	{
		System.out.println("���α׷��� �����մϴ�.");
	}
		
	
	public int numberSelection()
	{
		int n;
		while(true)
		{
			try
			{
				System.out.print("��ȣ > ");
				n = scan.nextInt();	
			}
			catch(Exception e)
			{
				System.out.println("���ڸ� �Է��ϼ���.");
				scan.nextLine();
				continue;
			}
			break;
		}
		return n;
	}
	
	
	
}//BoardUI