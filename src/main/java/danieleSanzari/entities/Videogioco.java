package danieleSanzari.entities;

import danieleSanzari.entities.enums.Genere;
import danieleSanzari.entities.enums.Piattaforma;

public class Videogioco extends Gioco {
    private Piattaforma piattaforma;
    private int durataGioco;
    private Genere genere;

    public Videogioco(int Id, String titolo, int anno, double prezzo, Piattaforma piattaforma, int durataGioco, Genere genere) {
        super(Id, titolo, anno, prezzo);
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;

    }

    public int getDurataGioco() {
        return durataGioco;
    }

    public void setDurataGioco(int durataGioco) {
        this.durataGioco = durataGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Piattaforma getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(Piattaforma piattaforma) {
        this.piattaforma = piattaforma;
    }

    @Override
    public String toString() {
        return "Videogioco {" +
                "durataGioco=" + durataGioco +
                ", piattaforma=" + piattaforma +
                ", genere=" + genere +
                ", anno=" + anno +
                ", Id=" + Id +
                ", prezzo=" + prezzo +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
