package bettapcq.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


import java.time.LocalDate;

@Entity
@DiscriminatorValue("Calcio")
public class PartitaDiCalcio extends Evento{
private String squadraCasa;
private String squadraOspite;
private String squadraVincente;
private int numGolSqCasa;
private int numGolSqOspite;

public PartitaDiCalcio(){
    //costr vuoto
}


    public PartitaDiCalcio(String titolo,
                                  LocalDate dataEvento,
                                  String descrizione,
                                  tipiEvento tipoEvento,
                                  long numeroMassimoPartecipanti,
                                  String location,
                                  String squadraCasa,
                                  String squadraOspite,
                                  int numGolSqCasa,
                                  int numGolSqOspite

    ){
        super( titolo, dataEvento, descrizione, tipoEvento,numeroMassimoPartecipanti, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.numGolSqCasa = numGolSqCasa;
        this.numGolSqOspite = numGolSqOspite;
        if (numGolSqOspite == numGolSqCasa){
            this.squadraVincente = null;
        } else if(numGolSqOspite < numGolSqCasa){
            this.squadraVincente = squadraCasa;
        } else {
            this.squadraVincente = squadraOspite;
        }

    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public int getNumGolSqCasa() {
        return numGolSqCasa;
    }

    public void setNumGolSqCasa(int numGolSqCasa) {
        this.numGolSqCasa = numGolSqCasa;
    }

    public int getNumGolSqOspite() {
        return numGolSqOspite;
    }

    public void setNumGolSqOspite(int numGolSqOspite) {
        this.numGolSqOspite = numGolSqOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numGolSqCasa=" + numGolSqCasa +
                ", numGolSqOspite=" + numGolSqOspite +
                '}';
    }
}
