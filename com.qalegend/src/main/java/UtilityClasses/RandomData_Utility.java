package UtilityClasses;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class RandomData_Utility {

	private static final Faker faker = new Faker();
	private static final Faker faker1 = new Faker(new Locale("en-IND"));

	public static String getNewUserFullName() {
		
		return faker1.name().fullName();

	}
	
	public static String getUsername() {
		return faker.name().username();

	}
	
	public static String getRandomEmail() {
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
	
	public static String getPassword() {
		return faker.internet().password();
		
	}
	
	public static String getProductName() {
		return faker.commerce().productName();
		
	}
	
	public static String getProductAlertQuantity() {
		int a = faker.number().numberBetween(1, 130);
		return String.valueOf(a);
		
	}
	public static String getExpirirngPeriod() {
	 int b=	 faker.number().numberBetween(1, 24);
		 return	String.valueOf(b)	;
		
	}
	
	public static String getExactTax() {
		int c=faker.number().numberBetween(1, 100);
		return String.valueOf(c);
	}
	
	
	
	
	
	
	
	
	

}
