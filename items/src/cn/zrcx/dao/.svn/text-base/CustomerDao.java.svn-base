package cn.zrcx.dao;

import java.util.List;

import cn.zrcx.cutpage.RecordResult;
import cn.zrcx.entity.CompanyNameJson;
import cn.zrcx.entity.Customer;

public interface CustomerDao {
	/**
	 * 添加
	 * @param customer
	 */
	public void save(Customer customer);
	/**
	 * 修改
	 * @param customer
	 */
	public void update(Customer customer);
	/**
	 * 删除
	 * @param customer
	 */
	public void delete(Customer customer);
	/**
	 * 通过id得到customer
	 */
	public Customer getCustomer(Customer customer);
	/**
	 * 分页查询所有排序customer
	 * @param customer
	 * @return
	 */
	public List<Customer> getCustomers(Customer customer);
	
	/**
	 * 分页查询所有customer
	 * @param customer
	 * @return
	 */
	public List<Customer> getCustomersOrder(Customer customer);
	
	/**
	 * 检查customer
	 * @param customer
	 * @return
	 */
	public String checkC_companyname(Customer customer);
	
	/**
	 * 获得总条数
	 * @return
	 */
	public int getTotalRecord();
	/**
	 * 通过关键字分页查询
	 * @param customer
	 * @return
	 */
	public List<Customer> getCustomerByLike(Customer customer);
	
	/**
	 * 通过关键字查询总条数
	 * @param customer
	 * @return
	 */
	public int getTotalRecord(Customer customer);
	
	/**
	 * 获取所有的公司名字和联系人
	 * @return List<CompanyNameJson>
	 */
	public List<CompanyNameJson> getCompanyNameJson();
}
