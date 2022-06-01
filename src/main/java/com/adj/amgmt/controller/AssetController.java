package com.adj.amgmt.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.adj.amgmt.dto.AssetDTO;
import com.adj.amgmt.dto.AssetTypeDTO;
import com.adj.amgmt.service.AssetTypesServiceImpl;
import com.adj.amgmt.service.AssetsServiceImpl;

@Controller
@RequestMapping("/asset")
public class AssetController {

	@Autowired
	AssetsServiceImpl assetsService;

	@Autowired
	AssetTypesServiceImpl assetTypesService;

	@Autowired
	ModelMapper modelMapper;

	// controller to show assets page
	@RequestMapping("/")
	public ModelAndView assetView() {
		ModelAndView modelAndView = new ModelAndView();
		List<AssetDTO> assetListDTO = assetsService.getAssetList();
		modelAndView.addObject("assetList", assetListDTO);
		modelAndView.setViewName("assetsView");
		return modelAndView;
	}

	// controller to open save asset view
	@RequestMapping(value = "/open_asset_view")
	public String openAssetView(Model model) {

		// parent asset is same as asset
		List<AssetDTO> assetListDTO = assetsService.getAssetList();
		List<String> parentAssetList = new ArrayList<String>();
		for (AssetDTO assetDTO : assetListDTO) {
			String name = assetDTO.getName();
			parentAssetList.add(name);
		}
		model.addAttribute("parentAssetList", parentAssetList);

		// loading asset type
		List<AssetTypeDTO> assetTypeListDTO = assetTypesService.getAssetTypeList();
		if (!model.containsAttribute("assetDTOError")) {
			model.addAttribute("assetDTOError", new AssetDTO());
		}
		model.addAttribute("assetTypeList", assetTypeListDTO);

		model.addAttribute("asset", new AssetDTO());
		return "saveUpdateAsset";
	}

	// controller to save asset
	@RequestMapping(value = "/save_update_asset", method = RequestMethod.POST)
	public ModelAndView saveAsset(@Valid @ModelAttribute("asset") AssetDTO assetDTO, Errors errors,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		if (errors.hasErrors()) {
			List<AssetTypeDTO> assetTypeListDTO = assetTypesService.getAssetTypeList();
			modelAndView.addObject("assetTypeList", assetTypeListDTO);
			modelAndView.setViewName("saveUpdateAsset");

		} else {
			String filePath = "C:/Users/Ravi/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/src/main/webapp/WEB-INF/temp/";
			try {
				MultipartFile file = assetDTO.getFile();
				String fileName = file.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(filePath + fileName);
				byte[] bt = file.getBytes();
				fos.write(bt);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assetsService.save(assetDTO);
			modelAndView.setViewName("redirect:/asset/");
		}
		return modelAndView;
	}

	// controller to delete asset
	@RequestMapping("/delete_asset")
	public ModelAndView deleteAssetById(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		boolean deletedAssetById = assetsService.deleteAssetById(id);
		System.out.println("-------->" + deletedAssetById);
		modelAndView.addObject("deletedAssetById", deletedAssetById);// returns false
		modelAndView.setViewName("redirect:/asset/");
		return modelAndView;
	}

	// controller is used to forward the data to edit form
	@RequestMapping("/open_update_form")
	public ModelAndView openUpdateform(@RequestParam("assetId") int assetId) {
		ModelAndView modelAndView = new ModelAndView("asset");
		AssetDTO assetDTO = assetsService.getAssetById(assetId);
		modelAndView.addObject("asset", assetDTO);
		List<AssetTypeDTO> assetTypeListDTO = assetTypesService.getAssetTypeList();
		modelAndView.addObject("assetTypeList", assetTypeListDTO);
		modelAndView.setViewName("saveUpdateAsset");
		return modelAndView;
	}

}
