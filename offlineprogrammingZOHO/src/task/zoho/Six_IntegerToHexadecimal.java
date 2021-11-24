package task.zoho;

import java.util.Scanner;

public class Six_IntegerToHexadecimal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : ");
		int decimal = sc.nextInt();

		String binary = decimalToBinary(decimal);
		if (decimal > 0)
			System.out.println("\nHexadecimal Equivalent of '" + decimal + "' is : '" + toHex(binary) + "'");
		else {
			 binary = complement(binary);
			 System.out.println("\nHexadecimal Equivalent of '"+decimal+"' is : '"+toHex(binary)+"'");
		}
		sc.close();
	}

	private static String complement(String binary) {

		for (int i = 0; i < binary.length(); i++)
			if (binary.charAt(i) == '1')
				binary = binary.substring(0, i) + "0" + binary.substring(i + 1);
			else
				binary = binary.substring(0, i) + "1" + binary.substring(i + 1);

		for (int i = binary.length() - 1; i >= 0; i--) {
			char c = binary.charAt(i);
			if (c == '1')
				binary = binary.substring(0, i) + "0" + binary.substring(i + 1);
			else if (c == '0') {
				binary = binary.substring(0, i) + "1" + binary.substring(i + 1);
				return binary;
			}
		}
		return binary;
	}

	private static String toHex(String str) {
		String hex = "";
		Integer value = 8, sum = 0;

		for (int i = 0; i < str.length(); i++) {

			if ((i + 1) % 4 == 0) {
				sum = sum + (value * (str.charAt(i) - '0'));
				hex += hexCode(sum.toString());
				sum = 0;
				value = 8;
			} else {
				sum = sum + (value * (str.charAt(i) - '0'));
				value = value / 2;
			}
		}
		return hex;
	}

	private static String decimalToBinary(int decimal) {

		if (decimal < 0)
			decimal = decimal * -1;

		StringBuilder binary = new StringBuilder();
		while (decimal > 0) {
			binary.append(((decimal & 1) > 0) ? "1" : "0");
			decimal = decimal >> 1;
		}

		String str = binary.reverse().toString();

		if (str.length() % 4 == 0)
			return str;

		for (int i = 0; i <= (str.length() % 4); i++)
			str = "0" + str;

		return str;
	}

	private static String hexCode(String code) {

		Integer n = Integer.parseInt(code);
		if (n < 10)
			return n.toString();
		else if (n == 10)
			return "A";
		else if (n == 11)
			return "B";
		else if (n == 12)
			return "C";
		else if (n == 13)
			return "D";
		else if (n == 14)
			return "E";
		else if (n == 15)
			return "F";
		return "";
	}
}
