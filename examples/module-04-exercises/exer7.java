public class exer7 {
    private static final int ITERATIONS = 50_000;

    static String withString() {
        String result = "";
        for (int i = 0; i < ITERATIONS; i++) {
            result += "x";
        }
        return result;
    }

    static String withBuilder() {
        // Initial capacity avoids repeated buffer growth.
         StringBuilder result = new StringBuilder(ITERATIONS);
        for (int i = 0; i < ITERATIONS; i++) {
           result.append('x');
        }
        return result.toString();
    }

    public static void main(String[] args) {

        // Time withString()
        long stringStart = System.nanoTime();
        String stringResult = withString();
        long stringEnd = System.nanoTime();

        long stringNanos = stringEnd - stringStart;


        // Time withBuilder()
        long builderStart = System.nanoTime();
        String builderResult = withBuilder();
        long builderEnd = System.nanoTime();

        long builderNanos = builderEnd - builderStart;


        // Print lengths and times in milliseconds
        System.out.printf(
                "String length: %d, time: %.3f ms%n",
                stringResult.length(),
                stringNanos / 1_000_000.0
        );

        System.out.printf(
                "Builder length: %d, time: %.3f ms%n",
                builderResult.length(),
                builderNanos / 1_000_000.0
        );
    }

}