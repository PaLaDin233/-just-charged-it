package xyz.zhhg.jci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.zhhg.jci.model.standard.type.AccountDetailType;
import xyz.zhhg.jci.model.standard.type.AccountTypes;

public interface TypeMapper {
	public void initUserTypeList(String openid);
	
	public List<AccountTypes> getUsersAllExpendType(String openid,String type);
	
	public boolean insertAType(AccountTypes types);
	
	public int getATypeIdByNameAndOpenIdAndType(AccountTypes types);
	
	public boolean insertDType(@Param("name")String name, @Param("typeid")int typeid, @Param("openid")String openid);
	
	public int getDTypeIdByTypeIdAndName(AccountDetailType detailType);
	
	public boolean deleteAtypeByopenId(String openid);
	
	public boolean deleteAtypeById(AccountTypes types);
	
	public boolean deleteDtypeById(@Param("id")int i ,@Param("openid")String openid);
	
	public boolean updateAtype(AccountTypes types);

	public boolean updateDtype(@Param("id")int i, @Param("name")String name, @Param("typeid")int typeid, @Param("openid")String openid);

	
}
