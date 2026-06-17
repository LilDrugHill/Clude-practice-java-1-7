import Classes.BuildingElement;
import Classes.UnitRegistry;
import enums.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import records.Dimensions;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    BuildingElement e1 = new BuildingElement(
            "Доска",
            Material.WOOD,
            new Dimensions(1000, 100, 5)
    );

    BuildingElement e2 = new BuildingElement(
            "Кирпич",
            Material.BRICK,
            new Dimensions(500, 100, 20));

    BuildingElement e3 = new BuildingElement(
            "Стальной лист",
            Material.STEEL,
            new Dimensions(1000, 500, 2));

    System.out.println(UnitRegistry.getInstance().format(BuildingElement.totalMass(e1, e2, e3)));
}
