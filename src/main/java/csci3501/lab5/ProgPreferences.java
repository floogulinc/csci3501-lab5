package csci3501.lab5;

import java.util.Arrays;

public class ProgPreferences {
	final int selfInt;
	final int maxLevel;
	private final char[] charPreferences;

	ProgPreferences(int selfValue, char[] preferences){
		this.selfInt = selfValue;
		maxLevel = preferences.length;
		charPreferences = preferences;
	}

	char preference(int level) {
		return charPreferences[level];
	}

	public String toString() {
		return selfInt + ": " + Arrays.toString(charPreferences);
	}
}
