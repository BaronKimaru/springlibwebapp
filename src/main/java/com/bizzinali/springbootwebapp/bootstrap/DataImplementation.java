package com.bizzinali.springbootwebapp.bootstrap;

import com.bizzinali.springbootwebapp.domain.Author;
import com.bizzinali.springbootwebapp.domain.Book;
import com.bizzinali.springbootwebapp.domain.Publisher;
import com.bizzinali.springbootwebapp.repositories.AuthorRepository;
import com.bizzinali.springbootwebapp.repositories.BookRepository;
import com.bizzinali.springbootwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// this decorator lets springframework know that the below should be a spring-managed component
@Component
public class DataImplementation implements CommandLineRunner {

    // dependency injection
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DataImplementation(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    // When Spring finds instances of this type, it Runs them
    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started Data Implementation");

        // set up a publisher (instantiate this since we didnt have initialized constructor)
        Publisher bloomsbury = new Publisher();
        // no need to include any of the below since none is initialized in constructor
        bloomsbury.setName("Bloomsbury Publishing Plc");
        bloomsbury.setAddressLine1("50 Bedford Square");
        bloomsbury.setZip("WC1B 3DP");
        bloomsbury.setCity("London");
        bloomsbury.setState("England");
        // save publisher to the H2 Database
        publisherRepository.save(bloomsbury);

        // set up some authors and books
        Author jkrowling = new Author("J.K.", "Rowling");
        Book chamberSecrets = new Book("Harry Potter & the Chamber of Secrets", "9526326");
        Book prisonerAzkaban = new Book("Harry Potter & the Prisoner of Azkaban", "325632856");
        Book sorcerersStone = new Book("Harry Potter & the Sorcerer's Stone", "548712333");
        Book gobletOfFire = new Book("Harry Potter & the Goblet Of Fire", "68752222");

        // 1. add book to the authors ... 2. author to the book ... 3. book to the publisher ... save to the h2 database
        jkrowling.getBooks().add(chamberSecrets);
        chamberSecrets.getAuthors().add(jkrowling);
        bloomsbury.getBooks().add(chamberSecrets);

        authorRepository.save(jkrowling);
        bookRepository.save(chamberSecrets);
        publisherRepository.save(bloomsbury);


        /*
        1. add book to the authors ...
        2. author to the book ...
        3. book to the publisher ...
        save to the h2 database
        */
        jkrowling.getBooks().add(prisonerAzkaban);
        prisonerAzkaban.getAuthors().add(jkrowling);
        bloomsbury.getBooks().add(prisonerAzkaban);

        // authorRepository.save(jkrowling);
        bookRepository.save(prisonerAzkaban);
        publisherRepository.save(bloomsbury);


        /*
        1. add book to the authors ...
        2. author to the book ...
        3. book to the publisher ...
        save to the h2 database
        */
        jkrowling.getBooks().add(sorcerersStone);
        sorcerersStone.getAuthors().add(jkrowling);
        bloomsbury.getBooks().add(sorcerersStone);

        // authorRepository.save(jkrowling);
        bookRepository.save(sorcerersStone);
        publisherRepository.save(bloomsbury);

        /*
        1. add book to the authors ...
        2. author to the book ...
        3. book to the publisher ...
        save to the h2 database
        */
        jkrowling.getBooks().add(gobletOfFire);
        gobletOfFire.getAuthors().add(jkrowling);
        bloomsbury.getBooks().add(gobletOfFire);

        // authorRepository.save(jkrowling);
        bookRepository.save(gobletOfFire);
        publisherRepository.save(bloomsbury);

        /*
        1. add book to the authors ...
        2. author to the book ...
        3. book to the publisher ...
        save to the h2 database
        */
        Author suntzu = new Author("Sun", "Tzu");
        Book artOfWar = new Book("Art of War", "1599869772");
        Publisher filiquarian = new Publisher();
        filiquarian.setName("Filiquarian");
        suntzu.getBooks().add(artOfWar);
        artOfWar.getAuthors().add(suntzu);
        filiquarian.getBooks().add(artOfWar);

        authorRepository.save(suntzu);
        bookRepository.save(artOfWar);
        publisherRepository.save(filiquarian);

        /*
        1. add book to the authors ...
        2. author to the book ...
        3. book to the publisher ...
        save to the h2 database
        */
        Publisher penguinPublishingGroup = new Publisher();
        penguinPublishingGroup.setName("Penguin Publishing Group");
        Author robertGreene = new Author("Robert", "Greene");
        Book the48LawsOfPower = new Book("The 48 Laws of Power", "0140280197");
        robertGreene.getBooks().add(the48LawsOfPower);
        the48LawsOfPower.getAuthors().add(robertGreene);
        penguinPublishingGroup.getBooks().add(the48LawsOfPower);

         authorRepository.save(robertGreene);
        bookRepository.save(the48LawsOfPower);
        publisherRepository.save(penguinPublishingGroup);


        System.out.println("No. of Publishers: " + publisherRepository.count());
        System.out.println("bloomsbury's no of Books: " + bloomsbury.getBooks().size());
        System.out.println("No. of Books: " + bookRepository.count());
        System.out.println("No. of Authors: " + authorRepository.count());
        System.out.println("Rowling's no of Books: " + jkrowling.getBooks().size());

    }
}
