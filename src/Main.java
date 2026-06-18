import enums.Material;
import models.*;
import models.abstracts.BuildingElement;
import records.Dimensions;

import java.util.Arrays;

public class Main {
    // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        BuildingElement[] elements = {
                new Wall("Несущая стена", Material.CONCRETE, new Dimensions(6, 0.3, 3), true),
                new Wall("Перегородка", Material.BRICK, new Dimensions(4, 0.12, 3), false),
                new Window("Панорамное окно", Material.GLASS, new Dimensions(2, 0.05, 1.5), true),
                new Slab("Перекрытие 1 этажа", Material.CONCRETE, new Dimensions(6, 4, 0.2)),
                new Wall("Несущая стена", Material.CONCRETE, new Dimensions(6, 0.3, 3), true),
                new Wall("Перегородка", Material.BRICK, new Dimensions(4, 0.12, 3), false),
                new Window("Панорамное окно", Material.GLASS, new Dimensions(2, 0.05, 1.5), true),
                new Slab("Перекрытие 1 этажа", Material.CONCRETE, new Dimensions(6, 4, 0.2))
        };

        BuildingElement.printCatalog(elements);
        Arrays.stream(elements).forEach((x) -> System.out.println(x.report()));

        var w1 = new Wall("Несущая стена", Material.CONCRETE, new Dimensions(6, 0.3, 3), true);
        var w2 = new Wall("Несущая стена", Material.CONCRETE, new Dimensions(6, 0.3, 3), true);
        System.out.println(w1.equals(w2));

        Building.Builder builder = new Building.Builder().withAddress("Lenin's street 6");
        Arrays.stream(elements).forEach(builder::addElement);
        Building building = builder.build();

        BuildingElement[] walls = building.filter((el) -> el instanceof Wall);
        Arrays.stream(walls).forEach((el) -> System.out.println(el.report()));

        double prByMass = new Estimator(new ByMassPrice()).estimate(walls);
        double prByVolume = new Estimator(new ByVolumePrice()).estimate(walls);

        System.out.println("By Volume: " + prByVolume);
        System.out.println("By Mass: " + prByMass);
        if (prByVolume > prByMass) {
            System.out.println("By Volume: " + prByVolume);
            System.out.println("By Mass: " + prByMass);
        }

    }
}
