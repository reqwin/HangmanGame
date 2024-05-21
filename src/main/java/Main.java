import java.util.Scanner;


enum Level{
    EASY,
    MEDIUM,
    HARD
        }


public class Main {
    static final Scanner sc = new Scanner (System.in);
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        Level level = menu.start();
        new StartGame(level).gameloop();
    }
}
