/**
 * yoshinoda.com
 */
package com.yoshinoda.shou6216;

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
		RegisterRun registerRun = new RegisterRun();
		registerRun.execute();
	}
	
	public void execute() {
		LOGGER.info("execute start");
		LOGGER.info("execute end");
	}

}
