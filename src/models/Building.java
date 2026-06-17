package models;

import intefaces.ElementCondition;
import models.abstracts.BuildingElement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Building {
    private final BuildingElement[]  buildingElements;
    private final String address;

    private Building(String address, BuildingElement[] buildingElements) {
        this.address = address;
        this.buildingElements = buildingElements;
    };

    public BuildingElement[] filter(ElementCondition elementCondition) {
        return Arrays.stream(buildingElements)
                .filter(elementCondition::test)
                .toArray(BuildingElement[]::new);
    }

    public String getAddress() {
        return address;
    }
    /**
     * @return -1 if array is full
     */
    private static <T> int findFreeIndex(T[] array) {
        for  (int i = 0; i < array.length; i++) {
            if (array[i] == null) { return i; }
        }
        return -1;
    }

    /**
     * @return resized array with coped values and multiplied x2 length
     */
    private static <T> T[] resizeArray(T[] array) {
        int newLength = array.length * 2;
        return Arrays.copyOf(array, newLength);
    }

    public Iterator<BuildingElement> elementIterator() {
        return new Iterator<BuildingElement>() {
            int counter = -1;

            @Override
            public boolean hasNext() {
                return buildingElements[counter + 1] != null;
            }

            @Override
            public BuildingElement next() {
                if (hasNext()) return buildingElements[counter++];
                else throw new NoSuchElementException();
            }
        };
    }


    public static class Builder {
        private String address;
        private static final int START_ARRAY_LENGTH = 10;
        private BuildingElement[] buildingElements =  new BuildingElement[START_ARRAY_LENGTH];
        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public void addElement(BuildingElement buildingElement) {
            if (this.buildingElements == null) {
                this.buildingElements = new BuildingElement[START_ARRAY_LENGTH];
                buildingElements[0] = buildingElement;
                return;
            }

            int i = findFreeIndex(buildingElements);
            if(i == -1) {
                int newIndex = buildingElements.length;
                BuildingElement[] resizedBuildingElements = resizeArray(buildingElements);
                resizedBuildingElements[newIndex] = buildingElement;
                return;
            }

            buildingElements[i] = buildingElement;

        }

        public Building build() {
            if (address == null) { throw new IllegalArgumentException("address cannot be null"); }
            if (buildingElements == null) { throw new IllegalArgumentException("buildingElements cannot be null"); }
            return new Building(address, buildingElements);
        }



    }
}
