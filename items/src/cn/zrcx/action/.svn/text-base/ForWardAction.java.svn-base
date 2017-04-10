package cn.zrcx.action;

import java.awt.PageAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zrcx.action.form.EmployeeRoles;
import cn.zrcx.action.form.MybatisChoose;
import cn.zrcx.action.form.RoleAndMenu;
import cn.zrcx.action.form.UserDimForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.cutpage.RecordResult;
import cn.zrcx.dao.Employee_RoleDao;
import cn.zrcx.dao.RoleDao;
import cn.zrcx.entity.Employee;
import cn.zrcx.entity.Menu;
import cn.zrcx.entity.Role;
import cn.zrcx.service.Employee_RoleService;
import cn.zrcx.service.MenuService;
import cn.zrcx.service.RoleService;
import cn.zrcx.utils.JsonDateValueProcessor;

@Controller
@Scope("prototype")
@RequestMapping("/forward")
public class ForWardAction {
	@Resource
	private MenuService menuService;
	@Resource
	private RoleService roleService;
	@Resource
	private Employee_RoleService employee_RoleService;
	@RequestMapping("/forward_top.do")
	public String top()
	{
		return "top";
	}
	@RequestMapping("/forward_main.do")
	public String main()
	{
		return "main";
	}
	@RequestMapping("/forward_menu.do")
	public String menu(HttpServletRequest request,HttpSession httpSession)
	{
		Employee employee = (Employee) httpSession.getAttribute("employee");
		List<EmployeeRoles> rids = employee_RoleService.getRoles(employee.getE_id());
		/**
		 * set过滤重复的菜单id
		 * 
		 */
		Set<Integer> mids=new HashSet<Integer>(); 
			int num1 = rids.size();//role数量
			for(int i=0;i<num1;i++){
				List<RoleAndMenu> r_m = roleService.getRoleAndMenuInfoById(Integer.parseInt(rids.get(i).getR_id()));
				for(int j=0;j<r_m.size();j++){
					int m_id = r_m.get(j).getMenu_id();
					mids.add(m_id);
				}
			}
			Iterator<Integer> its = mids.iterator();
	/*		for (Integer integer : mids) {
				System.out.print(integer.intValue()+"-");
			}*/
			
			//List<RoleAndMenu> r_m = roleService.getRoleAndMenuInfoById(r_id);
			int num = mids.size();
			int[] arry = new int[num];
			/*for(int i=0;i<num;i++){
				
			arry[i]=r_m.get(i).getMenu_id();
			}*/
			/**
			 * set不能放入数组中，通过放入list中然后放入arry
			 */
			List<Integer> ll = new ArrayList<Integer>();
			while(its.hasNext()){
				ll.add(its.next());
			}
			/**
			 * 放入arry中
			 */
			for(int i=0;i<ll.size();i++){
				arry[i]=ll.get(i);
			}
/*			
			for(int i = 0;i<arry.length;i++){
				System.out.print(arry[i]);
			}*/
			
			MybatisChoose choose = new MybatisChoose();
			choose.setArry(arry);
			List<Menu> menu = menuService.getListOfMenus(choose);
			if(request.getAttribute("menus") != null)
				request.removeAttribute("menus");
			request.setAttribute("menus", menu);
		
		
		//	List<Menu> menus = menuService.getListOfMenu();
		
		
		
		//menuService.getListOfMenus(list);
		
		
/*		if(request.getAttribute("menus") != null)
			request.removeAttribute("menus");
		request.setAttribute("menus", menus);*/
		return "menu";
	}
	
	@RequestMapping("/forward_role.do")
	public String role(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		//List<Role> roles = roleService.getAllRoles();	
		//request.setAttribute("roles", roles);
		
/*		int currentPage = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		
		PageView<Role> pageView = new PageView<Role>(currentPage, pageSize);
		List<Role> records= roleService.queryRoles(pageView);
		
		RecordResult<Role> recordResult = new RecordResult<Role>();
		recordResult.setRecords(records);*/
		
//		int totalRecord = roleService.queryToltleSize();
		//recordResult.setTotalRecord(totalRecord);

/*	    JsonConfig jsonConfig = new JsonConfig();
	    jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor()); 
		JSONArray jsonArray=JSONArray.fromObject(recordResult.getRecords(),jsonConfig);
		
		response.getWriter().println("{\"total\":"+recordResult.getTotalRecord()+",\"rows\":"+jsonArray.toString()+"}");*/
		return "role";
	}
	@RequestMapping("/forward_query_roles.do")
	public void queryRoles(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));

		PageView<Role> pageView = new PageView<Role>(currentPage, pageSize);
		List<Role> records= roleService.queryRoles(pageView);
		RecordResult<Role> recordResult = new RecordResult<Role>();
		recordResult.setRecords(records);
		
		
		//总记录数
		int totalRecord = roleService.queryToltleSize();
		recordResult.setTotalRecord(totalRecord);
		
	    JsonConfig jsonConfig = new JsonConfig();
	    jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor()); 
		JSONArray jsonArray=JSONArray.fromObject(recordResult.getRecords(),jsonConfig);
		
		response.getWriter().println("{\"total\":"+recordResult.getTotalRecord()+",\"rows\":"+jsonArray.toString()+"}");
		
		
	}
	@RequestMapping("/forward_role-add.do")
	public String addEmployee(HttpServletRequest request)
	{	
		
		List<Menu> menus = menuService.getListOfMenu();
		if(request.getAttribute("menus") != null)
			request.removeAttribute("menus");
		request.setAttribute("menus", menus);
		return "role-add";
	}
	
	@RequestMapping("/forward_user.do")
	public String user()
	{	
		
		
		
		return "user";
	}
	@RequestMapping("/forward_user-add.do")
	public String useradd(HttpServletRequest request){
		
		 List<Role> roles = roleService.getAllRoles();
		 request.setAttribute("roles", roles);
		return "user-add";
	}
	@RequestMapping("/forward_user-look.do")
	public String userlook(){
		
		return "user-look";
	}
	
	@RequestMapping("/forward_query_user.do")
	public void queryUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		

		UserDimForm userDimForm = new UserDimForm();
		int num = employee_RoleService.getTotleNum(userDimForm);

		//	limit ${currentSize},${pageSize
		PageView<Employee> pageView = new PageView<Employee>(currentPage, pageSize);


		List<Employee> employees = employee_RoleService.getEmployeeOrderLimit(pageView);
		int e_id=0;
		for(int i=0;i<employees.size();i++){
			e_id = employees.get(i).getE_id();
			String names="";
			List<EmployeeRoles> enames = employee_RoleService.getRoles(e_id);
			for(int j=0;j<enames.size();j++){
				names += enames.get(j).getR_name();
				if(j !=enames.size()-1){
					names+=",";
				}
			}
			if(names!=null&&names.length()!=0){
				employees.get(i).setAllRole(names);
			}

		}
		
		RecordResult<Employee> recordResult = new RecordResult<Employee>();
		recordResult.setRecords(employees);
		recordResult.setTotalRecord(num);
		

	    JsonConfig jsonConfig = new JsonConfig();
	    jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor()); 
		JSONArray jsonArray=JSONArray.fromObject(recordResult.getRecords(),jsonConfig);
		
		response.getWriter().println("{\"total\":"+recordResult.getTotalRecord()+",\"rows\":"+jsonArray.toString()+"}");
	}
	
}
