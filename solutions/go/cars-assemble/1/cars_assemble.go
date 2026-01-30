package cars

// CalculateWorkingCarsPerHour calculates how many working cars are
// produced by the assembly line every hour.
func CalculateWorkingCarsPerHour(productionRate int, successRate float64) float64 {
    rateOfSuccess := successRate / float64(100)
    workingCarsPerHour := float64(productionRate) * rateOfSuccess
    return workingCarsPerHour
}

// CalculateWorkingCarsPerMinute calculates how many working cars are
// produced by the assembly line every minute.
func CalculateWorkingCarsPerMinute(productionRate int, successRate float64) int {
    workingCarsPerHour := CalculateWorkingCarsPerHour(productionRate, successRate)
    workingCarsPerMinute := workingCarsPerHour / 60
    return int(workingCarsPerMinute)
}

// CalculateCost works out the cost of producing the given number of cars.
func CalculateCost(carsCount int) uint {
    tenCarsCost := 95000
    individualCarCost := 10000
    unitNumber := carsCount % 10
    tensNumber := carsCount / 10

    cost := (tensNumber * tenCarsCost) + (unitNumber * individualCarCost)
	return uint(cost)
}
