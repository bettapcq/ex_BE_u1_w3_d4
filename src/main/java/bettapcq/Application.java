package bettapcq;

import bettapcq.dao.EventiDAO;
import bettapcq.dao.LocationsDAO;
import bettapcq.dao.PartecipazioniDAO;
import bettapcq.dao.PersoneDAO;
import bettapcq.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import com.github.javafaker.Faker;

public class Application {

    //connessione al DB tramite apertura EntityManagerFactory:
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi2pu");

    public static void main(String[] args) {

        System.out.println("Hello world!");

        Faker faker = new Faker(Locale.ITALY);
        Random rndm = new Random();

//oggetto per la gestione delle comunicazioni con DB:
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //richiamo il DAO:
        EventiDAO eventiDAO = new EventiDAO(entityManager);
        LocationsDAO locationsDAO = new LocationsDAO(entityManager);
        PartecipazioniDAO partecipazioniDAO = new PartecipazioniDAO(entityManager);
        PersoneDAO personeDAO = new PersoneDAO(entityManager);

        Location locationX = locationsDAO.getById(3);


        Concerto concerto = new Concerto(
                faker.rockBand().name(),
                LocalDate.now().plusDays(20),
                faker.lorem().sentence(),
                tipiEvento.PUBBLICO,
                faker.number().numberBetween(500, 20000),
                locationX,
                GeneriConcerto.ROCK,
                faker.bool().bool()
        );


        eventiDAO.save(concerto);



        // chiusura EntityManager, EntityManagerFactory:
        entityManager.close();
        entityManagerFactory.close();

    }
}





//
//        for (int i = 0; i < 20; i++) {
//        eventiDAO.save(new Evento(
//        faker.chuckNorris().fact(),
//                    LocalDate.of(rndm.nextInt(2023, 2025),
//                            rndm.nextInt(1, 13),
//                            rndm.nextInt(1, 29)),
//        faker.lorem().fixedString(50),
//                    rndm.nextInt(1, 3) == 1 ? tipiEvento.PRIVATO : tipiEvento.PUBBLICO,
//        rndm.nextInt(1, 1000),rndm.nextInt(0, 2) == 0 ? location1: location2));
//      Location location1 = new Location(faker.address().city(), faker.address().cityName());
//         locationsDAO.save(location1);
//
//        Location location2 = new Location(faker.address().city(), faker.address().cityName());
//         locationsDAO.save(location2);

//      Persona persona2 = new Persona(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),  LocalDate.now(), TipiSesso.MASCHIO);
//      personeDAO.save(persona2);

