package models;

import enums.Material;
import intefaces.PriceStrategy;
import models.abstracts.BuildingElement;

import java.util.EnumMap;
import java.util.Map;

public class ByMassPrice implements PriceStrategy {

    public final static Map<Material, Double> prices = new EnumMap<>(Material.class);
    static {
        prices.put(Material.CONCRETE, 0.10);
        prices.put(Material.BRICK,    0.30);
        prices.put(Material.WOOD,     0.80);
        prices.put(Material.STEEL,    2.50);
        prices.put(Material.GLASS,    4.00);
    }

    @Override
    public double price(BuildingElement buildingElement) {
        return buildingElement.mass() * prices.get(buildingElement.getMaterial());
    }
}
