public class MemoryMonitor {

    public static void printMemoryReport(String label) {
        Runtime runtime = Runtime.getRuntime();

        long total = runtime.totalMemory();
        long free = runtime.freeMemory();
        long used = total - free;
        long max = runtime.maxMemory();

        System.out.printf(
                "%s - Used: %.2f MB, Free: %.2f MB, Total: %.2f MB, Max: %.2f MB%n",
                label,
                toMB(used),
                toMB(free),
                toMB(total),
                toMB(max)
        );
    }

    public static void triggerGarbageCollection() {
        System.gc();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static long getUsedBytes() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    public static double toMB(long bytes) {
        return bytes / (1024.0 * 1024.0);
    }
}