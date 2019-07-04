package xyz.zhhg.jci.api.controller.type;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.zhhg.jci.api.model.InsertTypeListModel;
import xyz.zhhg.jci.model.standard.jsons.jsondata.JsonData;
import xyz.zhhg.jci.model.standard.type.AccountDetailType;
import xyz.zhhg.jci.model.standard.type.AccountTypes;
import xyz.zhhg.jci.service.TypeService;

@Controller
public class TypeController {
	
	@Autowired
	TypeService typeService;
	
	
	@RequestMapping(value="/api/getTypeList",produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData getTypeList(HttpServletRequest request) {
		
		try {
			System.out.println(JsonData.success(typeService.getUserType(request)).toString());
			return JsonData.success(typeService.getUserType(request));			
		}
		catch (Exception e) {
			return JsonData.failure(e.getMessage());
		}
	}
	
	@RequestMapping(value="/api/getAllTypeList",produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData getAllTypeList(HttpServletRequest request) {
		
		try {
			return JsonData.success(typeService.getUserAllType(request));			
		}
		catch (Exception e) {
			return JsonData.failure(e.getMessage());
		}
	}
	
	
	@RequestMapping(value="/api/insertTypes",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData insertTypes(@RequestBody InsertTypeListModel model,HttpServletRequest request) {
		try {
			typeService.insertATypeList(model,request);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
	@RequestMapping(value="/api/insertAType",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData insertAType(@RequestBody AccountTypes types,HttpServletRequest request) {
		try {
			typeService.insertAType(types,request);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
	
	@RequestMapping(value="/api/deleteAType",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData deleteAType(@RequestBody AccountTypes types,HttpServletRequest request) {
		try {
			typeService.deleteATypeById(request,types);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
	@RequestMapping(value="/api/updateAType",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData updateAType(@RequestBody AccountTypes types, HttpServletRequest request) {
		
		
		try {
			
			typeService.updateATypeById(request, types);
		}catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
	@RequestMapping(value="/api/insertDType",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData insertDType(@RequestBody AccountDetailType dType,HttpServletRequest request) {
		try {
			typeService.insertDTypeById(request,dType);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
	@RequestMapping(value="/api/deleteDType",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData deleteDType(int id,HttpServletRequest request) {
		try {
			typeService.deleteDTypeById(request,id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
	
	@RequestMapping(value="/api/updateDType",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData updateDType(HttpServletRequest request, @RequestBody AccountDetailType dType) {
		try {
			typeService.updateDTypeById(request,dType);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.failure(e.getMessage());
		}
		return JsonData.success("");
	}
	
}
