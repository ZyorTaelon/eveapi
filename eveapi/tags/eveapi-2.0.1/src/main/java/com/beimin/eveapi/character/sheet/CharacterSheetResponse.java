package com.beimin.eveapi.character.sheet;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class CharacterSheetResponse extends ApiResponse {
	private long characterID;
	private String name;
	private String race;
	private String bloodLine;
	private String gender;
	private String corporationName;
	private long corporationID;
	private double balance;
	private final Set<ApiAttributeEnhancer> attributeEnhancers = new HashSet<ApiAttributeEnhancer>();
	private int intelligence;
	private int memory;
	private int charisma;
	private int perception;
	private int willpower;
	private final Set<ApiSkill> skills = new HashSet<ApiSkill>();

	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getBloodLine() {
		return bloodLine;
	}

	public void setBloodLine(String bloodLine) {
		this.bloodLine = bloodLine;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void addAttributeEnhancer(ApiAttributeEnhancer attributeEnhancer) {
		attributeEnhancers.add(attributeEnhancer);
	}

	public Set<ApiAttributeEnhancer> getAttributeEnhancers() {
		return attributeEnhancers;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception) {
		this.perception = perception;
	}

	public int getWillpower() {
		return willpower;
	}

	public void setWillpower(int willpower) {
		this.willpower = willpower;
	}

	public void addSkill(ApiSkill skill) {
		skills.add(skill);
	}

	public Set<ApiSkill> getSkills() {
		return skills;
	}
}
