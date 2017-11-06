
public class Main {

    public static void main(String[] args) {
        // write test code here
        String hello = "24:41:16";
        if (clockTime(hello)) {
            System.out.println("The form is fine.");
        } else {
            System.out.println("The form is wrong.");
        }
    }
    
    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    public static boolean allVowels(String string) {
        return string.matches("[aeiouäö]*");
    }
    public static boolean clockTime(String string) {
        return string.matches("([0-1][0-9]|2[0-3])(:[0-5][0-9]){2}");
        // ([0-2][0-9](:[0-5][0-5]{2})    [0-2][0-9](:[0-5][0-9]){2}  
    }
}
