package testWeb1.dao;

import testWeb1.vo.*;

public interface UserDAO {
	
	/**
	 * 根据用户信息查询用户是否存在
	 * @param userinfo 用户信息对象，包含用户名和密码
	 * @return 存在返回1，不存在返回0
	 * @throws Exception 查询过程中可能抛出的异常
	 */
	public int queryByUserInfo(UserInfo userinfo) throws Exception;
	
}
