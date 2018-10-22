package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteAction implements UserAction {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���̵� �Է� : ");
		String id = sc.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.userOne(id);
		
		if(userDTO == null) {
			
			
		}else {
			userDAO.userDelete(id);
			System.out.println("�����͸� �����Ͽ����ϴ�.");
		}
	}

}
