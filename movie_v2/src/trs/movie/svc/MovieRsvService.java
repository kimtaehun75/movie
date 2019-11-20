package trs.movie.svc;

import static trs.movie.db.JdbcUtil.close;
import static trs.movie.db.JdbcUtil.commit;
import static trs.movie.db.JdbcUtil.getConnection;
import static trs.movie.db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;


import trs.movie.dao.UsersDAO;
import trs.movie.vo.Film;
import trs.movie.vo.Movie;
import trs.movie.vo.Seat;

public class MovieRsvService {
	public ArrayList<Movie> getMovieList() {

		Connection con = getConnection();

		UsersDAO usersDAO = new UsersDAO(con);

		ArrayList<Movie> movieList = usersDAO.selectMovieList();

		close(con);
		return movieList;
	}
	
	public ArrayList<Film> getTimeList(String movieNumber){
		
		Connection con = getConnection();
		
		UsersDAO usersDAO = new UsersDAO(con);
		
		ArrayList<Film> timeList = usersDAO.selectTimeList(movieNumber);
		
		close(con);
		return timeList;
	}
	
	public ArrayList<Seat> getSeatList(String movieNumber,String timeNumber){
		
		Connection con = getConnection();
		
		UsersDAO usersDAO = new UsersDAO(con);
		
		ArrayList<Seat> seatList = usersDAO.selectSeatList(movieNumber,timeNumber);
		
		close(con);
		return seatList;
	}
	
	public boolean insertUser(String id,String movieNumber,String timeNumber,String seatNumber) {
		boolean insertSuccess = false;
		
		Connection con = getConnection();
		
		UsersDAO usersDAO = new UsersDAO(con);
		
		int isInsertSuccess = usersDAO.insertUserList(id,movieNumber,timeNumber,seatNumber);
		
		if(isInsertSuccess > 0) {
			commit(con);
			insertSuccess = true;
		}else {
			rollback(con);
			close(con);
		}
		return insertSuccess;
	}
	
	public boolean updateSeat(String id,String movieNumber,String timeNumber,String seatNumber) {
		boolean updateSeat = false;
		
		Connection con = getConnection();
		
		UsersDAO usersDAO = new UsersDAO(con);
	
		int isUpdateSeat = usersDAO.updateSeatList(id,movieNumber,timeNumber,seatNumber);
		
		if(isUpdateSeat > 0) {
			commit(con);
			updateSeat = true;
		}else {
			rollback(con);
			close(con);
		}
		
		return updateSeat;
	}
}
