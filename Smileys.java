
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String characterString) {
        int characterLength;
        if (!isEven(characterString)) { 
            characterLength = characterString.length() + 1; 
        } else {
            characterLength = characterString.length();
        }
        printLineOfSmileys(characterLength + 2);
        if (isEven(characterString)) {
            System.out.println(":) " + characterString + " :)");
        } else {
            System.out.println(":) " + characterString + "  :)");
        }
        printLineOfSmileys(characterLength + 2);
    }
    
    private static void printLineOfSmileys(int length) {
        for (int i = 0; i < length/2 + 2; i++) {
            System.out.print(":)");
        }
        System.out.println("");
    }
    
    private static boolean isEven(String characterString) {
        return (characterString.length() % 2) == 0;
    }

}
