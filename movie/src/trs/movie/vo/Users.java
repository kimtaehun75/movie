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
		return "Users [id=" + id + ", name=" + name + ", movietime=" + movietime + ", screen=" + screen
				+ ", seatnumber=" + seatnumber + "]";
	}

}
