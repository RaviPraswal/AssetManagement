package com.adj.amgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public ModelAndView listView() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<EmployeeDTO> employeeListDTO = employeeService.getEmployeeList();
			modelAndView.addObject("employeeList", employeeListDTO);
			modelAndView.setViewName("employeeView");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;

	}

	// controller to open save form of employee
	@RequestMapping(value = "/open_employee")
	public String saveView(Model model) {
		model.addAttribute("employee", new EmployeeDTO());
		return "saveUpdateEmployee";
	}

	// controller to save an employee
	@RequestMapping(value = "/save_update_employee")
	public ModelAndView saveEmployee(@ModelAttribute("employee") EmployeeDTO employeeDTO) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<EmployeeDTO> employeeList = employeeService.getEmployeeList();
			for (EmployeeDTO employeeDTO2 : employeeList) {
				if (employeeDTO2.getEmail().equals(employeeDTO.getEmail())) {
					System.out.println("Employee already exists<----");
					modelAndView.addObject("existEmail", " * This Email already exist!");
					modelAndView.setViewName("saveUpdateEmployee");
					return modelAndView;
				}
			}
			employeeService.addEmployee(employeeDTO);
			modelAndView.addObject("saved", "savedSuccessfully");
			modelAndView.setViewName("redirect:/employee/");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	// controller to save an employee
	@RequestMapping(value = "/editEmployee")
	public ModelAndView editEmployee(@RequestParam("empId") int empId) {
		ModelAndView modelAndView = new ModelAndView("employee");
		EmployeeDTO employeeDTO = employeeService.getEmployeeById(empId);
		modelAndView.addObject("employee", employeeDTO);
		modelAndView.setViewName("saveUpdateEmployee");
		/*
		 * try { employeeService.addEmployee(employeeDTO);
		 * modelAndView.addObject("saved", "savedSuccessfully");
		 * modelAndView.setViewName("redirect:/employee/"); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		return modelAndView;
	}

	// controller to delete an employee by id
	@RequestMapping("/delete_employee_by_Id")
	public ModelAndView deleteById(@ModelAttribute("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			employeeService.deleteEmployeeById(id);
			modelAndView.addObject("delete", "deleted");
			modelAndView.setViewName("redirect:/employee/");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

}
