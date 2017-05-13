/**
 * yoshinoda.com
 */
package com.yoshinoda.shou6216;

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

		
		

	}

}
