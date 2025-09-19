package MattiaPastorini.Entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import MattiaPastorini.Entities.*;

public class Collezione {
    private List<Gioco> giochi;

    public Collezione(){
        giochi = new ArrayList<>();
    }

    public void aggiungiGioco(Gioco gioco){
        if (giochi.stream().anyMatch(g -> g.getId().equals(gioco.getId()))){
            System.out.println("Errore: ID già presente!");
        }else{
            giochi.add(gioco);
            System.out.println("Gioco aggiunto con successo.");
        }
    }

    public Gioco ricercaId(String id){
        return giochi.stream().filter(g -> g.getId().equals(id)).findFirst().orElse(null);
    }
    public void rimuoviPerId(String id){
        boolean rimuovi= giochi.removeIf(g->g.getId().equals(id));
        if (rimuovi){
            System.out.println("Gioco eliminato con successo.");
        }else{
            System.out.println("ID non trovato!");
        }
    }
    public List<Gioco> ricercaPerPrezzo(double prezzoMax){
        return giochi.stream().filter(g->g.getPrezzo()<=prezzoMax).collect(Collectors.toList());
    }
    public List<GiocoDaTavolo> ricercaNumGiocatori(int numGiocatori){
        return giochi.stream().map(g->g.getTipo().equals("Gioco da tavolo") ? (GiocoDaTavolo) g : null).filter(Objects::nonNull).filter(g-> g.getNumGiocatori() == numGiocatori).collect(Collectors.toList());

    }
    public void aggiornaGioco(String id, Gioco nuovoGioco){
        boolean trovato=false;
        for (int i=0; i<giochi.size();i++){
            if (giochi.get(i).getId().equals(id)){
                giochi.set(i, nuovoGioco);
                trovato=true;
                System.out.println("Gioco aggiornato.");
                break;
            }
        }
        if (!trovato){
            System.out.println("ID non trovato");
        }
    }

    public void Statistiche(){
        long numVideoGiochi = giochi.stream().filter(g-> g.getTipo().equals("VideoGioco")).count();
        long numGiochiDaTavolo =  giochi.stream().filter(g-> g.getTipo().equals("Giochi Da Tavolo")).count();

        Gioco prezzoMax= giochi.stream().max(Comparator.comparingDouble(Gioco::getPrezzo)).orElse(null);
        double prezzoMedio = giochi.stream().mapToDouble(Gioco::getPrezzo).average().orElse(0);

        System.out.println("==================== Statistiche della collezione ====================");
        System.out.println("Il numero totale dei VideoGiochi nella collezione è: " + numVideoGiochi + ";");
        System.out.println("Il numero totale dei Giochi Da Tavolo nella collezione è: " + numGiochiDaTavolo + ";");
        System.out.println("Il gioco nella collezione con il prezzo più alto è: " + prezzoMax + ";");
        System.out.println("Nella collezione il prezzo medio dei giochi è: " + prezzoMedio + "€;");
        System.out.println("======================================================================");
    }
    public void visualizzaGiochi(){
        if (giochi.isEmpty()){
            System.out.println("La collezione è vuota!");
        }else{
            giochi.forEach(System.out::println);
        }
    }

}
