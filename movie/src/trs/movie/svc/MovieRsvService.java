package trs.movie.svc;

import static trs.movie.db.JdbcUtil.close;
import static trs.movie.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import trs.movie.dao.UsersDAO;
import trs.movie.vo.Movie;

public class MovieRsvService {
	public ArrayList<Movie> getMovieList() {

		Connection con = getConnection();

		UsersDAO usersDAO = new UsersDAO(con);

		ArrayList<Movie> movieList = usersDAO.selectMovieList();

		close(con);
		return movieList;
	}
}
