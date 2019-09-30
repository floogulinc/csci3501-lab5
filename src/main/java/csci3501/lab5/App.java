package csci3501.lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class App {
	private static ArrayList<CompPreferences> compsPreferences = new ArrayList<>();
	private static ArrayList<ProgPreferences> progsPreferences = new ArrayList<>();
	private static ArrayList<PreferencePair> matchedPairs = new ArrayList<>();

	public static void main(String[] args) {
		int N = 5;
		compsPreferences.add(new CompPreferences('A', new int[]{2, 5, 1, 3, 4}));
		compsPreferences.add(new CompPreferences('B', new int[]{1, 2, 3, 4, 5}));
		compsPreferences.add(new CompPreferences('C', new int[]{5, 3, 2, 1, 4}));
		compsPreferences.add(new CompPreferences('D', new int[]{1, 3, 2, 4, 5}));
		compsPreferences.add(new CompPreferences('E', new int[]{2, 3, 5, 4, 1}));
		progsPreferences.add(new ProgPreferences(1, new char[]{'E', 'A', 'D', 'B', 'C'}));
		progsPreferences.add(new ProgPreferences(2, new char[]{'D', 'E', 'B', 'A', 'C'}));
		progsPreferences.add(new ProgPreferences(3, new char[]{'D', 'B', 'C', 'E', 'A'}));
		progsPreferences.add(new ProgPreferences(4, new char[]{'C', 'B', 'D', 'A', 'E'}));
		progsPreferences.add(new ProgPreferences(5, new char[]{'A', 'D', 'B', 'C', 'E'}));

		System.out.println("Input Preferences:");
		for (CompPreferences p : compsPreferences) {
			System.out.println(p);
		}
		for (ProgPreferences p : progsPreferences) {
			System.out.println(p);
		}

		//match(N);

		System.out.println("\nSolution:");
		System.out.println(matchedPairs);
	}
}
