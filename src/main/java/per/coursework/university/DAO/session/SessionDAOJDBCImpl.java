package per.coursework.university.DAO.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.session.interfaces.ISessionDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SessionDAOJDBCImpl implements ISessionDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Session> list = new ArrayList<>();

    @Override
    public Session insertSession(Session session) {
        return null;
    }

    @Override
    public Session getSession(int id) {
        return null;
    }

    @Override
    public Session updateSession(Session session) {
        return null;
    }

    @Override
    public Session deleteSession(int id) {
        return null;
    }

    @Override
    public List<Session> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from session " +
                "inner join student on student_id = student.id " +
                "inner join curriculum on curriculum_id = curriculum.id " +
                "inner join subject on subject_id = subject.id " +
                "inner join teacher on teacher_id = teacher.id " +
                "inner join type_of_subject on type_of_subject_id = type_of_subject.id " +
                "inner join form_of_control on form_of_control_id = form_of_control.id");
        while (rs.next())
        {
            list.add(new Session(
                    rs.getInt("session.id"),
                    rs.getInt("session.mark"),
                    new Student(
                            rs.getInt("student.id"),
                            rs.getString("student.name"),
                            rs.getDate("student.date_of_birth").toLocalDate(),
                            rs.getBoolean("student.children"),
                            rs.getInt("student.scholarship"),
                            null),
                    new Curriculum(
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
                                    null)
            ));
        }
        return list;
    }
}
