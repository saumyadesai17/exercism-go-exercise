//Package weather provides methods/functions to get forecast of a particular city.
package weather

var (
    // CurrentCondition stores the present condition of any location in the country.
	CurrentCondition string

    // CurrentLocation stores the coordinates of any location in the country.
	CurrentLocation  string
)

// Forecast takes the city and its current condition and it forecasts the curent weather condition of the city.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
