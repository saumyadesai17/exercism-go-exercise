package thefarm
import "fmt"
import "errors"

// TODO: define the 'DivideFood' function
func DivideFood(fodder FodderCalculator, numberOfCows int) (float64, error) {
    amountOfFodder, err := fodder.FodderAmount(numberOfCows)
    if err != nil{
        return 0, err
    }
    flattenFactor, err := fodder.FatteningFactor()
    if err != nil {
        return 0, err
    }
    amountOfFoodPerCow := (amountOfFodder * flattenFactor) / float64(numberOfCows)
    return amountOfFoodPerCow, nil
}

// TODO: define the 'ValidateInputAndDivideFood' function
func ValidateInputAndDivideFood(fodder FodderCalculator, numberOfCows int) (float64, error) {
    if numberOfCows <= 0 {
        return 0, errors.New("invalid number of cows")
    }
    food, err := DivideFood(fodder, numberOfCows)
    return food, err
}

type InvalidCowsError struct {
    numberOfCows int
    customMessage string
}

func (i *InvalidCowsError) Error() string {
    return fmt.Sprintf("%d cows are invalid: %s", i.numberOfCows, i.customMessage)
}

// TODO: define the 'ValidateNumberOfCows' function
func ValidateNumberOfCows(numberOfCows int) error {
    if numberOfCows < 0 {
        return &InvalidCowsError {
            numberOfCows: numberOfCows,
            customMessage: "there are no negative cows",
        }
    }
    if numberOfCows == 0 {
        return &InvalidCowsError {
            numberOfCows: numberOfCows,
            customMessage: "no cows don't need food",
        }
    }
    return nil
}
