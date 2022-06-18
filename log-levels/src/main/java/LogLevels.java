import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {

    private static final String REGEX = "\\[(?<level>[A-Z]+)\\]\\:\\s+(?<message>.+)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    
    public static String message(String logLine) {
        return matches(logLine).group("message").trim();
    }

    public static String logLevel(String logLine) {
        return matches(logLine).group("level").toLowerCase();
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }

    private static Matcher matches(String logLine) {
        var matcher = PATTERN.matcher(logLine);
        matcher.find();
        return matcher;
    }
}
