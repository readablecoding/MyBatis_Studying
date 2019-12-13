package global.sesoc.person.dao;

import java.util.ArrayList;

import global.sesoc.person.vo.Person;

/**
 * Mapper XML�� SQL�� ��� �޼��� ����
 */
public interface PersonMapper 
{ 
	//Person��ü ����
	public int insertPerson(Person p); //insert, delete, update�� int�� ����, ó���� �� ���� ������, �߸��Ǹ� ������ 0�̴�.
	//-> Person Ÿ���� p�� �μ��� �޴� insertPerson �޼ҵ�� int������ ����. ������ 0�̸� ������ ��
	//-> PersonMapper���� ���� �Ͱ� �¾ƾ� �Ѵ�.
	
	//��ȣ�� �� ����
	public int deletePerson(int n);		
	
	//��ȣ�� ���� ����
	public int updatePerson(Person p); // PersonMapper.xml���� ���� ó���ϰ� ���ƿ� �װ��� ���� PersonDAO�� ����
	
	//��ȣ�� ȸ�� �˻�
	public Person selectPerson(int n); // Mapper.xml���� id�� selectPerson, parameter�� int n, result tpye�� Person
	
	//�̸����� ȸ�� �˻�
	public ArrayList<Person> selectPersonByName(String s); //���� Ÿ���� Person ��ü�� ��� ArrayList
	
	//��� ȸ�� ����
	public ArrayList<Person> selectPersonAll();
	
	//interface�� �ȿ� �߻�޼ҵ尡 ��� �ִ�. ������ ���� �����Ű�� �޼ҵ尡 �ƴϴ�.
	//mybatis�� ���� �� ���ش�.
	//�츮�� �� ���� sql�� ����α�.
	
}
