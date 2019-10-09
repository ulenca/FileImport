package main;

public class DataMiner {

	public static void main(String[] args) {
		
		DataMiner raportAboutPeople = new DataMiner();

		System.out.println("Number of people equals" 
				+ raportAboutPeople.countPeople());
		
		System.out.println("Data of the oldest person with phone number" 
				+ raportAboutPeople.findTheOldersPersonWithPhoneNumber().toString());

	}

	public int countPeople() {
		
		return 0;
		
	}
	
	public Person findTheOldersPersonWithPhoneNumber() {
	
		return null;
		
	}
	
}
