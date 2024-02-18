import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestingExampleTest {
	@BeforeAll
	static void setUpBeforeClass()  {
		TestingExample obj = new TestingExample();
	}
	
	
	 @Test
	    void testNegativeExpenditure() {
	        assertEquals("The function should give -1 in this situation",-1, TestingExample.RewardPoints(-50, 100));
	    }

	    @Test
	    void testNegativeCreditLimit() {
	        assertEquals("The function should give -1 in this situation",-1, TestingExample.RewardPoints(50, -100));
	    }

	    @Test
	    void testBothNegative() {
	        assertEquals("The function should give -1 in this situation",-1, TestingExample.RewardPoints(-50, -100));
	    }

	    @Test
	    void testExpenditureLessThanCreditLimit() {
	        assertEquals("The function should give -1 in this situation",-1, TestingExample.RewardPoints(50, 100));
	    }

	    @Test
	    void testWithinLimitNoPoints() {
	        assertEquals("The function should give 0 points in this situation",0, TestingExample.RewardPoints(100, 100));
	    }

	    @Test
	    void test100To299Points() {
	        assertEquals("The function should give 100 points in this situation",100, TestingExample.RewardPoints(200, 100));
	    }

	    @Test
	    void test300To499Points() {
	        assertEquals("The function should give 600 points in this situation",600, TestingExample.RewardPoints(400, 100));
	    }

	    @Test
	    void test500OrMorePoints() {
	        assertEquals("The function should give 1800 points in this situation",1800, TestingExample.RewardPoints(1100, 500));
	    }
	
	
}
