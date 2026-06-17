package models;

import enums.Material;
import models.abstracts.BuildingElement;
import records.Dimensions;

public class Slab extends BuildingElement {
    public Slab(String s, Material material, Dimensions dimensions) {
        super(s, material, dimensions);
    }

    @Override
    public String category() {
        return "SLAB";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String detailed() {
        return "THIS IS A SLAB";
    }
}
