import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemo {

    private static final Logger logger =
            LoggerFactory.getLogger(LogDemo.class);

    public static void main(String[] args) {

        logger.info("Program started");

        int balance = 100;

        logger.info("Current balance: {}", balance);

        if (balance < 50) {
            logger.warn("Balance is getting low");
        }

        logger.error("Something went wrong");

        logger.info("Program finished");
    }
}