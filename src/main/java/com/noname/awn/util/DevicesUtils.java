package com.noname.awn.util;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.model.Devices;
import com.noname.awn.repository.DevicesRepository;

@Component
public class DevicesUtils {
	
	private static DevicesRepository devicesRepositoryUtil;
	
	@Autowired
	public void setDevicesRepo(DevicesRepository devicesRepository) {
		DevicesUtils.devicesRepositoryUtil = devicesRepository;
	}
	
	public static List<Devices> getListDevices(List<ObjectId> obj) {
		List<Devices> logs = new ArrayList<>();
		for(ObjectId id : obj) {
			Devices devices = devicesRepositoryUtil.findBy_id(id);
			logs.add(devices);
		}
		return logs;
	}
}
