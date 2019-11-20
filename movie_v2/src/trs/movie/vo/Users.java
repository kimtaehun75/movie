package trs.movie.vo;

public class Users {
	String id;
	String name;
	String movietime;
	int screen;
	String seatnumber;
	
	public Users(String id, String name, String movietime, int screen, String seatnumber) {
		super();
		this.id = id;
		this.name = name;
		this.movietime = movietime;
		this.screen = screen;
		this.seatnumber = seatnumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(String seatnumber) {
		this.seatnumber = seatnumber;
	}
	@Override
	public String toString() {
StringBuffer s = new StringBuffer();
		int value = id.length() != 22? 22-id.length() : 22;
		s.append(id);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		value = name.length() != 23? 15-name.length() : 23;
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
		value = seatnumber.length() != 15? 15-seatnumber.length() : 15;
		s.append(seatnumber);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		
		
		return s.toString();
	}
	
	
	
}
