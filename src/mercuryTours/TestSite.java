package mercuryTours;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class TestSite {
	@Test
	public void testRegister() {
		AssertJUnit.assertTrue("Passed",TestRegister.testPage());
	}
	
	@Test
	public void testSignIn() {
		AssertJUnit.assertTrue("Passed",TestSignIn.testPage());
	}
	
	@Test
	public void testFlightFinderRoundTrip() {
		AssertJUnit.assertTrue("Passed",TestFlightFinderRoundTrip.testPage());
	}
	
	@Test 
	public void testFlightFinderOneWay() {
		AssertJUnit.assertTrue("Passed",TestFlightFinderOneWay.testPage());
	}
}
