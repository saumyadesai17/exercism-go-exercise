public class LogLevels {
    
    public static String message(String logLine) {
        int colonIndex = logLine.indexOf(":");
        String message = logLine.substring(colonIndex+1);
        return message.trim();
    }

    public static String logLevel(String logLine) {
        int startIdx = logLine.indexOf("[");
        int endIdx = logLine.indexOf("]");
        return logLine.substring(startIdx+1, endIdx).toLowerCase();
    }

    public static String reformat(String logLine) {
        String message = message(logLine);
        String logLevel = logLevel(logLine);
        return message + " (" + logLevel + ")";
    }
}
