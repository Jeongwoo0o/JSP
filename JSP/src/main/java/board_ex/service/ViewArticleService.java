package board_ex.service;

import java.util.List;

import board_ex.model.*;
import guest.model.MessageDao;
import guest.model.MessageException;


public class ViewArticleService {
	
	private static ViewArticleService instance;
	public static ViewArticleService getInstance()  throws BoardException {
		if( instance == null )
		{
			instance = new ViewArticleService();
		}
		return instance;
	}
	
	public BoardVO getArticleById(String id) throws BoardException {
		int article_id = 0;
		if( id != null ) article_id = Integer.parseInt(id);
		BoardDao dao = BoardDao.getInstance();
		dao.increaseReadCount(article_id);
		BoardVO rec = dao.selectById(article_id);		
		
		return rec;
	}
	
	
		
}

