package ch.rgw.rpg;

import java.util.Date;
import java.util.Random;

public class Generator {
	private Namen names = new Namen();
	private Lipsum lipsum = new Lipsum();
	private Random rand=new Random();

	public String getRandomFirstname(){
		return names.getRandomVorname();
	}
	
	public String getRandomLastname(){
		return names.getRandomNachname();
	}
	
	public String getLipsumSentence(){
		return lipsum.getSentence();
	}
	
	public String getLipsumParagraph(){
		return lipsum.getParagraph();
	}
	
	public String getRandomBirthdate() {
		int year = (int) (rand.nextInt(99) + 1915); // born between 1015 and
														// 2015
		int month = (int) (rand.nextInt(11) + 1);
		int day = (int) (rand.nextInt(27) + 1); // keep things simple
		StringBuilder ret = new StringBuilder();
		ret.append(year)

		.append(String.format("%02d", month)).append(String.format("%02d", day));
		return ret.toString();
	}
	
	public Date getRandomDate(){
		int fiveYears=365*5*24*3600;
		long now=System.currentTimeMillis()/1000;
		long from=now-fiveYears;
		long randomDate=(from+rand.nextInt(fiveYears))*1000;
		return new Date(randomDate);
	}
	
	public String getRandomPhoneNumber() {
		StringBuilder ret = new StringBuilder();
		ret.append("555-");
		for (int i = 0; i < 7; i++) {
			ret.append((char) Math.round(Math.random() * ('9' - '0') + '0'));
		}
		return ret.toString();
	}

	public String getRandomCharSequence(int minlen, int maxlen) {
		int l = (int) Math.round(rand.nextInt(maxlen)+minlen);
		StringBuilder ret = new StringBuilder();
		ret.append(Character.toUpperCase(getRandomLetter()));
		for (int i = 0; i < l; i++) {
			ret.append(getRandomLetter());
		}
		return ret.toString();
	}

	public char getRandomLetter() {
		return (char) Math.round(Math.random() * ('z' - 'a') + 'a');
	}

	public String getRandomStreet() {
		final String[] streets={"strasse","gasse","weg","rank","buck"};
		String[] chopped=lipsum.getParagraph().split("[,\\.\\?\\!\\s]+");
		int idx=new Random().nextInt(chopped.length);
		String suffix=streets[rand.nextInt(streets.length)];
		return chopped[idx]+suffix+" "+Integer.toString(rand.nextInt(137)+1);
	}
	
	public String getRandomZip(){
		return Integer.toString(rand.nextInt(9999)+1000);
	}
	
	public String getRandomCity(){
		final String[] suffices={"","wil","ingen","tann","berg","tal","wilen","iggen","hausen"};
		String[] chopped=lipsum.getParagraph().split("[,\\.\\?\\!\\s]+");
		int idx=new Random().nextInt(chopped.length);
		String suffix=suffices[rand.nextInt(suffices.length)];
		return chopped[idx]+suffix;
	}

	public int getRandomNumber(int lower, int upper){
		return rand.nextInt(upper-lower)+lower;
	}
}
