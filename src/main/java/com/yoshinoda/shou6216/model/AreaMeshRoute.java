/**
 * yoshinoda.com
 */
package com.yoshinoda.shou6216.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author shou_y
 *
 */
public class AreaMeshRoute {
	
	private int fromMeshCode;
	private int toMeshCode;
	private int timeWalk;
	private int timeCar;
	private int timeTrain;
	
	public AreaMeshRoute(int fromMeshCode, int toMeshCode,
			int timeWalk, int timeCar, int timeTrain) {
		this.fromMeshCode = fromMeshCode;
		this.toMeshCode = toMeshCode;
		this.timeWalk = timeWalk;
		this.timeCar = timeCar;
		this.timeTrain = timeTrain;
	}

	public int getFromMeshCode() {
		return fromMeshCode;
	}

	public int getToMeshCode() {
		return toMeshCode;
	}

	public int getTimeWalk() {
		return timeWalk;
	}

	public int getTimeCar() {
		return timeCar;
	}

	public int getTimeTrain() {
		return timeTrain;
	}
	
	public void setTimeCar(int timeCar) {
		this.timeCar = timeCar;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this ,ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
