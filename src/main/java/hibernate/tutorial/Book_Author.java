package hibernate.tutorial;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOOK_AUTHOR")
public class Book_Author {
	private long id;
	private String title;
	private String description;
	private Date publishedDate;

	private Author_Book author;

	public Book_Author() {
	}

	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PUBLISHED")
	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AUTHOR_ID")
	public Author_Book getAuthor() {
		return author;
	}

	public void setAuthor(Author_Book author) {
		this.author = author;
	}
}