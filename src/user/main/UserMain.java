package user.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import user.action.UserAction;
import user.action.UserInsertAction;
import user.action.UserSelectAction;

public class UserMain {
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	public void menu() {
		
		Map<String, String> className = new HashMap<String, String>();
		
		className.put("insert", "user.action.UserInsertAction");
		className.put("select", "user.action.UserSelectAction");
		className.put("delete", "user.action.UserDeleteAction");
		className.put("update", "user.action.UserUpdateAction");
		
		
		Iterator it = className.keySet().iterator();
		while(it.hasNext()) {
			
			String key = (String)it.next();
			String class_name = className.get(key);
			Class classType;
			
			try {
				classType = Class.forName(class_name);
				Object ob = classType.newInstance();
				map.put(key, ob);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		
		Scanner sc = new Scanner(System.in);
		int num;
		UserAction userAction = null;
		
		while(true) {
			System.out.println();
			System.out.println("----------------");
			System.out.println("	1. 입력		");
			System.out.println("	2. 출력		");
			System.out.println("	3. 수정		");
			System.out.println("	4. 삭제		");
			System.out.println("	5. 검색		");
			System.out.println("	6. 종료		");
			System.out.println("----------------");
			System.out.print(" 번호입력 : ");
			num = sc.nextInt();
			
			if(num == 6) {
				break;
			}else if(num == 1) {
				userAction = (UserAction)map.get("insert");
			}else if(num == 2) {
				userAction = (UserAction)map.get("select");
			}else if(num == 3) {
				userAction = (UserAction)map.get("update");
			}else if(num == 4) {
				userAction = (UserAction)map.get("delete");
			}else if(num == 5) {
				userAction = (UserAction)map.get("select");
			}
			userAction.execute();
		}
	}
	public static void main(String[] args) {
		UserMain userMain = new UserMain();
		
		userMain.menu();
		System.out.println("프로그램 종료");
	}
	
}
