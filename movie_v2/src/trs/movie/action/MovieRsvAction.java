package trs.movie.action;

import java.util.ArrayList;
import java.util.Scanner;

import trs.movie.Util.ConsoleUtil;
import trs.movie.svc.MovieRsvService;
import trs.movie.vo.Film;
import trs.movie.vo.Movie;
import trs.movie.vo.Seat;

public class MovieRsvAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		boolean insertSuccess = false;
		boolean updateSeat = false;
		ConsoleUtil cu = new ConsoleUtil();
		
		String[] seatNumber = null;
		
		int person = 0;
		
		MovieRsvService mr = new MovieRsvService();
		
		ArrayList<Movie> movieList = mr.getMovieList();
		
		cu.printMovieList(movieList);
		
		String movieNumber = sc.next();
		
		ArrayList<Film> timeList = mr.getTimeList(movieNumber);
		
		cu.printTimeList(timeList);
		
		String timeNumber = sc.next();
		
		person = cu.getPerson(sc);
		
		seatNumber = new String[person];
		
		ArrayList<Seat> seatList = mr.getSeatList(movieNumber,timeNumber);
		
		cu.printSeatList(seatList);
		
		
		for(int i=0;i<person;i++) {
			seatNumber[i] = cu.RsvSeat(sc,i,person);
		}
		
		
		String id = cu.getId(sc);
		
		
		for(int i=0;i<person;i++) {
			insertSuccess = mr.insertUser(id,movieNumber,timeNumber,seatNumber[i]);
		}
		
		for(int i=0;i<person;i++) {
			updateSeat = mr.updateSeat(id,movieNumber,timeNumber,seatNumber[i]);
		}
		
		
		if(insertSuccess && updateSeat) {
			cu.printInsertSuccess();
		}else {
			cu.printInsertFail();
		}
	}
}