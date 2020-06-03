import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class HammingTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testNoDistanceBetweenEmptyStrands() {
        assertEquals(0, new Hamming("", "").getHammingDistance());
    }

    @Test
    public void testNoDistanceBetweenShortIdenticalStrands() {
        assertEquals(0, new Hamming("A", "A").getHammingDistance());
    }

    @Test
    public void testCompleteDistanceInSingleLetterDifferentStrands() {
        assertEquals(1, new Hamming("G", "T").getHammingDistance());
    }

    @Test
    public void testDistanceInLongIdenticalStrands() {
        assertEquals(0, new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG").getHammingDistance());
    }

    @Test
    public void testDistanceInLongDifferentStrandsCase1() {
        assertEquals(9, new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance());
    }

    @Test
    public void testDistanceInLongDifferentStrandsCase2() {
        assertEquals(4, new Hamming("ACTG", "GTCA").getHammingDistance());
    }

    @Test
    public void testDistanceInLongDifferentStrandsCase3() {
        assertEquals(2, new Hamming("ATTG", "ACTA").getHammingDistance());
    }

    @Test
    public void testValidatesFirstStrandNotLonger() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("left strand and right strand must be of equal length.");

        new Hamming("AATG", "AAA");
    }

    @Test
    public void testValidatesFirstStrandNotNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("left strand must not be null.");

        new Hamming(null, "AAA");
    }

    @Test
    public void testValidatesSecondStrandNotNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("right strand must not be null.");

        new Hamming("ACTG", null);
    }

    @Test
    public void testValidatesSecondStrandNotLonger() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("left strand and right strand must be of equal length.");

        new Hamming("ATA", "AGTG");
    }

    @Test
    public void testDisallowLeftEmptyStrand() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("left strand must not be empty.");

        new Hamming("", "G");
    }

    @Test
    public void testDisallowRightEmptyStrand() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("right strand must not be empty.");

        new Hamming("G", "");
    }

}
