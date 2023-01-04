import java.io.IOException;

public class TableTest {
    private static void waitForEnter(String message) {
        System.out.println(message);
        System.out.println("Press ENTER to continue...");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Table table = new Table(3, 3);

        table.setCell("A1", new Cell(1));
        table.setCell("B1", new Cell(0));
        table.setCell("C1", new Cell("=A1+B1", table.getCell("A1"), table.getCell("B1")));
        table.setCell("A2", new Cell(0));
        table.setCell("B2", new Cell(1));
        table.setCell("C2", new Cell("=A2+B2", table.getCell("A2"), table.getCell("B2")));
        table.setCell("A3", new Cell(0));
        table.setCell("B3", new Cell(0));
        table.setCell("C3", new Cell(0));

        System.out.println(table);
        waitForEnter("Changing values A1 and B1 to 2 and 3 respectively");

        table.getCell("A1").setValue(2);
        table.getCell("B1").setValue(3);

        System.out.println(table);
        waitForEnter("Setting C3 to formula =C1+C2");

        table.setCell("C3", new Cell("=C1+C2", table.getCell("C1"), table.getCell("C2")));

        System.out.println(table);
        waitForEnter("Setting values A2 and B2 to 4 and 5 respectively");

        table.getCell("A2").setValue(4);
        table.getCell("B2").setValue(5);

        System.out.println(table);
        waitForEnter("Setting C3 to value 6");

        table.setCell("C3", new Cell(6));

        System.out.println(table);
        waitForEnter("Setting A1, A2 to values 7 and 8 respectively");

        table.getCell("A1").setValue(7);
        table.getCell("A2").setValue(8);

        System.out.println(table);
    }
}
