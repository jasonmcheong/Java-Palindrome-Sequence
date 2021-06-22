package app;
/**
 * 
 * The App program class is the entry point for our application.
 * 
 * @author Jason Cheong
 * @version 1.0
 * @since 2021-06-20
 */
public class App {
    /**
     * Main method that calls the primary Palindrome method to find the nearest
     * palindrome from a given string of integers
     * @param args           Unused
     * @exception Exception  Throws exception if anything goes wrong
     */
    public static void main(String[] args) throws Exception {
        String result = Palindrome.findNearest("2003");
        System.out.println(result);
    }
}
