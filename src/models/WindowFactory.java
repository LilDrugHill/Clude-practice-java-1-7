package models;

import annotations.Component;
import enums.Material;
import intefaces.ElementFactory;
import models.abstracts.BuildingElement;
import records.Dimensions;

@Component(name = "windowFactory")
public class WindowFactory implements ElementFactory {
    @Override
    public BuildingElement create(String name, Material material, Dimensions dimensions) {
        return new Window(name, material, dimensions);
    }
}