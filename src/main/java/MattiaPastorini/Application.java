package MattiaPastorini;

import MattiaPastorini.Entities.*;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collezione collezione= new Collezione();
        Scanner scanner = new Scanner(System.in);
         boolean esci=false;

         while (!esci){
             System.out.println("\n\n============ COLLEZIONE DI GIOCHI ============");
             System.out.println("==================== Menu ====================");
             System.out.println("1. Aggiungi Gioco");
             System.out.println("2. Ricerca per ID");
             System.out.println("3. Ricerca per prezzo");
             System.out.println("4. Ricerca per numero di giocatori");
             System.out.println("5. Elimina Gioco");
             System.out.println("6. Aggiorna Gioco");
             System.out.println("7. Statistiche della Collezione");
             System.out.println("8. Visualizza tutti i giochi della Collezione");
             System.out.println("0. Esci");
             System.out.println("==============================================");
             System.out.println("=================== Scelta ===================");

             int scelta=scanner.nextInt();
             scanner.nextLine();

             switch (scelta){
                 case 1 -> { //Aggiungi Gioco
                     System.out.println("Inserisci il tipo (1.VideoGioco o 2.Gioco da tavolo): ");
                     int tipo = scanner.nextInt();
                     scanner.nextLine();
                     System.out.println("Inserisci l'ID: ");
                     String id=scanner.nextLine();
                     System.out.println("Inserisci il titolo: ");
                     String titolo=scanner.nextLine();
                     System.out.println("Inserisci l'anno di uscita: ");
                     int anno=scanner.nextInt();
                     scanner.nextLine();
                     System.out.println("Inserisci il prezzo: ");
                     double prezzo= scanner.nextDouble();
                     scanner.nextLine();

                     if (tipo == 1){
                         System.out.println("Inserire la piattaforma: ");
                         String piattaforma = scanner.nextLine();
                         System.out.println("Inserire la durata in ore del gioco: ");
                         int ore = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("Inserire il genere del gioco (Azione, Avventura, RPG, Strategia, Sport, Puzzle, Simulazione): ");
                         String genereGioco = scanner.nextLine();

                         VideoGioco v = new VideoGioco(id, titolo, anno, prezzo, piattaforma, ore, VideoGioco.GenereVideoGioco.valueOf(genereGioco));
                         collezione.aggiungiGioco(v);
                     }else if (tipo == 2){
                         System.out.println("Inserire il numero si giocatori: ");
                         int nG = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("Inserire la durata media di una partita in minuti: ");
                         int minuti=scanner.nextInt();
                         scanner.nextLine();

                         GiocoDaTavolo g = new GiocoDaTavolo(id, titolo, anno, prezzo, nG, minuti);
                         collezione.aggiungiGioco(g);
                     }else {
                         System.out.println("Tipo non valido!");
                     }
                 }
                 case 2 -> { //Ricerca per ID
                     System.out.println("Inserire l'ID: ");
                     String id=scanner.nextLine();
                     Gioco  g = collezione.ricercaId(id);
                 }
                 case 3 -> { //Ricerca per prezzo
                     System.out.println("Inserire il prezzo: ");
                     double prezzoMax = scanner.nextDouble();
                     scanner.nextLine();
                     List<Gioco> list=collezione.ricercaPerPrezzo(prezzoMax);
                     list.forEach(System.out::println);
                 }
                 case 4 -> { //Ricerca per numero di giocatori
                     System.out.println("Inserire il numero dei giocatori: ");
                     int nG =scanner.nextInt();
                     scanner.nextLine();
                     List<GiocoDaTavolo> list = collezione.ricercaNumGiocatori(nG);
                     list.forEach(System.out::println);
                 }
                 case 5 -> { //Elimina gioco
                     System.out.println("Inserire l'ID da eliminare: ");
                     String id=scanner.nextLine();
                     collezione.rimuoviPerId(id);
                 }
                 case 6 -> { //Aggiorna gioco
                     System.out.println("Inserire l'ID del gioco che vuoi aggiornare: ");
                     String id=scanner.nextLine();
                     Gioco vecchio = collezione.ricercaId(id);
                     if (vecchio == null){
                         System.out.println("Id non trovato.");
                     }
                     System.out.println("Inserire il nuovo titolo:");
                     String titolo=scanner.nextLine();
                     System.out.println("Inserire il nuovo anno di uscita:");
                     int anno=scanner.nextInt();
                     scanner.nextLine();
                     System.out.println("Inserire il nuovo prezzo:");
                     double prezzo=scanner.nextDouble();
                     scanner.nextLine();

                     if (vecchio.getTipo().equals("VideoGioco")){
                         System.out.println("Inserire la nuova piattaforma:");
                         String piattaforma=scanner.nextLine();
                         System.out.println("Inserire la nuova durata in ore:");
                         int ore=scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("Inserire il nuovo genere (Azione, Avventura, RPG, Strategia, Sport, Puzzle, Simulazione):");
                         String genereGioco=scanner.nextLine();

                         VideoGioco v = new VideoGioco(id, titolo, anno, prezzo, piattaforma,  ore, VideoGioco.GenereVideoGioco.valueOf(genereGioco));
                         collezione.aggiornaGioco(id, v);
                     } else if (vecchio.getTipo().equals("Gioco Da Tavolo")) {
                         System.out.println("Inserire il nuovo numero di giocatori:");
                         int nG=scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("Inserire la nuova durata media di una partita in minuti:");
                         int minuti=scanner.nextInt();
                         scanner.nextLine();
                         GiocoDaTavolo g= new GiocoDaTavolo(id, titolo, minuti, prezzo, anno, nG);
                         collezione.aggiornaGioco(id, g);
                     }
                 }
                 case 7 -> { //Statistiche
                     collezione.Statistiche();
                 }
                 case 8 -> { //Visualizza Giochi
                     collezione.visualizzaGiochi();
                 }
                 case 0 -> { //Esci
                     esci=true;

                 }
                 default ->
                     System.out.println("Scelta non valida!");

             }
         }
         scanner.close();
    }
}
