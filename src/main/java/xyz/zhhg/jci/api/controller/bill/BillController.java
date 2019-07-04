package xyz.zhhg.jci.api.controller.bill;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.zhhg.jci.api.model.BillForm;
import xyz.zhhg.jci.api.model.BillListFrom;
import xyz.zhhg.jci.exception.SessionOverDueException;
import xyz.zhhg.jci.model.standard.bill.Bill;
import xyz.zhhg.jci.model.standard.bill.BillDTO;
import xyz.zhhg.jci.model.standard.bill.statistics.StatisticsForm;
import xyz.zhhg.jci.model.standard.jsons.jsondata.JsonData;
import xyz.zhhg.jci.service.BillService;

@Controller
public class BillController {
	@Autowired
	BillService billService;
	
	@RequestMapping(value="/api/addBill",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData addBill(@RequestBody BillForm billFrom,HttpServletRequest request) {

		try {
			System.out.println(billFrom);
			Bill bill = new Bill(billFrom);
			billService.insertBill(request, bill);
		}catch(SessionOverDueException e) {
			JsonData.failure(-2, e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
	@RequestMapping(value="/api/delBill",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData delBill(@RequestBody Bill bill,HttpServletRequest request) {

		try {
			billService.deleteBill(request, bill);
		}catch(SessionOverDueException e) {
			JsonData.failure(-2, e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
	@RequestMapping(value="/api/updateBill",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData updateBill(@RequestBody BillForm form,HttpServletRequest request) {
		try {
			billService.updateBill(request, new Bill(form));
			return JsonData.success("");
		}catch(SessionOverDueException e) {
			return JsonData.failure(-2, e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
	}
	
	@RequestMapping(value="/api/getBillList",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData getBillList(@RequestBody BillListFrom form,HttpServletRequest request) {
		try {
			BillDTO dto=new BillDTO(form);
			System.out.println(dto);
			List<Bill> list=billService.getUserBillList(request, dto);
			List<BillForm> billForms=new ArrayList<BillForm>();
			for (Bill bill : list) {
				billForms.add(new BillForm(bill));
			}
			return JsonData.success(billForms);
		}catch(SessionOverDueException e) {
			return JsonData.failure(-2, e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
	}
	
	@RequestMapping(value="/api/getSumBill",produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData getSumBill(BillListFrom form,HttpServletRequest request) {
		try {
			BillDTO dto=new BillDTO(form);
			System.out.println(dto);
			return JsonData.success(billService.getSumMoney(request, dto));
		}catch(SessionOverDueException e) {
			return JsonData.failure(-2, e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
	}
	
	@RequestMapping(value="/api/getStatistics",produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData getStatistics(StatisticsForm form,HttpServletRequest request) {
		try {
			
			return JsonData.success(billService.getStatistics(request, form));
		}catch(SessionOverDueException e) {
			return JsonData.failure(-2, e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
	}

}
