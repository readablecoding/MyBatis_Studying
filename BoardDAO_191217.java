package global.sesoc.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import global.sesoc.board.dao.MybatisConfig;
import global.sesoc.board.dao.BoardMapper;
import global.sesoc.board.vo.BoardVO;



public class BoardDAO 
{
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü 
	//SqlSessionFactory�� �θ���.MybatisConfig.getSqlSessionFactory()�޼ҵ� . static �޼ҵ带 ȣ���Ѵ�.
	
	//�� ����
	public int writeBoard(BoardVO vo) 
	{
		SqlSession ss = null;
		int cnt = 0;
		try 
		{
			ss = factory.openSession(); //������ ����. ���߿� commit �Ǵ� rollback �Ѵ�
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //�������̽� ��ü �����. PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			cnt = mapper.writeBoard(vo); //������ ������ �ѱ�. ȣ��
			ss.commit();	//��ȭ�� ���� �� commi�� �� �Ѵ�. commit �ϸ� �ϳ��� ������ ����. commit�� �ؾ� �����Ϳ� �ݿ��� �ȴ�.
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //���� �޽��� ���
		}
		finally 
		{			
			if (ss != null) ss.close();	//������ ���� �� ���ܰ� �߻� �ϰų� ���ϰų� ������ �ݵ��� finally�� ����
			
		}
		return cnt;

	}//writeBoard
	
	
	
	//�� 1�� �б� �Ǵ� ��� �� �б�
	public ArrayList<BoardVO> readBoard(int n) 
	{
		SqlSession ss = null;
		ArrayList<BoardVO> list = null;
		try 
		{
			ss = factory.openSession(); //������ ����. ���߿� commit �Ǵ� rollback �Ѵ�
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			list = mapper.readBoard(n); //������ ������ �ѱ�. ȣ��
			ss.commit();	//commit �ϸ� �ϳ��� ������ ����. commit�� �ؾ� �����Ϳ� �ݿ��� �ȴ�.
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //���� �޽��� ���
		}
		finally 
		{			
			if (ss != null) ss.close();	//������ ���� �� ���ܰ� �߻� �ϰų� ���ϰų� ������ �ݵ��� finally�� ����
				
		}
		return list;
	}//readBoard
	
	
	//��ü �� ����
	public ArrayList<BoardVO> listBoard() 
	{
		SqlSession ss = null;
		ArrayList<BoardVO> list = null;
		try 
		{
			ss = factory.openSession(); //������ ����. ���߿� commit �Ǵ� rollback �Ѵ�
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			list = mapper.listBoard(); //������ ������ �ѱ�. ȣ��
			ss.commit();	//commit �ϸ� �ϳ��� ������ ����. commit�� �ؾ� �����Ϳ� �ݿ��� �ȴ�.
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //���� �޽��� ���
		}
		finally 
		{			
			if (ss != null) ss.close();	//������ ���� �� ���ܰ� �߻� �ϰų� ���ϰų� ������ �ݵ��� finally�� ����
				
		}
		return list;
	}//readBoard
		
	
	//�� ����
	public int deleteBoard(int n)
	{
		SqlSession ss = null;
		int cnt = 0;
		try 
		{
			ss = factory.openSession(); //������ ����. ���߿� commit �Ǵ� rollback �Ѵ�
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			cnt = mapper.deleteBoard(n); 
			ss.commit();	
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //���� �޽��� ���
		}
		finally 
		{			
			if (ss != null) ss.close();	//������ ���� �� ���ܰ� �߻� �ϰų� ���ϰų� ������ �ݵ��� finally�� ����
				
		}
		return cnt;
	}//readBoard
	
	//�� ����
	public int updateBoard(BoardVO vo)
	{
		SqlSession ss = null;
		int cnt = 0;
		try 
		{
			ss = factory.openSession(); //������ ����. ���߿� commit �Ǵ� rollback �Ѵ�
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			cnt = mapper.updateBoard(vo); 
			ss.commit();	
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //���� �޽��� ���
		}
		finally 
		{			
			if (ss != null) ss.close();	//������ ���� �� ���ܰ� �߻� �ϰų� ���ϰų� ������ �ݵ��� finally�� ����
				
		}
		return cnt;
	}
	
	//�� �˻�
	public ArrayList<BoardVO> searchBoard(int type, String word)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);	// put("Ű", ��)
		map.put("word", word);	// put("Ű", ��)
		
		SqlSession ss = null;
		ArrayList<BoardVO> list = null;
		try 
		{
			ss = factory.openSession(); //������ ����. ���߿� commit �Ǵ� rollback �Ѵ�
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			list = mapper.searchBoard(map); 
			ss.commit();	
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //���� �޽��� ���
		}
		finally 
		{			
			if (ss != null) ss.close();	//������ ���� �� ���ܰ� �߻� �ϰų� ���ϰų� ������ �ݵ��� finally�� ����
				
		}
		return list;
	}
	
}//class BoardDAO