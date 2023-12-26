package model;

import java.sql.Date;
import java.util.Objects;

public class Author {
	private String authorId;
	private String authorName;
	private String authorDes;
	private Date authorDate;
	
	public Author() {
		super();
	}
	public Author(String authorId, String authorName, String authorDes, Date authorDate) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDes = authorDes;
		this.authorDate = authorDate;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorDes() {
		return authorDes;
	}
	public void setAuthorDes(String authorDes) {
		this.authorDes = authorDes;
	}
	public Date getAuthorDate() {
		return authorDate;
	}
	public void setAuthorDate(Date authorDate) {
		this.authorDate = authorDate;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", authorDes=" + authorDes
				+ ", authorDate=" + authorDate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(authorId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(authorId, other.authorId);
	}
	
}
