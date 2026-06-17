package enums;

public enum Material {
    CONCRETE(2400), BRICK(1800), STEEL(7850), GLASS(2500), WOOD(600);

    public final double density;


    Material(double density) {
        this.density = density;
    }

    public double getDensity() {
        return density;
    }
}
