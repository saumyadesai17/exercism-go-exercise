package parsinglogfiles
import "regexp"
import "fmt"

func IsValidLine(text string) bool {
    re := regexp.MustCompile(`^\[(TRC|DBG|INF|WRN|ERR|FTL)\]`)
    match := re.MatchString(text)
    return match
}

func SplitLogLine(text string) []string {
    re := regexp.MustCompile(`<(~|\*|=|\-)*>`)
    return re.Split(text, -1)
}

func CountQuotedPasswords(lines []string) int {
    count := 0
    re := regexp.MustCompile(`".*(?i)password.*"`)
    for _, value := range lines {
        if re.MatchString(value) {
            count++
        }
    }
    return count
}

func RemoveEndOfLineText(text string) string {
    re := regexp.MustCompile(`(end-of-line)[0-9]*`)
    splittedArray := re.Split(text, -1)
	var mergedArray string = ""
    for _, value := range splittedArray {
        mergedArray += value
    }
    return mergedArray
}

func TagWithUserName(lines []string) []string {
	re := regexp.MustCompile(`User\s+(\S+)`)
	taggedLines := make([]string, len(lines))
	for i, line := range lines {
		submatches := re.FindStringSubmatch(line)
		if submatches != nil {
			userName := submatches[1]
			taggedLines[i] = fmt.Sprintf("[USR] %s %s", userName, line)
		} else {
			taggedLines[i] = line
		}
	}
	return taggedLines
}