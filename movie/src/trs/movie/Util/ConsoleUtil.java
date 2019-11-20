package trs.movie.Util;

import java.util.ArrayList;

import trs.movie.vo.Movie;

public class ConsoleUtil {
	public void printMovieList(ArrayList<Movie> movieList) {
		for(int i=0;i<movieList.size();i++) {
			System.out.println(movieList.get(i));
		}
	}
}
