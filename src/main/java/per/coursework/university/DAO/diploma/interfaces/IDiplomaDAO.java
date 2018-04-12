package per.coursework.university.DAO.diploma.interfaces;

import per.coursework.university.model.Department;
import per.coursework.university.model.Diploma;

import java.sql.SQLException;
import java.util.List;

public interface IDiplomaDAO {

    public Diploma insertDiploma(Diploma diploma);
    public Diploma getDiploma(int id);
    public Diploma updateDiploma(Diploma diploma);
    public Diploma deleteDiploma(int id);
    public List<Diploma> getAll() throws SQLException;
}
