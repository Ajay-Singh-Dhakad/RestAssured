package Demo;

import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Junit {

	@Before
	public void bt() {
		String Expected="Ajay";
		String Actual="Aman";
		Assert.assertEquals(Expected,Actual);
	}
	@Test
	public void tc() {
		System.out.println("Anurag");
	}
	@Test
	public void tc1() {
		System.out.println("Anuragggg");
	}
	@After
	public void at() {
		System.out.println("Anu");
	}
}
