import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        Container container = new Container();

        Product hoverboard1 = new Hoverboard("1", "a", "Lexis");
        Product hoverboard2 = new Hoverboard("2", "b", "Laxis");

        Product hydroBottle1 = new HydroBottle("110101001");
        Product hydroBottle2 = new HydroBottle("100101101");

        container.add(hoverboard1);
        container.add(hoverboard2);
        container.add(hydroBottle1);
        container.add(hydroBottle2);

        container.printProductList();

    }
}
