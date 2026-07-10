public class ex1 {
    public static void main(String[] args) {
        LoggerTest.runTest();
    }
}

class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class LoggerTest {
    public static void runTest() {
        Logger first = Logger.getInstance();
        Logger second = Logger.getInstance();

        if (first == second) {
            System.out.println("Test passed: only one instance of Logger was created.");
        } else {
            System.out.println("Test failed: multiple instances were created.");
        }

        first.log("First message from the singleton logger.");
        second.log("Second message from the singleton logger.");
    }
}
