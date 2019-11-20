package trs.movie.svc;

import static trs.movie.db.JdbcUtil.*;


import java.sql.Connection;
import java.util.ArrayList;

import trs.movie.dao.UsersDAO;
import trs.movie.vo.Users;


public class MovieInfoService {
   public ArrayList<Users> getUsersList(String id) {
      
      Connection con = getConnection();
      
      UsersDAO usersDAO = new UsersDAO(con);
      
      ArrayList<Users> usersList = usersDAO.selectUsersList(id);
      
      close(con);
      
      return usersList;
   }
}