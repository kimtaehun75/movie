package trs.movie.vo;


public class Movie {
	private int num;
	private String name;
	private String Genre;
	private String run_time;
	private int age;
	private String dir;
	private String act;
	
	public Movie(int num, String name, String genre, String run_time, int age, String dir, String act) {
		super();
		this.num = num;
		this.name = name;
		Genre = genre;
		this.run_time = run_time;
		this.age = age;
		this.dir = dir;
		this.act = act;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public void setGenre(String genre) {
		Genre = genre;
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
		StringBuffer s = new StringBuffer();
		int value = (""+num).length() != 8? 8-(""+num).length() : 8;
		s.append(num);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		value = name.length() != 22? 22-name.length() : 22;
		s.append(name);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		value = Genre.length() != 15? 15-Genre.length() : 15;
		s.append(Genre);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		value = run_time.length() != 15? 15-run_time.length() : 15;
		s.append(run_time);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		value = (""+age).length() != 15? 15-(""+age).length() : 15;
		s.append(age);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		value = dir.length() != 25? 25-dir.length() : 25;
		s.append(dir);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		value = act.length() != 22? 22-act.length() : 22;
		s.append(act);
		for(int i=0;i<value;i++) {
			s.append(" ");
		}
		s.append("\n");
		return s.toString();
	}	
}
