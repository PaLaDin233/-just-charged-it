package xyz.zhhg.jci.dao;

import java.util.List;

import xyz.zhhg.jci.model.standard.budget.Budget;

/**
 * 预算mapper
 * @author 清居
 *
 */
public interface BudgetMapper {
	/**
	 * 插入一条预算记录
	 * @param budget
	 * @return
	 */
	public boolean insertBudget(Budget budget);
	

	public boolean deleteBudgetById(Budget budget);
	
	public boolean updateBudget(Budget budget);
	
	/**
	 * 获取用户指定日期段内的预算列表
	 * @param budget
	 * @return
	 */
	public List<Budget> selectBudgetByOpenIdAndDate(Budget budget);
	
	
	/**
	 * 获取指定id的预算，不指定id返回当前日期的预算
	 * @param budget
	 * @return
	 */
	public List<Budget> selectBudgetById(Budget budget);
	
	public boolean isBudgetIllegal(Budget budget);
	
	
	

}
