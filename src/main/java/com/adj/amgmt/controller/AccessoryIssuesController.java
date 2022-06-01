package com.adj.amgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adj.amgmt.dto.AccessoryDTO;
import com.adj.amgmt.dto.AccessoryIssueDTO;
import com.adj.amgmt.dto.EmployeeDTO;
import com.adj.amgmt.service.AccessoryIssueService;
import com.adj.amgmt.service.AccessoryService;
import com.adj.amgmt.service.EmployeeService;

@Controller
@RequestMapping("/accessory_issues")
public class AccessoryIssuesController {

	@Autowired
	AccessoryIssueService accessoryIssueService;

	@Autowired
	AccessoryService accessoryService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ModelMapper modelMapper;

	// controller to show accessory issues page
	@RequestMapping("/")
	public ModelAndView accessoryIssueView() {
		ModelAndView modelAndView = new ModelAndView();
		List<AccessoryIssueDTO> accessoryIssueList = accessoryIssueService.getAccessoryIssuesList();
		modelAndView.addObject("accessoryIssuesList", accessoryIssueList);
		modelAndView.setViewName("accessoryIssuesView");
		return modelAndView;
	}

	// controller to save accessory issue
	@RequestMapping(value = "/open_accessory_issue")
	public ModelAndView openAccessoryIssue() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("accessoryIssues", new AccessoryIssueDTO());

		// loading accessories
		List<AccessoryDTO> loadAccessory = accessoryService.getAccessoryList();
		modelAndView.addObject("loadAccessory", loadAccessory);

		// loading employees
		List<EmployeeDTO> loadEmployee = employeeService.getEmployeeList();
		modelAndView.addObject("loadEmployee", loadEmployee);
		
		modelAndView.setViewName("saveUpdateAccessoryIssue");
		return modelAndView;
	}

	// controller to save accessory issue
	@RequestMapping(value = "/save_update_accessory_issue")
	public ModelAndView saveAccessoryIssue(@Valid @ModelAttribute("accessoryIssues") AccessoryIssueDTO accessoryIssueDTO, Errors errors) {
		ModelAndView modelAndView = new ModelAndView();
	
		if(errors.hasErrors()) {
			// loading accessories
			List<AccessoryDTO> loadAccessory = accessoryService.getAccessoryList();
			modelAndView.addObject("loadAccessory", loadAccessory);

			// loading employees
			List<EmployeeDTO> loadEmployee = employeeService.getEmployeeList();
			modelAndView.addObject("loadEmployee", loadEmployee);
			
			modelAndView.setViewName("saveUpdateAccessoryIssue");
		}else {
			accessoryIssueService.saveAccessoryIssue(accessoryIssueDTO);
			modelAndView.setViewName("redirect:/accessory_issues/");
		}
		return modelAndView;
	}

	// controller to delete accessory issue
	@RequestMapping("/delete_accessory_issue")
	public ModelAndView deleteAccessoryIssueById(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		accessoryIssueService.deleteAccessoryIssueById(id);
		modelAndView.setViewName("redirect:/accessory_issues/");
		return modelAndView;
	}
	
	
}
