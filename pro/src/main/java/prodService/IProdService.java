package prodService;

import java.util.List;

import prodVo.prodVO;

public interface IProdService {
	public List<prodVO> selectByLgu(String lgu);
	public prodVO selectById(String id);
}
