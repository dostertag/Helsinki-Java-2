public interface NationalService {
    int getDaysLeft();
    void work();
}


public class CivilService implements NationalService {
    
    private int daysLeft;
    public CivilService() {
        this.daysLeft = 362;
    }
    
    public int getDaysLeft() {
        return this.daysLeft;
    }
    
    public void work() {
        if (this.daysLeft > 0) {
            this.daysLeft--;
        } else {
            this.daysLeft = 0;
        }
    }
    
    
}


public class MilitaryService implements NationalService {
    private int daysLeft;
    
    public MilitaryService(int daysLeft) {
        if (daysLeft >= 0) {
            this.daysLeft = daysLeft;
        } else {
            this.daysLeft = 0;
        }
    }
    
    public void work() {
        if (this.daysLeft > 0) {
            this.daysLeft--;
        } else {
            this.daysLeft = 0;
        }
    }
    
    public int getDaysLeft() {
        return this.daysLeft;
    }
}
