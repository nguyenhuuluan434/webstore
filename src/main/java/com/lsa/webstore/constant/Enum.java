package com.lsa.webstore.constant;

public enum Enum {
	PHONE("phone"), LAPTOP("laptop"), TABLET("tablet"), GOOGLE("google"), APPLE("apple"), DELL("dell"), BRAND(
			"brand"), CATEGORY("category"), LOW("low"), HIGH("high");
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Enum(String name) {
		this.name = name;
	}

}
