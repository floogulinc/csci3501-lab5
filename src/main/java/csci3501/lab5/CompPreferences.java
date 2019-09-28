package csci3501.lab5;

import java.util.Arrays;

public class CompPreferences {
	final char selfChar;
	final int maxLevel;
	private final int[] intPreferences;

	CompPreferences(char selfChar, int[] preferences){
		this.selfChar = selfChar;
		maxLevel = preferences.length;
		intPreferences = preferences;
	}

	int preference(int level) {
		return intPreferences[level];
	}

	public String toString() {
		return selfChar + ": " + Arrays.toString(intPreferences);
	}
}
