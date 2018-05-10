package cn.java.test;

import java.util.List;

import cn.java.dao.UserDao;
import cn.java.dao.Impl.UserDaoImpl;
import cn.java.entity.User;

public class Test {
			//单元测试
			@org.junit.Test
		public void Test(){
				UserDao userDao =new UserDaoImpl();
				//查询所有用户信息
				List<User> list = userDao.getUser();
				for (User user : list) {
					System.out.println(user.toString());
				}
				
//				System.out.println(list);
			
				
		}
}
