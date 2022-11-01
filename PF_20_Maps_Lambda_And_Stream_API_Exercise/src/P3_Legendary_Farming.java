import java.util.*;

public class P3_Legendary_Farming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] resources = scanner.nextLine().split("\\s+");
        Map<String, Integer> qualityResources = new HashMap<>();
        Map<String, Integer> junkResources = new TreeMap<>();
        boolean itemIsCreated = false;
        createQualityResources(qualityResources);
        while (true) {
            for (int i = 0; i < resources.length; i += 2) {
                int resourceQuantity = Integer.parseInt(resources[i]);
                String resourceName = resources[i + 1].toLowerCase();
                switch (resourceName) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        qualityResources.put(resourceName, qualityResources.get(resourceName) + resourceQuantity);
                        break;
                    default:
                        junkResources.putIfAbsent(resourceName, 0);
                        junkResources.put(resourceName, junkResources.get(resourceName) + resourceQuantity);
                        break;
                }
                if (createItem(qualityResources, resourceName)) {
                    printItem(resourceName);
                    itemIsCreated = true;
                    break;
                }
            }
            if (itemIsCreated) {
                break;
            }
            resources = scanner.nextLine().split("\\s+");
        }
        printQualityResources(qualityResources);

        printJunkResources(junkResources);
    }

    private static boolean createItem(Map<String, Integer> qualityResources, String resourceName) {
        if (qualityResources.containsKey(resourceName) && qualityResources.get(resourceName) >= 250) {
            qualityResources.put(resourceName, qualityResources.get(resourceName) - 250);
            return true;
        }
        return false;
    }

    private static void createQualityResources(Map<String, Integer> quality) {
        quality.put("fragments", 0);
        quality.put("motes", 0);
        quality.put("shards", 0);
    }

    private static void printItem(String resource) {
        switch (resource) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }
    }

    private static void printQualityResources(Map<String, Integer> quality) {
        quality.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue().equals(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                })
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static void printJunkResources(Map<String, Integer> poor) {
        poor.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
