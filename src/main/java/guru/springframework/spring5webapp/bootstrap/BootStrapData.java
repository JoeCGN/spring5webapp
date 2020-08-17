package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRespository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRespository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRespository authorRespository, BookRepository bookRepository, PublisherRepository publisherRepository) {

			this.authorRepository = authorRespository;
			this.bookRepository = bookRepository;
			this.publisherRepository =  publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "ddd");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		
		Author rod = new Author("Rod", "Johnson");
		Book noejb = new Book("J2EE Development without EJB", "6546545");
		
		rod.getBooks().add(noejb);
		noejb.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noejb);
		
		Publisher firstChance = new Publisher("Mainstreet", "Los Angeles", "California", "123546");
		Publisher secondChance = new Publisher("SunsetBlvd.", "New York", "New York", "654321");
		
		publisherRepository.save(firstChance);
		publisherRepository.save(secondChance);

		System.out.println("Started In Bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of authors: " + authorRepository.count());
		System.out.println("Number of publishers: " + publisherRepository.count());
	}
	
}
