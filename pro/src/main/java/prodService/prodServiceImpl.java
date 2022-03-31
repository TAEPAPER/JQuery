package prodService;

import java.util.List;

import prodDao.IProdDao;
import prodDao.prodDaoImpl;
import prodVo.prodVO;

public class prodServiceImpl implements IProdService {
		private IProdDao dao;
		private static IProdService service;
		private prodServiceImpl() {
		      dao = prodDaoImpl.getInstance();
		}
	    public static IProdService getInstance() {
	    	if(service ==null) {
	    		service = new prodServiceImpl();
	    	}
	    	return service;
	    }
	
	
	@Override
	public List<prodVO> selectByLgu(String lgu) {

		return dao.selectByLgu(lgu);
	}
	@Override
	public prodVO selectById(String id) {
		
		return dao.selectById(id);
	}

}
