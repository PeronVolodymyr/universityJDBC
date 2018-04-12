package per.coursework.university.DAO.diploma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.diploma.interfaces.IDiplomaDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.Diploma;
import per.coursework.university.model.Student;
import per.coursework.university.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DiplomaDAOJDBCImpl implements IDiplomaDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Diploma> list = new ArrayList<>();

    @Override
    public Diploma insertDiploma(Diploma diploma) {
        return null;
    }

    @Override
    public Diploma getDiploma(int id) {
        return null;
    }

    @Override
    public Diploma updateDiploma(Diploma diploma) {
        return null;
    }

    @Override
    public Diploma deleteDiploma(int id) {
        return null;
    }

    @Override
    public List<Diploma> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from diploma inner join student " +
                "on student_id = student.id inner join teacher " +
                "on teacher_id = teacher.id");
        while (rs.next())
        {
            list.add(new Diploma(
                    rs.getInt("diploma.id"),
                    rs.getString("diploma.theme_of_the_diploma"),
                    new Teacher(
                            rs.getInt("teacher.id"),
                            rs.getString("teacher.name"),
                            rs.getDate("teacher.date_of_birth").toLocalDate(),
                            rs.getInt("teacher.count_of_children"),
                            rs.getInt("teacher.salary"),
                            null,
                            null
                    ),
                    new Student(
                            rs.getInt("student.id"),
                            rs.getString("student.name"),
                            rs.getDate("student.date_of_birth").toLocalDate(),
                            rs.getBoolean("student.children"),
                            rs.getInt("student.scholarship"),
                            null
                    )
            ));
        }
        return list;
    }
}
