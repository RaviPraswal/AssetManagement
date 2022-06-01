package com.adj.amgmt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adj.amgmt.dto.AccessoryTypesDTO;
import com.adj.amgmt.service.AccessoryTypesServiceImpl;

@Controller
@RequestMapping("/accessory_type")
public class AccessoryTypeController {

	@Autowired
	AccessoryTypesServiceImpl accessoryTypesService;

	// controller to show accessory type page
	@RequestMapping("/")
	public ModelAndView accessoryTypeView() {
		ModelAndView modelAndView = new ModelAndView();
		List<AccessoryTypesDTO> accessoryTypeListDTO = accessoryTypesService.getAccessoryTypeList();
		modelAndView.addObject("accessoryTypeList", accessoryTypeListDTO);
		modelAndView.setViewName("accessoryTypeView");
		return modelAndView;
	}

	// controller to open save and update form
	@RequestMapping("/save_update_view")
	public ModelAndView saveAssetTypeView() {
		ModelAndView modelAndView = new ModelAndView();
		List<AccessoryTypesDTO> accessoryTypeListDTO = accessoryTypesService.getAccessoryTypeList();
		List<String> parentTypeList=new ArrayList<String>();
		for (AccessoryTypesDTO accessoryTypeDTO : accessoryTypeListDTO) {
			String typeName = accessoryTypeDTO.getTypeName();
			parentTypeList.add(typeName);
		}
		modelAndView.addObject("parentTypeList", parentTypeList);
		modelAndView.addObject("accessoryType", new AccessoryTypesDTO());
		modelAndView.setViewName("saveUpdateAccessoryType");
		return modelAndView;
	}

	// controller to save accessory type
	@RequestMapping(value = "/save_accessory_type")
	public ModelAndView saveAccessoryType(@Valid @ModelAttribute("accessoryType") AccessoryTypesDTO accessoryTypeDTO,
			Errors errors) {
		ModelAndView modelAndView = new ModelAndView();
		if (errors.hasErrors()) {
			modelAndView.setViewName("saveUpdateAccessoryType");
		} else {
			accessoryTypesService.saveAccessoryType(accessoryTypeDTO);
			modelAndView.setViewName("redirect:/accessory_type/");
		}

		return modelAndView;
	}

	// controller to delete accessory type
	@RequestMapping("/delete_accessory_type")
	public ModelAndView deleteAccessoryTypeById(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteAccessoryTypeById =accessoryTypesService.deleteAccessoryTypeById(id);
		modelAndView.addObject("deleteAccessoryTypeById", deleteAccessoryTypeById);
		modelAndView.setViewName("redirect:/accessory_type/");
		return modelAndView;
	}

	// controller to open update form for accessory type
	@RequestMapping("/open_update_form")
	public ModelAndView openUpdateform(@RequestParam("accessoryTypeId") int accessoryTypeId) {
		ModelAndView modelAndView = new ModelAndView("accessoryType");
		AccessoryTypesDTO accessoryTypeDTO = accessoryTypesService.getAccessoryTypeId(accessoryTypeId);
		modelAndView.addObject("accessoryType", accessoryTypeDTO);
		modelAndView.setViewName("saveUpdateAccessoryType");
		return modelAndView;
	}

}
