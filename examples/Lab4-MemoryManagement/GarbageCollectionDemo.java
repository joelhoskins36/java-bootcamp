public class GarbageCollectionDemo {

    static class DemoObject {
        private byte[] payload;

        DemoObject() {
            payload = new byte[1024];
        }

        @Override
        public String toString() {
            return "DemoObject{payload=" + payload.length + " bytes}";
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Garbage Collection Demonstration =====");

        // 1. Allocate about 100,000 objects
        DemoObject[] objects = new DemoObject[100_000];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = new DemoObject();
        }

        // 2. Print count and memory after allocation
        System.out.println("Objects allocated: " + objects.length);
        MemoryMonitor.printMemoryReport("After allocation");

        // 3. Remove the array reference
        objects = null;

        System.out.println("\nArray reference set to null.");
        System.out.println("Objects are now eligible for garbage collection.");

        MemoryMonitor.printMemoryReport("Before GC");

        // 4. Trigger GC and measure elapsed time
        long start = System.nanoTime();

        MemoryMonitor.triggerGarbageCollection();

        long end = System.nanoTime();

        double elapsedMs = (end - start) / 1_000_000.0;

        // 5. Print after-GC report
        System.out.printf("GC request elapsed time: %.3f ms%n", elapsedMs);
        MemoryMonitor.printMemoryReport("After GC");
    }
}