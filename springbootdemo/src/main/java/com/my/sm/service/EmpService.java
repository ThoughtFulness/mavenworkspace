package com.my.sm.service;

import com.my.sm.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-09 16:16
 */
public interface EmpService {
	/**
	 * 员工列表方法
	 * @param map
	 * @return
	 */
	List<Emp> getList(Map map);

	/**
	 * 调用存储过程，根据部门编号获取人员列表
	 * @param deptNo
	 * @return
	 */
	List<Emp> getProListByDeptNo(Integer deptNo);
	/**
	 * 添加
	 * @param emp
	 * @return
	 */
	int addEmp(Emp emp);
	/**
	 * 删除员工
	 * @param empNo
	 * @return
	 */
	int delete(Integer empNo);
	/**
	 * 通过ID查询员工信息
	 * @return
	 */
	List<Emp> getListEmp(Integer empNo);
	/**
	 * 修改
	 * @param emp
	 * @return
	 */
	int update(Emp emp);
}

