package per.coursework.university.DAO.candidatesDissertation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.candidatesDissertation.interfaces.ICandidatesDissertationDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.CandidatesDissertation;
import per.coursework.university.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CandidatesDissertationDAOJDBCImpl implements ICandidatesDissertationDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<CandidatesDissertation> list = new ArrayList<>();

    @Override
    public CandidatesDissertation insertCandidatesDissertation(CandidatesDissertation candidatesDissertation) {
        return null;
    }

    @Override
    public CandidatesDissertation getCandidatesDissertation(int id) {
        return null;
    }

    @Override
    public CandidatesDissertation updateCandidatesDissertation(CandidatesDissertation candidatesDissertation) {
        return null;
    }

    @Override
    public CandidatesDissertation deleteCandidatesDissertation(int id) {
        return null;
    }

    @Override
    public List<CandidatesDissertation> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from candidates_dissertation inner join teacher" +
                " on teacher_id = teacher.id");
        while (rs.next())
        {
            list.add(new CandidatesDissertation(
                    rs.getInt("candidates_dissertation.id"),
                    rs.getString("candidates_dissertation.theme_of_the_dissertation"),
                    rs.getDate("candidates_dissertation.protection_date").toLocalDate(),
                    new Teacher(
                            rs.getInt("teacher.id"),
                            rs.getString("teacher.name"),
                            rs.getDate("teacher.date_of_birth").toLocalDate(),
                            rs.getInt("teacher.count_of_children"),
                            rs.getInt("teacher.salary"),
                            null,
                            null
                    )
            ));
        }
        return list;
    }

}
