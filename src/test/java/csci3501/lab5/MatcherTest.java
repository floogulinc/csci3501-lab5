package csci3501.lab5;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Test the match function with different programmer and company preferences inputs
 *
 */
public class MatcherTest {

	/**
	 * Test the match method with empty input preference
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testEmpty() {
		int N = 0;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with one programmer and one company
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testOnePair() {
		int N = 1;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{1});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'A'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with two programmers and two companies having random preferences
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testTwoPairs() {
		int N = 2;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{1, 2});
		compsPreferences[1] = new CompPreferences('B', new int[]{2, 1});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'B', 'A'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'A', 'B'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with two programmers and two companies having the same preferences
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testTwoPairsSamePrefs() {
		int N = 2;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{1, 2});
		compsPreferences[1] = new CompPreferences('B', new int[]{1, 2});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'A', 'B'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'A', 'B'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with two programmers and two companies having the same preferences
	 * But the programmers' preference are in reversed orders
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testTwoPairsReversePrefs() {
		int N = 2;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{1, 2});
		compsPreferences[1] = new CompPreferences('B', new int[]{1, 2});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'B', 'A'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'B', 'A'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with two programmers and two companies having the same preferences
	 * But the companies' preference are in reversed orders
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testTwoPairsReversePrefs2() {
		int N = 2;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{2, 1});
		compsPreferences[1] = new CompPreferences('B', new int[]{2, 1});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'A', 'B'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'A', 'B'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with three programmers and three companies with random preferences
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testThreePairs() {
		int N = 3;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{3, 2, 1});
		compsPreferences[1] = new CompPreferences('B', new int[]{2, 1, 3});
		compsPreferences[2] = new CompPreferences('C', new int[]{2, 3, 1});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'B', 'A', 'C'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'C', 'A', 'B'});
		progsPreferences[2] = new ProgPreferences(3, new char[]{'A', 'C', 'B'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with three programmers and three companies having the same preferences
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testThreePairsSamePrefs() {
		int N = 3;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{1, 2, 3});
		compsPreferences[1] = new CompPreferences('B', new int[]{1, 2, 3});
		compsPreferences[2] = new CompPreferences('C', new int[]{1, 2, 3});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'A', 'B', 'C'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'A', 'B', 'C'});
		progsPreferences[2] = new ProgPreferences(3, new char[]{'A', 'B', 'C'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with three programmers and three companies having the same preferences
	 * But the programmers' preference are in reversed orders
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testThreePairsReversePrefs() {
		int N = 3;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{1, 2, 3});
		compsPreferences[1] = new CompPreferences('B', new int[]{1, 2, 3});
		compsPreferences[2] = new CompPreferences('C', new int[]{1, 2, 3});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'C', 'B', 'A'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'C', 'B', 'A'});
		progsPreferences[2] = new ProgPreferences(3, new char[]{'C', 'B', 'A'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with three programmers and three companies having the same preferences
	 * But the companies' preference are in reversed orders
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testThreePairsReversePrefs2() {
		int N = 3;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{3, 2, 1});
		compsPreferences[1] = new CompPreferences('B', new int[]{3, 2, 1});
		compsPreferences[2] = new CompPreferences('C', new int[]{3, 2, 1});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'A', 'B', 'C'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'A', 'B', 'C'});
		progsPreferences[2] = new ProgPreferences(3, new char[]{'A', 'B', 'C'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with five programmers and five companies with random preferences
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
    @Test public void testFivePairs() {
    	int N = 5;
	    CompPreferences[] compsPreferences = new CompPreferences[N];
	    ProgPreferences[] progsPreferences = new ProgPreferences[N];
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
	    Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
        ArrayList<PreferencePair> matchedPairs = matcher.match();
        System.out.println("Solution: " + matchedPairs);
        assertEquals("Matches size is wrong", matchedPairs.size(), N);
        assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
    }

    @Test public void testFivePairsOtherConstructor() {
    	int N = 5;
	    CompPreferences[] compsPreferences = new CompPreferences[N];
	    ProgPreferences[] progsPreferences = new ProgPreferences[N];
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
	    Matcher matcher = new Matcher(compsPreferences, progsPreferences);
        ArrayList<PreferencePair> matchedPairs = matcher.match();
        System.out.println("Solution: " + matchedPairs);
        assertEquals("Matches size is wrong", matchedPairs.size(), N);
        assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
    }

	/**
	 * Test the match method with five programmers and five companies with the same preferences
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testFivePairsSamePrefs() {
		int N = 5;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{1, 2, 3, 4, 5});
		compsPreferences[1] = new CompPreferences('B', new int[]{1, 2, 3, 4, 5});
		compsPreferences[2] = new CompPreferences('C', new int[]{1, 2, 3, 4, 5});
		compsPreferences[3] = new CompPreferences('D', new int[]{1, 2, 3, 4, 5});
		compsPreferences[4] = new CompPreferences('E', new int[]{1, 2, 3, 4, 5});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'A', 'B', 'C', 'D', 'E'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'A', 'B', 'C', 'D', 'E'});
		progsPreferences[2] = new ProgPreferences(3, new char[]{'A', 'B', 'C', 'D', 'E'});
		progsPreferences[3] = new ProgPreferences(4, new char[]{'A', 'B', 'C', 'D', 'E'});
		progsPreferences[4] = new ProgPreferences(5, new char[]{'A', 'B', 'C', 'D', 'E'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with five programmers and five companies with the same preferences
	 * But the programmers' preference are in reversed orders
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testFivePairsReversePrefs() {
		int N = 5;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{1, 2, 3, 4, 5});
		compsPreferences[1] = new CompPreferences('B', new int[]{1, 2, 3, 4, 5});
		compsPreferences[2] = new CompPreferences('C', new int[]{1, 2, 3, 4, 5});
		compsPreferences[3] = new CompPreferences('D', new int[]{1, 2, 3, 4, 5});
		compsPreferences[4] = new CompPreferences('E', new int[]{1, 2, 3, 4, 5});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'E', 'D', 'C', 'B', 'A'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'E', 'D', 'C', 'B', 'A'});
		progsPreferences[2] = new ProgPreferences(3, new char[]{'E', 'D', 'C', 'B', 'A'});
		progsPreferences[3] = new ProgPreferences(4, new char[]{'E', 'D', 'C', 'B', 'A'});
		progsPreferences[4] = new ProgPreferences(5, new char[]{'E', 'D', 'C', 'B', 'A'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with five programmers and five companies with the same preferences
	 * But the companies' preference are in reversed orders
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testFivePairsReversePrefs2() {
		int N = 5;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{5, 4, 3, 2, 1});
		compsPreferences[1] = new CompPreferences('B', new int[]{5, 4, 3, 2, 1});
		compsPreferences[2] = new CompPreferences('C', new int[]{5, 4, 3, 2, 1});
		compsPreferences[3] = new CompPreferences('D', new int[]{5, 4, 3, 2, 1});
		compsPreferences[4] = new CompPreferences('E', new int[]{5, 4, 3, 2, 1});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'A', 'B', 'C', 'D', 'E'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'A', 'B', 'C', 'D', 'E'});
		progsPreferences[2] = new ProgPreferences(3, new char[]{'A', 'B', 'C', 'D', 'E'});
		progsPreferences[3] = new ProgPreferences(4, new char[]{'A', 'B', 'C', 'D', 'E'});
		progsPreferences[4] = new ProgPreferences(5, new char[]{'A', 'B', 'C', 'D', 'E'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}

	/**
	 * Test the match method with ten programmers and ten companies with random preferences
	 * Our match function works correctly and the result is satisfactory from the assertions
	 * and the result printed
	 */
	@Test public void testTenPairs() {
		int N = 10;
		CompPreferences[] compsPreferences = new CompPreferences[N];
		ProgPreferences[] progsPreferences = new ProgPreferences[N];
		compsPreferences[0] = new CompPreferences('A', new int[]{5, 2, 7, 3, 6, 1, 4, 8, 9, 10});
		compsPreferences[1] = new CompPreferences('B', new int[]{5, 9, 8, 4, 6, 7, 3, 1, 10, 2});
		compsPreferences[2] = new CompPreferences('C', new int[]{8, 9, 7, 10, 2, 6, 3, 1, 4, 5});
		compsPreferences[3] = new CompPreferences('D', new int[]{10, 8, 5, 4, 1, 7, 6, 9, 3, 2});
		compsPreferences[4] = new CompPreferences('E', new int[]{3, 9, 4, 6, 2, 8, 7, 10, 1, 5});
		compsPreferences[5] = new CompPreferences('F', new int[]{1, 8, 10, 5, 4, 9, 7, 3, 6, 2});
		compsPreferences[6] = new CompPreferences('G', new int[]{5, 7, 3, 6, 8, 2, 4, 9, 10, 1});
		compsPreferences[7] = new CompPreferences('H', new int[]{6, 3, 5, 4, 10, 1, 8, 2, 9, 7});
		compsPreferences[8] = new CompPreferences('I', new int[]{8, 4, 1, 10, 6, 9, 3, 5, 2, 7});
		compsPreferences[9] = new CompPreferences('J', new int[]{10, 9, 6, 1, 2, 7, 5, 3, 4, 8});
		progsPreferences[0] = new ProgPreferences(1, new char[]{'J', 'H', 'A', 'G', 'B', 'F', 'E', 'I', 'D', 'C'});
		progsPreferences[1] = new ProgPreferences(2, new char[]{'H', 'A', 'G', 'B', 'F', 'E', 'I', 'D', 'C', 'J'});
		progsPreferences[2] = new ProgPreferences(3, new char[]{'A', 'G', 'B', 'F', 'E', 'I', 'D', 'C', 'J', 'H'});
		progsPreferences[3] = new ProgPreferences(4, new char[]{'G', 'B', 'F', 'E', 'I', 'D', 'C', 'J', 'H', 'A'});
		progsPreferences[4] = new ProgPreferences(5, new char[]{'B', 'F', 'E', 'I', 'D', 'C', 'J', 'H', 'A', 'G'});
		progsPreferences[5] = new ProgPreferences(6, new char[]{'F', 'E', 'I', 'D', 'C', 'J', 'H', 'A', 'G', 'B'});
		progsPreferences[6] = new ProgPreferences(7, new char[]{'E', 'I', 'D', 'C', 'J', 'H', 'A', 'G', 'B', 'F'});
		progsPreferences[7] = new ProgPreferences(8, new char[]{'I', 'D', 'C', 'J', 'H', 'A', 'G', 'B', 'F', 'E'});
		progsPreferences[8] = new ProgPreferences(9, new char[]{'D', 'C', 'J', 'H', 'A', 'G', 'B', 'F', 'E', 'I'});
		progsPreferences[9] = new ProgPreferences(10, new char[]{'C', 'J', 'H', 'A', 'G', 'B', 'F', 'E', 'I', 'D'});
		Matcher matcher = new Matcher(compsPreferences, progsPreferences, N);
		ArrayList<PreferencePair> matchedPairs = matcher.match();
		System.out.println("Solution: " + matchedPairs);
		assertEquals("Matches size is wrong", matchedPairs.size(), N);
		assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
	}
}
