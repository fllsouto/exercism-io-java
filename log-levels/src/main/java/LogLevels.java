public class LogLevels {
    
    public static String message(String logLine) {
        String[] lineTokens = logLine.split(":");
        return lineTokens[1].trim();
    }

    public static String logLevel(String logLine) {
        String[] lineTokens = logLine.split(":");
        return lineTokens[0].substring(1, lineTokens[0].length() - 1).toLowerCase();
    }

    public static String reformat(String logLine) {
        String s = String.format("%s (%s)", message(logLine), logLevel(logLine));
        return s;
    }
}
