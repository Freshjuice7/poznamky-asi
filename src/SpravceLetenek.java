import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SpravceLetenek {
    private ArrayList<Letenka> list = new ArrayList<>();

    public void pridatLetenku(Letenka letenka) {
        list.add(letenka);
        System.out.println("Letenka byla úspěšně přidána!");
    }

    public void odebratLetenku(int cisloLetenky) {
        boolean odebrano = list.removeIf(l -> l.getCisloLetenky() == cisloLetenky);
        if (odebrano) {
            System.out.println("Letenka byla smazána.");
        } else {
            System.out.println("Letenka s tímto číslem nebyla nalezena.");
        }
    }

    public void najitLetenkuPodleCisla(int cisloLetenky) {
        for (Letenka l : list) {
            if (l.getCisloLetenky() == cisloLetenky) {
                System.out.println(l);
                return;
            }
        }
        System.out.println("Letenka s tímto číslem nebyla nalezena.");
    }

    public void vypsatLetenkyZeZeme(String zeme) {
        boolean nalezeno = false;
        for (Letenka l : list) {
            if (l instanceof MezinarodniLetenka mez) {
                if (mez.getZemePristani().equalsIgnoreCase(zeme)) {
                    System.out.println(mez);
                    nalezeno = true;
                }
            }
        }
        if (!nalezeno) System.out.println("Žádné letenky do této země nejsou.");
    }

    public void smazatLetenkyPoOdletu() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate dnes = LocalDate.now();

        list.removeIf(l -> {
            try {
                LocalDate datum = LocalDate.parse(l.getDatumOdletu(), formatter);
                return datum.isBefore(dnes);
            } catch (Exception e) {
                return false;
            }
        });

        System.out.println("Všechny letenky s datem odletu v minulosti byly odstraněny.");
    }

    public void vypsatLetenky() {
        if (list.isEmpty()) {
            System.out.println("Žádné letenky nejsou uloženy.");
            return;
        }

        System.out.println("\n=== SEZNAM LETENEK ===");
        for (Letenka l : list) {
            if (l instanceof MezinarodniLetenka mez) {
                System.out.println("Letenka č. " + mez.getCisloLetenky());
                System.out.println("Odlet: " + mez.getOdletoveMisto());
                System.out.println("Cíl: " + mez.getCiloveMisto());
                System.out.println("Datum: " + mez.getDatumOdletu());
                System.out.println("Země přistání: " + mez.getZemePristani());
            } else if (l instanceof DomaciLetenka dom) {
                System.out.println("Letenka č. " + dom.getCisloLetenky());
                System.out.println("Odlet: " + dom.getOdletoveMisto());
                System.out.println("Cíl: " + dom.getCiloveMisto());
                System.out.println("Datum: " + dom.getDatumOdletu());
                System.out.println("Terminál: " + dom.getCisloTerminalu());
            }
            System.out.println("---------------------------"); // oddělení jednotlivých letenek
        }
    }
    public Letenka najitNejstarsiLetenku() {
        Letenka nejstarsi = null;

        for (Letenka l : list) {
            try {
                int rok = Integer.parseInt(l.getDatumOdletu());
                if (nejstarsi == null || rok < Integer.parseInt(nejstarsi.getDatumOdletu())) {
                    nejstarsi = l;
                }
            } catch (NumberFormatException e) {
                System.err.println("Chybný formát roku u letenky č. " + l.getCisloLetenky());
            }
        }

        return nejstarsi;
    }

}

