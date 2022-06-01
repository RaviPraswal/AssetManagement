package com.adj.amgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adj.amgmt.dto.EmployeeDTO;
import com.adj.amgmt.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// controller to open employee page
	@RequestMapping(value = "/")
	public ModelAndView employee_view() {
		ModelAndView modelAndView = new ModelAndView();
		List<EmployeeDTO> employeeListDTO = employeeService.getEmployeeList();
		modelAndView.addObject("employeeList", employeeListDTO);
		modelAndView.setViewName("employeeView");
		return modelAndView;

	}

	// controller to save an employee
	@RequestMapping(value = "/open_employee")
	public String openEmployee() {
		return "saveUpdateEmployee";
	}

	// controller to save an employee
	@RequestMapping(value = "/save_update_employee")
	public ModelAndView saveEmployee(@ModelAttribute("employee") EmployeeDTO employeeDTO) {
		ModelAndView modelAndView = new ModelAndView();

		employeeService.addEmployee(employeeDTO);
		modelAndView.addObject("saved", "savedSuccessfully");

		modelAndView.setViewName("redirect:/employee/");
		return modelAndView;
	}

	// controller to delete an employee by id
	@RequestMapping("/delete_employee_by_Id")
	public ModelAndView deleteEmployeeById(@ModelAttribute("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		employeeService.deleteEmployeeById(id);
		modelAndView.setViewName("redirect:/employee/");
		return modelAndView;
	}

	// controller is used to forward the data to edit form
	@RequestMapping("/editEmployee")
	public ModelAndView openUpdateform(@RequestParam("empId") int empId) {
		ModelAndView modelAndView = new ModelAndView("employee");
		EmployeeDTO employeeDTO = employeeService.getEmployeeById(empId);
		modelAndView.addObject("employee", employeeDTO);
		modelAndView.setViewName("saveUpdateEmployee");
		return modelAndView;
	}

}
