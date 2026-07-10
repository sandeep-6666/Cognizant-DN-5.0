public class dsaex7 {
    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.08;
        int years = 5;

        double forecastedValue = forecastFutureValue(initialValue, growthRate, years);

        System.out.println("Recursive financial forecasting");
        System.out.println("Initial value: " + initialValue);
        System.out.println("Growth rate: " + (growthRate * 100) + "% per year");
        System.out.println("Years: " + years);
        System.out.println("Forecasted value after " + years + " years: " + String.format("%.2f", forecastedValue));
        System.out.println("\nAnalysis:");
        System.out.println("Recursion solves the problem by breaking it into smaller subproblems.");
        System.out.println("Time complexity is O(n) because each year is processed once.");
        System.out.println("To optimize, use iteration instead of recursion for large values to avoid stack overhead.");
    }

    public static double forecastFutureValue(double currentValue, double growthRate, int yearsLeft) {
        if (yearsLeft == 0) {
            return currentValue;
        }

        return forecastFutureValue(currentValue * (1 + growthRate), growthRate, yearsLeft - 1);
    }
}
