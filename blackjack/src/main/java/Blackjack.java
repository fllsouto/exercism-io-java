import java.util.Map;
import java.util.stream.Stream;

public class Blackjack {

    private static final int LARGE_HAND_SCORE = 20;
    private static final int LARGE_HAND_DEALER_LOSE_SCORE = 10;
    private static final int SMALL_HAND_DEALER_STAND_SCORE = 7;
    private static final int SMALL_HAND_LOW_SCORE = 11;
    private static final int SMALL_HAND_HIGH_SCORE = 17;
    private static final int BLACKJACK_SCORE = 21;
    private static Map<String, Integer> cardDeck = initializeCardDeck();

    public int parseCard(String card) {
        return Blackjack.cardDeck.getOrDefault(card, 0);
    }

    public boolean isBlackjack(String card1, String card2) {
        return Stream.of(card1, card2).mapToInt(this::parseCard)
            .sum() == BLACKJACK_SCORE;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (!isBlackjack)
            return Option.SPLIT.code;

        if (dealerScore < LARGE_HAND_DEALER_LOSE_SCORE)
            return Option.WIN.code;
        
        return Option.STAND.code;    
    }

    public String smallHand(int handScore, int dealerScore) {
        if (handScore >= SMALL_HAND_HIGH_SCORE)
            return Option.STAND.code;
        
        if (handScore <= SMALL_HAND_LOW_SCORE)
            return Option.HIT.code;
        
        return (dealerScore < SMALL_HAND_DEALER_STAND_SCORE) ? Option.STAND.code : Option.HIT.code;
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (handScore > LARGE_HAND_SCORE) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }

    private static Map<String, Integer> initializeCardDeck() {
        return Map.ofEntries(
            Map.entry("ace", 11),   
            Map.entry("two", 2),   
            Map.entry("three", 3),   
            Map.entry("four", 4),   
            Map.entry("five", 5),   
            Map.entry("six", 6),   
            Map.entry("seven", 7),   
            Map.entry("eight", 8),   
            Map.entry("nine", 9),   
            Map.entry("ten", 10),   
            Map.entry("jack", 10),   
            Map.entry("queen", 10),   
            Map.entry("king", 10)
        );
    }

    private enum Option {
        STAND("S"),
        HIT("H"),
        SPLIT("P"),
        WIN("W");

        private final String code;

        Option(String code) {
            this.code = code;
        }
    }
}
