package test.dao;

import java.util.ArrayList;

import test.vo.Person;

/**
 * Mapper XML�� SQL�� ��� �޼��� ����
 */
public interface PersonMapper 
{ 
	//Person��ü ����
	public int insertPerson(Person p); //insert, delete, update�� int�� ����, ó���� �� ���� ������, �߸��Ǹ� ������ 0�̴�.
	//��ȣ�� �� ����
	public int deletePerson(int n);		
	
	//interface�� �ȿ� �߻�޼ҵ尡 ��� �ִ�. ������ ���� �����Ű�� �޼ҵ尡 �ƴϴ�.
	//mybatis�� ���� �� ���ش�.
	//�츮�� �� ���� sql�� ����α�.
	
	
}
