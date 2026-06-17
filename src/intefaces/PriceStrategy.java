package intefaces;

import models.abstracts.BuildingElement;

public interface PriceStrategy {
    double price(BuildingElement buildingElement);
}
