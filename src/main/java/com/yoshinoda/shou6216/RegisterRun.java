/**
 * yoshinoda.com
 */
package com.yoshinoda.shou6216;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 処理高速化
 * @author shou_y
 *
 */
public class RegisterRun {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterRun.class);
	
	private static final String FROM_FILE = "fromList.txt";

	public static void main(String[] args) {
		StopWatch sw = new StopWatch();
		sw.start();
		
		LOGGER.info("RegisterRun start");
		
		RegisterRun registerRun = new RegisterRun();
		registerRun.execute();
		
		sw.stop();
		LOGGER.info("RegisterRun end {}[msec]", sw.getTime());
	}
	
	public void execute() {
		List<Integer> fromMeshCodeList = getFromMeshCodeList();
		if (fromMeshCodeList.isEmpty()) {
			LOGGER.info("fromMeshCodeList is empty");
			return;
		}
		
		LOGGER.info("Number of fromMeshCodeList : {}", fromMeshCodeList.size());
		for (int fromMeshCode : fromMeshCodeList) {
			LOGGER.info("fromMeshCode : {}", fromMeshCode);
		}
		
		

	}

	private List<Integer> getFromMeshCodeList() {
		Path path = Paths.get(FROM_FILE);
		LOGGER.info("fromAreaMeshList path={}", path);
		
		List<Integer> fromMeshCodeList = new ArrayList<Integer>();
		try (Stream<String> stream = Files.lines(path, Charset.forName("UTF-8"))) {
			fromMeshCodeList = stream
				.filter(line -> StringUtils.isNotBlank(line))
				.map(line -> Integer.valueOf(line))
				.collect(Collectors.toList());
			
		} catch (IOException e) {
			LOGGER.error("read fromMeshCodeList error", e);
		}
		return fromMeshCodeList;
	}
}
