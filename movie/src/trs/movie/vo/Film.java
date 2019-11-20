package trs.movie.vo;

public class Film {
	String name;
	String movietime;
	int screen;

	public Film(String name, String movietime, int screen) {
		super();
		this.name = name;
		this.movietime = movietime;
		this.screen = screen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMovietime() {
		return movietime;
	}

	public void setMovietime(String movietime) {
		this.movietime = movietime;
	}

	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Film [name=" + name + ", movietime=" + movietime + ", screen=" + screen + "]";
	}

}
