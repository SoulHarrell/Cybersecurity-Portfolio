import java.util.ArrayList;
import java.util.HashSet;

public class RuleEngine {
    HashSet<String> alertedIps = new HashSet<>();
    
    public void analyze(ArrayList<LogEvent> events, AlertManager alertManager) {
        
        for (LogEvent event : events) {
            
            String ip = event.getIp();
            int count = 0;
            
            for (LogEvent other : events) {
                
                if (other.getIp().equals(ip)) {
                    count++;
                }
            }
            if (count >= 3 && !alertedIps.contains(ip)) {
                alertManager.sendAlert("Possible brute force from IP " + ip + " (" + count + " attempts)");
                
                alertedIps.add(ip);
            }
        }
    }
}
