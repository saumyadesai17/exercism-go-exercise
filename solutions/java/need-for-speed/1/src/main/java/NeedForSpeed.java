class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distanceCovered = 0;
    private int battery = 100;
    
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return batteryDrain > battery ? true : false;
    }

    public int distanceDriven() {
        return distanceCovered;
    }

    public void drive() {
        boolean isBatteryDrained = batteryDrained();
        if (!isBatteryDrained) {
            distanceCovered += speed;
            battery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        var nitroCar = new NeedForSpeed(50, 4);
        return nitroCar;
    }
}

class RaceTrack {
    private int distance;
    
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        while (!car.batteryDrained()) {
            car.drive();
        }

        return car.distanceDriven() >= distance ? true : false;
    }
}
