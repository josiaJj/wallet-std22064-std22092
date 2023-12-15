package repository;

import java.sql.SQLException;
import java.util.List;

public interface CrudOperationsBases<T> {
    List<T> findAll() throws SQLException;
    List<T> saveAll(List<T> toSave);
    T save(T toSave);
}
