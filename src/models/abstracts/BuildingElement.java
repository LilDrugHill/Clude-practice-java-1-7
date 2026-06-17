package models.abstracts;

import enums.Material;
import records.Dimensions;

import java.util.Optional;

public abstract class BuildingElement {
    private String name;
    private Material material;
    private Dimensions dimensions;
    public BuildingElement(String name, Material material, Dimensions dimensions) {
        setDimensions(dimensions);
        setMaterial(material);
        setName(name);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public String getName() {
        return this.name;
    }

    public Material getMaterial() {
        return this.material;
    }

    public Dimensions getDimensions() {
        return this.dimensions;
    }

    public double mass() {
        return this.material.getDensity() * this.dimensions.volume();
    }

    public static Optional<String> findName(BuildingElement[] elements, int index) {
        Optional<String> result;
        try {
            return Optional.of(elements[index].name);
        } catch (ArrayIndexOutOfBoundsException ex) {
            return Optional.empty();
        }
    }

    public static <T> T firstOrNull(T[] array) {
        if (array.length == 0) return null;
        return array[0];
    }

    public static double totalMass(BuildingElement... elements) {
        double totalMass = 0.0d;
        for (BuildingElement element : elements) {
            totalMass += element.mass();
        }
        return totalMass;
    }

    abstract public String category();
    abstract public String detailed();

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BuildingElement buildingElement)) return false;

        return buildingElement.getMaterial() == this.getMaterial()
                && buildingElement.getDimensions().equals(this.getDimensions())
                && buildingElement.getName().equals(this.getName());

    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() * this.getMaterial().hashCode() * this.getDimensions().hashCode();
    }

    public static void printCatalog(BuildingElement[] elements) {
        for (BuildingElement element : elements) {
            System.out.printf(
                    "%s|%s\n".formatted(
                            element.category(),
                            element));
        }
    }

    public final String report() {
        StringBuilder sb = new StringBuilder();
        String header = header();
        sb.append(header);
        sb.append("\n");
        sb.append(detailed());
        sb.append("\n");
        sb.append(footer(header.length()));
        return  sb.toString();
    }

    private String header() {
        return "=== %s | %s ===".formatted(category(), getName());
    }

    private String footer(int headerLength) {
        return "=".repeat(headerLength);
    }


}
