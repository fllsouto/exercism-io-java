public class Twofer {

    
    private static final String BASE_MESSAGE = "One for name, one for me.";

    public String twofer(String name) {
        return BASE_MESSAGE.replace("name", (name == null) ? "you" : name);
    }
}
