package per.coursework.university.DAO.diploma.interfaces;

import per.coursework.university.model.Department;
import per.coursework.university.model.Diploma;

import java.sql.SQLException;
import java.util.List;

public interface IDiplomaDAO {

    public Diploma insertDiploma(Diploma diploma) throws SQLException;
    public Diploma getDiploma(int id) throws SQLException;
    public Diploma updateDiploma(Diploma diploma) throws SQLException;
    public void deleteDiploma(int id) throws SQLException;
    public List<Diploma> getAll() throws SQLException;
}
