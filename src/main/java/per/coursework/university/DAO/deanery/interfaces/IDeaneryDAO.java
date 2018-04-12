package per.coursework.university.DAO.deanery.interfaces;

import per.coursework.university.model.Curriculum;
import per.coursework.university.model.Deanery;

import java.sql.SQLException;
import java.util.List;

public interface IDeaneryDAO {

    public Deanery insertDeanery(Deanery deanery);
    public Deanery getDeanery(int id);
    public Deanery updateDeanery(Deanery deanery);
    public Deanery deleteDeanery(int id);
    public List<Deanery> getAll() throws SQLException;
}
