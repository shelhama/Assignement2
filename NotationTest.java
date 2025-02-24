import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class NotationTest {
	public String complexInfix = "(3+(((5*7)-(((8/2)-1)*4))*6))";
	public String complexPostfix =  "357*82/1-4*-6*+";
	public String easyInfix = "(5+4)";
	public String easyPostfix = "54+";
	public String intermediateInfix = "((3*(5+4))+2)";
	public String intermediatePostfix = "354+*2+";

	public String invalidPostfixExpression = "354+*-";
	public String invalidInfixExpression = "(3+5)*4)-2";
	
	public double evalComplexPostfix = 141.0;
	public double evalIntermediatePostfix = 29.0;
	public double evalEasyPostfix = 9.0;

	@BeforeEach	
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testComplexConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.infixToPostfix(complexInfix);
		
	}
	
	@Test
	public void testIntermediateConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.infixToPostfix(intermediateInfix);
	
	}
	
	@Test
	public void testEasyConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.infixToPostfix(easyInfix);
		
	}
	
	@Test
	public void testInvalidInfixExpression() {
		try{
			Notation.infixToPostfix(invalidInfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
	
	@Test
	public void testComplexConvertPostfixToInfix() throws InvalidNotationFormatException, StackUnderflowException {
		String infixResult = Notation.postfixToInfix(complexPostfix);
		assertEquals(complexInfix, infixResult);
	}
	
	@Test
	public void testIntermediateConvertPostfixToInfix() throws InvalidNotationFormatException, StackUnderflowException {
		String infixResult = Notation.postfixToInfix(intermediatePostfix);
		assertEquals(intermediateInfix, infixResult);
	}
	
	@Test
	public void testEasyConvertPostfixToInfix() throws InvalidNotationFormatException, StackUnderflowException {
		String infixResult = Notation.postfixToInfix(easyPostfix);
		assertEquals(easyInfix, infixResult);
	}

	@Test
	public void testInvalidPostfixExpressionB() throws StackUnderflowException {
		try{
			Notation.postfixToInfix(invalidPostfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
	
	@Test
	public void testComplexEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostfix(complexPostfix);
		assertEquals(evalComplexPostfix, result, .001);
	}
	
	@Test
	public void testIntermediateEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostfix(intermediatePostfix);
		assertEquals(evalIntermediatePostfix, result, .001);
	}
	
	@Test
	public void testEasyEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostfix(easyPostfix);
		assertEquals(evalEasyPostfix, result, .001);
	}
	
	@Test
	public void testInvalidPostfixExpressionA() {
		try{
			Notation.evaluatePostfix(invalidPostfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
}