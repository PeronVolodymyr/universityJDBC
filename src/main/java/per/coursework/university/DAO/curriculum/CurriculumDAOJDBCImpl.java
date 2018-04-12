package per.coursework.university.DAO.curriculum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.curriculum.interfaces.ICurriculumDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CurriculumDAOJDBCImpl implements ICurriculumDAO {
    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Curriculum> list = new ArrayList<>();

    @Override
    public Curriculum insertCurriculum(Curriculum curriculum) {
        return null;
    }

    @Override
    public Curriculum getCurriculum(int id) {
        return null;
    }

    @Override
    public Curriculum updateCurriculum(Curriculum curriculum) {
        return null;
    }

    @Override
    public Curriculum deleteCurriculum(int id) {
        return null;
    }

    @Override
    public List<Curriculum> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from curriculum inner join teacher " +
                "on teacher_id = teacher.id inner join subject on subject_id = subject.id " +
                "inner join information_system_of_the_university.group on group_id = group.id " +
                "inner join type_of_subject on type_of_subject_id = type_of_subject.id " +
                "inner join form_of_control on form_of_control_id = form_of_control.id");
        while (rs.next())
        {
            list.add(new Curriculum(
                    rs.getInt("curriculum.id"),
                    rs.getInt("curriculum.semestr"),
                    new Teacher(
                            rs.getInt("teacher.id"),
                            rs.getString("teacher.name"),
                            rs.getDate("teacher.date_of_birth").toLocalDate(),
                            rs.getInt("teacher.count_of_children"),
                            rs.getInt("teacher.salary"),
                            null,
                            null),
                    new Subject(
                            rs.getInt("subject.id"),
                            rs.getString("subject.name"),
                            rs.getInt("subject.number_of_hours"),
                            new TypeOfSubject(
                                    rs.getInt("type_of_subject.id"),
                                    rs.getString("type_of_subject.type")),
                            new FormOfControl(
                                    rs.getInt("form_of_control.id"),
                                    rs.getString("form_of_control.form"))),
                    new Group(
                            rs.getInt("group.id"),
                            rs.getInt("group.course"),
                            rs.getInt("group.number"),
                            null
                    )
            ));
        }
        return list;
    }
}
