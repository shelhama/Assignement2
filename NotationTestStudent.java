import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotationTestStudent {

    // Test case for infixToPostfix method with a valid expression
    @Test
    void testInfixToPostfix_validExpression() throws InvalidNotationFormatException {
        String infix = "3+(2*5)";  // Infix expression
        String expectedPostfix = "3 2 5 * +";  // Expected postfix expression

        String actualPostfix = Notation.infixToPostfix(infix);  // Call method to convert to postfix
        assertEquals(expectedPostfix, actualPostfix);  // Assert the result matches expected postfix expression
    }

    // Test case for infixToPostfix method with an invalid expression
    @Test
    void testInfixToPostfix_invalidExpression() {
        String infix = "3 2 * +";  // Invalid expression with misplaced operator
        assertThrows(InvalidNotationFormatException.class, () -> {
            Notation.infixToPostfix(infix);  // Should throw InvalidNotationFormatException
        });
    }

   

    // Test case for postfixToInfix method with an invalid expression
    @Test
    void testPostfixToInfix_invalidExpression() {
        String postfix = "3 2 * +";  // Invalid postfix expression (missing operand)
        assertThrows(InvalidNotationFormatException.class, () -> {
            Notation.postfixToInfix(postfix);  // Should throw InvalidNotationFormatException
        });
    }

    // Test case for evaluatePostfix method with a valid expression
   

    // Test case for evaluatePostfix method with an invalid expression
    @Test
    void testEvaluatePostfix_invalidExpression() {
        String postfix = "3 2 + *";  // Invalid postfix expression (operator without enough operands)
        assertThrows(InvalidNotationFormatException.class, () -> {
            Notation.evaluatePostfix(postfix);  // Should throw InvalidNotationFormatException
        });
    }

    // Test case for evaluatePostfix method with division by zero
    @Test
    void testEvaluatePostfix_divisionByZero() {
        String postfix = "3 0 /";  // Division by zero in postfix expression
        try {
            Notation.evaluatePostfix(postfix);  // Should throw ArithmeticException for division by zero
            fail("Expected ArithmeticException to be thrown"); // If no exception is thrown, the test fails
        } catch (ArithmeticException e) {
            // Test passed as ArithmeticException is expected
            assertTrue(true);
        } catch (Exception e) {
       
        }
    }

}
