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
		StringBuffer s = new StringBuffer();
		
		int value = name.length() != 22? 22-name.length() : 22;
		s.append(name);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		value = movietime.length() != 15? 15-movietime.length() : 15;
		s.append(movietime);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		value = (""+screen).length() != 15? 15-(""+screen).length() : 15;
		s.append(screen);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		
		return s.toString();
	}
	
	
	
}
