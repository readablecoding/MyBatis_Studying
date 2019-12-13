package global.sesoc.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import global.sesoc.board.dao.MybatisConfig;
import global.sesoc.board.dao.BoardMapper;
import global.sesoc.board.vo.BoardVO;



public class BoardDAO 
{
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü
	//SqlSessionFactory�� �θ���.MybatisConfig.getSqlSessionFactory()�޼ҵ� . static �޼ҵ�
	
	//�۾���
	public int writeBoard(BoardVO vo) 
	{
		SqlSession ss = null;
		int cnt = 0;
		try 
		{
			ss = factory.openSession(); //������ ����. ���߿� commit �Ǵ� rollback �Ѵ�
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			cnt = mapper.writeBoard(vo); //������ ������ �ѱ�. ȣ��
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
		return cnt;

	}//writeBoard
	
	
	
	//�� �б�
	public BoardVO readBoard(int n) 
	{
		SqlSession ss = null;
		BoardVO vo = null;
		try 
		{
			ss = factory.openSession(); //������ ����. ���߿� commit �Ǵ� rollback �Ѵ�
			BoardMapper mapper = ss.getMapper(BoardMapper.class); //PersonMapper�� ���� ����Ǵ� �ڵ尡 ����ִ� ��
			vo = mapper.readBoard(n); //������ ������ �ѱ�. ȣ��
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
		return vo;
	}//readBoard
		
	//�� ��� ����
	public ArrayList<BoardVO> listBoard() 
	{
		SqlSession ss = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>(); 
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
		
	}//listBoard	
	
}//class BoardDAO