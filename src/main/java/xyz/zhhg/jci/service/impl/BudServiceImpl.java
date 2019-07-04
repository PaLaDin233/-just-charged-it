package xyz.zhhg.jci.service.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.zhhg.jci.dao.BudgetMapper;
import xyz.zhhg.jci.model.standard.budget.Budget;
import xyz.zhhg.jci.service.BudgetService;
import xyz.zhhg.jci.tools.SessionTools;

@Service
public class BudServiceImpl implements BudgetService{

	@Autowired
	BudgetMapper budgetMapper;
	
	@Override
	public boolean addBudget(HttpServletRequest request, Budget budget) throws Exception {
		String openid=SessionTools.getOpenId(request);
		budget.setOpenid(openid);
		if(budgetMapper.isBudgetIllegal(budget)) {//存在与表中日期段相交的字段
			throw new Exception("插入失敗");
		}else {			
			return budgetMapper.insertBudget(budget);
		}
	}

	@Override
	public boolean delBudget(HttpServletRequest request, Budget budget) throws Exception {
		String openid=SessionTools.getOpenId(request);
		budget.setOpenid(openid);
		if(!budgetMapper.deleteBudgetById(budget)) {
			throw new Exception("删除失败");
		}
		return true;
	}

	@Override
	public boolean updateBudget(HttpServletRequest request, Budget budget) throws Exception {
		String openid=SessionTools.getOpenId(request);
		budget.setOpenid(openid);
		if(!budgetMapper.updateBudget(budget)) {
			throw new Exception("删除失败");
		}
		
		return true;
	}

	@Override
	public List<Budget> getBudget(HttpServletRequest request, Budget budget) throws Exception {
		String openid=SessionTools.getOpenId(request);
		budget.setOpenid(openid);
		
		List<Budget> budgets=null;
		if(budget.getId()!=0||budget.getBegindate()==null||budget.getBegindate().equals("")) {
			budgets=budgetMapper.selectBudgetById(budget);
		}
		else {	
			budgets=budgetMapper.selectBudgetByOpenIdAndDate(budget);
		}
		if(budgets==null||budgets.size()==0) {
			throw new Exception("不存在满足条件的预算");
		}
		return budgets;
	}

}
