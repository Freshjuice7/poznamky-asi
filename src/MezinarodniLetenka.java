import java.util.Scanner;

public class MezinarodniLetenka extends Letenka {

    private String zemePristani;

    public MezinarodniLetenka(Scanner sc) {
        super();
        sc.nextLine();
        System.out.print("Jaká je země přistání? ");
        this.zemePristani = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Mezinárodní " + super.toString() +
                " | Země přistání: " + zemePristani;
    }

    public String getZemePristani() {
        return zemePristani;
    }
}
