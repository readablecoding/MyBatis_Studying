package board.ui;

import java.util.ArrayList;
import java.util.Scanner;

import board.dao.BoardDAO;
import board.vo.BoardVO;

public class BoardUI {
	Scanner scan = new Scanner(System.in);
	BoardDAO dao = new BoardDAO();
	
	//생성자
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
	
	//메뉴
	public int menuPrint()
	{
		
		System.out.println("[게시판]");
		System.out.println("1. 쓰기");
		System.out.println("2. 읽기");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 검색");
		System.out.println("0. 종료");
		System.out.println();
		int n;
		
		while(true)
		{
			try
			{
				System.out.print("선택 > ");
				n = scan.nextInt();
				if(n < 0 || n > 5)
				{
					System.out.println("0 ~ 5 중에 선택하세요.");
				}
			}
			catch(Exception e)
			{
				System.out.println("숫자를 입력하세요.");
				scan.nextLine();
				continue;
			}
			break;
		}	
		return n;
	}
	
	public void write()
	{
		System.out.println("[쓰기]");
		
		scan.nextLine();
		String id, title, contents;	
		
		while(true)
		{
			try
			{
				System.out.print("id > ");
				id = scan.nextLine();
				System.out.print("제목 > ");
				title = scan.nextLine();
				System.out.print("내용 > ");
				contents = scan.nextLine();	
			}
			catch(Exception e)
			{
				System.out.println("잘못 입력했습니다. 다시 입력하세요.");
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
			System.out.println("글이 저장되었습니다.");
		}
		else
		{
			System.out.println("저장 실패했습니다.");
		}
	}
	
	public void read()
	{
		System.out.println("[읽기]");
		
		ArrayList<BoardVO> list = null;
		
		int n = numberSelection();
		
		list = dao.read(n);
		if(list == null || list.size() == 0)
		{
			System.out.println("글이 존재하지 않습니다.");
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
		System.out.println("[수정]");
		
		String title, contents;
		int cnt = 0;
		int num = numberSelection();
		scan.nextLine();
		System.out.print("제목 > ");
		title = scan.nextLine();
		System.out.print("내용 > ");
		contents = scan.nextLine();


		BoardVO vo = new BoardVO(num, title, contents);
		
		cnt = dao.update(vo);
		
		
		if(cnt == 0)
		{
			System.out.println("글이 존재하지 않습니다.");
		}
		else
		{
			System.out.println("수정 했습니다.");
		}
		
		
	}
	
	public void delete()
	{
		System.out.println("[삭제]");
	
		int cnt = 0;	
		int n = numberSelection();
		cnt = dao.delete(n);
		if(cnt != 0)
		{
			System.out.println("삭제되었습니다.");
		}
		else
		{
			System.out.println("삭제 실패했습니다.");
		}
			
	}
	
	public void search()
	{
		System.out.println("[검색]");
		System.out.println("1.제목");
		System.out.println("2.내용");
		int type;
		String word;
		ArrayList<BoardVO> list = null;
		
		while(true)
		{
			try
			{
				System.out.print("번호 > ");
				type = scan.nextInt();
				if(type < 1 || type > 2)
				{
					System.out.println("1과 2중에서 선택하세요.");
				}
			}
			catch(Exception e)
			{
				System.out.println("숫자를 입력하세요.");
				scan.nextLine();
				continue;
			}	
			break;
		}
		scan.nextLine();
		System.out.print("검색어 > ");
		word = scan.nextLine();
		list = dao.search(type, word);
		if(list == null || list.size() == 0)
		{
			System.out.println("검색 결과가 없습니다.");
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
		System.out.println("프로그램을 종료합니다.");
	}
		
	
	public int numberSelection()
	{
		int n;
		while(true)
		{
			try
			{
				System.out.print("번호 > ");
				n = scan.nextInt();	
			}
			catch(Exception e)
			{
				System.out.println("숫자를 입력하세요.");
				scan.nextLine();
				continue;
			}
			break;
		}
		return n;
	}
	
	
	
}//BoardUI