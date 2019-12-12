package global.sesec.person.dao;

import java.util.ArrayList;

import global.sesec.person.vo.Person;

/**
 * Mapper XML�� SQL�� ��� �޼��� ����
 */
public interface PersonMapper {
	//Person��ü ����
	public int insertPerson(Person p);
	//��ȣ�� �� ����
	public int deletePerson(int n);
	//��ȣ�� ���� ����
	public int updatePerson(Person p);
	//��ȣ�� ȸ�� �˻�
	public Person selectPerson(int n);
	//�̸����� ȸ�� �˻�
	public ArrayList<Person> selectPersonByName(String n);
}











