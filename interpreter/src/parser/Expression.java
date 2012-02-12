package parser;

import java.util.*;
 
interface Expression {
    public void interpret(Stack<Integer> s);
}
 
class TerminalExpression_Number implements Expression {
    private int number;
    public TerminalExpression_Number(int number)       { this.number = number; }
    public void interpret(Stack<Integer> s)  { s.push(number); }
}
 
class TerminalExpression_Plus implements Expression {
    public void interpret(Stack<Integer> s)  { s.push( s.pop() + s.pop() ); }
}
 
class TerminalExpression_Minus implements Expression {
    public void interpret(Stack<Integer> s)  { s.push( - s.pop() + s.pop() ); }
}
 