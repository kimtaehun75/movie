package trs.movie.ui;

import java.util.Scanner;

import trs.movie.action.Action;
import trs.movie.action.MovieDeleteAction;
import trs.movie.action.MovieInfoAction;
import trs.movie.action.MovieRsvAction;
import trs.movie.controller.MovieController;

public class MovieUI {
	public static void main(String[] args) {
		boolean isStop = false;
		
		MovieController mc = new MovieController();
	
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("T4 ��ȭ ���� �ý���");
			System.out.println("1.��ȭ ����");
			System.out.println("2.���� Ȯ��");
			System.out.println("3.���� ���");
			System.out.println("4.���α׷� ����");
			System.out.print("�޴� ��ȣ : ");
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
				action = new MovieDeleteAction();
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
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
