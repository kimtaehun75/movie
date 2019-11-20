package trs.movie.action;

import java.util.ArrayList;
import java.util.Scanner;

import trs.movie.Util.ConsoleUtil;
import trs.movie.svc.MovieDeleteService;
import trs.movie.svc.MovieInfoService;
import trs.movie.vo.Users;

public class MovieDeleteAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		boolean deleteSuccess = false;
		boolean checkDelete = false;
		boolean updateSuccess = false;
		String selectNumber = null;
		MovieDeleteService md = new MovieDeleteService();

		MovieInfoService ms = new MovieInfoService();

		ConsoleUtil cu = new ConsoleUtil();

		String id = cu.checkId(sc);

		ArrayList<Users> usersList = ms.getUsersList(id);

		cu.printUsersList(usersList, id);

		while (!checkDelete) {
			selectNumber = cu.deleteRsv(sc);

			updateSuccess = md.updateUser(id, selectNumber);

			deleteSuccess = md.deleteUser(id, selectNumber);

			usersList = ms.getUsersList(id);

			cu.printUsersList(usersList, id);

			String answer = cu.printRequest(sc);
			if (answer.equals("n") || answer.equals("no")) {
				checkDelete = true;
				break;
			} else
				continue;
		}

		if (deleteSuccess && updateSuccess)
			cu.printDeleteSuccess();
		else
			cu.printDeleteFail();

	}

}
