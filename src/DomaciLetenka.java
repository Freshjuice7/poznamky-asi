import java.util.Scanner;

public class DomaciLetenka extends Letenka {
    private int cisloTerminalu;

    public DomaciLetenka(Scanner sc) {
        super();
        sc.nextLine();
        System.out.print("Jaké je číslo terminálu? ");
        this.cisloTerminalu = sc.nextInt();
        sc.nextLine(); // vyčistí buffer
    }

    @Override
    public String toString() {
        return "Domácí " + super.toString() +
                " | Terminál: " + cisloTerminalu;
    }

    public int getCisloTerminalu() {
        return cisloTerminalu;
    }
}
