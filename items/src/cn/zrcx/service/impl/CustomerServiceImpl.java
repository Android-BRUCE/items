package cn.zrcx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zrcx.cutpage.RecordResult;
import cn.zrcx.dao.CustomerDao;
import cn.zrcx.entity.CompanyNameJson;
import cn.zrcx.entity.Customer;
import cn.zrcx.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	

	@Resource
	private CustomerDao customerDao;
	
	
	public void save(Customer customer) {
		customerDao.save(customer);
		
	}

	
	public void update(Customer customer) {

		customerDao.update(customer);
	}

	
	public void delete(Customer customer) {
		
		customerDao.delete(customer);
		
	}

	
	public Customer getCustomer(Customer customer) {

		return customerDao.getCustomer(customer);
	}

	
	public List<Customer> getCustomers(Customer customer) {
		
		return customerDao.getCustomers(customer);
	}


	
	public String checkC_companyname(Customer customer) {

		return customerDao.checkC_companyname(customer);
	}


	
	public int getTotalRecord() {
		
		return customerDao.getTotalRecord();
	}


	
	public List<Customer> getCustomerByLike(Customer customer) {
		
		return customerDao.getCustomerByLike(customer);
	}


	
	public int getTotalRecord(Customer customer) {

		return customerDao.getTotalRecord(customer);
	}


	
	public List<Customer> getCustomersOrder(Customer customer) {

		return customerDao.getCustomersOrder(customer);
	}


	@Override
	public List<CompanyNameJson> getCompanyNameJson() {
		// TODO Auto-generated method stub
		return customerDao.getCompanyNameJson();
	}
	
	

}
