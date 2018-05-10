package cn.java.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.java.dao.BaseDao;
import cn.java.dao.UserDao;
import cn.java.entity.User;

public class UserDaoImpl  extends BaseDao implements UserDao{

	public List<User> getUser() {
		List<User> list =new ArrayList<User>();
		String sql ="SELECT * FROM USER";
		Object[]params =null;
		super.rs=super.getResultSet(sql, params);
		try {
			while(rs.next()){
				//��ʾ��ѯ�����û�����
				User user =new User();  //�����û�����
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setScore(rs.getDouble(3));
				//��ӵ�������
				list.add(user);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			super.close(conn, ps, rs);
		}
		return list;
	}

}
