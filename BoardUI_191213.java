package global.sesoc.board.ui;

import java.util.ArrayList;
import java.util.Scanner;

import global.sesoc.board.dao.BoardDAO;
import global.sesoc.board.vo.BoardVO;

//Board 예제의 사용자화면 부분
public class BoardUI 
{
	//BoardUI 호출되자마자 시작되는 부분
	Scanner scan = new Scanner(System.in);
	BoardDAO dao = new BoardDAO();		//나중에 생성 예정
	ArrayList<BoardVO> list = null;

	public BoardUI()
	{
		//반복문으로 메뉴 출력, 번호 선택 등
		while(true)
		{
			int menu = printMainMenu();
			switch(menu)
			{
				case 1: 
					write(); 	//글쓰기
					break;		
				case 2: 
					read();		//글 읽기
					break;		
				case 3: 
					list();		//글 목록 보기
					break;		
				case 0: 
					System.out.println("프로그램을 종료합니다.");
					return;		//종료
			}//switch
	
		}//while
	
	}//BoardUI()
	
	//각 메뉴에 따른 기능들
	public int printMainMenu()
	{	
		System.out.println();
		System.out.println("[게시판]");
		System.out.println("1. 글쓰기");
		System.out.println("2. 글 읽기");
		System.out.println("3. 글 목록 보기");
		System.out.println("0. 종료");
		int m = 0;
		
		while(true)
		{
			try
			{
				System.out.print("번호 선택 > ");
				m = scan.nextInt();
				if(m < 0 || m > 3)
				{
					continue;
				}
			}
			catch(Exception e)
			{
				System.out.println("잘못 입력했습니다. 다시 입력하세요.");
				scan.nextLine();
				continue;
			}
			break;
		}//while
		System.out.println();
		return m;	
		
	}//printMainMenu()
	
	
	//각 메뉴에 따른 기능들
	
	public void write()
	{
		//ID, 제목, 글 내용을 입력받아 BoardVO객체를 생성해서 DAO로 전달
		String id, title, contents;
		
		System.out.println("[글쓰기]");
		scan.nextLine();
		while(true)
		{
			try
			{
				System.out.print("작성자ID > ");
				id = scan.nextLine();
				System.out.print("제목 > ");
				title = scan.nextLine();
				System.out.print("글 내용 > ");
				contents = scan.nextLine();
			}
			catch(Exception e)
			{
				System.out.println("잘못 입력했습니다.다시 입력하세요");
				scan.nextLine();
				continue;
			}
			break;
		}
		
		BoardVO vo = new BoardVO(id, title, contents);
		int cnt = dao.writeBoard(vo);	//dao 클래스로 전달.
		if(cnt == 1)
		{
			System.out.println("저장되었습니다.");
		}
		else
		{
			System.out.println("저장 실패");
		}
		System.out.println();
		
	}//write()
	
	public void read()
	{
		//읽을 글 번호를 입력받아 DAO로 전달하여 해당 번호의 글 정보를 BoardVO객체로 리턴받아 출력
		System.out.println("[글 읽기]");
		BoardVO vo;
		while(true)
		{
			try
			{
				System.out.print("번호 > ");
				int n = scan.nextInt();
				vo = dao.readBoard(n);
			}
			catch(Exception e)
			{
				System.out.println("잘못 입력했습니다. 다시 입력하세요");
				scan.nextLine();
				continue;
			}
			break;
		}
			
		if(vo == null)
		{
			System.out.println("글이 존재하지 않습니다.");
			
		}
		else
		{
			System.out.print("작성자 ID: " + vo.getId() + ", ");
			System.out.print("제목: " + vo.getTitle() + ", ");
			System.out.print("내용: " + vo.getContents());		
		}
		System.out.println();
		
	}//read()
	
	
	
	public void list()
	{
		// DAO로 요청하여 전체 글 정보를  List로 리턴받아 출력
		System.out.println("[글 목록 보기]");
		list = dao.listBoard();
		
		if(list == null || list.size() == 0)
		{
			System.out.println("글이 존재하지 않습니다.");
		}
		else
		{
			for(int i = 0 ; i < list.size(); i++)
			{
				System.out.print("번호: " + list.get(i).getNum() + ", ");
				System.out.print("작성자 ID: " + list.get(i).getId() + ", ");
				System.out.print("제목: " + list.get(i).getTitle() + ", ");
				System.out.print("내용: " + list.get(i).getContents());
				System.out.println();	
			}
		}
		
	}//list()
	
	

}//class BoardUI 
