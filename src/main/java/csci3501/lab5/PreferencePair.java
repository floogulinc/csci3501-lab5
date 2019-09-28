package csci3501.lab5;

public class PreferencePair {
	private final int prog;
	private final char comp;

	PreferencePair(int programmer, char company) {
		prog = programmer;
		comp = company;
	}

	public String toString() {
		return "" + comp + prog;
	}
}
