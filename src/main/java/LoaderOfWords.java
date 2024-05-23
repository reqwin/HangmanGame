import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

class LoaderOfWords {
    private final String fileName = "\\russian_nouns.txt";

    public String getWord(int min, int max) throws Exception {
        List<String> listWord = new BufferedReader(new FileReader(new File(fileName))).lines().toList();
        String word;
        while(true){
            word = listWord.get(new Random().nextInt(listWord.size())).toLowerCase();
            if(word.length() >= min && word.length() <= max && !(word.contains("-")))
                break;
        }
        return word;
    }
}