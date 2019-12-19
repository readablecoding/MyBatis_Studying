package guestbook.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import guestbook.vo.Guestbook;

public class GuestbookDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//등록
	public int insert(Guestbook vo)
	{
		SqlSession ss = null;
		int cnt = 0;
		try
		{
			ss = factory.openSession();
			GuestbookMapper mapper = ss.getMapper(GuestbookMapper.class);
			cnt = mapper.insertGuestbook(vo);
			ss.commit();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ss != null)
			{
				ss.close();
			}
		}
		return cnt;
	}
	
	//조회
	public ArrayList<Guestbook> select()
	{
		SqlSession ss = null;
		ArrayList<Guestbook> list = null;
		try
		{
			ss = factory.openSession();
			GuestbookMapper mapper = ss.getMapper(GuestbookMapper.class);
			list = mapper.selectGuestbook();
			ss.commit();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ss != null)
			{
				ss.close();
			}
		}
		return list;
	}
	
	//삭제
	public int delete(int n)
	{
		SqlSession ss = null;
		int cnt = 0;
		try
		{
			ss = factory.openSession();
			GuestbookMapper mapper = ss.getMapper(GuestbookMapper.class);
			cnt = mapper.deleteGuestbook(n);
			ss.commit();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ss != null)
			{
				ss.close();
			}
		}
		return cnt;
	}
	
	
	
}
