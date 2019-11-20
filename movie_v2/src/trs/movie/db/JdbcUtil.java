package trs.movie.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	static {
		// 공통으로 사용되는 부분
		// 프로그램 시작 시 메모리 등록, 종료 시 까지 유지함
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 오라클 접속 시도 메소드
	public static Connection getConnection() {
		Connection con = null;
		// 오라클과 연결을 위해서 Connection 객체 변수 선언
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "1234");
			// 계정 정보를 가지고 연결 시도
			con.setAutoCommit(false);
			// 연결이 됐다면 AutoCommit은 해제
		} catch (SQLException e) {
			e.printStackTrace();
			// 오류가 발생된다면 Exception 처리
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
	// 연결 처리가 끝나면, 끝났음을 운영체재에 전달
	// overloading 처리함

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// statement : 자바에서 생성된 값을 저장하고, 결과를 리턴할 때 사용

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 결과 모음 ResultSet
	public static void commit(Connection con) {
		try {
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}// 트랜잭션 완료 ( 최종 결제 받듯이 )
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}// 트랜잭션 취소
}