import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {

	//@BeforeEach
	void setUp() throws Exception {
		
	}

	//@AfterEach
	void tearDown() throws Exception {
	}

	//@Test
	void test() {
		double[][] dataSet1 = {{1,2,3},
				{4,5},
				{6,7,8,9}};
		assertEquals(5.0,TwoDimRaggedArrayUtility.getAverage(dataSet1),0.01);
		assertEquals(45.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),0.01);
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),0.01);
	}

}