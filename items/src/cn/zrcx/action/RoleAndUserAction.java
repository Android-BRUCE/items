package cn.zrcx.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zrcx.action.form.EmployeeAndRole;
import cn.zrcx.action.form.EmployeeRoles;
import cn.zrcx.action.form.MybatisChoose;
import cn.zrcx.action.form.RoleAddInfo;
import cn.zrcx.action.form.RoleAndMenu;
import cn.zrcx.action.form.RoleDimForm;
import cn.zrcx.action.form.UserDimForm;
import cn.zrcx.action.form.employeeForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.cutpage.RecordResult;
import cn.zrcx.dao.MenuDao;
import cn.zrcx.dao.RoleDao;
import cn.zrcx.entity.Employee;
import cn.zrcx.entity.Menu;
import cn.zrcx.entity.Position;
import cn.zrcx.entity.Role;
import cn.zrcx.service.Employee_RoleService;
import cn.zrcx.service.MenuService;
import cn.zrcx.service.PositionService;
import cn.zrcx.service.RoleService;
import cn.zrcx.utils.JsonDateValueProcessor;

@Controller
@Scope("prototype")
@RequestMapping("/role")
public class RoleAndUserAction {
	
	
	@Resource
	private RoleService roleService;
	@Resource
	private MenuService menuService;
	@Resource
	private Employee_RoleService employee_RoleService;
	/**
	 * 保存role信息和该role的menu信息
	 * @param roleAddInfo jsp返回的role信息,不含有拥有的mennu信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/role_add.do")
	public String addRole(RoleAddInfo roleAddInfo,HttpServletRequest request){
		//1,5,11,14,18,22
		String[] a1 = request.getParameterValues("1");
		String[] a2 = request.getParameterValues("5");
		String[] a3 = request.getParameterValues("14");
		String[] a4 = request.getParameterValues("18");
		String[] a5 = request.getParameterValues("22");
		String[] a6 = request.getParameterValues("11");
		
		List<String[]> list = new ArrayList<String[]>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
 		list.add(a4);
		list.add(a5);
		list.add(a6);
		roleService.addRole(roleAddInfo);
		int rid= roleAddInfo.getR_id();
		for(int i=0;i<list.size();i++){
			executeaddRoleAndMenu(rid,list.get(i));
		}
		return "redirect:/forward/forward_role.do";
	}
	public void executeaddRoleAndMenu(int rid,String[] s){
		RoleAndMenu andMenu;
		andMenu = new RoleAndMenu();
		if(s != null){
			for(int i=0;i<s.length;i++){
				andMenu.setMenu_id(Integer.parseInt(s[i]));
				andMenu.setR_id(rid);
				roleService.addTheOfRoleMenuCenter(andMenu);
			}
		}
	}
	@RequestMapping("/role_delete.do")
	public void deleteRole(@RequestParam("r_id") int r_id,HttpServletResponse response) throws IOException{
		///items/role/role_delete.do
		roleService.deleteRoleAndMenuFrom(r_id);
		roleService.deleteRole(r_id);
		//ServletActionContext.getResponse().getWriter().println("{\"message\":\"删除成功\"}");
		response.getWriter().println("{\"message\":\"删除成功\"}");
	}
	///items/role/role_edit.do
	/**
	 * 跳转到修改页面
	 * @param r_id
	 * @param request
	 * @return
	 */
	@RequestMapping("/role_edit.do")
	public String roleedit(@RequestParam("r_id") int r_id,HttpServletRequest request){
		/**获取当前角色的menu
		 * List<RoleAndMenu> r_m = roleService.getRoleAndMenuInfoById(r_id);
		 * int num = r_m.size();
		int[] arry = new int[num];
		for(int i=0;i<num;i++){
			arry[i]=r_m.get(i).getMenu_id();
		}
		MybatisChoose choose = new MybatisChoose();
		choose.setArry(arry);
		List<Menu> menu = menuService.getListOfMenus(choose);**/
		
		//所有的menu信息
		List<Menu> menu = menuService.getListOfMenu();
		if(request.getAttribute("menus") != null)
			request.removeAttribute("menu");
		request.setAttribute("menu", menu);
		
		//角色信息
		Role roleInfo = roleService.getRoleInfoById(r_id);
		request.setAttribute("roleInfo", roleInfo);		
		//request.setAttribute("menu", menu);
		return "role-edit";
	}
	/**
	 * 修改role
	 * @return
	 */
	@RequestMapping("/role_editsave.do")
	public String roleeditsave(RoleAddInfo roleAddInfo,HttpServletRequest request){
		
		//修改role信息
		roleService.saveEditRole(roleAddInfo);
		//删除r_menu中信息
		roleService.deleteRoleAndMenuFrom(roleAddInfo.getR_id());
		
		//添加r_menu中信息
		String[] a1 = request.getParameterValues("1");
		String[] a2 = request.getParameterValues("5");
		String[] a3 = request.getParameterValues("14");
		String[] a4 = request.getParameterValues("18");
		String[] a5 = request.getParameterValues("22");
		String[] a6 = request.getParameterValues("11");
		List<String[]> list = new ArrayList<String[]>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		list.add(a6);
		int rid= roleAddInfo.getR_id();
		for(int i=0;i<list.size();i++){
			executeaddRoleAndMenu(rid,list.get(i));
		}
		return "redirect:/forward/forward_role.do";
	}
	/**
	 * 查看role所有信息
	 * @param r_id
	 * @param request
	 * @return
	 * /items/role/role_look.do
	 */
	@RequestMapping("/role_look.do")
	public String rolelook(@RequestParam("r_id") int r_id,HttpServletRequest request){
		/**获取当前角色的menu**/
		List<RoleAndMenu> r_m = roleService.getRoleAndMenuInfoById(r_id);
		int num = r_m.size();
		int[] arry = new int[num];
		for(int i=0;i<num;i++){
			arry[i]=r_m.get(i).getMenu_id();
		}
		MybatisChoose choose = new MybatisChoose();
		choose.setArry(arry);
		List<Menu> menu = menuService.getListOfMenus(choose);
		request.setAttribute("menu", menu);
		
		//角色信息
		Role roleInfo = roleService.getRoleInfoById(r_id);
		request.setAttribute("roleInfo", roleInfo);
		
		return "role-look";
	}
	/**
	 * 按条件查询role
	 * @param roleDimForm
	 * @param request
	 * @throws IOException 
	 */
	@RequestMapping("/dimRole.do")
	public void dimRole(RoleDimForm roleDimForm,HttpServletRequest request,HttpServletResponse response) throws IOException{
		//System.out.println(request.getParameter("keyword"));
		//System.out.println(roleDimForm.getCid()+"/"+roleDimForm.getKeyword()+"/"+roleDimForm.getCondition()+"/"+roleDimForm.getResult());;
		
		int num = roleService.queryToltleSizeByCondition(roleDimForm);
		//System.out.println("按条件查询条数为："+num);
		
		String scurrentPage = request.getParameter("page");
		String spageSize = request.getParameter("rows");
		
		int currentPage=1;
		int pageSize=5;
		if(scurrentPage!=null && spageSize!=null ){
			currentPage = Integer.parseInt(scurrentPage);
			pageSize = Integer.parseInt(spageSize);
			
		}
		PageView<Role> pageView = new PageView<Role>(currentPage, pageSize);
		pageView.setCondition(roleDimForm.getCondition());
		pageView.setResult(roleDimForm.getResult());
		List<Role> roles = roleService.queryRolesByCondition(pageView);
		
/*		for (Role role : roles) {
			System.out.println(role.getR_name());
		}*/
		
		RecordResult<Role> recordResult = new RecordResult<Role>();
		recordResult.setRecords(roles);
		recordResult.setTotalRecord(num);
		
	    JsonConfig jsonConfig = new JsonConfig();
	    jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor()); 
		JSONArray jsonArray=JSONArray.fromObject(recordResult.getRecords(),jsonConfig);
		
