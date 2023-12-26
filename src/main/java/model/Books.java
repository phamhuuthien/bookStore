package model;

import java.util.Objects;

public class Books {
	private String idBook;
	private String title;
	private Author author;
	private String publicYear;
	private Double price;
	private int available;
	private String description;
//	loại sách
	private Category category;
//	lưu gg cloudinary cần cái này
	private String fileName;
	private Double star;
	public Books() {
		super();
	}
	public Books(String idBook, String title, Author author, String publicYear, Double price, int available,
			String description, Category category, String fileName, Double star) {
		super();
		this.idBook = idBook;
		this.title = title;
		this.author = author;
		this.publicYear = publicYear;
		this.price = price;
		this.available = available;
		this.description = description;
		this.category = category;
		this.fileName = fileName;
		this.star = star;
	}
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getPublicYear() {
		return publicYear;
	}
	public void setPublicYear(String publicYear) {
		this.publicYear = publicYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Double getStar() {
		return star;
	}
	public void setStar(Double star) {
		this.star = star;
	}
	@Override
	public String toString() {
		return "Books [idBook=" + idBook + ", title=" + title + ", author=" + author + ", publicYear=" + publicYear
				+ ", price=" + price + ", available=" + available + ", description=" + description + ", category="
				+ category + ", fileName=" + fileName + ", star=" + star + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idBook);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		return Objects.equals(idBook, other.idBook);
	}
	
}
