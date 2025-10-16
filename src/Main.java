import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SpravceLetenek spravce = new SpravceLetenek();
        boolean pokracovat = true;

        while (pokracovat) {
            System.out.println("\n===== SPRÁVCE LETENEK =====");
            System.out.println("1. Přidat letenku");
            System.out.println("2. Smazat letenku podle čísla");
            System.out.println("3. Vyhledat letenku podle čísla");
            System.out.println("4. Vypsat všechny letenky z dané země");
            System.out.println("5. Smazat všechny letenky, jejichž let již proběhl");
            System.out.println("6. Vypsat všechny letenky");
            System.out.println("0. Ukončit program");
            System.out.print("Zadej volbu: ");

            int volba = sc.nextInt();
            sc.nextLine(); // vyčistí buffer

            switch (volba) {
                case 0 -> {
                    pokracovat = false;
                    System.out.println("Program ukončen.");
                }

                case 1 -> {
                    System.out.println("Jaký je to typ letenky?");
                    System.out.println("1. Domácí");
                    System.out.println("2. Mezinárodní");
                    System.out.print("Zadej volbu: ");
                    int typ = sc.nextInt();
                    sc.nextLine(); // vyčistí buffer

                    switch (typ) {
                        case 1 -> spravce.pridatLetenku(new DomaciLetenka(sc));
                        case 2 -> spravce.pridatLetenku(new MezinarodniLetenka(sc));
                        default -> System.err.println("Neplatná volba typu letenky!");
                    }
                }

                case 2 -> {
                    System.out.print("Zadej číslo letenky ke smazání: ");
                    int cislo = sc.nextInt();
                    sc.nextLine();
                    spravce.odebratLetenku(cislo);
                }

                case 3 -> {
                    System.out.print("Zadej číslo letenky k vyhledání: ");
                    int cislo = sc.nextInt();
                    sc.nextLine();
                    spravce.najitLetenkuPodleCisla(cislo);
                }

                case 4 -> {
                    System.out.print("Zadej zemi (např. Česká republika): ");
                    String zeme = sc.nextLine();
                    spravce.vypsatLetenkyZeZeme(zeme);
                }

                case 5 -> spravce.smazatLetenkyPoOdletu();

                case 6 -> spravce.vypsatLetenky();
                case 7 -> {
                    Letenka nejstarsi = spravce.najitNejstarsiLetenku();
                    if (nejstarsi != null) {
                        System.out.println("Nejstarší letenka:");
                        System.out.println(nejstarsi);
                    } else {
                        System.out.println("Žádné letenky k dispozici.");
                    }
                }


                default -> System.err.println("Neplatná volba!");
            }
        }

        sc.close();
    }
}
