package trs.movie.action;

import java.util.ArrayList;
import java.util.Scanner;

import trs.movie.Util.ConsoleUtil;
import trs.movie.svc.MovieRsvService;
import trs.movie.vo.Movie;

public class MovieRsvAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		
		MovieRsvService mr = new MovieRsvService();
		
		ArrayList<Movie> movieList = mr.getMovieList();
		
		cu.printMovieList(movieList);
	}

}
