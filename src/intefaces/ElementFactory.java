package intefaces;

import enums.Material;
import models.abstracts.BuildingElement;
import records.Dimensions;

public interface ElementFactory {
    BuildingElement create(String name, Material material, Dimensions dimensions);
}