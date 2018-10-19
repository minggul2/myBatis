package user.action;

import java.util.List;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectAction implements UserAction {

	@Override
	public void execute() {
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.userList();
		
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t"
					+ userDTO.getId() + "\t"
					+ userDTO.getPwd());
		}
		
	}

}
