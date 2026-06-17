package Classes;

import enums.Material;
import records.Dimensions;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

public class BuildingElement {
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
        } catch (ArrayIndexOutOfBoundsException _) {
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
}
