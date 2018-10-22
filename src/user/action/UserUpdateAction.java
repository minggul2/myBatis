package user.action;

import java.util.List;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateAction implements UserAction {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("수정할 아이디 입력 : ");
		String id = sc.next(); 
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO  = userDAO.userOne(id);
		
		if(userDTO != null) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			System.out.print("수정 할 이름 입력 : ");
			userDTO.setName(sc.next());
			System.out.print("수정 할 비밀번호 입력 : ");
			userDTO.setPwd(sc.next());
			userDAO.userModify(userDTO);
			System.out.println("데이터를 수정하였습니다");
		}else {
			System.out.println("찾고자 하는 아이디가 없습니다");
		}

	}

}
