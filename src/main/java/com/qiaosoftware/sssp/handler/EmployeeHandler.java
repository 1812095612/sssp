package com.qiaosoftware.sssp.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.qiaosoftware.sssp.entities.Employee;
import com.qiaosoftware.sssp.service.DepartmentService;
import com.qiaosoftware.sssp.service.EmployeeService;
import com.qiaosoftware.sssp.utils.ConstantsUtil;
import com.qiaosoftware.sssp.utils.MyWebUtilForQueryCondition;
import com.qiaosoftware.sssp.utils.Servlets;

@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute
    public void getModel(@RequestParam(value = "id", required = false) Integer id,
                        Map<String, Object> map) {
        if (id != null) {
            Employee emp = employeeService.findById(id);
            emp.setDepartment(null);
            map.put("employee", emp);
        }
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String update(Employee employee) {
        employeeService.saveOrUpdate(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("departments", departmentService.getAll());
        map.put("employee", employeeService.findById(id));
        return "input";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "redirect:/emps";
    }
    
    //查询条件：按照约定写法如下
    //search_EQD_birth=2000-02-12&search_LIKES_department.departmentName=市场部
    //                           &search_LIKES_email=zhangsan@163.com&search_LIKES_lastName=张三
    @RequestMapping(value = "/emps", method = {RequestMethod.GET})
    public String list(@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNoStr,
                        Map<String, Object> map, HttpServletRequest request) {
        //1. 获取带有指定前缀的请求参数的 Map
        Map<String, Object> requestParams = Servlets.getParametersStartingWith(request, "search_");
        System.out.println(requestParams);
        
        //2. 把请求参数的 Map 再转为查询字符串, 传回到页面
        String queryString = Servlets.encodeParameterStringWithPrefix(requestParams, "search_");
        map.put("queryString", queryString);
        System.out.println(queryString);
        
        //前端传入的pageNo从1开始，而PageRequest里的pageNo是从0开始
        int pageNo = 1;
        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {}
        Pageable pageable = new PageRequest(pageNo - 1, ConstantsUtil.PAGE_SIZE);
        
        //3. 调用 Service 方法. 
        map.put("page", employeeService.findConditionPage(pageable, requestParams));
        return "list";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(Employee employee) {
        employeeService.saveOrUpdate(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {
        map.put("departments", departmentService.getAll());
        map.put("employee", new Employee());
        return "input";
    }
}
