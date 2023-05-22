package org.example.repository;

import org.example.domain.Library;
import org.example.repository.db.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LibraryRepositoryImpl implements LibraryRepository {

    @Override
    public void insert(Library library) {
        String sql = "insert into library(name, author, publisher, isbn, release_year, count, summary, image, category) " +
                "values('" + library.getName() + "', '" + library.getAuthor() + "', '" + library.getPublisher() + "', '"
                + library.getIsbn() + "', '" + library.getReleaseYear() + "', '" + library.getCount() + "', '" + library.getSummary().replace("'", "") + "', '"
                + library.getImage() + "', '" + library.getCategory() + "')";
        executeUpdate(sql);
    }

    @Override
    public List<Library> findAll() {
        String sql = "select * from library";
        return executeQuery(sql);
    }

    @Override
    public Library findById(Long id) {
        String sql = "select * from library where id = " + id;
        try {
            return executeQuery(sql).get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Library findByName(String name) {
        String sql = "select * from library where name like '%" + name + "%'";
        try {
            return executeQuery(sql).get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Library> findByAuthor(String author) {
        String sql = "select * from library where author like '%" + author + "%'";
        return executeQuery(sql);
    }

    @Override
    public List<Library> findByPublisher(String publisher) {
        String sql = "select * from library where publisher like '%" + publisher + "%'";
        return executeQuery(sql);
    }

    @Override
    public Library findByIsbn(String isbn) {
        String sql = "select * from library where isbn = '" + isbn + "'";
        try {
            return executeQuery(sql).get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Library> findByCategory(String category) {
        String sql = "select * from library where category like '%" + category + "%'";
        return executeQuery(sql);
    }

    @Override
    public void countPlus(Long id, int count) {
        String sql = "update library set count = count + " + count + " where id = " + id;
        executeUpdate(sql);
    }

    @Override
    public void countMinus(Long id, int count) {
        String sql = "update library set count = count - " + count + " where id = " + id;
        executeUpdate(sql);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "delete from library where id = " + id;
        executeUpdate(sql);
    }

    @Override
    public void updateSummary(Long id, String summary) {
        String sql = "update library set summary = '" + summary + "' where id = " + id;
        executeUpdate(sql);
    }

    @Override
    public void updateImage(Long id, String img) {
        String sql = "update library set image = '" + img + "' where id = " + id;
        executeUpdate(sql);
    }

    @Override
    public void updateCategory(Long id, String category) {
        String sql = "update library set category = '" + category + "' where id = " + id;
        executeUpdate(sql);
    }

    @Override
    public void removeAll() {
        String sql = "delete from library";
        executeUpdate(sql);
    }

    private List<Library> executeQuery(String sql) {
        List<Library> libraryList = new ArrayList<>();
        try {
            Statement stmt = ConnectionManager.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                libraryList.add(new Library(Long.parseLong(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), Integer.parseInt(rs.getString(6)), Integer.parseInt(rs.getString(7)),
                        rs.getString(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return libraryList;
    }

    private void executeUpdate(String sql) {
        try {
            Statement stmt = ConnectionManager.con.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
