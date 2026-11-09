/**
 * WarmUp.java - Output Prediction
 *
 * 1. Explicit Casting:
 *    int a = (int) 7.9;
 *    - Converts double to int.
 *    - Decimal part is removed.
 *    - Result: a = 7
 *
 * 2. Implicit Casting:
 *    int x = 5;
 *    double d = x;
 *    - Java automatically converts int to double.
 *    - Result: d = 5.0
 *
 * 3. Byte Casting:
 *
 *    Example 1:
 *    int n = 10;
 *    byte b = (byte) n;
 *
 *    - Explicitly converts int to byte.
 *    - Byte range: -128 to 127.
 *    - Since 10 is within the byte range, no overflow occurs.
 *    - Result: b = 10.
 *
 *    Example 2:
 *    int n = 127;
 *    byte b = (byte) n;
 *
 *    - Since 127 is the maximum byte value, it remains unchanged.
 *    - Result: b = 127.
 *
 *    Example 3:
 *    int n = 130;
 *    byte b = (byte) n;
 *
 *    - Since 130 is greater than 127, overflow occurs.
 *    - Result: b = 130 - 256 = -126.
 *
 *    Example 4:
 *    int n = 999;
 *    byte b = (byte) n;
 *
 *    - Calculate remainder: 999 % 256 = 231.
 *    - Since 231 >= 128, subtract 256.
 *    - Result: b = 231 - 256 = -25.
 *
 * 4. Switch Statement:
 *    day = 2
 *    - case 1 is skipped.
 *    - case 2 prints "Two".
 *    - No break statement, so execution continues to case 3.
 *    - case 3 prints "Three".
 *
 * 5. Predicted Output:
 *    7 5.0 -126
 *    Two
 *    Three
 *
 * 6. Actual Output:
 *
 *    7 5.0 -126
 *    Two
 *    Three
 *
 * Conclusion:
 *    The predicted output matches the actual output.
 *    Missing break statements cause switch fall-through.
 */
public class WarmUp {
    public static void main(String[] args) {
        int a = (int) 7.9;
        int x = 5;
        double d = x;
        int n = 130;
        byte b = (byte) n;

        System.out.println(a + " " + d + " " + b);

        int day = 2;

        switch (day) {
            case 1: System.out.println("One");
            case 2: System.out.println("Two");
            case 3: System.out.println("Three");
        }
    }
}