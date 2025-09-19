package MattiaPastorini.Entities;

public class GiocoDaTavolo extends Gioco {
    private int numGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo(String id, String titolo, int anno, double prezzo, int numGiocatori, int durataMediaPartita){
        super(id, titolo, anno, prezzo);

        if (numGiocatori>=2 && numGiocatori<=10){
            this.numGiocatori=numGiocatori;
        }else {
            System.out.println("Numero di giocatori non valido, minimo 2 e massimo 10.");
            this.numGiocatori= 2;
        }

        this.durataMediaPartita=durataMediaPartita;
    }

    public int getNumGiocatori(){
        return numGiocatori;
    }

    @Override
    public String getTipo(){
        return "Gioco da Tavolo";
    }

    @Override
    public String toString(){
        return super.toString() + "Gioco da tavolo, " + numGiocatori + " giocatori, " + durataMediaPartita + " min";
    }

}
