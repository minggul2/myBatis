package user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchAction implements UserAction {

	@Override
	public void execute() {
		/*
		1. �̸� �˻�
		2. ���̵� �˻�
		��ȣ �Է� : 1
		
		ã���� �ϴ� �̸� �Է� : ȫ
		ȫ�浿	aaa	111
		ȫ�繫	bbb	111
		----------------------
		
		ã���� �ϴ� ���̵� �Է� : h
		hong 
		ddochi
		
		* userMapper.xml���� id = userSearch �� �� �ϳ��� �����
		* 
		 */
		//�Ķ���� ����  1 or 2
		//
		Map<String, String> map = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("	1. �̸� �˻�");
		System.out.println("	2. ���̵� �˻�");
		System.out.print("��ȣ �Է� : ");
		int num = sc.nextInt();
		
		String colName = null;
		String value = null;
		
		
		if (num == 1) {
			System.out.print("ã���� �ϴ� �̸� �Է�  : ");
			value = sc.next();
//			map.put("name", '%'+name+'%');
//			map.put("id", "");
			colName = "name";
			
		}else {
			System.out.print("ã���� �ϴ� ���̵� �Է� : ");
			value = sc.next();
//			map.put("id", '%'+id+'%');
//			map.put("name", "");
			colName = "id";
			
		}
		
		
		UserDAO userDAO = UserDAO.getInstance();
		
		List<UserDTO> list = userDAO.search(colName, value);
		
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		}
	}

}
