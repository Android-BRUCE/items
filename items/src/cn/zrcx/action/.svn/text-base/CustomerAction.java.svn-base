package cn.zrcx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zrcx.action.form.CustomerForm;
import cn.zrcx.cutpage.RecordResult;
import cn.zrcx.entity.Customer;
import cn.zrcx.service.CustomerService;
import cn.zrcx.utils.JsonDateValueProcessor;

@Controller
@Scope("prototype")
@RequestMapping("/customer")
public class CustomerAction {
	
	@Resource
	private CustomerService customerService;
	
	private CustomerForm customerForm;
	
	/**
	 * 实现customer的添加
	 * @param cf
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/customerAction_add.action")
	public String add(CustomerForm cf,HttpServletResponse response) throws IOException{
		
		Customer customer=new Customer(cf.getC_companyname(),cf.getC_linkman(),new Date(),cf.getC_address(),cf.getC_phone(),cf.getC_mobilephone(),cf.getC_intro(),cf.getC_comment());
		customerService.save(customer);
		System.out.println("!!!!!!!!!!!!!!!!!");
		
		response.getWriter().println("{\"message\":\"添加成功\"}");
		
		return "forward:/cus/customer.jsp";
	}
	/**
	 * 实现customer的修改
	 * @param cf
	 * @return
	 */
	@RequestMapping("/customerAction_update.action")
	public String update(CustomerForm cf){
		
		Customer customer=new Customer(cf.getC_companyname(),cf.getC_linkman(),cf.getC_address(),cf.getC_phone(),cf.getC_mobilephone(),cf.getC_intro(),cf.getC_comment(),new Date());
		customerService.update(customer);
		return "forward:/cus/customer.jsp";
		
	}
	
	/**
	 * 实现customer的删除
	 * @param c_ids
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/customerAction_delete.action")
	@ResponseBody
	public void delete(String c_ids,HttpServletResponse response) throws IOException{
		System.out.println(c_ids);
		Customer customer = new Customer();
		String[] idds=c_ids.split(",");
		Integer[] idss=new Integer[idds.length];
		for(int i=0;i<idds.length;i++){
			idss[i]=Integer.parseInt(idds[i]);
			customer.setC_id(idss[i]);
			customerService.delete(customer);
		}
		
		
		
		response.getWriter().print("{\"message\":\"已删除\"}");
		
	}
	
	/**
	 * 获得customer详情
	 * @param c_id
	 * @return
	 */
	@RequestMapping("/customerAction_getCustomer.action")
	
	public String getCustomer(@RequestParam("c_id") int c_id,HttpServletResponse response) throws IOException{
		System.out.println(c_id);
		Customer cu=new Customer();
		cu.setC_id(c_id);
		System.out.println("cccccccccccccccc");
		Customer customer=customerService.getCustomer(cu);
		response.getWriter().print(customer);
		
		return "forward:/cus/customer-edit.jsp";
	}
	

	
	/**
	 * 查询该公司名是否已被占用
	 * @param cf
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/customerAction_checkC_companyname.action")
	public void checkC_companyname(CustomerForm cf,HttpServletResponse response) throws IOException{
		Customer customer=new Customer(cf.getC_companyname());
		System.out.println(cf.getC_companyname());
		String companyname=customerService.checkC_companyname(customer);
		System.out.println("++++++++++");
		System.out.println(companyname);
		
		if(companyname==null){
			response.getWriter().println("{\"message\":\"该公司已经注册\",\"color\":\"error\"}");
			
		}else{
			response.getWriter().println("{\"message\":\"该公司可以注册\",\"color\":\"success\"}");
			
		}
		
		
		
	}
	
	/**
	 * 分页遍历customer
	 * @param page
	 * @param rows
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/customerAction_getCustomers.action")
	@ResponseBody
	public void getCustomers(int page,int rows,String order,HttpServletResponse response) throws IOException
	{
		List<Customer> customerList;
		Customer customer=new Customer();
		customer.setFirstResult((page-1)*page);
		customer.setMaxResult(rows);
		int totalRecord=customerService.getTotalRecord();
		
		if(order==null){
			customerList=customerService.getCustomers(customer);
			
		}else{
			customer.setOrder(order);
			customerList=customerService.getCustomersOrder(customer);
			}
			
			
			RecordResult<Customer> recordResult=new RecordResult<Customer>();
			recordResult.setRecords(customerList);
			recordResult.setTotalRecord(totalRecord);
			JsonConfig jsonConfig = new JsonConfig();
		    jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor()); 
			JSONArray jsonArray=JSONArray.fromObject(recordResult.getRecords(),jsonConfig);
			response.getWriter().println("{\"total\":"+recordResult.getTotalRecord()+",\"rows\":"+jsonArray.toString()+"}");
	}
	
	@RequestMapping("/customerAction_getCustomerByLike.action")
	@ResponseBody
	public void getCustomerByLike(int page,int rows,String order,String like,HttpServletResponse response) throws IOException{
		
		Customer customer = new Customer();
		customer.setOrder(order);
		customer.setMaxResult(rows);
		if(!like.equals(null)){
		customer.setFirstResult((page-1)*page);
		int totalRecord=customerService.getTotalRecord(customer);
		List<Customer> customerList=customerService.getCustomerByLike(customer);
		RecordResult<Customer> recordResult=new RecordResult<Customer>();
		recordResult.setRecords(customerList);
		recordResult.setTotalRecord(totalRecord);
		JsonConfig jsonConfig = new JsonConfig();
	    jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor()); 
		JSONArray jsonArray=JSONArray.fromObject(recordResult.getRecords(),jsonConfig);
		response.getWriter().println("{\"total\":"+recordResult.getTotalRecord()+",\"rows\":"+jsonArray.toString()+"}");
		}else{
			this.getCustomers(page, rows, order, response);
			
		}
	}
}

