package xyz.zhhg.jci.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import xyz.zhhg.jci.model.standard.budget.Budget;

 
 

public interface BudgetService {
	public boolean addBudget(HttpServletRequest request,Budget budget) throws Exception;
	
	public boolean delBudget(HttpServletRequest request,Budget budget)throws Exception;
	
	public boolean updateBudget(HttpServletRequest request,Budget budget)throws Exception;
	
	/**
	 * 
	 * @param request
	 * @param budget
	 * @return
	 */
	public List<Budget> getBudget(HttpServletRequest request,Budget budget)throws Exception;
	
}
