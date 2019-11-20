package trs.movie.dao;

import static trs.movie.db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trs.movie.Util.ConsoleUtil;
import trs.movie.vo.Film;
import trs.movie.vo.Movie;
import trs.movie.vo.Seat;
import trs.movie.vo.Users;

public class UsersDAO {
	Connection con;
	ConsoleUtil cu = new ConsoleUtil();
	public UsersDAO(Connection con) {
		super();
		this.con = con;
	}

	public ArrayList<Movie> selectMovieList() {
		ArrayList<Movie> movieList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select movie_num_seq as num,name,genre,run_time,age,dir,act from movie2";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			movieList = new ArrayList<Movie>();

			Movie movie = null;

			while (rs.next()) {
				movie = new Movie(rs.getInt("num"),
						rs.getString("name"), 
						rs.getString("Genre"), 
						rs.getString("Run_time"),
						rs.getInt("age"), 
						rs.getString("dir"), 
						rs.getString("act"));

				movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}// end movieList

	public ArrayList<Film> selectTimeList(String movieNumber){
		ArrayList<Film> timeList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select m.name,movie_time,screen from movie2 m,film f where m.name = f.name and movie_num_seq = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movieNumber);
			rs = pstmt.executeQuery();
			timeList = new ArrayList<Film>();
			
			Film time = null;
			
			while(rs.next()) {
				time = new Film(rs.getString("name"),
						rs.getString("movie_time"),
						rs.getInt("screen"));
			
						timeList.add(time);
			}
						
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return timeList;
	}//end timeList
	
	public ArrayList<Seat> selectSeatList(String movieNumber,String timeNumber){
		ArrayList<Seat> seatList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select s.name,s.screen,movietime,seatnumber,usingseat\r\n" + 
				"from movie2 m,\r\n" + 
				"(select *\r\n" + 
				"from \r\n" + 
				"(select rownum as num,m.name,movie_time,screen\r\n" + 
				"from movie2 m,film f\r\n" + 
				"where \r\n" + 
				"m.name = f.name and\r\n" + 
				"movie_num_seq = ?) a\r\n" + 
				"where a.num = ?) f\r\n" + 
				",seat2 s\r\n" + 
				"where movie_num_seq = ?\r\n" + 
				"and m.name = f.name\r\n" + 
				"and f.screen = s.screen\r\n" + 
				"and f.movie_time = s.movietime";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movieNumber);
			pstmt.setString(2, timeNumber);
			pstmt.setString(3, movieNumber);
			rs = pstmt.executeQuery();
			seatList = new ArrayList<Seat>();
			
			Seat seat = null;
			
			while(rs.next()) {
				seat = new Seat(rs.getString("name"),
						rs.getInt("screen"),
						rs.getString("movietime"),
						rs.getString("seatnumber"),
						rs.getInt("usingseat"));
				
				seatList.add(seat);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return seatList;
	}//end seatList
	
	public ArrayList<Users> selectUsersList(String id) { 
	      ArrayList<Users> usersList = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql ="select * from users where id = ?";
	      
	      try {
	         pstmt=con.prepareStatement(sql); //쿼리준비
	         
	         pstmt.setString(1, id);
	         rs=pstmt.executeQuery(); //쿼리실행
	         usersList = new ArrayList<Users>();
	         // 맴버 객체 여러개를 담을 객체 배열
	         // 오라클 레코드 1줄은 = 맴버 객체 1개
	         Users users =null; //맴버객체를 저장할 변수선언
	         
	         
	         while(rs.next()) {
	            // select한 결과가 있는지 확인. rs.next()
	            users = new Users(
	            		rs.getString("id"),
	                  rs.getString("name"),
	                  rs.getString("movietime"),
	                  rs.getInt("screen"),
	                  rs.getString("seatnumber"));
	            //조회한 결과(select),
	            //컬럼명이 name이면 가져와서 1번째 전달값으로 이용.
	            usersList.add(users);
	            //생성된 객체 member를 arraylist에 추가
	         }
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            close(rs);
	            close(pstmt);
	         }catch(Exception e) {
	            e.printStackTrace();
	         }
	      }
	         
