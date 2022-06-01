package com.adj.amgmt.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adj.amgmt.dto.AssetAssignmentDTO;
import com.adj.amgmt.dto.AssetDTO;
import com.adj.amgmt.entity.Asset;
import com.adj.amgmt.entity.AssetTypes;
import com.adj.amgmt.repository.AssetRepository;
import com.adj.amgmt.repository.AssetTypeRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class AssetsServiceImpl implements AssetService{

	/*
	 * @Autowired AssetsRepositoryImpl assetsRepository;
	 */
	
	@Autowired
	AssetRepository assetsRepository;
	
	@Autowired
	AssetTypeRepository assetTypeRepository;

	@Autowired
	AssetAssignmentService assetAssignmentService;

	@Autowired
	ModelMapper modelMapper;

	// method to load all asset type from db to add asset page
	//we have to load asset type using asset type repository
	public List<AssetTypes> loadAssetTypes() {
		return assetTypeRepository.findAll();

	}

	// method to save an asset
	public void save(AssetDTO assetDTO) {
		Asset asset = modelMapper.map(assetDTO, Asset.class);
		asset.setFileName(asset.getFile().getOriginalFilename());
		assetsRepository.saveAndFlush(asset);
	}

	// method to delete an asset
	public boolean deleteAssetById(int id) {
		List<AssetAssignmentDTO> assetAssignmentList = assetAssignmentService.getAssetAssignmentList();
		boolean f = false;
		for (AssetAssignmentDTO assetAssignmentDTO : assetAssignmentList) {
			Asset asset = assetAssignmentDTO.getAsset();
			if (asset.getId() == id) {
				f = true;
				break;
			} else {
				f = false;
			}
		}
		if (f == false) {
			assetsRepository.deleteById(id);
			return true;
		}
		return false;

	}

	// method to update an asset
	public void updateAsset(Asset asset) {
		assetsRepository.saveAndFlush(asset);

	}

	// method to get asset list
	public List<AssetDTO> getAssetList() {
		List<Asset> assetList = assetsRepository.findAll();
		List<AssetDTO> assetListDTO = Arrays.asList(modelMapper.map(assetList, AssetDTO[].class));
		return assetListDTO;

	}

	// method to get an asset by id
	public AssetDTO getAssetById(int assetId) {
		Asset assetById = assetsRepository.getById(assetId);
		AssetDTO assetDTO = modelMapper.map(assetById, AssetDTO.class);
		return assetDTO;
	}

}
