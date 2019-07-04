package xyz.zhhg.jci.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.zhhg.jci.api.model.InsertTypeListModel;
import xyz.zhhg.jci.dao.TypeMapper;
import xyz.zhhg.jci.exception.ColumnExistException;
import xyz.zhhg.jci.model.standard.type.AccountDetailType;
import xyz.zhhg.jci.model.standard.type.AccountTypes;
import xyz.zhhg.jci.service.TypeService;
import xyz.zhhg.jci.tools.SessionTools;

@Service
@Transactional(rollbackFor=Exception.class)
public class TypeServiceImpl implements TypeService{

	@Autowired
	TypeMapper typeMapper;
	
	@Override
	public List<AccountTypes> getUserType(HttpServletRequest request)throws Exception {
		//从session中获取用户openid
		String openid=SessionTools.getOpenId(request);
		
		//从request中获取用户查询的分类类型，支出？收入？
		String type=request.getParameter("type");
		
		System.out.println("openId:"+openid+" type"+type);
		//调用mapper层获取用户拥有的指定账目类型
		List<AccountTypes> lists= typeMapper.getUsersAllExpendType(openid, type);
		
		
		return lists;
	}
	
	@Override
	public List<List<AccountTypes>> getUserAllType(HttpServletRequest request) throws Exception {
		String openid=SessionTools.getOpenId(request);
		
		List<List<AccountTypes>> res=new ArrayList<>();
		 
		res.add(typeMapper.getUsersAllExpendType(openid, "0"));
		res.add(typeMapper.getUsersAllExpendType(openid, "1"));
		
		return res;
		
		
	}

	@Override
	public void insertAType(AccountTypes types, HttpServletRequest request) throws Exception {
		String openid=SessionTools.getOpenId(request);
		
		types.setOpenid(openid);
		
		if(!typeMapper.insertAType(types)) {
			throw new Exception("插入失败");
		}else {
			//获取插入的大类id
			int id=typeMapper.getATypeIdByNameAndOpenIdAndType(types);
			typeMapper.insertDType("", id, openid);
		}
		
	}
	
	public void insertATypeList(InsertTypeListModel model, HttpServletRequest request)throws Exception {
		//从request中获取用户openid
		String openid=SessionTools.getOpenId(request);
		
		//获取收支类型
		String type=model.getType();
		
		//获取分类列表
		List<AccountTypes> list=model.getTypeList();
		
		//遍历分类列表
		for (AccountTypes types : list) {
			//设置列表中项的openid
			types.setOpenid(openid);
			
			//设置列表中项的收支类型
			types.setType(type);
			
			System.out.println(types);
			
			//尝试插入该项，失败的情况，表中已存在该用户的该分类
			if(!typeMapper.insertAType(types)) {
				//插入失败，进行更新
				int id=typeMapper.getATypeIdByNameAndOpenIdAndType(types);
				types.setId(id);
				typeMapper.updateAtype(types);
			}else {
				//插入成功，重新设置大类id
				int id=typeMapper.getATypeIdByNameAndOpenIdAndType(types);
				types.setId(id);				
				//插入大类下默认细类
				typeMapper.insertDType("", id, openid);
				
			}
			
			//遍历该大类下的子类
			for (AccountDetailType dtype : types.getList()) {
				//设置子类的大类id
				if(dtype.getTypeid()==0) dtype.setTypeid(types.getId());
				System.out.println(dtype);
				//尝试插入子类，失败的情况，表中存在该大类的子类
				if(!typeMapper.insertDType(dtype.getName(),dtype.getTypeid(),openid)) {
					//插入失败,更新子类
					typeMapper.updateDtype(dtype.getId(), dtype.getName(), types.getId(), openid);;
				}

			}
		}
		
		
	}


	public void updateATypeById(HttpServletRequest request, AccountTypes types) throws Exception {
		//获取openid
		String openid=SessionTools.getOpenId(request);
		
		//设置openid
		types.setOpenid(openid);
		
		//更新用户Atype
		if(!typeMapper.updateAtype(types)) {
			throw new ColumnExistException("已存在同名列，更新失败~");
		}
	}

	@Override
	public void deleteATypeById(HttpServletRequest request, AccountTypes types) throws Exception {
		//获取openid
		String openid=SessionTools.getOpenId(request);
		
		//设置openid
		types.setOpenid(openid);
		
		//删除指定AType
		if(!typeMapper.deleteAtypeById(types)) {
			//TODO 用户使用的是默认类型时进行的删除操作
			throw new Exception("真遗憾,删除失败了~");
		}	
	}



	@Override
	public void insertDTypeById(HttpServletRequest request, AccountDetailType dType) throws Exception {
		String openid=SessionTools.getOpenId(request);
		
		if(!typeMapper.insertDType(dType.getName(),dType.getTypeid(),openid)) {
			throw new Exception("插入失败,存在同名项或非法操作");
		}
		
		
	}



	@Override
	public void deleteDTypeById(HttpServletRequest request, int id) throws Exception {
		String openid=SessionTools.getOpenId(request);
		
		if(!typeMapper.deleteDtypeById(id, openid)) {
			throw new Exception("删除失败，无效类型");
		}
		
	}



	@Override
	public void updateDTypeById(HttpServletRequest request, AccountDetailType dType) throws Exception {
		String openid=SessionTools.getOpenId(request);
		String t=request.getParameter("typeid");
		if(t!=null) {
			dType.setTypeid(Integer.parseInt(t));
		}
		
		if(!typeMapper.updateDtype(dType.getId(), dType.getName(), dType.getTypeid(), openid)) {
			throw new Exception("更新失败");
		}
		
		
	}



	




	
	

}
