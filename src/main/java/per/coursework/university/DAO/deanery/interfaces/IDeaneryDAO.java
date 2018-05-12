package per.coursework.university.DAO.deanery.interfaces;

import per.coursework.university.model.Curriculum;
import per.coursework.university.model.Deanery;

import java.sql.SQLException;
import java.util.List;

public interface IDeaneryDAO {

    public Deanery insertDeanery(Deanery deanery) throws SQLException;
    public Deanery getDeanery(int id) throws SQLException;
    public Deanery updateDeanery(Deanery deanery) throws SQLException;
    public void deleteDeanery(int id) throws SQLException;
    public List<Deanery> getAll() throws SQLException;
}
