package per.coursework.university.DAO.doctoralDissertation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.doctoralDissertation.interfaces.IDoctoralDissertationDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.DoctoralDissertation;
import per.coursework.university.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctoralDissertationDAOJDBCImpl implements IDoctoralDissertationDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<DoctoralDissertation> list = new ArrayList<>();

    @Override
    public DoctoralDissertation insertDoctoralDissertation(DoctoralDissertation doctoralDissertation) {
        return null;
    }

    @Override
    public DoctoralDissertation getDoctoralDissertation(int id) {
        return null;
    }

    @Override
    public DoctoralDissertation updateDoctoralDissertation(DoctoralDissertation doctoralDissertation) {
        return null;
    }

    @Override
    public DoctoralDissertation deleteDoctoralDissertation(int id) {
        return null;
    }

    @Override
    public List<DoctoralDissertation> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from doctoral_dissertation inner join teacher " +
                "on teacher_id = teacher.id");
        while (rs.next())
        {
            list.add(new DoctoralDissertation(
                    rs.getInt("doctoral_dissertation.id"),
                    rs.getString("doctoral_dissertation.theme_of_the_dissertation"),
                    rs.getDate("doctoral_dissertation.protection_date").toLocalDate(),
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
