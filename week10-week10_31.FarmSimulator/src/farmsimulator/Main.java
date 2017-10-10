package farmsimulator;

public class Main {
    public static void main(String[] args) {
        // Test your program here
        BulkTank tank = new BulkTank();
        Farm tila = new Farm("pekka", new Barn( tank ));
        tila.installMilkingRobot( new MilkingRobot() );
        tila.addCow( new Cow("Lehmä 1") );
        tila.addCow( new Cow("Lehmä 2") );
        tila.addCow( new Cow("Lehmä 3") );
        tila.addCow( new Cow("Lehmä 4") );
        tila.addCow( new Cow("Lehmä 5") );
        tila.liveHour();
        tila.manageCows();
        System.out.println(tank.getVolume());
    }
}
