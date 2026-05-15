import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class RelativeDistance {
    private Map<String, List<String>> connections = new HashMap<>();
    
    RelativeDistance(Map<String, List<String>>  familyTree) {
        for (Map.Entry<String, List<String>> entries : familyTree.entrySet()) {
            String parent = entries.getKey();
            List<String> children = entries.getValue();

            connections.putIfAbsent(parent, new ArrayList<>());
            for (String child : children) {
                connections.putIfAbsent(child, new ArrayList<>());
                connections.get(parent).add(child);
                connections.get(child).add(parent);
            }

            for (int i = 0; i < children.size(); i++) {
                for (int j = i + 1; j < children.size(); j++) {
                    String siblingA = children.get(i);
                    String siblingB = children.get(j);
                    
                    connections.get(siblingA).add(siblingB);
                    connections.get(siblingB).add(siblingA);
                }
            }
        }
    }

    int degreeOfSeparation(String personA, String personB) {
        if (personA.equals(personB)) {
            return 0;
        } else if (!connections.containsKey(personA) || !connections.containsKey(personB)) {
            return -1;
        }

        Map<String, Integer> distances = new HashMap<>();
        List<String> toCheck = new ArrayList<>();
        toCheck.add(personA);

        while (!toCheck.isEmpty()) {
            String current = toCheck.get(0);
            toCheck.remove(0);
            distances.put(personA, 0);
            int currentDistance = distances.get(current);
            for (String relative : connections.get(current)) {
                if (!distances.containsKey(relative)) {
                    int nextDistance = currentDistance+1;
                    distances.put(relative, nextDistance);
                    toCheck.add(relative);

                    if (relative.equals(personB)) {
                        return nextDistance;
                    }
                }
            }
        }
        return -1;
    }
}
