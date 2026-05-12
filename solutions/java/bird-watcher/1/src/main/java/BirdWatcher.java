
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        int[] count = {0, 2, 5, 3, 7, 8, 4};
        return count;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int count : birdsPerDay) {
            if (count == 0 ) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int maxNumberOfDays = numberOfDays > birdsPerDay.length ? birdsPerDay.length : numberOfDays;
        int sum = 0;
        for (int i = 0; i < maxNumberOfDays; i++) {
            sum += birdsPerDay[i];
        }
        return sum;
    }

    public int getBusyDays() {
        int busyDays = 0;
        for (int birdCount : birdsPerDay) {
            if (birdCount >=5) {
                busyDays++;
            }
        }
        return busyDays;
    }
}