	      return usersList;
	   }//end usersList   	
	
	public int insertUserList(String id,String movieNumber,String timeNumber,String seatNumber) {
		int insertSuccess = 0;
		
		PreparedStatement pstmt = null;
		String sql = "insert into\r\n" + 
				"users\r\n" + 
				"select ?,\r\n" + 
				"(select distinct name \r\n" + 
				"from movie2\r\n" + 
				"where movie_num_seq = ?),\r\n" + 
				"(select distinct movie_time\r\n" + 
				"from movie2 m,\r\n" + 
				"(select *\r\n" + 
				"from \r\n" + 
				"(select rownum as num,m.name,movie_time,screen\r\n" + 
				"from movie2 m,film f\r\n" + 
				"where \r\n" + 
				"m.name = f.name and\r\n" + 
				"movie_num_seq = ?) a\r\n" + 
				"where a.num = ?) f\r\n" + 
				",seat s\r\n" + 
				"where movie_num_seq = ?\r\n" + 
				"and m.name = f.name\r\n" + 
				"and f.screen = s.screen\r\n" + 
				"and f.movie_time = s.movietime),\r\n" + 
				"(select distinct s.screen\r\n" + 
				"from movie2 m,\r\n" + 
				"(select *\r\n" + 
				"from \r\n" + 
				"(select rownum as num,m.name,movie_time,screen\r\n" + 
				"from movie2 m,film f\r\n" + 
				"where \r\n" + 
				"m.name = f.name and\r\n" + 
				"movie_num_seq = ?) a\r\n" + 
				"where a.num = ?) f\r\n" + 
				",seat s\r\n" + 
				"where movie_num_seq = ?\r\n" + 
				"and m.name = f.name\r\n" + 
				"and f.screen = s.screen\r\n" + 
				"and f.movie_time = s.movietime),\r\n" + 
				"?\r\n" + 
				"from dual\r\n" + 
				"where not exists\r\n" + 
				"(select *\r\n" + 
				"from users\r\n" + 
				"where \r\n" + 
				"id = ?\r\n" + 
				"and\r\n" + 
				"name = \r\n" + 
				"((select distinct name \r\n" + 
				"from movie2\r\n" + 
				"where movie_num_seq = ?))\r\n" + 
				"and\r\n" + 
				"movietime = \r\n" + 
				"((select distinct movie_time\r\n" + 
				"from movie2 m,\r\n" + 
				"(select *\r\n" + 
				"from \r\n" + 
				"(select rownum as num,m.name,movie_time,screen\r\n" + 
				"from movie2 m,film f\r\n" + 
				"where \r\n" + 
				"m.name = f.name and\r\n" + 
				"movie_num_seq = ?) a\r\n" + 
				"where a.num = ?) f\r\n" + 
				",seat s\r\n" + 
				"where movie_num_seq = ?\r\n" + 
				"and m.name = f.name\r\n" + 
				"and f.screen = s.screen\r\n" + 
				"and f.movie_time = s.movietime))\r\n" + 
				"and\r\n" + 
				"screen = \r\n" + 
				"((select distinct s.screen\r\n" + 
				"from movie2 m,\r\n" + 
				"(select *\r\n" + 
				"from \r\n" + 
				"(select rownum as num,m.name,movie_time,screen\r\n" + 
				"from movie2 m,film f\r\n" + 
				"where \r\n" + 
				"m.name = f.name and\r\n" + 
				"movie_num_seq = ?) a\r\n" + 
				"where a.num = ?) f\r\n" + 
				",seat s\r\n" + 
				"where movie_num_seq = ?\r\n" + 
				"and m.name = f.name\r\n" + 
				"and f.screen = s.screen\r\n" + 
				"and f.movie_time = s.movietime))\r\n" + 
				"and\r\n" + 
				"seatnumber = ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, movieNumber);
			pstmt.setString(3, movieNumber);
			pstmt.setString(4, timeNumber);
			pstmt.setString(5, movieNumber);
			pstmt.setString(6, movieNumber);
			pstmt.setString(7, timeNumber);
			pstmt.setString(8, movieNumber);
			pstmt.setString(9, seatNumber);
			pstmt.setString(10, id);
			pstmt.setString(11, movieNumber);
			pstmt.setString(12, movieNumber);
			pstmt.setString(13, timeNumber);
			pstmt.setString(14, movieNumber);
			pstmt.setString(15, movieNumber);
			pstmt.setString(16, timeNumber);
			pstmt.setString(17, movieNumber);
			pstmt.setString(18, seatNumber);
			
			
			insertSuccess = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return insertSuccess;
	}//end insertSuccess
	
	public ArrayList<Users> checkRsv() {
		ArrayList<Users> usersList = new ArrayList<>(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			Users users = null;
			while(rs.next()) {
				users = new Users(
							rs.getString("id"),
		                  rs.getString("name"),
		                  rs.getString("movietime"),
		                  rs.getInt("screen"),
		                  rs.getString("seatnumber"));
				
				
				
				usersList.add(users);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
				close(rs);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return usersList;
	}//end checkRsv
	
	public int deleteUser(String id,String selectNumber) {
		int deleteSuccess = 0;
		PreparedStatement pstmt = null;
		String sql = "delete\r\n" + 
				"from\r\n" + 
				"users\r\n" + 
				"where\r\n" + 
				"rowid =\r\n" + 
				"(select a.num1\r\n" + 
				"from \r\n" + 
				"(select rowid as num1,rownum as num\r\n" + 
				"from users u\r\n" + 
				"where \r\n" + 
				"id = ?) a\r\n" + 
				"where a.num = ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, selectNumber);
			
			
			deleteSuccess = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace(); 
		}finally {
			try {
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return deleteSuccess;
	}//end deleteUser
	
	public int updateSeatList(String id,String movieNumber,String timeNumber,String seatNumber) {
		int updateSuccess = 0;
		PreparedStatement pstmt = null;
		String sql = "update seat2 set usingseat = 0 where "
				+ "name = (select distinct name \r\n" + 
				"from movie2\r\n" + 
				"where movie_num_seq = "+movieNumber+") "
				+ "and "
				+ "screen = (select distinct s.screen\r\n" + 
				"from movie2 m,\r\n" + 
				"(select *\r\n" + 
				"from \r\n" + 
				"(select rownum as num,m.name,movie_time,screen\r\n" + 
				"from movie2 m,film f\r\n" + 
				"where \r\n" + 
				"m.name = f.name and\r\n" + 
				"movie_num_seq = "+movieNumber+") a\r\n" + 
				"where a.num = "+timeNumber+") f\r\n" + 
				",seat s\r\n" + 
				"where movie_num_seq = "+movieNumber+"\r\n" + 
				"and m.name = f.name\r\n" + 
				"and f.screen = s.screen\r\n" + 
				"and f.movie_time = s.movietime)"
				+ "and "
				+ "movietime = (select distinct movie_time\r\n" + 
				"from movie2 m,\r\n" + 
				"(select *\r\n" + 
				"from \r\n" + 
				"(select rownum as num,m.name,movie_time,screen\r\n" + 
				"from movie2 m,film f\r\n" + 
				"where \r\n" + 
				"m.name = f.name and\r\n" + 
				"movie_num_seq = "+movieNumber+") a\r\n" + 
				"where a.num = "+timeNumber+") f\r\n" + 
				",seat s\r\n" + 
				"where movie_num_seq = "+movieNumber+"\r\n" + 
				"and m.name = f.name\r\n" + 
				"and f.screen = s.screen\r\n" + 
				"and f.movie_time = s.movietime)"
				+ "and "
				+ "seatnumber = "+seatNumber+"";
		
			try {
				pstmt = con.prepareStatement(sql);
				
				updateSuccess = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					close(pstmt);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		return updateSuccess;
	}// end updateSccess
	
	public int updateUser(String id,String selectNumber) {
		int updateSuccess = 0;
		PreparedStatement pstmt = null;
		String sql = "update seat2\r\n" + 
				"set usingseat = '1'\r\n" + 
				"where \r\n" + 
				"name = \r\n" + 
				"(select name\r\n" + 
				"from \r\n" + 
				"(select rownum as num,name\r\n" + 
				"from users u\r\n" + 
				"where \r\n" + 
				"id = "+id+") a\r\n" + 
				"where a.num = "+selectNumber+")\r\n" + 
				"and\r\n" + 
				"screen = \r\n" + 
				"(select screen\r\n" + 
				"from \r\n" + 
				"(select rownum as num,screen\r\n" + 
				"from users u\r\n" + 
				"where \r\n" + 
				"id = "+id+") a\r\n" + 
				"where a.num = "+selectNumber+")\r\n" + 
				"and\r\n" + 
				"movietime = \r\n" + 
				"(select movietime\r\n" + 
				"from \r\n" + 
				"(select rownum as num,movietime\r\n" + 
				"from users u\r\n" + 
				"where \r\n" + 
				"id = "+id+") a\r\n" + 
				"where a.num = "+selectNumber+")\r\n" + 
				"and\r\n" + 
				"seatnumber =\r\n" + 
				"(select seatnumber\r\n" + 
				"from \r\n" + 
				"(select rownum as num,seatnumber\r\n" + 
				"from users u\r\n" + 
				"where \r\n" + 
				"id = "+id+") a\r\n" + 
				"where a.num = "+selectNumber+")";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			updateSuccess = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return updateSuccess;
	}//end updateUser
}// end class
