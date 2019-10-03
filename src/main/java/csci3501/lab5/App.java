package csci3501.lab5;

import java.util.ArrayList;

/**
 * The App class illustrates how to match programmers and companies with our algorithm with an example
 */
public class App {
	public static void main(String[] args) {
		// To use our match method, input the number of companies and programmers
		int N = 5;

		// For each company, create a CompPreferences with a char representing the company and an int array
		//      representing the preference of the company, the less the index of an int is, the higher
		//      preference the company has toward that programmer
		// Then put the preferences of each companies into an compsPreferences array
		CompPreferences[] compsPreferences = new CompPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{2, 5, 1, 3, 4});
		compsPreferences[1] = new CompPreferences('B', new int[]{1, 2, 3, 4, 5});
		compsPreferences[2] = new CompPreferences('C', new int[]{5, 3, 2, 1, 4});
		compsPreferences[3] = new CompPreferences('D', new int[]{1, 3, 2, 4, 5});
		compsPreferences[4] = new CompPreferences('E', new int[]{2, 3, 5, 4, 1});

		// For each programmer, create a ProgPreferences with an int representing the programmer and a char array
		//      representing the preference of the programmer, the less the index of a char is, the higher
		//      preference the programmer has toward that company
		// Then put the preferences of each programmers into an progsPreferences array
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		progsPreferences[0] = new ProgPreferences(1, new char[]{'E', 'A', 'D', 'B', 'C'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'D', 'E', 'B', 'A', 'C'});
		progsPreferences[2] = new ProgPreferences(3, new char[]{'D', 'B', 'C', 'E', 'A'});
		progsPreferences[3] = new ProgPreferences(4, new char[]{'C', 'B', 'D', 'A', 'E'});
		progsPreferences[4] = new ProgPreferences(5, new char[]{'A', 'D', 'B', 'C', 'E'});

		// Print the input companies' and programmers' preferences
		System.out.println("Input Preferences:");
		for (CompPreferences p : compsPreferences) {
			System.out.println(p);
		}
		for (ProgPreferences p : progsPreferences) {
			System.out.println(p);
		}

		// Call the constructor of the matcher and input the number of companies and programmers,
		// and the companies'and programmers' preferences
		Matcher m = new Matcher(compsPreferences, progsPreferences, N);
		// Call the matcher to match and store the returned pairs
		ArrayList<PreferencePair> matchedPairs = m.match();

		// Print the returned pairs and call the matcher to examine if it is satisfactory
		System.out.println("\nSolution:");
		System.out.println(matchedPairs);
		System.out.println("\nIs satisfactory: " + m.isSatisfactory());
	}
}
