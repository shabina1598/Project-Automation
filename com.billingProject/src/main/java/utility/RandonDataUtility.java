
package utility;

import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class RandonDataUtility {
	
	 static Faker faker;
	 
	
	 public static String getName()
	 {
		 faker = new Faker(new Locale("en-IND"));
		 return faker.name().name();
		 
	 }
	 public static String getEmail_Utility() {

			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			int length = 5;
			for (int i = 0; i < length; i++) {
				int index = random.nextInt(alphabet.length());
				char randomChar = alphabet.charAt(index);
				sb.append(randomChar);
			}
			String randomStringEmail = sb.toString() + "@gmail.com";
			return randomStringEmail;

		}
	 public static String getFirstName()
	 {
		 faker = new Faker(new Locale("en-IND"));
		 return faker.name().firstName();
		 
	 }
	 public static String getLastName()
	 {
		 faker = new Faker(new Locale("en-IND"));
		 return faker.name().lastName();
		 
	 }
	 public static String getPrefix()
	 {
		 faker = new Faker();
		 return faker.name().prefix();
		 
	 }
	 public static String getPassword()
	 {
		 faker = new Faker();
		 return faker.internet().password(5,8);
		 
	 }
 
	 public static int getRandomRoleIndex() {
		    Faker faker = new Faker();
		    int totalOptions = 4; // Assume your dropdown has 4 options including the placeholder
		    return faker.number().numberBetween(1, totalOptions); // skip index 0 (usually "Select...")
		}
	 
	 public static  String getCustomerGroupName()
	 {
		 Faker faker = new Faker();
		 return faker.company().name()+ " Group";
		 
	 }
	 public static String getRandomPercentage() {
		    Faker faker = new Faker();
		    int percentage = faker.number().numberBetween(0, 101); // 0 to 100 inclusive
		    return percentage + "%";
		}
}
