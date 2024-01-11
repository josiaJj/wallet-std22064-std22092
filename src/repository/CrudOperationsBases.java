package repository;

import model.Account;

import java.sql.SQLException;
import java.util.List;

public interface CrudOperationsBases<T> {
    T findById(int id);
    List<T> findAll() throws SQLException;
    List<T> saveAll(List<T> toSave);
    T save(T toSave);
    T delete(T toDelete);
}
