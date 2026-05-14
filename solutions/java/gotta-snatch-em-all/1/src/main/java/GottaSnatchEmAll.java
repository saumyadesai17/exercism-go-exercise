import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        Set<String> collectionSet = new HashSet<>();
        for (String card : cards){
            collectionSet.add(card);
        }
        return collectionSet;
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card) ? true : false;
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
       return myCollection.containsAll(theirCollection) || theirCollection.containsAll(myCollection) ? false : true;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> commonCard = new HashSet<>();
        Map<String, Integer> globalCount = new HashMap<>();

        for(Set<String> cards : collections) {
            for (String card : cards) {
                globalCount.merge(card, 1, Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : globalCount.entrySet()){
            if (entry.getValue() == collections.size()) {
                commonCard.add(entry.getKey());
            }
        }
        return commonCard;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> uniqueCards = new HashSet<>();
        
        for (Set<String> cards : collections) {
            for (String card : cards) {
                uniqueCards.add(card);
            }
        }
        return uniqueCards;
    }
}
