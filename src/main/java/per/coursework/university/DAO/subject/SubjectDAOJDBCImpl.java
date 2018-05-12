package per.coursework.university.DAO.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.subject.interfaces.ISubjectDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.FormOfControl;
import per.coursework.university.model.Student;
import per.coursework.university.model.Subject;
import per.coursework.university.model.TypeOfSubject;

import java.sql.PreparedStatement;
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
    public Subject insertSubject(Subject subject) throws SQLException {
        String query = "INSERT INTO `newdb`.`subject` (`name`, `number_of_hours`, `type_of_subject_id`, `form_of_control_id`) VALUES (?,?,?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, subject.getName());
        statement.setInt(2, subject.getNumberOfHours());
        statement.setInt(3, subject.getTypeOfSubject().getId());
        statement.setInt(4, subject.getFormOfControl().getId());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return subject;
    }

    @Override
    public Subject getSubject(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`subject` " +
                "inner join form_of_control on form_of_control_id = form_of_control.id " +
                "inner join type_of_subject on type_of_subject_id = type_of_subject.id WHERE subject.id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        Subject subject = new Subject(
                rs.getInt("subject.id"),
                rs.getString("subject.name"),
                rs.getInt("subject.number_of_hours"),
                new TypeOfSubject(
                        rs.getInt("type_of_subject.id"),
                        rs.getString("type_of_subject.type")),
                new FormOfControl(
                        rs.getInt("form_of_control.id"),
                        rs.getString("form_of_control.form"))
        );
        statement.close();
        return subject;
    }

    @Override
    public Subject updateSubject(Subject subject) throws SQLException {
        String query = "UPDATE `newdb`.`subject` SET `name`=?, `number_of_hours`=?, `type_of_subject_id`=?, `form_of_control_id`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, subject.getName());
        statement.setInt(2, subject.getNumberOfHours());
        statement.setInt(3, subject.getTypeOfSubject().getId());
        statement.setInt(4, subject.getFormOfControl().getId());
        statement.setInt(5, subject.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return subject;
    }

    @Override
    public void deleteSubject(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`subject` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<Subject> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from subject " +
                "inner join form_of_control on form_of_control_id = form_of_control.id " +
                "inner join type_of_subject on type_of_subject_id = type_of_subject.id " +
                "order by subject.id");
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
