package roman;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;




public class RomanNumeralTest {
	RomanNumeral numeral;
	
	@Before
	public void setUp() {
		numeral = new RomanNumeral();
	}
	
	@Test
	public void one() throws Exception {
		assertEquals("I", numeral.convert(1));
	}
	
	@Test
	public void two() throws Exception {
		assertEquals("II", numeral.convert(2));
	}
	
	@Test
	public void five() throws Exception {
		assertEquals("V", numeral.convert(5));
	}
	
	@Test
	public void four() throws Exception {
		assertEquals("IV", numeral.convert(4));
	}
	
	@Test
	public void six() throws Exception {
		assertEquals("VI", numeral.convert(6));
	}
	
	@Test
	public void eight() throws Exception {
		assertEquals("VIII", numeral.convert(8));
	}
	
	@Test
	public void nine() throws Exception {
		assertEquals("IX", numeral.convert(9));
	}
	
	@Test
	public void ten() throws Exception {
		assertEquals("X", numeral.convert(10));
	}
}
