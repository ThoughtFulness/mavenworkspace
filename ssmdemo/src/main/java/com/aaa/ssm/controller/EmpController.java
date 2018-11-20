package com.aaa.ssm.controller;

import com.aaa.ssm.service.EmpService;
import com.aaa.ssm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * className:EmpController
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-07 15:51:36
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

	//依赖注入
	@Autowired
	private EmpService empService;

	/**
	 * 雇佣列表
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam Map map, Model model, HttpServletRequest request){
		map.put("pageSize",5);
		int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
		String stringPage = new PageUtil(pageNo, 5, empService.getPageCount(map),request).getStringPage();
		model.addAttribute("stringPage",stringPage);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("sel",map.get("sel"));
		model.addAttribute("empList",empService.getPage(map));
		return "/emp/list";
	}

	/**
	 * 新增页面
	 * @return
	 */
	@RequestMapping("/ToAdd")
	public String addTo(){
		return "emp/add";
	}

	/**
	 * 新增
	 * @return
	 */
	@RequestMapping("/addEmp")
	public String AddEmp(@RequestParam Map map){
		int result = empService.AddEmp(map);
		if(result>0){
			return "redirect:list.do";
		}else{
			return "redirect:ToAdd.do";
		}
	}

	/**
	 * 删除
	 * @param empNo
	 * @return
	 */
	@RequestMapping("/deleteEmp")
	public Object DeleteEmp(@RequestParam Integer empNo,Integer pageNo){
		int result = empService.delete(empNo);
		if(result>0){
			//删除后留在本页面
			return "redirect:list.do?pageNo="+pageNo;
		}else{
			return "redirect:list.do";
		}

	}

	/**
	 * 通过ID查询员工信息
	 * @param empNo
	 * @return
	 */
	@RequestMapping("/getById")
	public Object queryEmpId(@RequestParam Integer empNo,Model model,Integer pageNo){
		if(empNo!=null){
			List<Map> list = empService.getListEmp(empNo);
			if(list!=null&&list.size()>0){
				model.addAttribute("emp",list.get(0));
				model.addAttribute("pageNo",pageNo);
				return "emp/Update";
			}
		}
		return null;
	}

	/**
	 * 修改员工
	 * @param map
	 * @return
	 */
	@RequestMapping("/updateEmp")
	public Object UpdateEmp(@RequestParam Map map){
		int result = empService.update(map);
		if(result>0){
			//修改后留在本页面
			return "redirect:list.do?pageNo="+map.get("pageNo");
		}
		return null;
	}
}
