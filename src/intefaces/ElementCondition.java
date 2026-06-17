package intefaces;

import models.abstracts.BuildingElement;

@FunctionalInterface
public interface ElementCondition {
    boolean test(BuildingElement element);
}
