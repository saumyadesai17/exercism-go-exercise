package logs
import "unicode/utf8"

// Application identifies the application emitting the given log.
func Application(log string) string {
    for _, value := range log {
        if  value == '❗' {
            return "recommendation"
        }
        if value == '🔍' {
            return "search"
        } 
        if value == '☀' {
            return "weather"
        }
    }
    return "default"
}

// Replace replaces all occurrences of old with new, returning the modified log
// to the caller.
func Replace(log string, oldRune, newRune rune) string {
    modifiedLog := ""
    for _, value := range log {
        if value == oldRune {
			modifiedLog += string(newRune)
        } else {
         	modifiedLog += string(value)   
        }
    }
    return modifiedLog
}

// WithinLimit determines whether or not the number of characters in log is
// within the limit.
func WithinLimit(log string, limit int) bool {
    if utf8.RuneCountInString(log) <= limit {
        return true
    } else {
        return false
    }
}
