public class Methods {
    public static void main(String[] args) {
        int sum = add(10,20);
        System.out.println(sum);

        String reply=greet("Aman");
        String message = reply;
        System.out.println(message);
    }

    // Scaffolded signature — implement the body only
    public static int add(int a, int b) {
        int sum= a + b;
        return(sum);
    }

    public static String greet(String name) {
        String reply=("Hello, "+ name );
        return(reply);
    }
}