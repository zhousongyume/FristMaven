package cn.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private String className = "com.mysql.jdbc.Driver";		//�����ַ���
	private String url = "jdbc:mysql://localhost:3306/ssm?useUnicode=true&amp;characterEncoding=UTF-8";	//�����ַ���
	private String user = "root";
	private String password = "root";
	/*jdbc�ӿ�*/
	protected Connection conn;				//����
	protected PreparedStatement ps;			//Ԥ��������
	protected ResultSet rs;					//�����
	/**
	 * �������Ӷ���
	 * @return
	 */
	public Connection getConnection(){
		try {
			//����mysql����
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	/**
	 * ��ɾ��
	 * @param sql
	 * @param params
	 */
	public void update(String sql,Object[] params){
		conn = this.getConnection();	//�������Ӷ���
		try {
			//����Ԥ��������
			ps = conn.prepareStatement(sql);
			if(params != null){
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			//ִ��sql���
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//�ر���Դ
			this.close(conn, ps, rs);
		}
	}
	
	/**
	 * ��ɾ��
	 * @param sql
	 * @param params
	 */
	public ResultSet getResultSet(String sql,Object[] params){
		conn = this.getConnection();	//�������Ӷ���
		try {
			//����Ԥ��������
			ps = conn.prepareStatement(sql);
			if(params != null){
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			//ִ��sql���
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(ps != null){
				ps.close();
				ps = null;
			}
			if(conn != null){
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
