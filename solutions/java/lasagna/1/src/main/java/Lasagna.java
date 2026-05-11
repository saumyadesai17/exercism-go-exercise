public class Lasagna {
    // TODO: define the 'expectedMinutesInOven()' method
    public static int expectedMinutesInOven() {
        return 40;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    public static int remainingMinutesInOven(int actualMinutes){
        int expectedMinutes = expectedMinutesInOven();
        return expectedMinutes - actualMinutes;
    }

    // TODO: define the 'preparationTimeInMinutes()' method
    public static int preparationTimeInMinutes(int layers) {
        return layers*2;
    }

    // TODO: define the 'totalTimeInMinutes()' method
    public static int totalTimeInMinutes(int layers, int minutes) {
        int layersPrepTime = preparationTimeInMinutes(layers);
        return layersPrepTime+minutes;
        
    }
}
