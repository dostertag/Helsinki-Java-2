
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class FileManager {
    private File file;
    private Scanner input;

    public List<String> read(String file) throws FileNotFoundException {
        List<String> returnList = new ArrayList<String>();
        this.file = new File(file);
        this.input = new Scanner(this.file);
        while(input.hasNextLine()) {
            returnList.add(input.nextLine());
        }
        return returnList;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        String joinedList = String.join("\n", texts);
        FileWriter writer = new FileWriter(file);
        writer.write(joinedList);
        writer.close();
    }

}
