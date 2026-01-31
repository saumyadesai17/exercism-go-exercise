package electionday
import "fmt"

// NewVoteCounter returns a new vote counter with
// a given number of initial votes.
func NewVoteCounter(initialVotes int) *int {
    var initialVotesPointer *int
    initialVotesPointer = &initialVotes
    return initialVotesPointer
}

// VoteCount extracts the number of votes from a counter.
func VoteCount(counter *int) int {
    numberOfVotes := 0
    if counter != nil {
        numberOfVotes = *counter
    }
    return numberOfVotes
}

// IncrementVoteCount increments the value in a vote counter.
func IncrementVoteCount(counter *int, increment int) {
    *counter += increment
}

// NewElectionResult creates a new election result.
func NewElectionResult(candidateName string, votes int) *ElectionResult {
    var candidateResult ElectionResult
    candidateResult = ElectionResult {Name: candidateName, Votes: votes}
    var PointerOfCandidateResult *ElectionResult
    PointerOfCandidateResult = &candidateResult
    return PointerOfCandidateResult
}

// DisplayResult creates a message with the result to be displayed.
func DisplayResult(result *ElectionResult) string {
    var resultDeferenced ElectionResult
    if result != nil {
        resultDeferenced = *result
    }
    message := fmt.Sprintf("%s (%d)", resultDeferenced.Name, resultDeferenced.Votes)
    return message
}

// DecrementVotesOfCandidate decrements by one the vote count of a candidate in a map.
func DecrementVotesOfCandidate(results map[string]int, candidate string) {
    results[candidate] -= 1
}
