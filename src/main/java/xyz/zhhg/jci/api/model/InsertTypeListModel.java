package xyz.zhhg.jci.api.model;

import java.util.List;

import xyz.zhhg.jci.model.standard.type.AccountTypes;

public class InsertTypeListModel {
	private String type;
	private List<AccountTypes> typeList;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<AccountTypes> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<AccountTypes> typeList) {
		this.typeList = typeList;
	}
	@Override
	public String toString() {
		return "InsertTypeListModel [type=" + type + ", typeList=" + typeList + "]";
	}
	
	
	
}
