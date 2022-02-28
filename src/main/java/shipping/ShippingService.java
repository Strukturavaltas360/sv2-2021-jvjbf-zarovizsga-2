package shipping;

import java.util.*;

public class ShippingService {
    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable aPackage) {
        if (aPackage == null) {
            throw new IllegalArgumentException("Package is null!");
        }
        packages.add(aPackage);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(transportable -> transportable.isBreakable() == breakable && transportable.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> result = new HashMap<>();
        for (Transportable actual : packages) {
            Integer count = result.computeIfAbsent(actual.getDestinationCountry(), s -> 0);
            count++;
            result.put(actual.getDestinationCountry(), count);
        }
        return result;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(transportable -> transportable.getClass() == InternationalPackage.class)
                .sorted(Comparator.comparing(transportable -> ((InternationalPackage) transportable).getDistance()))
                .toList();
    }

    public List<Transportable> getPackages() {
        return packages;
    }
}
