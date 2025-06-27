package danieleSanzari.entities;

public abstract class Gioco {
    protected int Id;
    protected String titolo;
    protected int anno;
    protected double prezzo;

    public Gioco(int Id, String titolo, int anno, double prezzo) {
        if (prezzo <= 0) throw new IllegalArgumentException("Prezzo deve essere un numero maggiore di 0");
        this.Id = Id;
        this.titolo = titolo;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    public String getTitolo() {
        return titolo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "Gioco {" +
                "titolo='" + titolo +
                ", Id=" + Id +
                ", anno=" + anno +
                ", prezzo=" + prezzo + '\'' +
                '}';
    }
}
