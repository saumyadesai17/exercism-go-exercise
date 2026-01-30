package gross

// Units stores the Gross Store unit measurements.
func Units() map[string]int {
    grossStore := map[string]int {
        "quarter_of_a_dozen":3,
		"half_of_a_dozen":6,
		"dozen":12,
		"small_gross":120,
		"gross":144,
		"great_gross":1728,
    }
    return grossStore
}

// NewBill creates a new bill.
func NewBill() map[string]int {
    emptyBill := make(map[string]int)
    return emptyBill
}

// AddItem adds an item to customer bill.
func AddItem(bill, units map[string]int, item, unit string) bool {
    unitValue, isUnitInMap := units[unit] 
    if isUnitInMap {
        value, exists := bill[item]
        if exists {
            bill[item] = value + unitValue
        } else {
            bill[item]=unitValue
        }
        return true
    }
    return false
}

// RemoveItem removes an item from customer bill.
func RemoveItem(bill, units map[string]int, item, unit string) bool {
    billValue, isItemInBill := bill[item]
    if !isItemInBill {
        return false
    }
    unitValue, isUnitInMap := units[unit]
    if !isUnitInMap {
        return false
    }
    if (billValue - unitValue) < 0 {
        return false
    } else if (billValue - unitValue) == 0{
        delete(bill, item)
        return true
    } else {
        bill[item]=billValue - unitValue
        return true
    }
}

// GetItem returns the quantity of an item that the customer has in his/her bill.
func GetItem(bill map[string]int, item string) (int, bool) {
    itemValue, isItemInBill := bill[item]
    if !isItemInBill {
        return itemValue, isItemInBill
    }
  	return itemValue, isItemInBill  
}
