package de.scandio.e4.worker.collections;

import de.scandio.e4.worker.interfaces.VirtualUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VirtualUserCollection extends ArrayList<Class<? extends VirtualUser>> {

	private double totalWeight = 0;

	private Map<Class<? extends VirtualUser>, Double> weights = new HashMap<>();

	public void add(Class<? extends VirtualUser> virtualUserClass, double weight) throws Exception {
		super.add(virtualUserClass);
		this.totalWeight += weight;
		if (this.totalWeight > 1) {
			throw new Exception("Total weight is now above 1 in this collection!");
		}
		this.weights.put(virtualUserClass, weight);
	}

	public Double getWeight(Class<? extends VirtualUser> virtualUserClass) {
		return this.weights.get(virtualUserClass);
	}
}
