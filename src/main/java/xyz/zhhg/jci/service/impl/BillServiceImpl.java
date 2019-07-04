package xyz.zhhg.jci.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.zhhg.jci.dao.BillMapper;
import xyz.zhhg.jci.model.standard.bill.Bill;
import xyz.zhhg.jci.model.standard.bill.BillDTO;
import xyz.zhhg.jci.model.standard.bill.statistics.Statistics;
import xyz.zhhg.jci.model.standard.bill.statistics.StatisticsForm;
import xyz.zhhg.jci.service.BillService;
import xyz.zhhg.jci.tools.SessionTools;

@Service
@Transactional(rollbackFor=Exception.class)
public class BillServiceImpl implements BillService{

	@Autowired
	BillMapper billMapper;
	
	public void insertBill(HttpServletRequest request, Bill bill) throws Exception {
		//获取openid
		String openid=SessionTools.getOpenId(request);
		
		//添加进bill
		bill.setOpenid(openid);
		
		//调用mapper
		billMapper.insertNewBill(bill);

	}

	@Override
	public void deleteBill(HttpServletRequest request, Bill bill) throws Exception {
		//获取openid
		String openid=SessionTools.getOpenId(request);
		
		//添加进bill
		bill.setOpenid(openid);
		
		//调用mapper
		billMapper.deleteBillById(bill);
		
	}

	@Override
	public void updateBill(HttpServletRequest request, Bill bill) throws Exception {
		//获取openid
		String openid=SessionTools.getOpenId(request);
		
		//添加进bill
		bill.setOpenid(openid);
		
		//调用mapper
		billMapper.updateBillById(bill);
		
	}

	@Override
	public List<Bill> getUserBillList(HttpServletRequest request, BillDTO dto) throws Exception {
		//获取openid
		String openid=SessionTools.getOpenId(request);
		
		//添加进dto
		dto.setOpenid(openid);
		
		//调用下一层
		return billMapper.selectUserBill(dto);
		
		
	}
	
	public List<Statistics> getSumMoney(HttpServletRequest request, BillDTO dto) throws Exception {
		//获取openid
		String openid=SessionTools.getOpenId(request);
		
		//添加进dto
		dto.setOpenid(openid);
		
		//调用下一层
		return billMapper.getSumMoneyFromBeginDateToEndDate(dto);
		
	}

	@Override
	public List<Statistics> getStatistics(HttpServletRequest request, StatisticsForm form) throws Exception {
		String openid=SessionTools.getOpenId(request);
		
		form.setOpenid(openid);
		
		return billMapper.getStatistics(form);
	}
	
	
	
	

}
