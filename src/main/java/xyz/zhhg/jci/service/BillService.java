package xyz.zhhg.jci.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import xyz.zhhg.jci.model.standard.bill.Bill;
import xyz.zhhg.jci.model.standard.bill.BillDTO;
import xyz.zhhg.jci.model.standard.bill.statistics.Statistics;
import xyz.zhhg.jci.model.standard.bill.statistics.StatisticsForm;

public interface BillService {
	public void insertBill(HttpServletRequest request,Bill bill) throws Exception;
	
	public void deleteBill(HttpServletRequest request,Bill bill) throws Exception;
	
	public void updateBill(HttpServletRequest request,Bill bill) throws Exception;
	
	public List<Bill> getUserBillList(HttpServletRequest request,BillDTO dto)throws Exception;
	
	public List<Statistics> getSumMoney(HttpServletRequest request, BillDTO dto) throws Exception;
	
	public List<Statistics> getStatistics(HttpServletRequest request, StatisticsForm form) throws Exception;
}
