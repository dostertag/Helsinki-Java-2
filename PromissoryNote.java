
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class PromissoryNote {
    
    private HashMap<String, Double> note;
    
    public PromissoryNote() {
        this.note = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double value) {
        if (!this.note.containsValue(value)) {
            this.note.put(toWhom, value);
        } else {
            System.out.println("This person already owes!!!");
        }
    }
    
    public double howMuchIsTheDebt(String whose) {
        if (this.note.containsKey(whose)) {
            return this.note.get(whose);
        }
        return 0;
    }
    
}

public class Main {
    public static void main(String[] args) {
        // Test your program here
          PromissoryNote mattisNote = new PromissoryNote();
            mattisNote.setLoan("Arto", 51.5);
            mattisNote.setLoan("Mikael", 30);

            System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
            System.out.println(mattisNote.howMuchIsTheDebt("Joel"));
    }
}
