class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int cloneNumber = numberToCheck;
        int sum = 0;
        int numOfDigits = Integer.toString(numberToCheck).length();
        // int[] digitArray = new int[Integer.toString(numberToCheck).length()];
        while (numberToCheck > 0) {
            int temp;
            temp = numberToCheck % 10;
            sum += Math.pow(temp, numOfDigits);
            numberToCheck = numberToCheck / 10;
        }
        return (numOfDigits == 1 || sum == cloneNumber) ? true : false;
    }
}
