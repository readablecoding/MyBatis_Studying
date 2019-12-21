package board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.BoardVO;

public class BoardDAO 
{
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//쓰기
	public int write(BoardVO vo)
	{
		SqlSession ss = null;
		int cnt = 0;
		try
		{
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			cnt = mapper.write(vo);
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
	
	//읽기
	public ArrayList<BoardVO> read(int n)
	{
		SqlSession ss = null;
		ArrayList<BoardVO> list = null;	
		try
		{
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			list = mapper.read(n);
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
	
	
	//수정
	public int update(BoardVO vo)
	{
		SqlSession ss = null;
		int cnt = 0;
		try
		{
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			cnt = mapper.update(vo);	
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
	
	
	//삭제
	public int delete(int n)
	{
		SqlSession ss = null;
		int cnt = 0;
		try
		{
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			cnt = mapper.delete(n);
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
	
	
	//검색
	public ArrayList<BoardVO> search(int type, String word)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("word", word);
		
		SqlSession ss = null;
		ArrayList<BoardVO> list = null;
		
		try
		{
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			list = mapper.search(map);
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
	
	
}
