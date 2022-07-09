package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import programs.NumberBaseConverter;

/* Space to write unit tests. */

public class Tests {

	@Test
	public void testZero() {
		NumberBaseConverter converter = new NumberBaseConverter();
		
		assertEquals(converter.convert(0, 2), converter.convert(0, 10));
	}
	
	/* Write more tests! */
}
