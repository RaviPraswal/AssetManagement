package com.adj.amgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adj.amgmt.dto.AssetAssignmentDTO;
import com.adj.amgmt.dto.AssetDTO;
import com.adj.amgmt.dto.EmployeeDTO;
import com.adj.amgmt.service.AssetAssignmentService;
import com.adj.amgmt.service.AssetsServiceImpl;
import com.adj.amgmt.service.EmployeeService;

@Controller
@RequestMapping("/asset_assignment")
public class AssetAssignmentController {

	@Autowired
	AssetAssignmentService assetAssignmentService;

	@Autowired
	AssetsServiceImpl assetService;

	@Autowired
	EmployeeService employeeService;

	// controller to show asset_assignment page
	@RequestMapping("/")
	public ModelAndView assetAssignmentView() {
		ModelAndView modelAndView = new ModelAndView();
		List<AssetAssignmentDTO> assetAssignmentListDTO = assetAssignmentService.getAssetAssignmentList();
		modelAndView.addObject("assetAssignmentList", assetAssignmentListDTO);
		modelAndView.setViewName("assetAssignmentView");
		return modelAndView;
	}

	@RequestMapping(value = "/open_asset_assignemnt")
	public ModelAndView openAssetAssignmentView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("assetAssignment", new AssetAssignmentDTO());

		// loading assets
		List<AssetDTO> loadAssetDTO = assetService.getAssetList();
		modelAndView.addObject("loadAsset", loadAssetDTO);

		// loading employee
		List<EmployeeDTO> loadEmployeeDTO = employeeService.getEmployeeList();
		modelAndView.addObject("loadEmployee", loadEmployeeDTO);

		modelAndView.setViewName("saveUpdateAssetAssignment");
		return modelAndView;
	}

	@RequestMapping(value = "/save_update_asset_assignment")
	public ModelAndView saveAssetAssignment(
			@Valid @ModelAttribute("assetAssignment") AssetAssignmentDTO assetAssignmentDTO, Errors errors) {
		ModelAndView modelAndView = new ModelAndView();

		if (errors.hasErrors()) {
			// loading assets
			List<AssetDTO> loadAssetDTO = assetService.getAssetList();
			modelAndView.addObject("loadAsset", loadAssetDTO);

			// loading employee
			List<EmployeeDTO> loadEmployeeDTO = employeeService.getEmployeeList();
			modelAndView.addObject("loadEmployee", loadEmployeeDTO);
			modelAndView.setViewName("saveUpdateAssetAssignment");

		} else {

			// here we are setting the status by checking that issueDate is empty or not
			if (!assetAssignmentDTO.getIssueDate().isEmpty()) {
				assetAssignmentDTO.setStatus("Assigned");
				if (!assetAssignmentDTO.getIssueDate().isEmpty() && !assetAssignmentDTO.getReturnDate().isEmpty()) {
					assetAssignmentDTO.setStatus("Returned");
				}
			}
			assetAssignmentService.saveAssetAssignment(assetAssignmentDTO);
			modelAndView.setViewName("redirect:/asset_assignment/");
		}

		return modelAndView;
	}

	@RequestMapping("/delete_asset_assignment")
	public ModelAndView deleteAssetAssignmentById(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(id / 0);
		// assetAssignmentService.deleteAssetAssignmentById(id);
		modelAndView.setViewName("redirect:/asset_assignment/");
		return modelAndView;
	}

	@RequestMapping("/open_update_asset_assignment_form")
	public ModelAndView openUpdateform(@RequestParam("assetAssignmentId") int assetAssignmentId) {
		ModelAndView modelAndView = new ModelAndView("assetAssignment");
		AssetAssignmentDTO assetAssignmentDTO = assetAssignmentService.getAssetAssignmentById(assetAssignmentId);
		modelAndView.addObject("assetAssignment", assetAssignmentDTO);
		// loading assets
		List<AssetDTO> loadAssetDTO = assetService.getAssetList();
		modelAndView.addObject("loadAsset", loadAssetDTO);

		// loading employee
		List<EmployeeDTO> loadEmployee = employeeService.getEmployeeList();
		modelAndView.addObject("loadEmployee", loadEmployee);
		modelAndView.setViewName("saveUpdateAssetAssignment");
		return modelAndView;
	}

}
