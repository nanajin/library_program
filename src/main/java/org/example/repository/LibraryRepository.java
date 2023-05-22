package org.example.repository;

import org.example.domain.Library;

import java.util.List;

public interface LibraryRepository {
    void insert(Library library);

    List<Library> findAll();

    Library findById(Long id);

    List<Library> findByName(String name);

    List<Library> findByAuthor(String author);

    List<Library> findByPublisher(String publisher);

    Library findByIsbn(String isbn);

    List<Library> findByCategory(String category);

    void countPlus(Long id, int count);

    void countMinus(Long id, int count);

    void deleteById(Long id);

    void updateSummary(Long id, String summary);

    void updateImage(Long id, String img);

    void updateCategory(Long id, String category);

    void removeAll();
}
