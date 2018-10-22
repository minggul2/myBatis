package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	public static UserDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	
	public static UserDAO getInstance() {
		if(instance == null) {
			synchronized(UserDAO.class) {
				instance = new UserDAO();
			}
		}
		return instance;
	}
	
	public UserDAO() {
		try {
			//InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);	//sqlSessionFactory�� interface
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void userWrite(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	//sqlSession ����
		sqlSession.insert("userSQL.userWrtie", userDTO);	//mapper.xml�� �ѱ�, 1�����ڴ� id �� ù��°�����ΰ� ã�ư�
		sqlSession.commit();
		sqlSession.close();
		//namespace.id
		//������.�޼ҵ��
	}

	public List<UserDTO> userList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.userList");
		sqlSession.close();
		return list;
	}

	public UserDTO userOne(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.userOne", id);
		sqlSession.close();
		
		return userDTO;
	}

	public void userModify(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("userSQL.userModify", userDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<UserDTO> search(String colName, String value) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, String> map = new HashMap<>();
		map.put("colName", colName);
		map.put("value", value);
		
		List<UserDTO> list = sqlSession.selectList("userSQL.userSearch", map);
		sqlSession.close();
		return list;
		
	}

	public void userDelete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.userDelete", id);
		sqlSession.commit();
		sqlSession.close();
	}
	
	
}

/*
IO stream
1. byte
	InputStream
	OutputStream

2. ����
	Reader
	Writer
*/
