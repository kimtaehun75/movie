package trs.movie.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static trs.movie.db.JdbcUtil.*;
import trs.movie.vo.Movie;

public class UsersDAO {
	Connection con;

	public UsersDAO(Connection con) {
		super();
		this.con = con;
	}
	public ArrayList<Movie> selectMovieList() {
		ArrayList<Movie> movieList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from movie";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			movieList = new ArrayList<Movie>();
			
			Movie movie = null;
			
			while(rs.next()) {
				movie = new Movie(rs.getString("name"),
						rs.getString("Genre"),
						rs.getString("Run_time"),
						rs.getInt("age"),
						rs.getString("dir"),
						rs.getString("act"));
				
						movieList.add(movie);
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
		return movieList;
	}//end movieList
}//end class
