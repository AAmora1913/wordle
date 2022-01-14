import java.util.*;
import java.io.*;

public class wordle {
    public static void main(String[] args) throws IOException {

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

    for(int tries = 1; tries > 5; tries++){
        System.out.println("Try " + tries);
        System.out.println(correctLetters + " correct letters found");
        System.out.println("There are " + _allWords.size() + " possible words remaining");
        System.out.println("Enter your 5-letter word");
        String _guess = sc.next();

        System.out.println("Your guess was " + _guess);

        for (int i = 0; i < _guess.length(); i++) {
            System.out.println("Was " + _guess.charAt(i)  + "...");
            System.out.println("1. In the right slot");
            System.out.println("2. Present, but in the wrong slot");
            System.out.println("3. Not in the word");
            int result = sc.nextInt();

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

        System.out.println("Still in play:");
        for(String a : _allWords) {
            System.out.println(a);
		}
    }
  }
}
