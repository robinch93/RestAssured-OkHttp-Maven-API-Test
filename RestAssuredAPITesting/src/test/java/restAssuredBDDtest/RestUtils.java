package restAssuredBDDtest;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random; 

public class RestUtils {

	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Usain" + generatedString);
	}
	
	public static String getLastName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Bolt" + generatedString);
	}
	
	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("usain" + generatedString);
	}
	
	public static String getPassword() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("bolt" + generatedString);
	}
	
	public static String getEmail() {
		String generatedString = RandomStringUtils.randomNumeric(1);
		return ("usain" + generatedString + "bolt" + "@gmail.com");
	}
	
	public static String getEmpName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Usain" + generatedString);
	}
	
	public static String getEmpSal() {
		String generatedString = RandomStringUtils.randomNumeric(4);
		return (generatedString);
	}
	
	public static String getEmpAge() {
		String generatedString = RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}

	public static String getEmpCity() {
		final String[] city_names = {"Munich", "Berlin", "Milan", "Brussels", "Zurich"};
		Random random = new Random();
		int index = random.nextInt(city_names.length);
		return city_names[index];
	}

}
