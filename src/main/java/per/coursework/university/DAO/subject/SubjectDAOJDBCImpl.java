package per.coursework.university.DAO.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.subject.interfaces.ISubjectDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.FormOfControl;
import per.coursework.university.model.Subject;
import per.coursework.university.model.TypeOfSubject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectDAOJDBCImpl implements ISubjectDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Subject> list = new ArrayList<>();

    @Override
    public Subject insertSubject(Subject subject) {
        return null;
    }

    @Override
    public Subject getSubject(int id) {
        return null;
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return null;
    }

    @Override
    public Subject deleteSubject(int id) {
        return null;
    }

    @Override
    public List<Subject> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from subject inner join form_of_control " +
                "on form_of_control_id = form_of_control.id inner join type_of_subject " +
                "on type_of_subject_id = type_of_subject.id");
        while (rs.next())
        {
            list.add(new Subject(
                    rs.getInt("subject.id"),
                    rs.getString("subject.name"),
                    rs.getInt("subject.number_of_hours"),
                    new TypeOfSubject(
                            rs.getInt("type_of_subject.id"),
                            rs.getString("type_of_subject.type")),
                    new FormOfControl(
                            rs.getInt("form_of_control.id"),
                            rs.getString("form_of_control.form"))
            ));
        }
        return list;
    }
}
