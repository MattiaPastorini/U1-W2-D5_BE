package MattiaPastorini.Entities;

public abstract class Gioco {
    private String id;
    private String titolo;
    private int anno;
    private double prezzo;
    public abstract String getTipo();


    public Gioco(String id, String titolo, int anno, double prezzo){
        this.id= id;
        this.titolo= titolo;
        this.anno= anno;

        if (prezzo>0){
            this.prezzo= prezzo;
        }else{
            System.out.println("Il prezzo deve essere positivo!");
            this.prezzo=0;
        }

    }
    public String getId(){
        return id;
    }
    public double getPrezzo(){
        return prezzo;
    }
    public String getTitolo(){
        return titolo;
    }
    public int getAnno(){
        return anno;
    }


    @Override
    public String toString(){
        return titolo + " (" + anno + ") - " + prezzo + "€ -> ";
    }
}
