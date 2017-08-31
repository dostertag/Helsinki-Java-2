
import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations requested in the assignment here!
        HashMap<String, String> thisMap = new HashMap<String, String>();
        
        thisMap.put("matti", "mage");
        thisMap.put("mikael", "mixu");
        thisMap.put("arto", "arppa");
        
        System.out.println(thisMap.get("mikael"));
        
    }

}
