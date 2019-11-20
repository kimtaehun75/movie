package trs.movie.controller;

import java.util.Scanner;

import trs.movie.action.Action;

public class MovieController {
	public void processRequest(Action action,Scanner sc) {
		// 사용자 메뉴 선택 의도과와 입력 값을 가져와서
		// execute 메소드를 실행
		try {
			action.execute(sc);
			// 상위 개념의 인터페이스에서 선언된 메소드는 하위 개념클래스의 재구현 메소드로 대체됨
			// 즉, memberAddaction.execute(sc)
			// 다형성 , 겉으로는 동일하지만, 어떤 객체가 전달되어지는지에 따라서
			// 다른 동작의 결과를 나타냄
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
