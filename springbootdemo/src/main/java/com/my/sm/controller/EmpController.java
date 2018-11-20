package com.my.sm.controller;

import com.my.sm.entity.Emp;
import com.my.sm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * className:EmpController
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-09 16:19
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
	//依赖注入
	@Autowired
	private EmpService empService;

	@Value("${upload.path}")
	private String filePath;//D:/images/
	//资源加载
	private ResourceLoader resourceLoader;

	@Autowired
	public EmpController(ResourceLoader resourceLoader) {

		this.resourceLoader = resourceLoader;
	}

	/**
	 * 跳转雇员列表
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList(){
		return "emplist";
	}

	/**
	 * 跳转上传页面
	 * @return
	 */
	@RequestMapping("/toUpload")
	public String toUpload(){
		return "picupload";
	}

	/**
	 * 上传
	 * @param filePic
	 * @return
	 */
	/*@RequestMapping("/picUpload")
	public String picUpload(@RequestParam MultipartFile filePic) {

	}*/
	/*public String uploadFile(MultipartFile oldfile,String savePath){
		//获取源文件名称
		String originalFilename = oldfile.getOriginalFilename();
		//获取源文件后缀名称
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		//组装新名称
		String newFileName = UUID.randomUUID() + suffix;
		//创建文件
		File file = new File(savePath, newFileName);//D:/images/随机串.jpg
		try {
			//文件读写
			oldfile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}    
		return newFileName;
	}*/

	/**
	 * 展示
	 * @param fileName
	 * @return
	 */
	@RequestMapping("show")
	public ResponseEntity show(String fileName){
		try {
			// 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
			return ResponseEntity.ok(resourceLoader.getResource("file:" + filePath + fileName));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}




	/**
	 * 查询
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Object list(@RequestParam Map map){
		return empService.getList(map);
	}
	/**
	 * 添加
	 * @param emp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Object add(@RequestBody Emp emp){
		int i = empService.addEmp(emp);
		if(i>0){
			System.out.println("添加成功了");
		}else{
			System.out.println("添加失败了");
		}
		return i;
	}

	/**
	 * 删除
	 * @param empNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Object delete(@RequestBody Integer empNo){
		int i = empService.delete(empNo);
		if(i>0){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		return i;
	}

	/**
	 * 通过ID查询信息
	 * @param empNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getById")
	public Object getById(@RequestBody Integer empNo){
		List<Emp> list = empService.getListEmp(empNo);
		if(list!=null&&list.size()>0){
			System.out.println("查询到了");
		}else{
			System.out.println("没有查询到");
		}
		return list;
	}

	/**
	 * 修改
	 * @param emp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object update(@RequestBody Emp emp){
		int i = empService.update(emp);
		if(i>0){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		return i;
	}

	/**
	 * 跳转登录
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "Login";
	}

	/**
	 * 记录session
	 * @param map
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/userLogin")
	public Object userLogin(@RequestBody Map map, HttpSession session){
		String user = map.get("userName")+"";
		String passWord = map.get("passWord")+"";
		Map maps = new HashMap();
		if("admin".equals(user)&&"admin".equals(passWord)){
			session.setAttribute("user",user);
			maps.put("msg",0);
		}else{
			maps.put("msg",1);
		}
		return maps;
	}

	/**
	 * 调用存储过程，根据部门编号获取人员列表
	 * @param deptNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/proLlist")
	public Object getProListByDeptNo(Integer deptNo){
		return empService.getProListByDeptNo(deptNo);
	}

}
