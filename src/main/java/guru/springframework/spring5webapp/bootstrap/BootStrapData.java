package guru.springframework.spring5webapp.bootstrap;

import org.hibernate.dialect.pagination.FirstLimitHandler;
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
		
		//Some authors
		Author auth_eric = new Author("Eric", "Evans");
		Author auth_rod = new Author("Rod", "Johnson");

		//Some Books
		Book book_ddd = new Book("Domain Driven Design", "ddd");
		Book book_noejb = new Book("J2EE Development without EJB", "6546545");
		
		//Some publishers
		Publisher pub_firstChance = new Publisher("Mainstreet", "Los Angeles", "California", "123546");
		Publisher pub_secondChance = new Publisher("SunsetBlvd.", "New York", "New York", "654321");
		
		//Add to repository
		authorRepository.save(auth_eric);
		authorRepository.save(auth_rod);
		
		bookRepository.save(book_ddd);
		bookRepository.save(book_noejb);
		
		
		publisherRepository.save(pub_firstChance);
		publisherRepository.save(pub_secondChance);
		

		//Add some relationships
		auth_eric.getBooks().add(book_ddd);
		book_ddd.getAuthors().add(auth_eric);

		pub_firstChance.getBooks().add(book_ddd);
		book_ddd.setPublisher(pub_firstChance);
		
		auth_rod.getBooks().add(book_noejb);
		book_noejb.getAuthors().add(auth_rod);
		pub_secondChance.getBooks().add(book_noejb);
		book_noejb.setPublisher(pub_secondChance);
		
		//Add to repository
		authorRepository.save(auth_eric);
		authorRepository.save(auth_rod);
		
		bookRepository.save(book_ddd);
		bookRepository.save(book_noejb);
		
		
		publisherRepository.save(pub_firstChance);
		publisherRepository.save(pub_secondChance);

		//Check
		System.out.println("Started In Bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of authors: " + authorRepository.count());
		System.out.println("Number of publishers: " + publisherRepository.count());
	}
	
}
