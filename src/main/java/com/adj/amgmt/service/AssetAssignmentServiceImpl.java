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

	@Autowired
	AssetAssignmentRepository assetAssignmentRepository;

	@Autowired
	ModelMapper modelMapper;

	public List<AssetAssignmentDTO> getAssetAssignmentList() {
		try {
			List<AssetAssignment> assetAssignmentList = assetAssignmentRepository.findAll();
			List<AssetAssignmentDTO> assetAssignmentListDTO = modelMapper.map(assetAssignmentList,
					((TypeToken<List<AssetAssignmentDTO>>) new TypeToken<List<AssetAssignmentDTO>>() {
					}).getType());

			return assetAssignmentListDTO;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void saveAssetAssignment(AssetAssignmentDTO assetAssignmentDTO) {
		try {
			AssetAssignment assetAssignment = modelMapper.map(assetAssignmentDTO, AssetAssignment.class);
			assetAssignmentRepository.saveAndFlush(assetAssignment);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void deleteAssetAssignmentById(int id) {
		try {
			assetAssignmentRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public AssetAssignmentDTO getAssetAssignmentById(int assetAssignmentId) {
		try {
			AssetAssignment assetAssignmentById = assetAssignmentRepository.getById(assetAssignmentId);
			AssetAssignmentDTO assetAssignmentDTO = modelMapper.map(assetAssignmentById, AssetAssignmentDTO.class);
			return assetAssignmentDTO;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void updateAssetAssignment(AssetAssignment assetAssignment) {
		try {
			assetAssignmentRepository.saveAndFlush(assetAssignment);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
