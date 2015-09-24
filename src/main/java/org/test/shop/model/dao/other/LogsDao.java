/*
 * 
 */
package org.test.shop.model.dao.other;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.test.shop.model.domain.entity.other.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


// TODO: Auto-generated Javadoc
/**
 * The Class LogsDao.
 */
@Repository
public class LogsDao {

	/**
	 * Creates the.
	 *
	 * @param Log the log
	 * @return the log
	 */
	public Log create(Log Log) {
		return Log;
	}

	/**
	 * Update.
	 *
	 * @param Log the log
	 * @return the log
	 */
	public Log update(Log Log) {
		return Log;
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Log> findAll() {
		return loadLogs();
	}
	
	

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the log
	 */
	public Log findById(Integer id) {
		return loadLogs().get(id);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	public Boolean delete(Integer id) {
		return true;
	}

	/**
	 * Load logs.
	 *
	 * @return the list
	 */
	private List<Log> loadLogs(){
		String output = "";
		ObjectMapper objectMapper = new ObjectMapper();
		List<Log> logs = new LinkedList<Log>();
		
		try {
			String location = "D:/LOGS/TOURISM/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".log";
			Path path = Paths.get(location);
			output = "[" +  new String(Files.readAllBytes(path)).substring(1) + "]";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output = e.getLocalizedMessage();
			Log log = new Log();
			log.setMsg(output);
			log.setTime(new Date().toString());
			logs.add(log);
			
			return logs;
		}
		
		try {
			logs = objectMapper.readValue(output,
					new TypeReference<List<Log>>() {
			});
			
			output = logs.size() > 0 ? logs.get(0).toString() : output; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output = e.getLocalizedMessage();
			Log log = new Log();
			log.setMsg(output);
			log.setTime(new Date().toString());
			logs.add(log);
		}
		
		Collections.reverse(logs);
		
		return logs;
	}
	
}
