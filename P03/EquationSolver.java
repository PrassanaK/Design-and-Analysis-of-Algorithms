import java.util.*;
public class EquationSolver
{
    public static double solve(String equation)
    {
        DSAQueue parsedEquation = new DSAQueue();
        double postFixEval;
        parsedEquation = parseInfixToPostfix(equation);
        postFixEval = evaluatePostFix(parsedEquation);
        //System.out.println(postFixEval);
        return postFixEval;
    }
        

    private static DSAQueue parseInfixToPostfix(String equation)
    {
        char val;
        DSAStack opStack = new DSAStack();
        DSAQueue postFix = new DSAQueue();
        
        String thisToken = null;
        StringTokenizer strTok;
        strTok = new StringTokenizer(equation, "()+-*/",true);
        while (strTok.hasMoreTokens())
        {
            thisToken = strTok.nextToken();
            System.out.println(thisToken);
            if (thisToken.equals("("))
            {
               opStack.push(thisToken);
            }
            else if(thisToken.equals(")"))
            {
                while (!(opStack.top()).equals("("))
                {
                    postFix.enqueue(opStack.pop());
                }
                opStack.pop();
            }
            else if ((thisToken.equals("+"))||(thisToken.equals("-"))||(thisToken.equals("*"))||(thisToken.equals("/")))
            {
		System.out.println("HERE");
                while ((!opStack.isEmpty())&&(((opStack.top()) != "(")&&(precedenceOf(((Character)opStack.top().toString().charAt(0))) >= precedenceOf(thisToken.charAt(0)))))
                {

                    postFix.enqueue(opStack.pop());
                    System.out.println("top" + opStack.top());
                    System.out.println("peek" + postFix.peek());
                }                 
                opStack.push(thisToken);
            }
            else
            {
                double operand = Double.parseDouble(thisToken);
                postFix.enqueue(operand);
            }
        }

        while (!opStack.isEmpty())
        {
            postFix.enqueue(opStack.pop());
        }
        return postFix;
    }

    private static double evaluatePostFix(DSAQueue postFix)
    {
	Object value;
	double result = -1;
        DSAStack stack = new DSAStack();
        while (!postFix.isEmpty())
        {
            value = postFix.dequeue();
            if (value instanceof Double)
            {
                stack.push(value);
            }
            else if(value instanceof Character)
            {
		Object op1 = stack.pop();
		Object op2 = stack.pop();
                result = executeOperation((char)value, (Double)op1, ((Double)op2));
		System.out.println(result);
                stack.push(result);
            }
            else
            {
                System.out.println("No Match");
            }
        }
        return (double)stack.top();
    }

    private static int precedenceOf(char theOperator)
    {
        int val = 0;
        switch(theOperator)
        {
            case '+': case '-':
                val = 1;
                break;
            case '*': case '/':
                val = 2;
                break;
            default:
                System.out.println("Invalid char");
        }    
        return val;  
    }

    private static double executeOperation(char op, double op1, double op2)
    {
        double number = 0.0;
        switch(op)
        {
            case '+':
                number = op1 + op2;
                break;
            case '-':
                number = op1 - op2;
                break;
            case '*':
                number = op1 * op2;
                break;
            case '/':
                number = op1 / op2;
                break;
            default:
                System.out.println("Error");
        }
        System.out.println(number);
        return number;
    }
}
