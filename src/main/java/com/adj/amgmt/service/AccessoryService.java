package com.adj.amgmt.service;

import java.util.List;

import com.adj.amgmt.dto.AccessoryDTO;
import com.adj.amgmt.entity.Accessory;

public interface AccessoryService {

	public void saveAccessory(AccessoryDTO accessoryDTO);

	public boolean deleteAccessoryBySkuId(int id);

	public void updateAccessory(Accessory accessory);

	public List<AccessoryDTO> getAccessoryList();

	public AccessoryDTO getAccessoryById(int accessoryId);

}
