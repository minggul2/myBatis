package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteAction implements UserAction {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 : ");
		String id = sc.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.userOne(id);
		
		if(userDTO == null) {
			
			
		}else {
			userDAO.userDelete(id);
			System.out.println("데이터를 삭제하였습니다.");
		}
	}

}
