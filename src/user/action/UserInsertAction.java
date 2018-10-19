package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertAction implements UserAction {

	@Override
	public void execute() {
		
		Scanner sc = new Scanner(System.in);
		
		//������
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		System.out.print("���̵� �Է� : ");
		String id = sc.next();
		System.out.print("��й�ȣ �Է� : ");
		String pwd = sc.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.userWrite(userDTO);
		
		System.out.println("�����͸� �����Ͽ����ϴ�");
		
	}

}
