package user.action;

import java.util.List;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateAction implements UserAction {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("������ ���̵� �Է� : ");
		String id = sc.next(); 
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO  = userDAO.userOne(id);
		
		if(userDTO != null) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			System.out.print("���� �� �̸� �Է� : ");
			userDTO.setName(sc.next());
			System.out.print("���� �� ��й�ȣ �Է� : ");
			userDTO.setPwd(sc.next());
			userDAO.userModify(userDTO);
			System.out.println("�����͸� �����Ͽ����ϴ�");
		}else {
			System.out.println("ã���� �ϴ� ���̵� �����ϴ�");
		}

	}

}
