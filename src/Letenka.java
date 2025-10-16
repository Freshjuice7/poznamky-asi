import java.util.*;
public class Letenka {
    Scanner sc = new Scanner(System.in);
    private int cisloLetenky;
    private String odletoveMisto;
    private String ciloveMisto;
    private String datumOdletu;

    public Letenka() {
        System.out.print("Jaké je číslo letenky? ");
        this.cisloLetenky = sc.nextInt();
        sc.nextLine(); // <<< vyčistit buffer po nextInt

        System.out.print("Jaké je odletové místo? ");
        this.odletoveMisto = sc.nextLine();

        System.out.print("Jaké je cílové místo? ");
        this.ciloveMisto = sc.nextLine();

        System.out.print("Jaký je datum odletu? ");
        this.datumOdletu = sc.nextLine();
    }



    public int getCisloLetenky() {
        return cisloLetenky;
    }

    public void setCisloLetenky(int cisloLetenky) {
        this.cisloLetenky = cisloLetenky;
    }

    public String getOdletoveMisto() {
        return odletoveMisto;
    }

    public void setOdletoveMisto(String odletoveMisto) {
        this.odletoveMisto = odletoveMisto;
    }

    public String getCiloveMisto() {
        return ciloveMisto;
    }

    public void setCiloveMisto(String ciloveMisto) {
        this.ciloveMisto = ciloveMisto;
    }

    public String getDatumOdletu() {
        return datumOdletu;
    }

    public void setDatumOdletu(String datumOdletu) {
        this.datumOdletu = datumOdletu;
    }


}
