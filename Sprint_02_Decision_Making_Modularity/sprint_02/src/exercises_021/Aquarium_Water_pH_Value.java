package exercises_021;

import java.util.Scanner;

public class Aquarium_Water_pH_Value {

	public static String WaterChange(int value) {
		if (value < 7) {
			return "pH value is low,partial water change required";
		} else if (value >= 7 && value <= 8) {
			return "pH value is fine";
		} else {
			return "pH value is high,partial water change required";
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter phLevel: ");
		int value = scanner.nextInt();

		String result = WaterChange(value);
		System.out.println(result);

		scanner.close();
	}
}
