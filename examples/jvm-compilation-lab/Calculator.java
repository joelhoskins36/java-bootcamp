public class Calculator {
    public static int add(int a, int b) {
        // TODO: compute and return a + b (use a local variable named result)
        int sum=a+b;
                return(sum);
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        // TODO: call add(x, y) and print "Sum = " + sum
        int sum=add(x,y);
        System.out.println("Sum = " + sum);
    }
}
