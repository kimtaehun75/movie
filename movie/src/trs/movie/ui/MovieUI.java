package trs.movie.ui;

import java.util.Scanner;

import trs.movie.action.Action;
import trs.movie.action.MovieInfoAction;
import trs.movie.action.MovieRsvAction;
import trs.movie.controller.MovieController;

public class MovieUI {
	public static void main(String[] args) {
		boolean isStop = false;
		
		MovieController mc = new MovieController();
	
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("T4 영화예매시스템");
			System.out.println("1.예매하기");
			System.out.println("2.예약확인");
			System.out.println("3.종료하기");
			System.out.print("번호 선택: ");
			int menu = sc.nextInt();
			
			Action action = null;
			
			switch(menu) {
			case 1:
				action = new MovieRsvAction();
				break;
			case 2:
				action = new MovieInfoAction();
				break;
			case 3:
				System.out.println("이용해주셔서 감사합니다.");
				isStop = true;
				break;
			default:
				break;
			}
			if(action != null)
				mc.processRequest(action, sc);
		}
		while(!isStop);
	}
	
}
