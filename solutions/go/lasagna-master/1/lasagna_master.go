package lasagna

// TODO: define the 'PreparationTime()' function
func PreparationTime (layers []string, avgTimePerLayer int) int {
    if avgTimePerLayer == 0 {
        avgTimePerLayer = 2
    }
    totalPreparationTime := len(layers) * avgTimePerLayer
    return totalPreparationTime
}

// TODO: define the 'Quantities()' function
func Quantities (layers []string) (int, float64) {
    countOfNoodleLayers := 0
    countOfSauceLayers := 0
    for i :=0; i < len(layers); i++ {
        if layers[i] == "noodles" {
            countOfNoodleLayers++
        }
        if layers[i] == "sauce" {
            countOfSauceLayers++
        }
    }
    return countOfNoodleLayers*50, float64(countOfSauceLayers)*0.2
}

// TODO: define the 'AddSecretIngredient()' function
func AddSecretIngredient (friendSlice, ownSlice []string) {
    ownSlice[len(ownSlice)-1] = friendSlice[len(friendSlice)-1]
}

// TODO: define the 'ScaleRecipe()' function
func ScaleRecipe (amountsNeeded []float64, numberOfPortions int) []float64 {
    scaledAmounts := make([]float64, len(amountsNeeded))
    for i := 0; i<len(amountsNeeded); i++ {
        scaledAmounts[i] = amountsNeeded[i]
    }
    for i := 0; i < len(scaledAmounts); i++ {
        scaledAmounts[i] = scaledAmounts[i] * (float64(numberOfPortions)/2.0) 
    }
    return scaledAmounts
}

// Your first steps could be to read through the tasks, and create
// these functions with their correct parameter lists and return types.
// The function body only needs to contain `panic("")`.
//
// This will make the tests compile, but they will fail.
// You can then implement the function logic one by one and see
// an increasing number of tests passing as you implement more
// functionality.