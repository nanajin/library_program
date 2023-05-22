package org.example.service;

import org.example.domain.Library;
import org.example.repository.LibraryRepositoryImpl;

import java.util.List;

public class LibraryService {
    private final LibraryRepositoryImpl libraryRepository;

    public LibraryService(LibraryRepositoryImpl libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void insert(Library library) {
        libraryRepository.insert(library);
    }

    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    public Library findById(Long id) {
        return libraryRepository.findById(id);
    }

    public Library findByName(String name) {
        return libraryRepository.findByName(name);
    }

    public List<Library> findByAuthor(String author) {
        return libraryRepository.findByAuthor(author);
    }

    public List<Library> findByPublisher(String publisher) {
        return libraryRepository.findByPublisher(publisher);
    }

    public Library findByIsbn(String isbn) {
        return libraryRepository.findByIsbn(isbn);
    }

    public List<Library> findByCategory(String category) {
        return libraryRepository.findByCategory(category);
    }

    public void countPlus(Long id, int count) {
        libraryRepository.countPlus(id, count);
    }

    public void countMinus(Long id, int count) {
        libraryRepository.countMinus(id, count);
    }

    public void deleteById(Long id) {
        libraryRepository.deleteById(id);
    }

    public void updateSummary(Long id, String summary) {
        libraryRepository.updateSummary(id, summary);
    }

    public void updateImage(Long id, String img) {
        libraryRepository.updateImage(id, img);
    }

    public void updateCategory(Long id, String category) {
        libraryRepository.updateCategory(id, category);
    }

    public void removeAll() {
        libraryRepository.removeAll();
    }
}
