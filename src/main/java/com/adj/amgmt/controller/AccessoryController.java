package com.adj.amgmt.controller;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.adj.amgmt.dto.AccessoryDTO;
import com.adj.amgmt.dto.AccessoryIssueDTO;
import com.adj.amgmt.dto.AccessoryTypesDTO;
import com.adj.amgmt.entity.Accessory;
import com.adj.amgmt.service.AccessoryIssueService;
import com.adj.amgmt.service.AccessoryService;
import com.adj.amgmt.service.AccessoryTypesServiceImpl;

@Controller
@RequestMapping("/accessory")
public class AccessoryController {

	@Autowired
	AccessoryService accessoryService;

	@Autowired
	AccessoryIssueService accessoryIssueService;

	@Autowired
	AccessoryTypesServiceImpl accessoryTypesService;

	@Autowired
	ModelMapper modelMapper;

	// controller to show accessory page
	@RequestMapping("/")
	public ModelAndView listView() {
		ModelAndView modelAndView = new ModelAndView();

		try {
			List<AccessoryDTO> accessoryListDTO = accessoryService.getAccessoryList();
			modelAndView.addObject("accessoryList", accessoryListDTO);
			modelAndView.setViewName("accessoryView");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	// controller to open saveAccessory page
	@GetMapping(value = "/open_accessory_view")
	public ModelAndView saveView() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.addObject("accessory", new AccessoryDTO());
			// loading accessory type
			List<AccessoryTypesDTO> accessoryTypesDTO = accessoryTypesService.getAccessoryTypeList();
			modelAndView.addObject("loadAccessoryTypes", accessoryTypesDTO);
			modelAndView.setViewName("saveUpdateAccessory");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	// controller to save accessory
	@PostMapping(value = "/save_update_accessory")
	public ModelAndView saveAccessory(@Valid @ModelAttribute("accessory") AccessoryDTO accessoryDTO, Errors errors,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
//		String filePath = "C:/Users/Ravi/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/src/main/webapp/WEB-INF/temp/";
		if (errors.hasErrors()) {
			List<AccessoryTypesDTO> accessoryTypesDTO = accessoryTypesService.getAccessoryTypeList();
			modelAndView.addObject("loadAccessoryTypes", accessoryTypesDTO);
			modelAndView.setViewName("saveUpdateAccessory");
		} else {
//			try {
//				MultipartFile file = accessoryDTO.getFile();
//				String fileName = file.getOriginalFilename();
//				FileOutputStream fos = new FileOutputStream(filePath + fileName);
//				byte[] bt = file.getBytes();
//				fos.write(bt);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			accessoryService.saveAccessory(accessoryDTO);
			modelAndView.addObject("saved", "save/update");
			modelAndView.setViewName("redirect:/accessory/");
		}

		return modelAndView;
	}

	// controller to open update form for accessory type
	@RequestMapping("/open_update_accessory_form")
	public ModelAndView openUpdateform(@RequestParam("accessoryId") int accessoryId) {
		ModelAndView modelAndView = new ModelAndView("accessory");

		try {
			AccessoryDTO accessoryDTO = accessoryService.getAccessoryById(accessoryId);
			modelAndView.addObject("accessory", accessoryDTO);
			List<AccessoryTypesDTO> accessoryTypesDTO = accessoryTypesService.getAccessoryTypeList();
			modelAndView.addObject("loadAccessoryTypes", accessoryTypesDTO);
			modelAndView.addObject("billFileName", accessoryDTO.getBillFileName());
			modelAndView.setViewName("saveUpdateAccessory");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	// controller to delete accessory
	@RequestMapping("/delete_accessory")
	public ModelAndView deleteById(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		List<AccessoryIssueDTO> accessoryIssuesList = accessoryIssueService.getAccessoryIssuesList();
		try {
			for (AccessoryIssueDTO accessoryIssueDTO : accessoryIssuesList) {
				AccessoryDTO accessory = accessoryIssueDTO.getAccessory();
				if (accessory.getId() == id) {
					modelAndView.addObject("existId", "This accessory already assigned.");
					modelAndView.setViewName("accessoryError");
				} else {
					accessoryService.deleteAccessoryBySkuId(id);
					modelAndView.addObject("deleted", "delete");
					modelAndView.setViewName("redirect:/accessory/");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

}
