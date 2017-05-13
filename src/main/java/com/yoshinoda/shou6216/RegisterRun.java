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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yoshinoda.shou6216.model.AreaMeshRoute;



/**
 * 処理高速化
 * @author shou_y
 *
 */
public class RegisterRun {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterRun.class);
	
	private static final String FROM_FILE = "fromList.txt";
	private static final String TO_FILE = "toList.txt";
	private static final int TO_COLUMN = 4;

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
			
			Set<AreaMeshRoute> toMeshSet = getToMeshList(fromMeshCode);
			for (AreaMeshRoute toMesh : toMeshSet) {
				LOGGER.info("toMeshCode : {}", toMesh);
			}
		}
	}

	private List<Integer> getFromMeshCodeList() {
		Path path = Paths.get(FROM_FILE);
		LOGGER.info("fromMeshCodeList path={}", path);
		
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
	
	private Set<AreaMeshRoute> getToMeshList(int fromMeshCode) {
		Path path = Paths.get(TO_FILE);
		LOGGER.info("toMeshList path={}", path);
		
		Set<AreaMeshRoute> toMeshSet = new HashSet<AreaMeshRoute>();
		try (Stream<String> stream = Files.lines(path, Charset.forName("UTF-8"))) {
			toMeshSet = stream
				.map(line -> line.split(","))
				.filter(values -> values.length == TO_COLUMN)
				.map(values -> new AreaMeshRoute(
						fromMeshCode,
						Integer.valueOf(values[0]),
						Integer.valueOf(values[1]),
						Integer.valueOf(values[2]),
						Integer.valueOf(values[3])
						))
				.collect(Collectors.toSet());
			
		} catch (IOException e) {
			LOGGER.error("read toMeshList error", e);
		}
		return toMeshSet;
	}
}
