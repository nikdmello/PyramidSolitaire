/**
 * An interaction with the user consists of some input to send the program
 * and some output to expect.
 */
public interface Interaction {
  void apply(StringBuilder in, StringBuilder out);
}
