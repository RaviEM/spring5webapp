package guru.sprinframework.spring5webapp.bootstrap;

import guru.sprinframework.spring5webapp.model.Author;
import guru.sprinframework.spring5webapp.model.Book;
import guru.sprinframework.spring5webapp.model.Publisher;
import guru.sprinframework.spring5webapp.repositories.AuthorRepository;
import guru.sprinframework.spring5webapp.repositories.BookRepository;
import guru.sprinframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){
        Publisher harper_collins = new Publisher("Harper Collins","SFO, CA");
        publisherRepository.save(harper_collins);
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","123", harper_collins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher worx = new Publisher("worx","Portland, OR");
        publisherRepository.save(worx);
        Author rod = new Author("Rod","Jhonson");
        Book noEJB = new Book("J@EE development without EJB","235", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
