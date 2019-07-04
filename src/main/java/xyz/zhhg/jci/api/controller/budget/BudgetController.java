package xyz.zhhg.jci.api.controller.budget;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.zhhg.jci.model.standard.budget.Budget;
import xyz.zhhg.jci.model.standard.jsons.jsondata.JsonData;
import xyz.zhhg.jci.service.BudgetService;

@Controller
@RequestMapping("/api/budget")
public class BudgetController {

	@Autowired
	BudgetService budgetService;
	
	
	@RequestMapping(value="/add" ,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData addBudget(HttpServletRequest request,Budget budget) { 
		try {
			budgetService.addBudget(request, budget);
		}catch (Exception e) {
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success(budget);
	}
	
	@RequestMapping(value="/del" ,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData delBudget(HttpServletRequest request,Budget budget) {
		try {
			budgetService.delBudget(request, budget);
		}catch (Exception e) {
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
	@RequestMapping(value="/update" ,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData updateBudget(HttpServletRequest request,Budget budget) {
		try {
			budgetService.updateBudget(request, budget);
		}catch (Exception e) {
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
	@RequestMapping(value="/get" ,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData getBudget(HttpServletRequest request,Budget budget) {
		try {
			List<Budget> res=budgetService.getBudget(request, budget);
			return JsonData.success(res);
		}catch (Exception e) {
			return JsonData.failure(e.getMessage());
		}
	}
	
}
