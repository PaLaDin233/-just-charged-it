package xyz.zhhg.jci.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import xyz.zhhg.jci.api.model.InsertTypeListModel;
import xyz.zhhg.jci.model.standard.jsons.jsondata.JsonData;
import xyz.zhhg.jci.model.standard.type.AccountDetailType;
import xyz.zhhg.jci.model.standard.type.AccountTypes;

public interface TypeService {
	/**
	 * 获取用户的类型列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<AccountTypes> getUserType(HttpServletRequest request) throws Exception;
	
	
	/**
	 * 插入指定类型列表 
	 * @param model
	 * @param request
	 * @throws Exception
	 */
	public void insertATypeList(InsertTypeListModel model, HttpServletRequest request) throws Exception;
	

	/**
	 * 插入一条大类
	 * @param types
	 * @param request
	 * @throws Exception
	 */
	public void insertAType(AccountTypes types, HttpServletRequest request) throws Exception;
	/**
	 * 修改指定大类型-重命名
	 * @param request
	 * @param types
	 * @throws Exception
	 */
	public void updateATypeById(HttpServletRequest request,AccountTypes types) throws Exception;
	
	/**
	 * 删除指定大类型
	 * @param request
	 * @param types
	 * @throws Exception
	 */
	public void deleteATypeById(HttpServletRequest request,AccountTypes types) throws Exception;
	
	/**
	 * 新增一条细类
	 * @param request
	 * @param dType
	 * @throws Exception
	 */
	public void insertDTypeById(HttpServletRequest request,AccountDetailType dType) throws Exception;
	
	
	/**
	 * 删除一条细类
	 * @param request
	 * @param dType
	 * @throws Exception
	 */
	public void deleteDTypeById(HttpServletRequest request,int id) throws Exception;
	
	
	/**
	 * 修改一条细类
	 * @param request
	 * @param dType
	 * @throws Exception
	 */
	public void updateDTypeById(HttpServletRequest request,AccountDetailType dType) throws Exception;


	public List<List<AccountTypes>> getUserAllType(HttpServletRequest request) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
}
