package csci3501.lab5;

import java.util.ArrayList;

public class App {
	private static int N = 5;
	private static CompPreferences[] compsPreferences = new CompPreferences[N];
	private static ProgPreferences[] progsPreferences = new ProgPreferences[N];

	public static void main(String[] args) {
		compsPreferences[0] = new CompPreferences('A', new int[]{2, 5, 1, 3, 4});
		compsPreferences[1] = new CompPreferences('B', new int[]{1, 2, 3, 4, 5});
		compsPreferences[2] = new CompPreferences('C', new int[]{5, 3, 2, 1, 4});
		compsPreferences[3] = new CompPreferences('D', new int[]{1, 3, 2, 4, 5});
		compsPreferences[4] = new CompPreferences('E', new int[]{2, 3, 5, 4, 1});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'E', 'A', 'D', 'B', 'C'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'D', 'E', 'B', 'A', 'C'});
		progsPreferences[2] = new ProgPreferences(3, new char[]{'D', 'B', 'C', 'E', 'A'});
		progsPreferences[3] = new ProgPreferences(4, new char[]{'C', 'B', 'D', 'A', 'E'});
		progsPreferences[4] = new ProgPreferences(5, new char[]{'A', 'D', 'B', 'C', 'E'});

		System.out.println("Input Preferences:");
		for (CompPreferences p : compsPreferences) {
			System.out.println(p);
		}
		for (ProgPreferences p : progsPreferences) {
			System.out.println(p);
		}

		Matcher m = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = m.match();

		System.out.println("\nSolution:");
		System.out.println(matchedPairs);
		System.out.println("\nIs satisfactory: " + m.isSatisfactory(matchedPairs));
	}
}
