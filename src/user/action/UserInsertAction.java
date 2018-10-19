package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertAction implements UserAction {

	@Override
	public void execute() {
		
		Scanner sc = new Scanner(System.in);
		
		//데이터
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pwd = sc.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.userWrite(userDTO);
		
		System.out.println("데이터를 저장하였습니다");
		
	}

}
