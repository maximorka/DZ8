package DZ8;

public class Calculator {
    public int getSum(int x, int y) {
        return x+y;
    }

    public int getDivide(int x, int y) {
        return x/y;
    }

    public int getMultiple(int x, int y) {
        return x*y;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
}
