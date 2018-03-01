//Kari Shelton
//CMPS 390
//Assignment #2: Postfix.java
//Due 6/14/2017


public class Postfix {

 public static String convertToPostfix(String infix) {
  char item;
  ArrayStack operatorStack = new ArrayStack();
  String p = ""; //postfix expression
  char top;
  for(int j = 0; j < infix.length(); j++){
     item = infix.charAt(j);
     if (isVariable(item)){
        p = p+item;  //Append it to the postfix expression
     }else if (item == '('){
        operatorStack.push(item);
     }else if (item == ')'){
        top = (char)operatorStack.pop();
        while (top != '('){ // do not append '(' to postfix expression
           p = p+top;  //Append it to the postfix expression
           top = (char)operatorStack.pop(); //popping the next item on stack off and testing with while-loop's continuation condition
        }//end while-loop
     }else{ // item is an operator: '+', '-', '*', or '/'
        while (!operatorStack.isEmpty()){
           top = (char)operatorStack.peek();
           if (getPrecedence(item) <= getPrecedence(top)){ 
              p = p+top;   //Append it to the postfix expression
              operatorStack.pop();
           }else{
              break;
           }
        }//end while-loop
        operatorStack.push(item);
     }//end else
  }//end for-loop
  while (!operatorStack.isEmpty()){
     top = (char)operatorStack.pop();
     p = p+top;  //Append it to the postfix expression
  }  
  return p;  //the postfix expression
 } // end convertToPostfix
 
  
public static double evaluatePostfix(String postfix) {
   ArrayStack valueStack = new ArrayStack();
   char item;
   double operand1;
   double operand2;
   double result;
   for(int j = 0; j < postfix.length(); j++){
      item = postfix.charAt(j);
      if(isVariable(item)){
         double op = valueOf(item);
         valueStack.push(op);  //convert to double then push!!!!!
      }else{         
         operand2 = (double)valueStack.pop();
         operand1 = (double)valueStack.pop();
         
         switch(item){
            case '-': result = operand1 - operand2; valueStack.push(result); break;
            case '+': result = operand1 + operand2; valueStack.push(result); break;
            case '/': result = operand1 / operand2; valueStack.push(result); break;
            case '*': result = operand1 * operand2; valueStack.push(result); break;
         }//end switch  
      }//end else
   }//end for-loop   
   return (double)valueStack.pop();
} // end evaluatePostfix
 
 /** Task: Determines the precedence of a given operator.
 * @param operator a character that is (, ), +, -, *, or /
 * @return an integer that indicates the precedence of operator:
 * 0 if ( or ), 1 if + or -, 2 if * or /, -1 if anything else
 */
 private static int getPrecedence(char operator) {
 switch (operator) {
 case '(': case ')': return 0;
 case '+': case '-': return 1;
 case '*': case '/': return 2;
 } // end switch
 return -1;
 } // end getPrecedence
 
 private static boolean isVariable(char ch) {
 return (ch == 'a') || (ch == 'b') || (ch == 'c') || (ch == 'd');
 } // end isVariable

 private static double valueOf(char variable) {
 switch (variable) {
 case 'a': return 2.0;
 case 'b': return 3.0;
 case 'c': return 4.0;
 case 'd': return 5.0;
 } // end switch
 return 0;
 } // end valueOf

} // end Postfix
