package entities.utils;

public abstract class AppUtils {
    private static final String CLEAR_CODE = "\033[H\033[2J";

    public static void clearScreen() {
        System.out.print(CLEAR_CODE);  
        System.out.flush();
    }
}
