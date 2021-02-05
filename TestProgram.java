
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestProgram {

    /*
     * Test de calculateResult() de la clase Calculadora
     */
    @Test
    public void testCalculadora() {
        Calculadora calc = new Calculadora();
        int result = calc.calculateResult("6 2 3 + *");
        assertEquals(result, 30);
    }

    /*
     * Test de push() de la clase StackArrayList
     */
    @Test
    public void testStackPush() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(stack.size(), 5);

    }

    /*
     * Test de peek() de la clase StackArrayList
     */
    @Test
    public void testStackPeek() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        assertEquals(stack.peek(), 5);
    }

    /*
     * Test de pop() de la clase StackArrayList
     */
    @Test
    public void testStackPop() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(3);
        stack.push(5);
        stack.push(7);
        assertEquals(stack.pop(), 7);
    }

}
