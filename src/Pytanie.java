public abstract class Pytanie {
    protected String tresc,zdjecie;
    protected boolean czy_poprawne;

    public Pytanie(String tresc, String zdjecie) {
        this.tresc = tresc;
        this.zdjecie = zdjecie;
        this.czy_poprawne = false;
    }

    protected abstract boolean SprawdzOdpowiedz(char odp);
}
