import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LogParser {
    
    public ArrayList<LogEvent> parse(String fileName) {
        
        ArrayList<LogEvent> events = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            
            while (scanner.hasNextLine()) {
                
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String ip = parts[parts.length - 1];
                LogEvent event = new LogEvent(ip, line);
                
                events.add(event);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return events;
    }
}
