package models;

import enums.Material;
import models.abstracts.BuildingElement;
import records.Dimensions;

public class Wall extends BuildingElement {

    private final boolean loadBearing;

    public boolean isLoadBearing() {
        return loadBearing;
    }

    public Wall(String name, Material material, Dimensions dimensions, boolean loadBearing) {
        super(name, material, dimensions);
        this.loadBearing = loadBearing;
    }

    public Wall(String name, Material material, Dimensions dimensions) {
        super(name, material, dimensions);
        this.loadBearing = false;
    }

    @Override
    public String category() {
        return "WALL";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String detailed() {
        return "THIS IS A WALL";
    }
}
