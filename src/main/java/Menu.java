public class Menu {
    public Level start() {
    String menu = "Приветствую в игре Висилица ! " +
                "\n Напиши: " +
                "\n \"GO\", чтобы начать ;" +
                "\n \"HELP\", чтобы прочитать правила игры ;" +
                "\n \"EXIT\" для выхода из игры.";
    System.out.println(menu);
        while(true) {
            switch (Main.sc.nextLine().toUpperCase())
            {
                case ("GO"):
                    System.out.println("Игра началась. Выберите сложность : \n" + "1 - EASY \n" + "2 - MEDIUM \n" + "3 - HARD \n" + "EXIT - ВЫХОД ИЗ ИГРЫ");
                    return (changeLevel());
                case ("EXIT"):
                    System.exit(0);
                case ("HELP"):
                    System.out.println("Программа загадывает слово. Вам необходимо, отгадывая буквы, разгадать всё слово. " +
                            "Вы можете совершить не более:\n" + "EASY   - 8 неудачных попыток \n" + "MEDIUM - 7 неудачных попыток \n" + "HARD   - 6 неудачных попыток \n");
                    System.out.println("Введите одно из значений GO/HELP/EXIT");
                    break;
                default:
                    System.out.println("Неверно. Введите одно из значений GO/HELP/EXIT");
            }
        }
    }

    private Level changeLevel()
    {
        while(true) {
            switch (Main.sc.nextLine().toUpperCase()) {
                case ("1"):
                    return Level.EASY;
                case ("2"):
                    return Level.MEDIUM;
                case ("3"):
                    return Level.HARD;
                case ("EXIT"):
                    System.exit(0);
                default:
                    System.out.println("Неверно. Введите одно из значений 1(EASY)/2(MEDIUM)/3(HARD)/EXIT");
            }
        }
    }
}
