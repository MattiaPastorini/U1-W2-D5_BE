package MattiaPastorini.Entities;

public class VideoGioco extends Gioco {
    private String piattaforma;
    private int durataGioco;
    private GenereVideoGioco genere;

    public enum GenereVideoGioco{
        Azione, Avventura, RPG, Strategia, Sport, Puzzle, Simulazione
    }

    public VideoGioco(String id, String titolo, int anno, double prezzo, String piattaforma, int durataGioco, GenereVideoGioco genere){
        super(id, titolo, anno, prezzo);
        this.piattaforma= piattaforma;
        this.durataGioco= durataGioco;
        this.genere= genere;
    }

    @Override
    public String getTipo(){
        return "Videogioco";
    }

    @Override
    public String toString(){
        return super.toString() + "Videogioco, " + piattaforma + ", " + durataGioco + " ore, genere: " + genere;
    }
}