		response.getWriter().println("{\"total\":"+recordResult.getTotalRecord()+",\"rows\":"+jsonArray.toString()+"}");
	}
	
	@RequestMapping("/position_names.do")
	public void getPosition(HttpServletResponse response) throws IOException{

		List<Position> list = employee_RoleService.position();
		PositionService positionService = new PositionService();
		positionService.setPositions(list);
		JSONArray jsonArray=JSONArray.fromObject(positionService);
		response.getWriter().println(jsonArray.toString());
	}
	@RequestMapping("/saveUser.do")
	public String saveUser(employeeForm employeeForm,HttpServletRequest 
			request){
		//先存取到e_id 存中间表
		employee_RoleService.saveUser(employeeForm);
		int e_id = employeeForm.getE_id();
		//存中建表
		String[] rids = request.getParameterValues("r_id");
		EmployeeAndRole employeeAndRole = new EmployeeAndRole();
		employeeAndRole.setE_id(e_id);
		
		for(int i=0;i<rids.length;i++){
			
			employeeAndRole.setR_id(Integer.parseInt(rids[i]));
			employee_RoleService.insertIntoRoleAndEmployee(employeeAndRole);
		}
		return "user";
	}
	
	
	/**
	 * 跳转编辑人员页面
	 * @param e_id
	 * @param request
	 * @return
	 */
	@RequestMapping("/jumpEditEmployee.do")
	public String jumpEditEmployee(@RequestParam("e_id") int e_id,HttpServletRequest 
			request){
		
		Employee employee = employee_RoleService.getSingleEmployeeById(e_id);
		
		
		 List<Role> roles = roleService.getAllRoles();
		 request.setAttribute("roles", roles);
		 
		 
		request.setAttribute("employee", employee);
		return "user-edit";
	}
	/**
	 * 保存编辑后的内容
	 * @return
	 */
	@RequestMapping("/saveEditUser.do")
	public String saveEditUser(employeeForm employeeForm,HttpServletRequest 
			request){
		int e_id = employeeForm.getE_id();
		//删除中间表
		employee_RoleService.deleteEmployeeAndRoles(e_id);
		
		
		String[] rids = request.getParameterValues("r_id");
		EmployeeAndRole employeeAndRole = new EmployeeAndRole();
		employeeAndRole.setE_id(e_id);
		
		for(int i=0;i<rids.length;i++){
			
			employeeAndRole.setR_id(Integer.parseInt(rids[i]));
			employee_RoleService.insertIntoRoleAndEmployee(employeeAndRole);
		}

		employeeForm.setE_afterdate((new Date()).toString());
		employee_RoleService.saveEditEmployee(employeeForm);
		return "user";
	}
	/**
	 * 携带数据跳转展示页面
	 * @param e_id
	 * @param request
	 * @return
	 */
	@RequestMapping("/employee_look.do")
	public String lookEmployee(@RequestParam("e_id") int e_id,HttpServletRequest 
			request){
		
		Employee employee = employee_RoleService.getSingleEmployeeById(e_id);
		request.setAttribute("employee", employee);
		
		String positionName = employee_RoleService.getPositionByEmployeeId(e_id);
		request.setAttribute("positionName", positionName);
		return "user-look";
	}
	
	@RequestMapping("/employee_delete.do")
	public void deleteEmployee(@RequestParam("e_id") int e_id,HttpServletResponse response) throws IOException{
		///items/role/role_delete.do
		
		employee_RoleService.deleteEmployeeAndRoles(e_id);
		employee_RoleService.deleteEmployeeByID(e_id);
		//ServletActionContext.getResponse().getWriter().println("{\"message\":\"删除成功\"}");
		response.getWriter().println("{\"message\":\"删除成功\"}");
	}
	
	
	@RequestMapping("/dimEmployee.do")
	public void dimEmployee(UserDimForm userDimForm, HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		
		

		int num = employee_RoleService.getTotleNum(userDimForm);
		
		
		
		PageView<Employee> pageView = new PageView<Employee>(currentPage, pageSize);
		pageView.setCondition(userDimForm.getCondition());
		pageView.setResult(userDimForm.getResult());
		pageView.setSort(userDimForm.getSort());
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
