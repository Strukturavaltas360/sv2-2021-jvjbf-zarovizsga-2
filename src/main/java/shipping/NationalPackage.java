package shipping;

public class NationalPackage implements Transportable {
    private static final int TRANSPORT_COST = 1000;
    private static final int BREAKABLE_MULTIPLIER = 2;
    private final int weigth;
    private final boolean breakable;

    public NationalPackage(int weigth, boolean breakable) {
        validate(weigth);
        this.weigth = weigth;
        this.breakable = breakable;
    }

    private void validate(int weigth) {
        if (weigth <= 0) {
            throw new IllegalArgumentException("Weight should be greater than zero");
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
        return breakable ? BREAKABLE_MULTIPLIER * TRANSPORT_COST : TRANSPORT_COST;
    }
}
