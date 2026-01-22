package bettapcq.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("Atletica")
public class GaraDiAtletica extends Evento{
    private Set<Persona> setAtleti;
    @ManyToOne
    @JoinColumn(name = "id_persona_vincitore")
    private Persona vincitore;



    public GaraDiAtletica(){
    //costr vuoto
}

    public GaraDiAtletica(String titolo,
                           LocalDate dataEvento,
                           String descrizione,
                           tipiEvento tipoEvento,
                           long numeroMassimoPartecipanti,
                           String location,
                           Set<Persona> setAtleti,
                           Persona vincitore

    ){
        super( titolo, dataEvento, descrizione, tipoEvento,numeroMassimoPartecipanti, location);
       this.setAtleti = setAtleti;
       this.vincitore = vincitore;

    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    public Set<Persona> getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(Set<Persona> setAtleti) {
        this.setAtleti = setAtleti;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "setAtleti=" + setAtleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
