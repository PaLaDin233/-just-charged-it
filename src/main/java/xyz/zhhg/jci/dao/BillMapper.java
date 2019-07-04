package xyz.zhhg.jci.dao;

import java.util.List;


import xyz.zhhg.jci.model.standard.bill.Bill;
import xyz.zhhg.jci.model.standard.bill.BillDTO;
import xyz.zhhg.jci.model.standard.bill.statistics.Statistics;
import xyz.zhhg.jci.model.standard.bill.statistics.StatisticsForm;

public interface BillMapper {
	public int insertNewBill(Bill bill);
	
	public boolean deleteBillById(Bill bill);
	
	public boolean updateBillById(Bill bill);
	
	public List<Bill> selectUserBill(BillDTO dto);
	
	/**
	 * 获取指定时间段的所有指定类型之和
	 * @param dto
	 * @return
	 */
	public List<Statistics> getSumMoneyFromBeginDateToEndDate(BillDTO dto);
	
	/**
	 * 统计相关
	 */
	
	public List<Statistics> getStatistics(StatisticsForm form);
}
