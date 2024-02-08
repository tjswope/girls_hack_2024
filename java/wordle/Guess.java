import java.awt.Color;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Guess {
	private String guess;
	private String[] wordlist;

	public Guess() {
		// TODO Auto-generated constructor stub
		this.guess = "";
		List<String> lines = new ArrayList<String>();
		
		try {
			Scanner sc = new Scanner(new File("wordle-La.txt"));
			
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			String[] arr = lines.toArray(new String[0]);
			this.wordlist = arr;
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		

	}
	public Guess(char[] chars) {
		for(char a : chars) {					
			this.guess+=Character.toString(a); //here, the individual chars are concatenated into a word.	
		}

		try {
			Scanner sc = new Scanner(new File("wordle-La.txt"));
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			String[] arr = lines.toArray(new String[0]);
			this.wordlist = arr;
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}


	public boolean isWord() {
		for(String word: this.wordlist) {
			if(this.guess.equals(word))
				return true;
		}
		return false;
	}

	public String getGuess() {
		return this.guess;
	}

	public String[] getWordlist() {
		return this.wordlist;
	}

	public void setGuess(char[] chars) {
		this.guess = "";
		for(char a : chars) {					
			this.guess+=Character.toString(a); //here, the individual chars are concatenated into a word.	
		}
	}


}
