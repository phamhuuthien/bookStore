package model;

import java.util.Objects;

public class Category {
	private String code;
	private String titleCategory;
	private String description;
	
	public Category() {
		super();
	}
	
	public Category(String code, String titleCategory) {
		super();
		this.code = code;
		this.titleCategory = titleCategory;
	}

	
	public Category(String code, String titleCategory, String description) {
		super();
		this.code = code;
		this.titleCategory = titleCategory;
		this.description = description;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitleCategory() {
		return titleCategory;
	}
	public void setTitleCategory(String titleCategory) {
		this.titleCategory = titleCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "category [code=" + code + ", titleCategory=" + titleCategory + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(code, other.code);
	}
	
}
