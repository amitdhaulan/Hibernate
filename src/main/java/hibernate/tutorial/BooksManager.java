package hibernate.tutorial;

import hibernate.util.HibernateUtil;

import java.util.Date;

import org.hibernate.Session;

/**
 * This program demonstrates using Hibernate framework to manage a one-to-one
 * mapping with foreign key using annotations.
 *
 * @author amitk
 *
 */
public class BooksManager {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Book_Author newBook = new Book_Author();
		newBook.setTitle("Hibernate Made Easy");
		newBook.setDescription("Simplified Data Persistence with Hibernate and JPA");
		newBook.setPublishedDate(new Date());

		newBook.setAuthor(new Author_Book("Amit Kumar Singh Kashyap",
				"amitk@gmail.com"));

		Long bookId = (Long) session.save(newBook);

		Book_Author book = (Book_Author) session.get(Book_Author.class, bookId);
		System.out.println("Book's Title: " + book.getTitle());
		System.out.println("Book's Description: " + book.getTitle());

		Author_Book author = book.getAuthor();
		System.out.println("Author's Name: " + author.getName());
		System.out.println("Author's Email: " + author.getEmail());

		session.getTransaction().commit();
		session.close();
	}
}