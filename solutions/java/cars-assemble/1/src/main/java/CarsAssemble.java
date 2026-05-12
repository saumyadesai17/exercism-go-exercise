public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double productionRate = (double) speed * 221;
        if (speed >= 1 && speed <= 4) {
            return productionRate;
        } else if (speed >=5 && speed <= 8 ) {
            return productionRate * 0.90;
        } else if (speed == 9) {
            return productionRate * 0.80;
        } else if (speed == 10) {
            return productionRate * 0.77;
        }
        return 0.0;
    }

    public int workingItemsPerMinute(int speed) {
        double ratePerHour = productionRatePerHour(speed);
        int itemsPerMinute = (int) ratePerHour / 60;
        return itemsPerMinute;
    }
}
