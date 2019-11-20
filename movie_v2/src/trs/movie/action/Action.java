package trs.movie.action;

import java.util.Scanner;

public interface Action {
	void execute(Scanner sc) throws Exception;
	//메소드의 선언만 있음
	// 몸체는 implements 받는 클래스에서 구현
}