package models;

import models.abstracts.BuildingElement;

public class Building {
    private BuildingElement[]  buildingElements;
    private String address;

    private Building() {};

    public static class Builder {
        private String address;
        private BuildingElement[] buildingElements;
        private int buildingElementCounter = 0;
        Building withAddress(String address) {
            this.address = address;
        }
        Building addElement(BuildingElement buildingElement) {
            if (this.buildingElements == null) {
                this.buildingElements = new BuildingElement[10];
            }

        }



    }
}
