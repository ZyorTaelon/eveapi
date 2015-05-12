package com.beimin.eveapi.model.eve;

/**
 * @author sbeimin
 *
 */
public class Bonus implements Detail {
	private String bonusType;
	private String bonusValue;

	public String getBonusType() {
		return bonusType;
	}

	public void setBonusType(String bonusType) {
		this.bonusType = bonusType;
	}

	public String getBonusValue() {
		return bonusValue;
	}

	public void setBonusValue(String bonusValue) {
		this.bonusValue = bonusValue;
	}

	@Override
	public String toString() {
		return bonusType + " " + bonusValue + "\n";
	}
}
