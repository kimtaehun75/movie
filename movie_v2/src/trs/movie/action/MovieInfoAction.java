package trs.movie.action;

import java.util.ArrayList;
import java.util.Scanner;

import trs.movie.Util.ConsoleUtil;
import trs.movie.svc.MovieInfoService;
import trs.movie.vo.Users;



public class MovieInfoAction implements Action {

   @Override
   public void execute(Scanner sc) throws Exception {
      ConsoleUtil cu = new ConsoleUtil();
      MovieInfoService movieinfoService = new MovieInfoService();
      
      String id = cu.checkId(sc);
      
      ArrayList<Users> usersList = movieinfoService.getUsersList(id);
      
      cu.printUsersList(usersList,id);
   }

}