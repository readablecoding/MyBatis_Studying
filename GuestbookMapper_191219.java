package guestbook.dao;

import java.util.ArrayList;

import guestbook.vo.Guestbook;

/**
 * 방명록 Mapper Interface
 */
public interface GuestbookMapper {
	
	//작성
	public int insertGuestbook(Guestbook vo);
	//조회
	public ArrayList<Guestbook> selectGuestbook();
	//삭제
	public int deleteGuestbook(int n);
	
}
