package board.controller;

import board.action.Action;
import board.action.BoardDeleteAction;
import board.action.BoardDetailAction;
import board.action.BoardInsertAction;
import board.action.BoardInsertFormAction;
import board.action.BoardListAction;
import board.action.BoardUpdateAction;
import board.action.BoardUpdateFormAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		// 서블릿에서 받은 command를 가지고 해당 명령처리하는 클래스를 찾음
		// 찾은 클래스를 객체 생성한 후 action에 담아서 리턴 (자바의 다형성을 활용한...)
		if(command.equals("listAll"))
			action = new BoardListAction();
		else if(command.equals("insertForm"))
			action = new BoardInsertFormAction();
		else if(command.equals("insert"))
			action = new BoardInsertAction();
		else if(command.equals("detail"))
			action = new BoardDetailAction();
		else if(command.equals("updateForm"))
			action = new BoardUpdateFormAction();
		else if(command.equals("update"))
			action = new BoardUpdateAction();
		else if(command.equals("delete"))
			action = new BoardDeleteAction();
		return action;
	}
}
