package trs.movie.vo;

public class Seat {
	String name;
	int screen;
	String movietime;
	String seatnumber;
	int usingseat;
	
	
	
	public Seat(String name, int screen, String movietime, String seatnumber, int usingseat) {
		super();
		this.name = name;
		this.screen = screen;
		this.movietime = movietime;
		this.seatnumber = seatnumber;
		this.usingseat = usingseat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScreen() {
		return screen;
	}
	public void setScreen(int screen) {
		this.screen = screen;
	}
	public String getMovietime() {
		return movietime;
	}
	public void setMovietime(String movietime) {
		this.movietime = movietime;
	}
	public String getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(String seatnumber) {
		this.seatnumber = seatnumber;
	}
	public int getUsingseat() {
		return usingseat;
	}
	public void setUsingseat(int usingseat) {
		this.usingseat = usingseat;
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
		value = seatnumber.length() != 15? 15-seatnumber.length() : 15;
		s.append(seatnumber);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		value = (""+usingseat).length() != 15? 15-(""+usingseat).length() : 15;
		if(usingseat == 1)
			s.append("가능");
		else
			s.append("불가능");
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		
		return s.toString();
	}	
}
