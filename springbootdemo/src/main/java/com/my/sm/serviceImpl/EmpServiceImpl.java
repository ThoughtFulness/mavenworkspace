package com.my.sm.serviceImpl;

import com.my.sm.dao.EmpDao;
import com.my.sm.entity.Emp;
import com.my.sm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-09 16:17
 */
@Transactional
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao empDao;


	/**
	 * 员工列表方法
	 * @param map
	 * @return
	 */
	@Override
	public List<Emp> getList(Map map) {
		map.put("sort",map.get("sort")==null?"empno":map.get("sort"));
		map.put("order",map.get("order")==null?"asc":map.get("order"));
		return empDao.getList(map);
	}

	/**
	 * 添加
	 * @param emp
	 * @return
	 */
	@Override
	public int addEmp(Emp emp) {
		return empDao.addEmp(emp);
	}

	/**
	 * 删除
	 * @param empNo
	 * @return
	 */
	@Override
	public int delete(Integer empNo) {
		return empDao.delete(empNo);
	}

	/**
	 * 通过ID查询信息
	 * @param empNo
	 * @return
	 */
	@Override
	public List<Emp> getListEmp(Integer empNo) {
		return empDao.getListEmp(empNo);
	}

	/**
	 * 修改
	 * @param emp
	 * @return
	 */
	@Override
	public int update(Emp emp) {

		return empDao.update(emp);
	}

	/**
	 * 调用存储过程，根据部门编号获取人员列表
	 * @param deptNo
	 * @return
	 */
	@Override
	public List<Emp> getProListByDeptNo(Integer deptNo) {
		Map map = new HashMap();
		map.put("deptNo",deptNo);
		//调用了根据存储过程获取列表方法之后
		empDao.getProListByDeptNo(map);
		//调用返回结果
		List<Emp> csrEmp = (List<Emp>) map.get("csrEmp");
		return csrEmp;
	}
}
