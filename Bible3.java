package bibleHW3;
import java.lang.Math;
public class Bible3 {

	public static void main(String[] args) {
		long[] people = new long[73];
		people[18] = 7700000000L;
		
		System.out.println("It took " + years(people) + " years to convert the whole world.");
	}

	public static int years(long[] people) {
		long[] numofDisciples = new long[people.length];
		int year = 0;
		numofDisciples[18] = 13;
		while(!allConverted(people, numofDisciples) && (year < 5000000000L)) {
			year++;
			
			//age everyone a year
			for(int n = people.length - 1; n > 0; n--) {
				people[n] = people[n - 1];
				numofDisciples[n] = numofDisciples[n - 1];
			}
			people[0] = 0;
			numofDisciples[0] = 0;
			//convert people
			long disciples = totalConverted(numofDisciples);
			if(disciples == 0) {
				System.out.println("Outta Gas");
				break;
			}
			long numToConvert = (long)(disciples * 2 * .001);
			int age = 18;
			if(year % 3 == 0) {
				while(numToConvert > 0 && age < 73) {
					long available = people[age] - numofDisciples[age];
					if(numToConvert < available) {
						numofDisciples[age] = numToConvert + numofDisciples[age];
						numToConvert = 0;
					}else { 
						numofDisciples[age] = available + numofDisciples[age];
						numToConvert = numToConvert - available;
					}
					age++;
				}
			}	
			//have babies
			people[0] = people[30];
			//people fall away
			for(int j = 0; j < numofDisciples.length; j++) {
				numofDisciples[j] = Math.round(numofDisciples[j] - numofDisciples[j] * 0.01);
			}
		}
		
		return year;
	}
	public static boolean allConverted(long[] people, long[] numofDisciples) {
		long totalPeople = 0;
		long totalDisciples = 0;
		for(int i = 0; i < people.length; i++) {
			totalPeople = people[i] + totalPeople;
			totalDisciples = numofDisciples[i] + totalDisciples;
		}
		return(totalPeople == totalDisciples);
	}
	public static long totalConverted(long[] numofDisciples) {
		long totalConverted = 0;
		for(int i = 0; i < numofDisciples.length; i++) {
			totalConverted = numofDisciples[i] + totalConverted;
		}
		return totalConverted;
	}
}
		
//how old do you have to be to be converted?
//do disciples have a kid that are automatically a disciple?
//how do you choose what age group/generation you are converting?

//every person has one kid, so a couple has two kids
//youngest first
//18 to be converted
//not automatically a disciple
	


