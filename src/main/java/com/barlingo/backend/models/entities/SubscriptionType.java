package com.barlingo.backend.models.entities;

public enum SubscriptionType {

	MONTHLY(1), TRIMESTRAL(3), ANNUAL(12);

	private Integer time;

	private SubscriptionType(Integer time) {
		this.time = time;
	}

	public Integer getMonths() {
		return time;
	}

}
