package com.qiaosoftware.sssp.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qiaosoftware.sssp.entities.Department;
import com.qiaosoftware.sssp.entities.Person;
import com.qiaosoftware.sssp.service.DepartmentService;
import com.qiaosoftware.sssp.service.PersonService;

@Controller
public class DepartmentHandler {

    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public String saveDepartment(Department department) {
        departmentService.save(department);
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public String addDepartment(Map<String, Object> map) {
        map.put("department", new Department());
        return "add_department";
    }
    
    @RequestMapping(value="/addPerson",method=RequestMethod.POST)
    public String addPerson(Person person) {
        personService.save(person);
        return "redirect:/index.jsp";
    }
    
    @RequestMapping(value="/addPerson",method=RequestMethod.GET)
    public String addPerson(Map<String, Object> map) {
        map.put("person", new Person());
        return "input_person";
    }

}
