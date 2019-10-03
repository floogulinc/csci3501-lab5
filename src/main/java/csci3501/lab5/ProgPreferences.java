package csci3501.lab5;

import java.util.Arrays;
import java.util.List;

import com.google.common.primitives.Chars;

public class ProgPreferences {
	final int selfInt;
	final char[] charPreferences;

	ProgPreferences(int selfInt, char[] preferences){
		this.selfInt = selfInt;
		charPreferences = preferences;
	}

	int indexOfPreference(char company) {
		return Chars.indexOf(charPreferences, company);		
	}

	public String toString() {
		return selfInt + ": " + Arrays.toString(charPreferences);
	}
}
