public class SalaryCalculator {
    public double salaryMultiplier(int daysSkipped) {
        double penalty = daysSkipped >= 5 ? 0.15 : 0.0;
        return 1.0 - penalty;
    }

    public int bonusMultiplier(int productsSold) {
        int multiplier = productsSold >= 20 ? 13 : 10;
        return multiplier;
    }

    public double bonusForProductsSold(int productsSold) {
        double multiplier = (double) bonusMultiplier(productsSold);
        return multiplier * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double baseSalary = 1000.00;
        double salaryMultiplier = salaryMultiplier(daysSkipped);
        double bonus = bonusForProductsSold(productsSold);
        double rawSalary = baseSalary * salaryMultiplier + bonus;
        double salary = rawSalary > 2000.00 ? 2000.00 : rawSalary;
        return salary;
    } 
}
