import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class StartGame {

    private int maxUserError;
    private int minWordLength;
    private int maxWordLength;
    private StageOfGame view_stageofhangman;

    StartGame(Level level){
        view_stageofhangman = new StageOfGame();
        if (level == Level.EASY)
        {
            maxUserError = 8;
            minWordLength = 3;
            maxWordLength = 7;
        }

        if (level == Level.MEDIUM)
        {
            maxUserError = 7;
            minWordLength = 6;
            maxWordLength = 10;
        }

        if (level == Level.HARD)
        {
            maxUserError = 6;
            minWordLength = 9;
            maxWordLength = 100;
        }
    }

    public void gameloop() throws Exception {
        int countUserError = 0;
        String wrongUserLetters = "";
        String secretWord = new Load_Word().getWord(minWordLength, maxWordLength);
        char[] playerWord = new char[secretWord.length()];
        String symbolMaskedLetter = "-";
        Arrays.fill(playerWord, symbolMaskedLetter.charAt(0));
        String letter; //вводимый символ
        boolean include;
        while(countUserError <= maxUserError && String.valueOf(playerWord).contains("-"))  //основной игровой цикл
        {
            PrintImage(playerWord, countUserError, wrongUserLetters);
            include = false;

            letter = String.valueOf(Main.sc.next()).toLowerCase();
            CheckforExit(letter);
            letter = String.valueOf(letter.charAt(0));

            if(letter.charAt(0) >= 'а' && letter.charAt(0) <= 'я' && !wrongUserLetters.contains(letter) && !String.valueOf(playerWord).contains(letter))
            {
                for(int i = 0; i < secretWord.length(); i++)
                {
                    if(secretWord.charAt(i) == letter.charAt(0))
                    {
                        include = true;
                        playerWord[i] = letter.charAt(0);
                    }
                }

                if(!include)
                {
                    wrongUserLetters += letter;
                    countUserError++;
                }
            }else {
                if(!(letter.charAt(0) >= 'а' && letter.charAt(0) <= 'я')) {
                    System.out.println("Введите букву от \"А\" до \"Я\" !");
                } else if(wrongUserLetters.contains(letter) || String.valueOf(playerWord).contains(letter))
                {
                    System.out.println("Буква уже была !");
                }
            }

        }

        if(countUserError >  maxUserError)
        {
            System.out.println("Вы проиграли ! Загаданное слово " + "*" + secretWord + "*");
        }else {
            System.out.println("Вы выиграли !");
        }


    }

    public void PrintImage(char[] playerWord, int countUserError, String wrongUserLetters){
        System.out.println("");
        System.out.println(playerWord);
        System.out.println("Количество ошибок: " + countUserError);
        if(countUserError == maxUserError){System.out.println("В случае ещё одной ошибки вы проиграете !");}
        System.out.printf("Ошибочные буквы: ");
        for(char c : wrongUserLetters.toCharArray()) {
            System.out.printf(c + " ");
        }
        System.out.println("");
        if(countUserError != 0) {
            System.out.println(view_stageofhangman.hangman[countUserError-1]);
        }
    }

    public void CheckforExit(String letter) {
        if(letter.equals("exit")){
            System.exit(0);
        }
    }
}

class Load_Word {
    private List<String> ListWord;
    private final String filename = "\\russian_nouns.txt";
    private void Download_to_ListWord() throws Exception {
        ListWord = new BufferedReader(new FileReader(new File(filename))).lines().toList();
    }

    public String getWord(int min, int max) throws Exception {
        this.Download_to_ListWord();
        String word;
        while(true){
            word = ListWord.get(new Random().nextInt(ListWord.size())).toLowerCase();
            if(word.length() >= min && word.length() <= max && !(word.contains("-")))
                break;
        }
        return word;
    }
}
