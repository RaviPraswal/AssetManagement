package com.adj.amgmt.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adj.amgmt.dto.AssetAssignmentDTO;
import com.adj.amgmt.entity.AssetAssignment;
import com.adj.amgmt.repository.AssetAssignmentRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class AssetAssignmentServiceImpl implements AssetAssignmentService {

	/*
	 * @Autowired AssetAssignmentRepositoryImpl assetAssignmentRepository;
	 */
	
	@Autowired
	AssetAssignmentRepository assetAssignmentRepository;

	@Autowired
	ModelMapper modelMapper;

	public List<AssetAssignmentDTO> getAssetAssignmentList() {
		List<AssetAssignment> assetAssignmentList = assetAssignmentRepository.findAll();

		//		List<AssetAssignmentDTO> assetAssignmentListDTO = Arrays.asList( modelMapper.map(assetAssignmentList, AssetAssignmentDTO.class));
		List<AssetAssignmentDTO> assetAssignmentListDTO = modelMapper.map(assetAssignmentList,
				((TypeToken<List<AssetAssignmentDTO>>) new TypeToken<List<AssetAssignmentDTO>>() {
				}).getType());

		return assetAssignmentListDTO;
	}

	public void saveAssetAssignment(AssetAssignmentDTO assetAssignmentDTO) {
		AssetAssignment assetAssignment = modelMapper.map(assetAssignmentDTO, AssetAssignment.class);
		assetAssignmentRepository.saveAndFlush(assetAssignment);
	}

	public void deleteAssetAssignmentById(int id) {
		assetAssignmentRepository.deleteById(id);
	}

	public AssetAssignmentDTO getAssetAssignmentById(int assetAssignmentId) {
		AssetAssignment assetAssignmentById = assetAssignmentRepository.getById(assetAssignmentId);
		AssetAssignmentDTO assetAssignmentDTO = modelMapper.map(assetAssignmentById, AssetAssignmentDTO.class);
		return assetAssignmentDTO;
	}

	public void updateAssetAssignment(AssetAssignment assetAssignment) {
		assetAssignmentRepository.saveAndFlush(assetAssignment);
	}

}
