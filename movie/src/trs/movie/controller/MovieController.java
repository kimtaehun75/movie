package trs.movie.controller;

import java.util.Scanner;

import trs.movie.action.Action;

public class MovieController {
	public void processRequest(Action action,Scanner sc) {
		// ����� �޴� ���� �ǵ����� �Է� ���� �����ͼ�
		// execute �޼ҵ带 ����
		try {
			action.execute(sc);
			// ���� ������ �������̽����� ����� �޼ҵ�� ���� ����Ŭ������ �籸�� �޼ҵ�� ��ü��
			// ��, memberAddaction.execute(sc)
			// ������ , �����δ� ����������, � ��ü�� ���޵Ǿ��������� ����
			// �ٸ� ������ ����� ��Ÿ��
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
