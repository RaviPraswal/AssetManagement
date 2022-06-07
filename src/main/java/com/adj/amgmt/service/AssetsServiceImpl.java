package com.adj.amgmt.service;

import java.util.Arrays;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adj.amgmt.dto.AssetAssignmentDTO;
import com.adj.amgmt.dto.AssetDTO;
import com.adj.amgmt.entity.Asset;
import com.adj.amgmt.entity.AssetTypes;
import com.adj.amgmt.entity.Bill;
import com.adj.amgmt.repository.AssetRepository;
import com.adj.amgmt.repository.AssetTypeRepository;
import com.adj.amgmt.repository.BillRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class AssetsServiceImpl implements AssetService {


	@Autowired
	AssetRepository assetsRepository;

	@Autowired
	AssetTypeRepository assetTypeRepository;

	@Autowired
	AssetAssignmentService assetAssignmentService;
	
	@Autowired
	BillRepository billRepo;

	@Autowired
	ModelMapper modelMapper;

	// method to load all asset type from db to add asset page
	// we have to load asset type using asset type repository
	public List<AssetTypes> loadAssetTypes() {
		return assetTypeRepository.findAll();

	}

	// method to save an asset
	public void save(AssetDTO assetDTO) {
		Bill bill = new Bill();
		String fileName="";
		try {
			Asset asset = modelMapper.map(assetDTO, Asset.class);
			fileName=asset.getFile().getOriginalFilename();
			asset.setFileName(fileName);

			bill.setFileName(fileName);
			bill.setFileBill(new Binary(BsonBinarySubType.BINARY, asset.getFile().getBytes()));
			billRepo.insert(bill);

			assetsRepository.saveAndFlush(asset);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// method to delete an asset
	public boolean deleteAssetById(int id) {
		List<AssetAssignmentDTO> assetAssignmentList = assetAssignmentService.getAssetAssignmentList();
		boolean f = false;
		for (AssetAssignmentDTO assetAssignmentDTO : assetAssignmentList) {
			AssetDTO asset = assetAssignmentDTO.getAsset();
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
		assetDTO.setBillFileName(assetById.getFileName());
		return assetDTO;
	}

}
