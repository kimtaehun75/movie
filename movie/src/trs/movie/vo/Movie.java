package trs.movie.vo;

public class Movie {
	private String name;
	private String Genre;
	private String run_time;
	private int age;
	private String dir;
	private String act;
	
	
	public Movie(String name, String Genre, String run_time, int age, String dir, String act) {
		super();
		this.name = name;
		this.Genre = Genre;
		this.run_time = run_time;
		this.age = age;
		this.dir = dir;
		this.act = act;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String Genre) {
		this.Genre = Genre;
	}
	public String getRun_time() {
		return run_time;
	}
	public void setRun_time(String run_time) {
		this.run_time = run_time;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}


	@Override
	public String toString() {
		return "Movie [name=" + name + ", Genre=" + Genre + ", run_time=" + run_time + ", age=" + age + ", dir=" + dir
				+ ", act=" + act + "]";
	}
	
	
}
