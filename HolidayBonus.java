/*
 Class: CMSC203 
 Program: Assignment # 5
 Instructor: Ashique Tanveer
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 */

/**
 * @author Harlene Kaur
 */
public class HolidayBonus {
	/**
	 * Calculates the holiday bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {

		double bonus[] = new double[data.length];

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
				double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);

				if (data[row][col] > 0) {
					if (data[row][col] == highest) {
						bonus[row] += high;
					} else if (data[row][col] == lowest) {
						bonus[row] += low;
					} else {
						bonus[row] += other;
					}

				}
			}
		}

		return bonus;
	}

	/**
	 * Calculates the total holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {

		double[] bonus = calculateHolidayBonus(data, high, low, other);

		double sum = 0;

		for (int i = 0; i < bonus.length; i++) {
			sum += bonus[i];
		}

		return sum;
	}

}