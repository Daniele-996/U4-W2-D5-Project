package danieleSanzari;

import danieleSanzari.entities.Collezione;
import danieleSanzari.entities.Gioco;
import danieleSanzari.entities.GiocoDaTavolo;
import danieleSanzari.entities.Videogioco;
import danieleSanzari.entities.enums.Genere;
import danieleSanzari.entities.enums.Piattaforma;

public class Application {

    public static void main(String[] args) {
        Gioco gioco = new GiocoDaTavolo(10001, "monopoly", 2012, 29.99, 8, 2);
        Gioco gioco1 = new GiocoDaTavolo(10002, "monopoly2", 2016, 29.99, 8, 2);
        Gioco gioco2 = new GiocoDaTavolo(10003, "monopoly3", 2022, 29.99, 8, 2);
        Gioco gioco7 = new GiocoDaTavolo(10007, "titolo", 2024, -0, 4, 4);

        Gioco gioco3 = new Videogioco(10004, "asc1", 2010, 39.99, Piattaforma.PS5, 30, Genere.AVVENTURA);
        Gioco gioco4 = new Videogioco(10005, "asc1", 2015, 39.99, Piattaforma.NINTENDO, 30, Genere.AVVENTURA);
        Gioco gioco5 = new Videogioco(10006, "asc1", 2019, 39.99, Piattaforma.XBOX, 30, Genere.AVVENTURA);

        Collezione collezioneGiochi = new Collezione();
        collezioneGiochi.aggiungiGioco(gioco5);
        collezioneGiochi.aggiungiGioco(gioco4);
        collezioneGiochi.aggiungiGioco(gioco3);
        collezioneGiochi.aggiungiGioco(gioco2);
        collezioneGiochi.aggiungiGioco(gioco1);
        collezioneGiochi.aggiungiGioco(gioco);
        collezioneGiochi.aggiungiGioco(gioco7);

        System.out.println(collezioneGiochi);
        System.out.println(collezioneGiochi.ricercaPerID(10006));
        System.out.println(collezioneGiochi.ricercaPerID(10002));

        System.out.println(collezioneGiochi.ricercaPerPrezzo(39.99));

        System.out.println(collezioneGiochi.ricercaPerNumeroGiocatori(8));

        collezioneGiochi.stampaStatistiche();
    }
}
