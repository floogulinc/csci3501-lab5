package csci3501.lab5;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsSatisfactoryTest {
    @Test public void testUnsatisfactoryPairing() {
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
	    
        ArrayList<PreferencePair> matchedPairs = new ArrayList<PreferencePair>(Arrays.asList(new PreferencePair(1,'A'), new PreferencePair(3,'B'),
        new PreferencePair(2,'C'), new PreferencePair(4,'D'), new PreferencePair(5,'E')));

        Matcher matcher = new Matcher(compsPreferences, progsPreferences, matchedPairs);

        assertEquals("Matches size is wrong", matchedPairs.size(), N);
        assertFalse("Matches are satisfactory but shouldn't be", matcher.isSatisfactory());
    }

    @Test public void testSatisfactoryPairing() {
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
	    
        ArrayList<PreferencePair> matchedPairs = new ArrayList<PreferencePair>(Arrays.asList(new PreferencePair(2,'E'), new PreferencePair(1,'D'),
        new PreferencePair(5,'A'), new PreferencePair(3,'B'), new PreferencePair(4,'C')));

        Matcher matcher = new Matcher(compsPreferences, progsPreferences, matchedPairs);

        assertEquals("Matches size is wrong", matchedPairs.size(), N);
        assertTrue("Matches are not satisfactory", matcher.isSatisfactory());
    }
}