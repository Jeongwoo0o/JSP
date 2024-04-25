package reply_ex.service;

import reply_ex.model.ReplyDao;
import reply_ex.model.ReplyException;
import reply_ex.model.ReplyVO;

public class ReplyInsertService {
	private static ReplyInsertService instance;
	
	public static ReplyInsertService getInstance()  throws ReplyException{
		if( instance == null )
		{
			instance = new ReplyInsertService();
		}
		return instance;
	}
	 
	public int insertReply( ReplyVO vo ) throws ReplyException{
		
		// DB에서 update
		int result = ReplyDao.getInstance().insertReply(vo);
	
		return result;
		
	}
}
