package com.example.mobilna;

public class PytanieZamkniete {
    private String tresc;
    private int obraz;
    private String odpowiedzA;
    private String odpowiedzB;
    private String odpowiedzC;
    private char poprawnaOdpowiedz;

    public PytanieZamkniete(String tresc, int obraz,
                            String odpowiedzA, String odpowiedzB, String odpowiedzC,
                            char poprawnaOdpowiedz) {
        this.tresc = tresc;
        this.obraz = obraz;
        this.odpowiedzA = odpowiedzA;
        this.odpowiedzB = odpowiedzB;
        this.odpowiedzC = odpowiedzC;
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
    }

    public String getTresc() {
        return tresc;
    }

    public int getObraz() {
        return obraz;
    }

    public String getOdpowiedzA() {
        return odpowiedzA;
    }

    public String getOdpowiedzB() {
        return odpowiedzB;
    }

    public String getOdpowiedzC() {
        return odpowiedzC;
    }

    public boolean sprawdz(char odpowiedz) {
        return odpowiedz == poprawnaOdpowiedz;
    }
}
