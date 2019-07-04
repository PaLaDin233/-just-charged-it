package xyz.zhhg.jci.service;

import javax.servlet.http.HttpServletRequest;

import xyz.zhhg.jci.model.standard.user.Tb_UserInfo;

public interface UserService {

	void weChatLogin(String code, HttpServletRequest request) throws Exception;

	void saveUserInfo(Tb_UserInfo userInfo);

}
