package records;

/**
 * Input params in mm
 * @param length mm
 * @param width mm
 * @param height mm
 */
public record Dimensions(double length, double width, double height) {
    public Dimensions {
        if (length < 0 || width < 0 || height < 0) throw new IllegalArgumentException();
    }

    /**
     *
     * @return kg/m^2
     */
    public double volume() {
        return length * width * height * Math.pow(0.001, 3);
    }
}
