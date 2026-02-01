package booking
import "fmt"
import "time"

// Schedule returns a time.Time from a string containing a date.
func Schedule(date string) time.Time {
    dateToFormat := date
    layout := "1/02/2006 15:04:05"
    time, _ := time.Parse(layout, dateToFormat)
    return time
}

// HasPassed returns whether a date has passed.
func HasPassed(date string) bool {
    dateToFormat := date
    layout := "January 2, 2006 15:04:05"
    t, _ := time.Parse(layout, dateToFormat)

    isBefore := t.Before(time.Now())
    return isBefore
}

// IsAfternoonAppointment returns whether a time is in the afternoon.
func IsAfternoonAppointment(date string) bool {
    dateToFormat := date
    layout := "Monday, January 2, 2006 15:04:05"
    t, _ := time.Parse(layout, dateToFormat)
    if t.Hour() >= 12 && t.Hour() < 18 {
        return true
    }
    return false
}

// Description returns a formatted string of the appointment time.
func Description(date string) string {
    dateToFormat := date
    layout := "1/2/2006 15:04:05"
    t, _ := time.Parse(layout, dateToFormat)
    appointmentString := fmt.Sprintf("You have an appointment on %s, %s %d, %d, at %d:%d.", t.Weekday(), t.Month(), t.Day(), t.Year(), t.Hour(), t.Minute())
    return appointmentString
}

// AnniversaryDate returns a Time with this year's anniversary.
func AnniversaryDate() time.Time {
    date := "9/15/2026 00:00:00"
    layout := "1/02/2006 15:04:05"
    t, _ := time.Parse(layout, date)
    return t
}
