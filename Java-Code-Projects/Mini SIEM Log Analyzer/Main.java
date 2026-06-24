import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== Mini SIEM Analyzer ===");
        
        LogParser parser = new LogParser();
        
        ArrayList<LogEvent> events = parser.parse("sample-auth.log");
        
        for (LogEvent event : events) {
            System.out.println(event.getIp());
        }
        
        RuleEngine engine = new RuleEngine();
        AlertManager alertManager = new AlertManager();
        
        engine.analyze(events, alertManager);
    }
}
