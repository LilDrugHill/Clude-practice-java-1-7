package models;

import enums.Material;
import models.abstracts.BuildingElement;
import records.Dimensions;

public class Window extends BuildingElement {
    private final boolean openable;

    public Window(String name, Material material, Dimensions dimensions, boolean openable) {
        super(name, material, dimensions);
        this.openable = openable;
    }
    public Window(String name, Material material, Dimensions dimensions) {
        super(name, material, dimensions);
        this.openable = true;
    }

    public boolean isOpenable() {
        return openable;
    }

    @Override
    public String category() {
        return "";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String detailed() {
        return "THIS IS A WINDOW";
    }
}
