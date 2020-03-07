package com.noname.awn.util;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.model.Logs;
import com.noname.awn.repository.LogsRepository;

@Component
public class LogsUtils {
	
	private static LogsRepository logsRepositoryUtil;
	
	@Autowired
	public void setLogsRepo(LogsRepository logsRepository) {
		LogsUtils.logsRepositoryUtil = logsRepository;
	}
	
	public static List<Logs> getListLogs(List<ObjectId> obj) {
		List<Logs> logs = new ArrayList<>();
		for(ObjectId id : obj) {
			Logs logs2 = logsRepositoryUtil.findBy_id(id);
			logs.add(logs2);
		}
		return logs;
	}
}
