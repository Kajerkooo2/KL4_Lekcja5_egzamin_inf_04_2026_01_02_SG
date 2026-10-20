public class PytanieZamkniete extends Pytanie {
    private String odpA;
    private String odpoB;
    private String odpC;
    private char poprawnaOdp;

    public PytanieZamkniete(String tresc, String zdjecie, String odpA, String odpB, String odpC, char poprawnaOdp) {
        super(tresc, zdjecie);

        this.odpA = odpA;
        this.odpoB = odpB;
        this.odpC = odpC;
        this.poprawnaOdp = poprawnaOdp;
    }

    @Override
    protected boolean SprawdzOdpowiedz(char odp) {
        if (Character.toUpperCase(odp) == Character.toUpperCase(this.poprawnaOdp)) {
            this.czy_poprawne = true;
        } else {
            this.czy_poprawne = false;
        }

        return this.czy_poprawne;
    }
}
