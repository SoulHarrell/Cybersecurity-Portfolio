
public class LogEvent {
    
    private String ip;
    private String line;
    
    public LogEvent(String ip, String message) {
        this.ip = ip;
        this.line = message;
    }
    
    public String getIp() {
        return ip;
    }
    
    public String getMessage() {
        return line;
    }
}
