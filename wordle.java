import java.util.*;
import java.io.*;

/* Code to cheat at wordle by taking a dictionary of 5-letter words and culling it based on which guesses were correct */
public class wordle {
    public static void main(String[] args) throws IOException {

    /* Read in the dictionary from wordle_words.txt */
    String wordsFile = "wordle_words.txt";
    File _source = new File(wordsFile);
    BufferedReader br = new BufferedReader(new FileReader(_source));
    ArrayList<String> _allWords = new ArrayList<String>();
    String _wordLine;
     
      while(((_wordLine = br.readLine()) != null)){
        String[] wordArray = _wordLine.split(" ");

        for(String a : wordArray) {
            _allWords.add(a);  
		}
	}

    int correctLetters = 0;
    Scanner sc = new Scanner(System.in);

    /*Loop for 5 tries. Note that there is no other exit method, Ctrl X to exit */
    for(int tries = 1; tries > 5; tries++){
        System.out.println("Try " + tries);
        System.out.println(correctLetters + " correct letters found");
        System.out.println("There are " + _allWords.size() + " possible words remaining");
        System.out.println("Enter your 5-letter word");

        /*Read in guess, must be in all caps */
        String _guess = sc.next();
        System.out.println("Your guess was " + _guess);

        /*Loop through the 5 characters*/
        for (int i = 0; i < _guess.length(); i++) {
            System.out.println("Was " + _guess.charAt(i)  + "...");
            System.out.println("1. In the right slot");
            System.out.println("2. Present, but in the wrong slot");
            System.out.println("3. Not in the word");
            int result = sc.nextInt();

            /*Letter was correct and in the right spot, remove all words where that letter is not placed in that particular spot */
            if(result == 1 ) {
                int dex = 0;
                while(dex < _allWords.size()) {
                    if(!(_allWords.get(dex).charAt(i) + "").equals(_guess.charAt(i) + "")) {
                        _allWords.remove(dex);
					}
                    else{
                        dex++;
					}
				}
			}
            /*Letter is in the word but in the wrong spot, remove all words where that letter is in, but not in that spot */
            else if(result == 2) {
                int dex = 0;
                while(dex < _allWords.size()) {

                    if(!(_allWords.get(dex).contains(_guess.charAt(i) + ""))) {
                        _allWords.remove(dex);

					}
                    else if ((_allWords.get(dex).charAt(i) + "").equals(_guess.charAt(i) + "")) {
                        _allWords.remove(dex);
					}
                    else{
                        dex++;

					}
				}
			}
            /*Letter is not in word, remove all words where that letter is present */
            else{
                int dex = 0;
                while(dex < _allWords.size()) {
                    if(_allWords.get(dex).contains(_guess.charAt(i) + "")) {
                        _allWords.remove(dex);
					}
                    else{
                        dex++;
					}
				}
			}
        }

        /*Display all words still possible */
        System.out.println("Still in play:");
        for(String a : _allWords) {
            System.out.println(a);
		}
    }
  }
}
