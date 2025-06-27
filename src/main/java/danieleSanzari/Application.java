package danieleSanzari;

import danieleSanzari.entities.Collezione;
import danieleSanzari.entities.Gioco;
import danieleSanzari.entities.GiocoDaTavolo;
import danieleSanzari.entities.Videogioco;
import danieleSanzari.entities.enums.Genere;
import danieleSanzari.entities.enums.Piattaforma;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Collezione collezioneGiochi = new Collezione();
        Scanner scan = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓ MENU ⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓");
            System.out.println("1. Aggiungi Videogioco");
            System.out.println("2. Aggiungi Gioco da Tavolo");
            System.out.println("3. Ricerca per ID");
            System.out.println("4. Ricerca per Prezzo");
            System.out.println("5. Ricerca per numero di Giocatori");
            System.out.println("6. Rimuovi per ID");
            System.out.println("7. Aggiorna per ID");
            System.out.println("8. Statistiche");
            System.out.println("9. Esci");
            System.out.println("10. Visualizza tutti i giochi");

            int scelta = Integer.parseInt(scan.nextLine());

            try {
                switch (scelta) {
                    case 1 -> {
                        try {
                            System.out.print("ID: ");
                            int Id = Integer.parseInt(scan.nextLine());
                            System.out.print("Titolo: ");
                            String titolo = scan.nextLine();
                            System.out.print("Anno: ");
                            int anno = Integer.parseInt(scan.nextLine());
                            double prezzo;
                            while (true) {
                                System.out.print("Prezzo (> 0): ");
                                prezzo = Double.parseDouble(scan.nextLine());
                                if (prezzo > 0) break;
                                System.out.println("Prezzo non valido. Deve essere maggiore di 0.");
                            }
                            System.out.print("Piattaforma (PC, PS5, XBOX, NINTENDO3): ");
                            Piattaforma piattaforma = Piattaforma.valueOf(scan.nextLine().toUpperCase());
                            System.out.print("Durata (ore): ");
                            int durata = Integer.parseInt(scan.nextLine());
                            System.out.print("Genere (STRATEGIA, AVVENTURA, ROMPICAPO, SINGOLO, MULTIGIOCATORE, SPORT): ");
                            Genere genere = Genere.valueOf(scan.nextLine().toUpperCase());
                            collezioneGiochi.aggiungiGioco(new Videogioco(Id, titolo, anno, prezzo, piattaforma, durata, genere));
                        } catch (Exception err) {
                            System.out.println("Errore durante l’inserimento: " + err.getMessage());
                        }
                    }

                    case 2 -> {
                        try {
                            System.out.print("ID: ");
                            int Id = Integer.parseInt(scan.nextLine());
                            System.out.print("Titolo: ");
                            String titolo = scan.nextLine();
                            System.out.print("Anno: ");
                            int anno = Integer.parseInt(scan.nextLine());
                            double prezzo;
                            while (true) {
                                System.out.print("Prezzo (> 0): ");
                                prezzo = Double.parseDouble(scan.nextLine());
                                if (prezzo > 0) break;
                                System.out.println("Prezzo non valido. Deve essere maggiore di 0.");
                            }
                            int giocatori;
                            while (true) {
                                System.out.print("Numero Giocatori (2-10): ");
                                giocatori = Integer.parseInt(scan.nextLine());
                                if (giocatori >= 2 && giocatori <= 10) break;
                                System.out.println("Numero giocatori non valido. Deve essere tra 2 e 10.");
                            }
                            System.out.print("Durata media (minuti): ");
                            int durata = Integer.parseInt(scan.nextLine());
                            collezioneGiochi.aggiungiGioco(new GiocoDaTavolo(Id, titolo, anno, prezzo, giocatori, durata));
                        } catch (NumberFormatException err) {
                            System.out.println("Inserisci un numero valido!");
                        }
                    }

                    case 3 -> {
                        System.out.print("ID: ");
                        int Id = Integer.parseInt(scan.nextLine());
                        System.out.println(collezioneGiochi.ricercaPerID(Id));
                    }
                    case 4 -> {
                        System.out.print("Prezzo max: ");
                        double maxPrezzo = Double.parseDouble(scan.nextLine());
                        collezioneGiochi.ricercaPerPrezzo(maxPrezzo)
                                .forEach(System.out::println);
                    }
                    case 5 -> {
                        System.out.print("Numero di giocatori: ");
                        int numero = Integer.parseInt(scan.nextLine());
                        List<Gioco> giochiCompatibili = collezioneGiochi.ricercaPerNumeroGiocatori(numero);
                        if (giochiCompatibili.isEmpty()) {
                            System.out.println("Nessun gioco da tavolo trovato per " + numero + " giocatori.");
                        } else {
                            giochiCompatibili.forEach(System.out::println);
                        }
                    }
                    case 6 -> {
                        System.out.print("ID: ");
                        collezioneGiochi.rimuoviGioco(Integer.valueOf(scan.nextLine()));
                    }
                    case 7 -> {
                        System.out.print("ID da aggiornare: ");
                        int id = Integer.parseInt(scan.nextLine());

                        try {
                            Gioco giocoEsistente = collezioneGiochi.ricercaPerID(id);
                            System.out.println("Gioco trovato: " + giocoEsistente);

                            System.out.println("Inserisci i nuovi dati:");
                            System.out.print("Titolo: ");
                            String titolo = scan.nextLine();
                            System.out.print("Anno: ");
                            int anno = Integer.parseInt(scan.nextLine());

                            double prezzo;
                            while (true) {
                                System.out.print("Prezzo (> 0): ");
                                prezzo = Double.parseDouble(scan.nextLine());
                                if (prezzo > 0) break;
                                System.out.println("Prezzo non valido.");
                            }

                            if (giocoEsistente instanceof Videogioco) {
                                System.out.print("Piattaforma: ");
                                Piattaforma piattaforma = Piattaforma.valueOf(scan.nextLine().toUpperCase());
                                System.out.print("Durata: ");
                                int durata = Integer.parseInt(scan.nextLine());
                                System.out.print("Genere: ");
                                Genere genere = Genere.valueOf(scan.nextLine().toUpperCase());

                                Videogioco nuovo = new Videogioco(id, titolo, anno, prezzo, piattaforma, durata, genere);
                                collezioneGiochi.aggiornaGioco(id, nuovo);

                            } else if (giocoEsistente instanceof GiocoDaTavolo) {
                                int giocatori;
                                while (true) {
                                    System.out.print("Numero Giocatori (2-10): ");
                                    giocatori = Integer.parseInt(scan.nextLine());
                                    if (giocatori >= 2 && giocatori <= 10) break;
                                    System.out.println("Numero non valido.");
                                }

                                System.out.print("Durata media: ");
                                int durata = Integer.parseInt(scan.nextLine());

                                GiocoDaTavolo nuovo = new GiocoDaTavolo(id, titolo, anno, prezzo, giocatori, durata);
                                collezioneGiochi.aggiornaGioco(id, nuovo);
                            }

                            System.out.println("Gioco aggiornato con successo!");

                        } catch (NoSuchElementException err) {
                            System.out.println("ID non trovato.");
                        } catch (Exception err) {
                            System.out.println("Errore durante l'aggiornamento: " + err.getMessage());
                        }
                    }

                    case 8 -> collezioneGiochi.stampaStatistiche();
                    case 9 -> continua = false;
                    case 10 -> {
                        System.out.println("------- GIOCHI NELLA COLLEZIONE -------");
                        collezioneGiochi.getMapGiochi().values().forEach(System.out::println);
                    }
                }
            } catch (Exception err) {
                System.out.println("Errore: " + err.getMessage());
            }
        }
        scan.close();
    }

}
