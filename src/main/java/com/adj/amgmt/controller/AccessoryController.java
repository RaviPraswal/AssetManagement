package com.adj.amgmt.controller;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.adj.amgmt.dto.AccessoryDTO;
import com.adj.amgmt.dto.AccessoryTypesDTO;
import com.adj.amgmt.service.AccessoryService;
import com.adj.amgmt.service.AccessoryTypesServiceImpl;

@Controller
@RequestMapping("/accessory")
public class AccessoryController {

	@Autowired
	AccessoryService accessoryService;

	@Autowired
	AccessoryTypesServiceImpl accessoryTypesService;

	@Autowired
	ModelMapper modelMapper;

	// controller to show accessory page
	@RequestMapping("/")
	public ModelAndView accessoryView() {
		ModelAndView modelAndView = new ModelAndView();
		List<AccessoryDTO> accessoryListDTO = accessoryService.getAccessoryList();
		modelAndView.addObject("accessoryList", accessoryListDTO);
		modelAndView.setViewName("accessoryView");
		return modelAndView;
	}

	// controller to open saveAccessory page
	@RequestMapping(value = "/open_accessory_view")
	public ModelAndView openSaveAccessoryView() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("accessory", new AccessoryDTO());
		// load accessory type
		List<AccessoryTypesDTO> accessoryTypesDTO = accessoryTypesService.getAccessoryTypeList();
		modelAndView.addObject("loadAccessoryTypes", accessoryTypesDTO);
		modelAndView.setViewName("saveUpdateAccessory");
		return modelAndView;
	}

	// controller to save accessory
	@RequestMapping(value = "/save_update_accessory", method = RequestMethod.POST)
	public ModelAndView saveAccessory(@Valid @ModelAttribute("accessory") AccessoryDTO accessoryDTO, Errors errors,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String filePath = "C:/Users/Ravi/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/src/main/webapp/WEB-INF/temp/";
		if (errors.hasErrors()) {
			List<AccessoryTypesDTO> accessoryTypesDTO = accessoryTypesService.getAccessoryTypeList();
			modelAndView.addObject("loadAccessoryTypes", accessoryTypesDTO);
			modelAndView.setViewName("saveUpdateAccessory");
		} else {
			try {
				MultipartFile file = accessoryDTO.getFile();
				String fileName = file.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(filePath + fileName);
				byte[] bt = file.getBytes();
				fos.write(bt);

			} catch (Exception e) {
				e.printStackTrace();
			}
			accessoryService.saveAccessory(accessoryDTO);
			modelAndView.setViewName("redirect:/accessory/");
		}

		return modelAndView;
	}

	// controller to delete accessory
	@RequestMapping("/delete_accessory")
	public ModelAndView deleteAccessoryById(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteAccessoryBySkuId = accessoryService.deleteAccessoryBySkuId(id);
		modelAndView.addObject("deleteAccessoryBySkuId", deleteAccessoryBySkuId);// returns false
		modelAndView.setViewName("redirect:/accessory/");
		return modelAndView;
	}

	// controller to open update form for accessory type
	@RequestMapping("/open_update_accessory_form")
	public ModelAndView openUpdateform(@RequestParam("accessoryId") int accessoryId) {
		ModelAndView modelAndView = new ModelAndView("accessory");

		AccessoryDTO accessoryDTO = accessoryService.getAccessoryById(accessoryId);
		modelAndView.addObject("accessory", accessoryDTO);

		List<AccessoryTypesDTO> accessoryTypesDTO = accessoryTypesService.getAccessoryTypeList();
		modelAndView.addObject("loadAccessoryTypes", accessoryTypesDTO);

		modelAndView.setViewName("saveUpdateAccessory");
		return modelAndView;
	}

}
