package trs.movie.Util;

import java.util.ArrayList;
import java.util.Scanner;

import trs.movie.vo.Film;
import trs.movie.vo.Movie;
import trs.movie.vo.Seat;
import trs.movie.vo.Users;

public class ConsoleUtil {
	public void printMovieList(ArrayList<Movie> movieList) {
		System.out.println("-Select Movie");
		System.out.println("������������������������������������������������������������������������������������������������������������������");
		System.out.println("Num     Name		      Genre          Runtime        Age            DIR                      ACT");
		System.out.println("������������������������������������������������������������������������������������������������������������������");
		for(int i=0;i<movieList.size();i++) {
			System.out.print(movieList.get(i));
		}
		System.out.println("��ȭ ��ȣ�� �Է��� �ּ���. ");
	}
	
	public void printTimeList(ArrayList<Film> timeList) {
		System.out.println("-Select Screen and Time");
		System.out.println("������������������������������������������������������������������������������������������������������������������");
		System.out.println("Num     Name		      Time           Screen");
		System.out.println("������������������������������������������������������������������������������������������������������������������");
		int j=1;
		for(int i=0;i<timeList.size();i++) {
			System.out.println(j+"       "+timeList.get(i));
			j++;
		}
		
		System.out.println("��ȣ�� �Է����ּ���. ");
	}
	
	public void printSeatList(ArrayList<Seat> seatList) {
		System.out.println("-Select Seat");
		System.out.println("������������������������������������������������������������������������������������������������������������������");
		System.out.println("Name		      Time           Screen         Seat");
		System.out.println("������������������������������������������������������������������������������������������������������������������");
		for(int i=0;i<seatList.size();i++) {
			System.out.println(seatList.get(i));
		}
		System.out.println("�¼���ȣ�� �Է����ּ���. ");
	}
	
	public void printInsertSuccess() {
		System.out.println("���࿡ �����Ͽ����ϴ�.");
	}
	
	public void printInsertFail() {
		System.out.println("�̹� ����� �ڸ��Դϴ�.");
		System.out.println("���࿡ �����Ͽ����ϴ�.");
	}
	public String getId(Scanner sc) {
		System.out.println("��ȭ��ȣ�� �Է����ּ���.");
		System.out.println("�����ȣ�� ��ȸ�� �� ���˴ϴ�.");
		return sc.next();
	}
	
	public String deleteRsv(Scanner sc) {
		System.out.println("�����Ͻ� ��ȣ�� �������ּ���.");
		return sc.next();
	}
	
	public void printUsersList(ArrayList<Users> usersList,String id){
		System.out.println("-"+id+"���� ��������");
		System.out.println("������������������������������������������������������������������������������������������������������������������");
		System.out.println("Num     ID                    Name           Time           Screen         Seat");
		System.out.println("������������������������������������������������������������������������������������������������������������������");  
		int j=1;
		for(int i=0;i<usersList.size();i++) {
			System.out.println(j+"       "+usersList.get(i));
			j++;
		}
			
	   }
	   public String checkId(Scanner sc) {
	      System.out.println("���� ��ȸ�� ���� ��ȭ��ȣ�� �Է��� �ּ���.");

	      return sc.next();
	   }
	   
	   public String RsvSeat(Scanner sc,int i,int person) {
		   System.out.println("�¼��� ������ �ּ���."+(i+1)+"/"+person);
		   return sc.next();
	   }
	   
	   public int getPerson(Scanner sc) {
		   System.out.println("�ο� ���� �Է��� �ּ���.");
		   return sc.nextInt();
	   }
	   
	   public String printRequest(Scanner sc) {
		   System.out.println("��� �̿��Ͻðڽ��ϱ�? y/n");
		   
		   return sc.next();
	   }
	public void printFailSave() {
		System.out.println("�̹� ����� �ڸ��Դϴ�.");
	}
	
	public void printSuccessSave() {
		System.out.println("������ ������ �ڸ��Դϴ�.");
	}
	
	public void printDeleteSuccess() {
		System.out.println("���� ��ҿ� �����Ͽ����ϴ�.");
	}
	
	public void printDeleteFail() {
		System.out.println("���� ��ҿ� �����Ͽ����ϴ�.");
		
	}
	
	
}
