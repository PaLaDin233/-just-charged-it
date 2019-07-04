package xyz.zhhg.jci.dao;

import java.util.List;

import xyz.zhhg.jci.model.standard.user.Tb_UserInfo;
import xyz.zhhg.jci.model.wechat.user.WeChatIdentifier;

public interface UserMapper {
	//public void insertUser(WeChatIdentifier identifier);
	
	public List<Tb_UserInfo> getAllUser();
	
	public void updateUserInfo(Tb_UserInfo userInfo);
	
	public boolean isExistOpenId(String openid);

	public void insertUser(Tb_UserInfo userInfo);
}
