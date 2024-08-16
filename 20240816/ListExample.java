package day08;

import java.util.*;

public class ListExample {
	
	static class Board {
		private String title;
		private String content;
		
		public Board(String title, String content) {
			this.title = title;
			this.content = content;
		}
		
		public String getTitle() {return title;	}
		public String getContent() {return content;}
	}
	
	static class BoardDao {
		public List<Board> getBoardList() {
			List<Board> list = new ArrayList<>();
			list.add(new Board("제목1", "내용1"));
			return list;
		}
	}
	
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for(Board board : list) {
			System.out.println(board.getTitle() + "-" +board.getContent());
		}

	}
}


