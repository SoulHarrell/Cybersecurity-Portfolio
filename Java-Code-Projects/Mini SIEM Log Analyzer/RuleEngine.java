import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RuleEngine {

    private HashSet<String> alertedIps = new HashSet<>();

    public void analyze(ArrayList<LogEvent> events, AlertManager alertManager) {

        HashMap<String, Integer> ipCounts = new HashMap<>();

        for (LogEvent event : events) {
            String ip = event.getIp();
            ipCounts.put(ip, ipCounts.getOrDefault(ip, 0) + 1);
        }

        for (String ip : ipCounts.keySet()) {
            int count = ipCounts.get(ip);

            if (count >= 3 && !alertedIps.contains(ip)) {
                alertManager.sendAlert(
                    "Possible brute force from IP " + ip + " (" + count + " attempts)"
                );

                alertedIps.add(ip);
            }
        }
    }
}
