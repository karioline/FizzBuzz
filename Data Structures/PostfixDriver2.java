public class PostfixDriver2 {
 public static void main(String[] args) {
 System.out.println("Testing postfix expressions with\n" +
 "a = 2.0, b = 3.0, c = 4.0, d = 5.0\n");
 testPostfix("a+b");
 testPostfix("a-b+c*d");
 testPostfix("(a+b)*c-d");
 testPostfix("a+b*(c-d)");
 testPostfix("(a+b)/(c-d)");
 testPostfix("a*(b/(c-d))");
 } // end main

 public static void testPostfix(String infixExpression) {
 String postfixExpression = Postfix.convertToPostfix(infixExpression);
 System.out.println("Infix: " + infixExpression);
 System.out.println("Postfix: " + postfixExpression);
 System.out.println("Value: " + Postfix.evaluatePostfix(postfixExpression));
 System.out.println();
 } // end testPostfix
} // end PostfixDriver
