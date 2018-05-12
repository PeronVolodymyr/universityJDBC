package per.coursework.university.DAO.doctoralDissertation.interfaces;

import per.coursework.university.model.Diploma;
import per.coursework.university.model.DoctoralDissertation;

import java.sql.SQLException;
import java.util.List;

public interface IDoctoralDissertationDAO {

    public DoctoralDissertation insertDoctoralDissertation(DoctoralDissertation doctoralDissertation) throws SQLException;
    public DoctoralDissertation getDoctoralDissertation(int id) throws SQLException;
    public DoctoralDissertation updateDoctoralDissertation(DoctoralDissertation doctoralDissertation) throws SQLException;
    public void deleteDoctoralDissertation(int id) throws SQLException;
    public List<DoctoralDissertation> getAll() throws SQLException;
}
