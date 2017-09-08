public interface ToBeStored {
    double weight();
}

public class CD implements ToBeStored {
    private String writer;
    private String name;
    private int publishingYear;
    
    public CD(String writer, String name, int publishingYear) {
        this.writer = writer;
        this.name = name;
        this.publishingYear = publishingYear;
    }
    
    public double weight() {
        return 0.1;
    }
    @Override
    public String toString() {
        return this.writer +": " + this.name + " (" + this.publishingYear + ")";
    }
}

public class Book implements ToBeStored {
    private String writer;
    private String name;
    private double weight;
    
    public Book(String writer, String name, double weight) {
        this.writer = writer;
        this.name = name;
        this.weight = (double)weight;
    }
    
    public double weight() {
        return this.weight;
    }
    @Override
    public String toString() {
        return this.writer + ": " + this.name;
    }
}

public class Box implements ToBeStored {
    private ArrayList<ToBeStored> boxItems;
    private double maximumWeight;
    
    public Box(double maximumWeight) {
        this.boxItems = new ArrayList<ToBeStored>();
        this.maximumWeight = maximumWeight;
    }
    
    public double weight() {
        double totalWeight = 0.0;
        for (ToBeStored tbs : this.boxItems) {
            totalWeight += tbs.weight();
        }
        return totalWeight;
    }
    
    public void add(ToBeStored storeThis) {
        if (this.weight() + storeThis.weight() < this.maximumWeight) {
            this.boxItems.add(storeThis);
        }
    }
    @Override
    public String toString() {
        // double temp = this.weight();
        return "Box: "  + this.boxItems.size() + " things, total weight " + this.weight() + " kg";
    }
    
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Box box = new Box(10);

        box.add( new Book("Fedor Dostojevski", "Crime and Punishment", 2) ) ;
        box.add( new Book("Robert Martin", "Clean Code", 1) );
        box.add( new Book("Kent Beck", "Test Driven Development", 0.7) );

        box.add( new CD("Pink Floyd", "Dark Side of the Moon", 1973) );
        box.add( new CD("Wigwam", "Nuclear Nightclub", 1975) );
        box.add( new CD("Rendezvous Park", "Closer to Being Here", 2012) );

        System.out.println( box );
    }
    
}
