package org.example.domain;

public class Library {
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private String isbn;
    private int releaseYear;
    private int count;
    private String summary;
    private String image;
    private String category;

    public Library() {
    }

    public Library(String name, String author, String publisher, String isbn, int releaseYear, int count, String summary, String image, String category) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.releaseYear = releaseYear;
        this.count = count;
        this.summary = summary;
        this.image = image;
        this.category = category;
    }

    public Library(Long id, String name, String author, String publisher, String isbn, int releaseYear, int count, String summary, String image, String category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.releaseYear = releaseYear;
        this.count = count;
        this.summary = summary;
        this.image = image;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getCount() {
        return count;
    }

    public String getSummary() {
        return summary;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }
}
