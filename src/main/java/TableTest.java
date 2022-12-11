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

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Table table = new Table(3, 3);

        table.setCell("A1", new Cell(1, table));
        table.setCell("B1", new Cell(0, table));
        table.setCell("C1", new Formula("=A1+B1", table));
        table.setCell("A2", new Cell(0, table));
        table.setCell("B2", new Cell(1, table));
        table.setCell("C2", new Formula("=A2+B2", table));
        table.setCell("A3", new Cell(0, table));
        table.setCell("B3", new Cell(0, table));
        table.setCell("C3", new Cell(0, table));

        System.out.println(table);
        waitForEnter("Changing values A1 and B1 to 2 and 3 respectively");

        table.setCell("A1", new Cell(2, table));
        table.setCell("B1", new Cell(3, table));

        System.out.println(table);
        waitForEnter("Setting C3 to formula =C1+C2");

        table.setCell("C3", new Formula("=C1+C2", table));

        System.out.println(table);
        waitForEnter("Setting values A2 and B2 to 4 and 5 respectively");

        table.setCell("A2", new Cell(4, table));
        table.setCell("B2", new Cell(5, table));

        System.out.println(table);
        waitForEnter("Setting C3 to value 6");

        table.setCell("C3", new Cell(6, table));

        System.out.println(table);
        waitForEnter("Setting A1, A2 to values 7 and 8 respectively");

        table.setCell("A1", new Cell(7, table));
        table.setCell("A2", new Cell(8, table));

        System.out.println(table);
    }
}
