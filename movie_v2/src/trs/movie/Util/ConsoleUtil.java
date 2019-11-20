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
		System.out.println("─────────────────────────────────────────────────────────");
		System.out.println("Num     Name		      Genre          Runtime        Age            DIR                      ACT");
		System.out.println("─────────────────────────────────────────────────────────");
		for(int i=0;i<movieList.size();i++) {
			System.out.print(movieList.get(i));
		}
		System.out.println("영화 번호를 입력해 주세요. ");
	}
	
	public void printTimeList(ArrayList<Film> timeList) {
		System.out.println("-Select Screen and Time");
		System.out.println("─────────────────────────────────────────────────────────");
		System.out.println("Num     Name		      Time           Screen");
		System.out.println("─────────────────────────────────────────────────────────");
		int j=1;
		for(int i=0;i<timeList.size();i++) {
			System.out.println(j+"       "+timeList.get(i));
			j++;
		}
		
		System.out.println("번호를 입력해주세요. ");
	}
	
	public void printSeatList(ArrayList<Seat> seatList) {
		System.out.println("-Select Seat");
		System.out.println("─────────────────────────────────────────────────────────");
		System.out.println("Name		      Time           Screen         Seat");
		System.out.println("─────────────────────────────────────────────────────────");
		for(int i=0;i<seatList.size();i++) {
			System.out.println(seatList.get(i));
		}
		System.out.println("좌석번호를 입력해주세요. ");
	}
	
	public void printInsertSuccess() {
		System.out.println("예약에 성공하였습니다.");
	}
	
	public void printInsertFail() {
		System.out.println("이미 예약된 자리입니다.");
		System.out.println("예약에 실패하였습니다.");
	}
	public String getId(Scanner sc) {
		System.out.println("전화번호를 입력해주세요.");
		System.out.println("예약번호를 조회할 때 사용됩니다.");
		return sc.next();
	}
	
	public String deleteRsv(Scanner sc) {
		System.out.println("삭제하실 번호를 선택해주세요.");
		return sc.next();
	}
	
	public void printUsersList(ArrayList<Users> usersList,String id){
		System.out.println("-"+id+"님의 예약정보");
		System.out.println("─────────────────────────────────────────────────────────");
		System.out.println("Num     ID                    Name           Time           Screen         Seat");
		System.out.println("─────────────────────────────────────────────────────────");  
		int j=1;
		for(int i=0;i<usersList.size();i++) {
			System.out.println(j+"       "+usersList.get(i));
			j++;
		}
			
	   }
	   public String checkId(Scanner sc) {
	      System.out.println("예약 조회를 위해 전화번호를 입력해 주세요.");

	      return sc.next();
	   }
	   
	   public String RsvSeat(Scanner sc,int i,int person) {
		   System.out.println("좌석을 선택해 주세요."+(i+1)+"/"+person);
		   return sc.next();
	   }
	   
	   public int getPerson(Scanner sc) {
		   System.out.println("인원 수를 입력해 주세요.");
		   return sc.nextInt();
	   }
	   
	   public String printRequest(Scanner sc) {
		   System.out.println("계속 이용하시겠습니까? y/n");
		   
		   return sc.next();
	   }
	public void printFailSave() {
		System.out.println("이미 예약된 자리입니다.");
	}
	
	public void printSuccessSave() {
		System.out.println("예약이 가능한 자리입니다.");
	}
	
	public void printDeleteSuccess() {
		System.out.println("예약 취소에 성공하였습니다.");
	}
	
	public void printDeleteFail() {
		System.out.println("예약 취소에 실패하였습니다.");
		
	}
	
	
}
