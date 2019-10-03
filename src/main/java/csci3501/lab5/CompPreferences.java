package csci3501.lab5;

import java.util.Arrays;

import com.google.common.primitives.Ints;

public class CompPreferences {
	final char selfChar;
	private final int[] intPreferences;
	private int i = 0;

	CompPreferences(char selfChar, int[] preferences){
		this.selfChar = selfChar;
		intPreferences = preferences;
	}

	int getProgrammer() {
		++i;
		return intPreferences[i - 1];
	}

	int indexOfPreference(int programmer) {
		return Ints.indexOf(intPreferences, programmer);
	}

	public String toString() {
		return selfChar + ": " + Arrays.toString(intPreferences);
	}
}
