package models;

import intefaces.PriceStrategy;
import models.abstracts.BuildingElement;

public class Estimator {
    private final PriceStrategy priceStrategy;
    public Estimator(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public double estimate(BuildingElement[] buildingElements) {
        double price = 0.0d;
        for(BuildingElement buildingElement : buildingElements){
            price += priceStrategy.price(buildingElement);
        }
        return price;
    }
}
