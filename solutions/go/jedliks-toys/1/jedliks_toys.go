package jedlik
import "fmt"

// TODO: define the 'Drive()' method
func (c *Car) Drive() Car {
    if c.batteryDrain > c.battery {
        return *c
    }
    c.battery -= c.batteryDrain
    c.distance += c.speed
    
    return *c
}

// TODO: define the 'DisplayDistance() string' method
func (c Car) DisplayDistance() string {
    distanceMessage := fmt.Sprintf("Driven %d meters", c.distance)
    return distanceMessage
}

// TODO: define the 'DisplayBattery() string' method
func (c Car) DisplayBattery() string {
	batteryMessage := fmt.Sprintf("Battery at %d%%", c.battery)
    return batteryMessage
}

// TODO: define the 'CanFinish(trackDistance int) bool' method
func (c *Car) CanFinish(trackDistance int) bool {
    for c.distance < trackDistance && c.battery > 0 {
        c.Drive()
    }
    if c.distance == trackDistance {
        return true
    }
    return false
}

// Your first steps could be to read through the tasks, and create
// these functions with their correct parameter lists and return types.
// The function body only needs to contain `panic("")`.
//
// This will make the tests compile, but they will fail.
// You can then implement the function logic one by one and see
// an increasing number of tests passing as you implement more
// functionality.'