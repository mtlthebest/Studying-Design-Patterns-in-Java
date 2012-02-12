import parser.Parser;

public class Main {
    public static void main(String[] args) {
        String expression = "121 32 - 23 +";
        Parser p = new Parser(expression);
        System.out.println("'" + expression +"' equals " + p.evaluate());
    }
}
