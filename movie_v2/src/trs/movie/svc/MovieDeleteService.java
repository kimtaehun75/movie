package trs.movie.svc;

import static trs.movie.db.JdbcUtil.*;


import java.sql.Connection;

import trs.movie.dao.UsersDAO;

public class MovieDeleteService {
	public boolean deleteUser(String id,String selectNumber) {
		boolean deleteSuccess = false;
		
		Connection con = getConnection();
		
		UsersDAO userDAO = new UsersDAO(con);
		
		int isDeleteSuccess = userDAO.deleteUser(id,selectNumber);
		
		if(isDeleteSuccess > 0) {
			commit(con);
			deleteSuccess = true;
		}else {
			rollback(con);
			close(con);
		}
		return deleteSuccess;
	}
	
	public boolean updateUser(String id,String selectNumber) {
		boolean updateSuccess = false;
		
		Connection con = getConnection();
		
		UsersDAO userDAO = new UsersDAO(con);
		
		int isUpdateSuccess = userDAO.updateUser(id,selectNumber);
		
		if(isUpdateSuccess > 0) {
			commit(con);
			updateSuccess = true;
		}else {
			rollback(con);
			close(con);
		}
		return updateSuccess;
	}
}
