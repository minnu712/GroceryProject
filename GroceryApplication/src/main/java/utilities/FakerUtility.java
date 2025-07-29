package utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Color;
import com.github.javafaker.Company;
import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.github.javafaker.Number;

public class FakerUtility {
	Faker faker = new Faker();
	public String generateName() {
		return faker.name().firstName();
	}
   public String  generateAddress() {
	  return  faker.address().cityName();
   }
   
   public String generatephonenumber() {
	 return  faker.number().toString();
   }
   
   public String generateplace() {
	   return faker.address().city();
   }
   
   public String generateEmail() {
	return  faker.internet().emailAddress();
	   
   }
    public IdNumber generateId() {
    	return  faker.idNumber();
   }
    
    public Company generateCompany() {
    	return faker.company();
    }
    public Country generateCountry() {
    	return faker.country();
    }
}
