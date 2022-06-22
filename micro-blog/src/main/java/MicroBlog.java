class MicroBlog {
    private static final int MAX_CHARACTERS = 5;

    public String truncate(String input) {
        return input
            .codePoints()
            .limit(MAX_CHARACTERS)
            .collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append
            ).toString();
    }
}
