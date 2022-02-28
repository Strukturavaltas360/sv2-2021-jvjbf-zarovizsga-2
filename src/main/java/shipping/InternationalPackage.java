package shipping;

public class InternationalPackage implements Transportable {
    private static final int BASE_TRANSPORT_COST = 1200;
    private static final int TRANSPORT_COST_PER_KM = 10;
    private static final int BREAKABLE_MULTIPLIER = 2;
    private final int weigth;
    private final boolean breakable;
    private final String destinationCountry;
    private final int distance;

    public InternationalPackage(int weigth, boolean breakable, String destinationCountry, int distance) {
        validate(weigth, destinationCountry, distance);
        this.weigth = weigth;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    private void validate(int weigth, String destinationCountry, int distance) {
        if (weigth <= 0) {
            throw new IllegalArgumentException("Weight should be greater than zero");
        }
        if (destinationCountry == null || destinationCountry.isBlank()) {
            throw new IllegalArgumentException("Destination country is empty!");
        }
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance should be greater than zero");
        }
    }

    @Override
    public int getWeight() {
        return weigth;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        int price = BASE_TRANSPORT_COST + distance * TRANSPORT_COST_PER_KM;
        if (breakable) {
            price = BREAKABLE_MULTIPLIER * BASE_TRANSPORT_COST + distance * TRANSPORT_COST_PER_KM;
        }
        return price;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }
}
