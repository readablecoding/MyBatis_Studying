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
	BoardVO vo = null;
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
				case 4:
					delete();	//글 삭제
					break;
				case 5:
					update();
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
		System.out.println("[게시판]");
		System.out.println("1. 글 저장");
		System.out.println("2. 글 1개 읽기");
		System.out.println("3. 모든 글 읽기");
		System.out.println("4. 글 삭제");
		System.out.println("5. 글 수정");
		System.out.println("0. 종료");
		int m = 0;
		
		while(true)
		{
			try
			{
				System.out.print("번호 선택 > ");
				m = scan.nextInt();
				if(m < 0 || m > 5)
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
	
	//글 저장
	public void write()
	{
		//ID, 제목, 글 내용을 입력받아 BoardVO객체를 생성해서 DAO로 전달
		String id, title, contents;
		
		System.out.println("[글 저장]");
		scan.nextLine();
		while(true)
		{
			try
			{
				System.out.print("작성자ID > ");
				id = scan.nextLine();
				System.out.print("제목 > ");
				title = scan.nextLine();
				System.out.print("내용 > ");
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
			System.out.println();
		}
		else
		{
			System.out.println("저장 실패");
			System.out.println();
		}
		System.out.println();
		
	}//write()
	
	//글 1개 읽기
	public void read()
	{
		//읽을 글 번호를 입력받아 DAO로 전달하여 해당 번호의 글 정보를 BoardVO객체로 리턴받아 출력
		System.out.println("[글 1개 읽기]");
		while(true)
		{
			try
			{
				System.out.print("읽을 번호 > ");
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
			System.out.println();
		}
		System.out.println();
		
	}//read()
	
	
	//모든 글 읽기
	public void list()
	{
		// DAO로 요청하여 전체 글 정보를  List로 리턴받아 출력
		System.out.println("[모든 글 읽기]");
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
		System.out.println();
		
	}//list()
	
	//글 삭제
	public void delete()
	{
		System.out.println("[글 삭제]");
		int n;
		int cnt = 0;
		while(true)
		{
			try
			{
				System.out.print("삭제할 번호 > ");
				 n= scan.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("잘못 입력했습니다. 다시 입력하세요.");
				scan.nextLine();
				continue;
			}
			break;
		}
		cnt = dao.deleteBoard(n);
		if(cnt == 0)
		{
			System.out.println("해당되는 번호의 글이 없습니다.");
		}
		else
		{
			System.out.println("삭제되었습니다.");
		}
		System.out.println();
	}
	
	//글 수정
	public void update()
	{
		System.out.println("[글 수정]");
		int num;
		int cnt = 0;
		String title, contents;
		
		while(true)
		{
			try
			{
				System.out.print("수정할 번호 > ");
				num = scan.nextInt();
				System.out.print("제목 > ");
				scan.nextLine();
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
		vo.setNum(num);
		vo.setTitle(title);
		vo.setContents(contents);
		 
		//BoardVo vo = new BoardVO(num, title, contents); -> 하나로 해결하는 방법, 그대신 BoardVO에 생성자 만들어야 함
		
		
		cnt = dao.updateBoard(vo);
		if(cnt == 0)
		{
			System.out.println("해당하는 번호의 글이 없습니다.");
			System.out.println();
		}
		else
		{
			System.out.println("수정되었습니다.");
			System.out.println();
		}
		System.out.println();
	}

}//class BoardUI 
