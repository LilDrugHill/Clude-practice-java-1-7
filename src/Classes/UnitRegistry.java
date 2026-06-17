package Classes;

public class UnitRegistry
{
    private UnitRegistry() {}
    private static class Holder {
        private static final UnitRegistry INSTANCE = new UnitRegistry();
    }
    public static UnitRegistry getInstance() {
        return Holder.INSTANCE;
    }

    public String format(double mass) {
        return String.format("%.1f kg", mass);
    }
}
