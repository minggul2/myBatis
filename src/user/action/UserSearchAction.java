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
		1. 이름 검색
		2. 아이디 검색
		번호 입력 : 1
		
		찾고자 하는 이름 입력 : 홍
		홍길동	aaa	111
		홍당무	bbb	111
		----------------------
		
		찾고자 하는 아이디 입력 : h
		hong 
		ddochi
		
		* userMapper.xml에는 id = userSearch 인 것 하나만 만들기
		* 
		 */
		//파라미터 개수  1 or 2
		//
		Map<String, String> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("	1. 이름 검색");
		System.out.println("	2. 아이디 검색");
		System.out.print("번호 입력 : ");
		int num = sc.nextInt();
		
		if (num == 1) {
			System.out.print("찾고자 하는 이름 입력  : ");
			String name = sc.next();
			map.put("name", name);
		}
		else {
			System.out.print("찾고자 하는 아이디 입력 : ");
			String id = sc.next();
			map.put("id", id);
			
		}
		
		
		UserDAO userDAO = UserDAO.getInstance();
		
		List<UserDTO> list = userDAO.search(map);
		
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		}
	}

}
