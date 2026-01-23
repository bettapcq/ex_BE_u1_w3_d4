package bettapcq.dao;

import bettapcq.entities.Concerto;
import bettapcq.entities.Evento;
import bettapcq.entities.GeneriConcerto;
import bettapcq.exceptions.IdNotFoundException;
import bettapcq.exceptions.NotResultFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventiDAO {
    private final EntityManager entityManager;

    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //metodo save:

    public void save(Evento nuovoEvento) {
        //1.richiesta nuova transazione:
        EntityTransaction transaction = entityManager.getTransaction();

        //2.avvio transazione:
        transaction.begin();

        //3.aggiunta dell'entità al PersistentContext (la rendiamo "managed"):
        entityManager.persist(nuovoEvento);

        //4.committiamo la modifica nel DB:
        transaction.commit();

        //5.msg di avvenuta operazione:
        System.out.println("L'aggiunta dell' evento con id " + nuovoEvento.getId() + " è avvenuta con successo!");
    }

    //metodo getById:

    public Evento getById(long idToSearch) {
        //questo metodo ritorna direttamente un'entità "managed":
        Evento result = entityManager.find(Evento.class, idToSearch);
        if (result == null) throw new IdNotFoundException(idToSearch);
        return result;
    }

    //metodo deleteById:

    public void deleteById(long idToSearch) {
        //0.ricerca dell'Id nel DB (automaticamente "managed"):
        Evento result = this.getById(idToSearch);

        //1.richiesta nuova transazione:
        EntityTransaction transaction = entityManager.getTransaction();

        //2.avvio transazione:
        transaction.begin();

        //3.rimozione dell'entità dal PersistentContext:
        entityManager.remove(result);

        //4.committiamo la modifica nel DB:
        transaction.commit();

        //5.msg di avvenuta operazione:
        System.out.println("La rimozione dell' evento con id " + idToSearch + " è avvenuta con successo!");
    }

    public List<Concerto> getConcertiInStreaming(boolean booleano){
            TypedQuery<Concerto> query = entityManager.createQuery("SELECT concerto FROM Concerto concerto WHERE concerto.inStreaming = :isStreaming", Concerto.class);
        query.setParameter("isStreaming", booleano);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GeneriConcerto genere){
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.genere LIKE :n", Concerto.class);
        query.setParameter("n", genere);
        return query.getResultList();
    }
}
