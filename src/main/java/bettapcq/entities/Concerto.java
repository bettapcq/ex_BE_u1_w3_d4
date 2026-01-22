package bettapcq.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;


@Entity
@DiscriminatorValue("Concerto")
public class Concerto extends Evento {
    private GeneriConcerto genere;
    private boolean inStreaming;

    public Concerto(){
        //costr vuoto
    }


    public Concerto(String titolo,
                          LocalDate dataEvento,
                          String descrizione,
                          tipiEvento tipoEvento,
                          long numeroMassimoPartecipanti,
                          Location location,
                          GeneriConcerto genere,
                          boolean inStreaming

    ){
        super( titolo, dataEvento, descrizione, tipoEvento,numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;

    }

    public GeneriConcerto getGenere() {
        return genere;
    }

    public void setGenere(GeneriConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
