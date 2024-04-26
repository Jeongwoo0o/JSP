package board_mybatis;

import java.util.HashMap;
import java.util.List;
import board_mybatis.BoardVO;

public class BoardService {
	private static BoardService instance;
	
	public static BoardService getInstance() {
		if( instance == null )
		{
			instance = new BoardService();
		}
		return instance;
	}
	
	// Model == Repository
	private BoardRepo repo = new BoardRepo();
	
	public List<BoardVO> selectBoard(){
		return repo.selectBoard();
	}
}
