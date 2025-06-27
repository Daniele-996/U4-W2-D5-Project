package danieleSanzari.entities;

import java.util.*;
import java.util.stream.Collectors;

public class Collezione {
    private Map<Integer, Gioco> mapGiochi = new HashMap<>();

    public Map<Integer, Gioco> getMapGiochi() {
        return mapGiochi;
    }

    public void setMapGiochi(Map<Integer, Gioco> mapGiochi) {
        this.mapGiochi = mapGiochi;
    }

    public void aggiungiGioco(Gioco gioco) {
        if (mapGiochi.containsKey(gioco.getId())) throw new IllegalArgumentException("Id già esistente.");
        mapGiochi.put(gioco.getId(), gioco);
    }

    public Gioco ricercaPerID(Integer id) {
        if (!mapGiochi.containsKey(id)) throw new NoSuchElementException("Id non trovato.");
        return mapGiochi.get(id);
    }

    public List<Gioco> ricercaPerPrezzo(double prezzo) {
        return mapGiochi.values().stream()
                .filter(gioco -> gioco.getPrezzo() <= prezzo)
                .collect(Collectors.toList());
    }

    public List<GiocoDaTavolo> ricercaPerNumeroGiocatori(int numero) {
        return mapGiochi.values().stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .map(gioco -> (GiocoDaTavolo) gioco)
                .filter(gioco -> gioco.getNumeroGiocatori() == numero)
                .collect(Collectors.toList());
    }

    public void rimuoviGioco(Integer id) {
        if (!mapGiochi.containsKey(id)) throw new NoSuchElementException("Id non trovato.");
        mapGiochi.remove(id);
    }

    public void aggiornaGioco(Integer id, Gioco nuovo) {
        if (!mapGiochi.containsKey(id)) throw new NoSuchElementException("Id non trovato.");
        mapGiochi.put(id, nuovo);
    }

    public void stampaStatistiche() {
        int numVideoGiochi = Math.toIntExact(mapGiochi.values().stream().filter(gioco -> gioco instanceof Videogioco).count());
        int numGiochiDaTavolo = mapGiochi.size() - numVideoGiochi;
        Optional<Gioco> max = mapGiochi.values().stream().max(Comparator.comparing(Gioco::getPrezzo));
        double media = mapGiochi.values().stream().mapToDouble(Gioco::getPrezzo).average().orElse(0);

        System.out.println("Totale Videogiochi: " + numVideoGiochi);
        System.out.println("Totale Giochi da Tavolo: " + numGiochiDaTavolo);
        System.out.println("Prezzo massimo: " + (max.isPresent() ? max.get().getPrezzo() : "Non è disponibile stabilire un prezzo massimo!"));
        System.out.println("Prezzo medio: " + media);
    }

    @Override
    public String toString() {
        return "Collezione {" +
                "mapGiochi=" + mapGiochi +
                '}';
    }
}
