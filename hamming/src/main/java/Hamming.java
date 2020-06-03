import java.util.stream.IntStream;

public class Hamming {
  
  private final String leftStrand;
  private final String rightStrand;

  public Hamming(String leftStrand, String rightStrand) {

    validateStrands(leftStrand, rightStrand);

    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;
  }

  public int getHammingDistance() {
    if (leftStrand.equals(rightStrand)) return 0;

    //return naiveSolution();
    return functionalSolution();
  }
  
  private int naiveSolution() {
    int hammingDif = 0;
    for (int i = 0; i < leftStrand.length(); i++) {
      if (leftStrand.charAt(i) != rightStrand.charAt(i))
        hammingDif++;
    }

    return hammingDif;
  }

  private int functionalSolution() {

    return IntStream
      .range(0, leftStrand.length())
      .map(i -> leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0)
      .sum();
  }

  private validateStrands(String leftStrand, String rightStrand) {
    validate(leftStrand, "left");
    validate(rightStrand, "right");
    verifyLength(leftStrand, rightStrand);

  }

  private void validate(String strand, String position) {
    if (strand == null) throw new 
      IllegalArgumentException(position + " strand must not be null.");
  }

  private void verifyLength(String leftStrand, String rightStrand) {
    if (leftStrand.length() != rightStrand.length()) {
      
      if (leftStrand.length() == 0)
        throw new IllegalArgumentException("left strand must not be empty.");

      if (rightStrand.length() == 0)
        throw new IllegalArgumentException("right strand must not be empty.");

      throw new IllegalArgumentException("left strand and right strand must be of equal length.");
    } 
  }

}