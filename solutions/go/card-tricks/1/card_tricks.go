package cards

// FavoriteCards returns a slice with the cards 2, 6 and 9 in that order.
func FavoriteCards() []int {
    favNumberCards := []int{2, 6, 9}
    return favNumberCards
}

// GetItem retrieves an item from a slice at given position.
// If the index is out of range, we want it to return -1.
func GetItem(slice []int, index int) int {
    if index < len(slice) && index >= 0 {
        return slice[index]
    } else {
        return -1
    }
}

// SetItem writes an item to a slice at given position overwriting an existing value.
// If the index is out of range the value needs to be appended.
func SetItem(slice []int, index, value int) []int {
    if index >= 0 && index < len(slice) {
        slice[index] = value
        return slice
    } else {
        appendedSlice := append(slice, value)
        return appendedSlice
    }
}

// PrependItems adds an arbitrary number of values at the front of a slice.
func PrependItems(slice []int, values ...int) []int {
    appendedSlice := append(values, slice...)
    return appendedSlice
}

// RemoveItem removes an item from a slice by modifying the existing slice.
func RemoveItem(slice []int, index int) []int {
    if index >= 0 && index < len(slice) {
		cleanedSlice := append(slice[0:index], slice[index+1:]...)   
    	return cleanedSlice
    } else {
        return slice
    }
}
