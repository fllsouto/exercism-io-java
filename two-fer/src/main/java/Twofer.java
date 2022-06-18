import java.util.Optional;

public class Twofer {
    
    private static final String BASE_MESSAGE = "One for %s, one for me.";

    public String twofer(String name) {
        return String.format(BASE_MESSAGE, Optional.ofNullable(name).orElse("you"));
    }
}
