package trs.movie.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	static {
		// �������� ���Ǵ� �κ�
		// ���α׷� ���� �� �޸� ���, ���� �� ���� ������
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ����Ŭ ���� �õ� �޼ҵ�
	public static Connection getConnection() {
		Connection con = null;
		// ����Ŭ�� ������ ���ؼ� Connection ��ü ���� ����
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "1234");
			// ���� ������ ������ ���� �õ�
			con.setAutoCommit(false);
			// ������ �ƴٸ� AutoCommit�� ����
		} catch (SQLException e) {
			e.printStackTrace();
			// ������ �߻��ȴٸ� Exception ó��
		}
		return con;
	}

	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// ���� ó���� ������, �������� �ü�翡 ����
	// overloading ó����

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// statement : �ڹٿ��� ������ ���� �����ϰ�, ����� ������ �� ���

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// ��� ���� ResultSet
	public static void commit(Connection con) {
		try {
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}// Ʈ����� �Ϸ� ( ���� ���� �޵��� )
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}// Ʈ����� ���
}