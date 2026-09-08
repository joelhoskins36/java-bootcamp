public class PerformanceTest {

    private static final int[] COUNTS = {
            10, 100, 1_000, 100_000, 1_000_000
    };

    static class DemoObject {
        private byte[] payload;

        DemoObject() {
            payload = new byte[100];
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Performance Measurement =====");
        System.out.printf(
                "%-12s %-18s %-18s%n",
                "Objects", "Used Memory", "Execution Time"
        );
        System.out.println("--------------------------------------------------");

        for (int count : COUNTS) {

            // Clean up before each measurement
            MemoryMonitor.triggerGarbageCollection();

            long memoryBefore = MemoryMonitor.getUsedBytes();

            long start = System.nanoTime();

            DemoObject[] objects = new DemoObject[count];

            for (int i = 0; i < count; i++) {
                objects[i] = new DemoObject();
            }

            long end = System.nanoTime();

            long memoryAfter = MemoryMonitor.getUsedBytes();

            double memoryUsedMB =
                    MemoryMonitor.toMB(memoryAfter - memoryBefore);

            double executionTimeMs =
                    (end - start) / 1_000_000.0;

            System.out.printf(
                    "%-12d %-18.2f %-18.3f%n",
                    count,
                    memoryUsedMB,
                    executionTimeMs
            );

            // Make the objects eligible for GC before the next test
            objects = null;
        }

        // -----------------------------------------
        // Additional measurements
        // -----------------------------------------

        System.out.println();
        System.out.println("Additional measurements:");

        // 10 million iteration loop
        long loopStart = System.nanoTime();

        long sum = 0;

        for (int i = 0; i < 10_000_000; i++) {
            sum += i;
        }

        long loopEnd = System.nanoTime();

        double loopTimeMs =
                (loopEnd - loopStart) / 1_000_000.0;

        System.out.printf(
                "Loop execution (10M iterations) : %.3f ms | sum = %d%n",
                loopTimeMs,
                sum
        );


        // Large int array
        long arrayStart = System.nanoTime();

        int[] largeArray = new int[1_000_000];

        long arrayEnd = System.nanoTime();

        double arrayTimeMs =
                (arrayEnd - arrayStart) / 1_000_000.0;

        System.out.printf(
                "int[1,000,000] allocation       : %.3f ms%n",
                arrayTimeMs
        );


        // About 10 MB byte array
        System.out.println();

        MemoryMonitor.printMemoryReport("Before Large byte[]");

        long byteArrayStart = System.nanoTime();

        byte[] largeByteArray = new byte[10 * 1024 * 1024];

        long byteArrayEnd = System.nanoTime();

        double byteArrayTimeMs =
                (byteArrayEnd - byteArrayStart) / 1_000_000.0;

        System.out.printf(
                "byte[~10 MB] allocation          : %.3f ms%n",
                byteArrayTimeMs
        );

        MemoryMonitor.printMemoryReport("After Large byte[]");

        // Keep the variable alive until this point.
        System.out.println(
                "Large byte[] size: "
                        + MemoryMonitor.toMB(largeByteArray.length)
                        + " MB"
        );
    }
}