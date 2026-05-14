public class LogLine {
    private String logline;
    
    public LogLine(String logLine) {
        this.logline = logLine;
    }

    public LogLevel getLogLevel() {
        String shortForm = logline.substring(1, 4);

        switch (shortForm) {
            case "TRC":
                return LogLevel.TRACE;
            case "DBG":
                return LogLevel.DEBUG;
            case "INF":
                return LogLevel.INFO;
            case "WRN":
                return LogLevel.WARNING;
            case "ERR":
                return LogLevel.ERROR;
            case "FTL":
                return LogLevel.FATAL;
        }
        return LogLevel.UNKNOWN;
    }

    public String getOutputForShortLog() {
        LogLevel level = this.getLogLevel();
        String message = logline.substring(7);
        return level.getLevel() + ":" + message;
    }
}
