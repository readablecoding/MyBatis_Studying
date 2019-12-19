package guestbook.ui;

import java.util.ArrayList;
import java.util.Scanner;

import guestbook.dao.GuestbookDAO;
import guestbook.vo.Guestbook;

public class GuestbookUI 
{

	// TODO
	// GuestDAO 객체를 생성
	GuestbookDAO dao = new GuestbookDAO();
	private Scanner sc = new Scanner(System.in);
	
	public GuestbookUI() {
		
		while(true) {
			int choice = 0;
			
			printMainMenu();
			
			try {
				choice = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("잘못된 입력");
				continue;
			}
			
			switch (choice) {
			case 1:
				insert();
				break;
			case 2:
				select();
				break;
			case 3:
				delete();
				break;
			case 0:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못된 입력");
				break;
			}
			
		}
	}
	
	/**
	 * 메인메뉴
	 * */
	public void printMainMenu(){
		System.out.println();
		System.out.println("[ 메인 메뉴 ]");
		System.out.println("1. 방명록 등록");
		System.out.println("2. 전체 방명록 조회");
		System.out.println("3. 방명록 삭제");
		System.out.println("0. 종료");
		System.out.print("* 번호 입력 : ");	
			
	}
	
	/**
	 * 방명록 등록
	 */
	public void insert() {
		System.out.println();
		System.out.println("[ 방명록 등록 ]");
		
		System.out.print("작성자: ");
		String author = sc.nextLine();
		System.out.print("내용: ");
		String content = sc.nextLine();
		
		// TODO
		// Guestbook vo객체를 생성하여 vo의 field에 입력받은 값을 설정
		
		Guestbook vo = new Guestbook();

		vo.setAuthor(author);
		vo.setContent(content);
		// GuestbookDAO 객체의 메서드를 호출하여 vo의 값을 DB에 저장
		int cnt = dao.insert(vo);
		// 메서드 호출 결과에 따라 "등록 성공" / "등록 실패" 출력
		if(cnt == 1) 
		{
			System.out.println("등록 성공");
		}
		else 
		{
			System.out.println("등록 실패");
		}
	}
	
	/**
	 * 전체 방명록 조회
	 */
	public void select() {
		System.out.println();
		System.out.println("[ 전체 방명록 조회 ]");
		
		// TODO
		// GuestbookDAO 객체의 메서드를 호출하여 DB에 저장된 데이터를 모두 가져옴
		ArrayList<Guestbook> list = null;
		list = dao.select();
		// 메서드 호출을 통해 가져온 데이터를 화면에 출력
		if(list == null || list.size() == 0)
		{
			System.out.println("글이 존재하지 않습니다");
		}
		else
		{
			for(Guestbook vo : list)
			{
				System.out.println(vo);
			}
		}
	}
	
	/**
	 * 방명록 삭제
	 */
	public void delete() {
		System.out.println();
		System.out.println("[ 방명록 삭제 ]");
		
		int sn = 0;
		
		try {
			System.out.print("삭제할 글 번호: ");
			sn = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("삭제 실패");
			return;
		}
		
		// TODO
		// GuestbookDAO 객체의 메서드를 호출하여 특정 게시글을 삭제
		int cnt = dao.delete(sn);
		// 메서드 호출 결과에 따라 "삭제 성공" / "삭제 실패" 출력
		if(cnt != 0) 
		{
			System.out.println("삭제 성공");
		}
		else 
		{
			System.out.println("삭제 실패");
		}
	}
	
}
