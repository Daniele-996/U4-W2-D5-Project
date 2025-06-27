package danieleSanzari.entities;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int mediaDurataPartita;

    public GiocoDaTavolo(int Id, String titolo, int anno, double prezzo, int numeroGiocatori, int mediaDurataPartita) {
        super(Id, titolo, anno, prezzo);
        this.numeroGiocatori = numeroGiocatori;
        this.mediaDurataPartita = mediaDurataPartita;
    }

    public int getMediaDurataPartita() {
        return mediaDurataPartita;
    }

    public void setMediaDurataPartita(int mediaDurataPartita) {
        this.mediaDurataPartita = mediaDurataPartita;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        this.numeroGiocatori = numeroGiocatori;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "mediaDurataPartita=" + mediaDurataPartita +
                ", numeroGiocatori=" + numeroGiocatori +
                ", anno=" + anno +
                ", prezzo=" + prezzo +
                ", Id=" + Id +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
