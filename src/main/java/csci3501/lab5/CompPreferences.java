package csci3501.lab5;

import java.util.Arrays;

import com.google.common.primitives.Ints;

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

	int indexOfPreference(int programmer) {
		return Ints.indexOf(intPreferences, programmer);
	}

	public String toString() {
		return selfChar + ": " + Arrays.toString(intPreferences);
	}
}
