package per.coursework.university.DAO.curriculum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.curriculum.interfaces.ICurriculumDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.*;

import java.sql.PreparedStatement;
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
    public Curriculum insertCurriculum(Curriculum curriculum) throws SQLException {
        String query = "INSERT INTO `newdb`.`curriculum` (`semestr`, `teacher_id`, `subject_id`, `group_id`) VALUES (?,?,?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1, curriculum.getSemester());
        statement.setInt(2, curriculum.getTeacher().getId());
        statement.setInt(3, curriculum.getSubject().getId());
        statement.setInt(4, curriculum.getGroup().getId());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return curriculum;
    }

    @Override
    public Curriculum getCurriculum(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`curriculum` " +
                "inner join teacher on teacher_id = teacher.id " +
                "inner join category_of_teacher on category_of_teacher_id = category_of_teacher.id " +
                "inner join chair chTe on teacher.chair_id = chTe.id " +
                "inner join department dpTe on chTe.department_id = dpTe.id " +
                "inner join deanery dnTe on dpTe.deanery_id = dnTe.id " +
                "inner join subject on subject_id = subject.id " +
                "inner join type_of_subject on type_of_subject_id = type_of_subject.id " +
                "inner join form_of_control on form_of_control_id = form_of_control.id " +
                "inner join newdb.group on group_id = newdb.group.id " +
                "inner join chair chGr on group.chair_id = chGr.id " +
                "inner join department dpGr on chGr.department_id = dpGr.id " +
                "inner join deanery dnGr on dpGr.deanery_id = dnGr.id WHERE curriculum.id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        Curriculum curriculum = new Curriculum(
                rs.getInt("curriculum.id"),
                rs.getInt("curriculum.semestr"),
                new Teacher(
                        rs.getInt("teacher.id"),
                        rs.getString("teacher.name"),
                        rs.getDate("teacher.date_of_birth").toLocalDate(),
                        rs.getInt("teacher.count_of_children"),
                        rs.getInt("teacher.salary"),
                        new CategoryOfTeacher(
                                rs.getInt("category_of_teacher.id"),
                                rs.getString("category_of_teacher.category")),
                        new Chair(
                                rs.getInt("chTe.id"),
                                rs.getString("chTe.name"),
                                rs.getString("chTe.head_of_chair"),
                                new Department(
                                        rs.getInt("dpTe.id"),
                                        rs.getString("dpTe.name"),
                                        rs.getString("dpTe.dean"),
                                        new Deanery(rs.getInt("dnTe.id"),
                                                rs.getString("dnTe.address"),
                                                rs.getString("dnTe.phone_number")
                                        )
                                )
                        )),
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
                        new Chair(
                                rs.getInt("chGr.id"),
                                rs.getString("chGr.name"),
                                rs.getString("chGr.head_of_chair"),
                                new Department(
                                        rs.getInt("dpGr.id"),
                                        rs.getString("dpGr.name"),
                                        rs.getString("dpGr.dean"),
                                        new Deanery(rs.getInt("dnGr.id"),
                                                rs.getString("dnGr.address"),
                                                rs.getString("dnGr.phone_number"))
                                )
                        )
                )
        );
        statement.close();
        return curriculum;
    }

    @Override
    public Curriculum updateCurriculum(Curriculum curriculum) throws SQLException {
        String query = "UPDATE `newdb`.`curriculum` SET `semestr`=?, `teacher_id`=?, `subject_id`=?, `group_id`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1, curriculum.getSemester());
        statement.setInt(2, curriculum.getTeacher().getId());
        statement.setInt(3, curriculum.getSubject().getId());
        statement.setInt(4, curriculum.getGroup().getId());
        statement.setInt(5, curriculum.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return curriculum;
    }

    @Override
    public void deleteCurriculum(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`curriculum` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<Curriculum> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from curriculum " +
                "inner join teacher on teacher_id = teacher.id " +
                "inner join category_of_teacher on category_of_teacher_id = category_of_teacher.id " +
                "inner join chair chTe on teacher.chair_id = chTe.id " +
                "inner join department dpTe on chTe.department_id = dpTe.id " +
                "inner join deanery dnTe on dpTe.deanery_id = dnTe.id " +
                "inner join subject on subject_id = subject.id " +
                "inner join type_of_subject on type_of_subject_id = type_of_subject.id " +
                "inner join form_of_control on form_of_control_id = form_of_control.id " +
                "inner join newdb.group on group_id = newdb.group.id " +
                "inner join chair chGr on group.chair_id = chGr.id " +
                "inner join department dpGr on chGr.department_id = dpGr.id " +
                "inner join deanery dnGr on dpGr.deanery_id = dnGr.id");
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
                    new CategoryOfTeacher(
                            rs.getInt("category_of_teacher.id"),
                            rs.getString("category_of_teacher.category")),
                    new Chair(
                            rs.getInt("chTe.id"),
                            rs.getString("chTe.name"),
                            rs.getString("chTe.head_of_chair"),
                            new Department(
                                    rs.getInt("dpTe.id"),
                                    rs.getString("dpTe.name"),
                                    rs.getString("dpTe.dean"),
                                    new Deanery(rs.getInt("dnTe.id"),
                                            rs.getString("dnTe.address"),
                                            rs.getString("dnTe.phone_number")
                                    )
                            )
                    )),
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
                            new Chair(
                                    rs.getInt("chGr.id"),
                                    rs.getString("chGr.name"),
                                    rs.getString("chGr.head_of_chair"),
                                    new Department(
                                            rs.getInt("dpGr.id"),
                                            rs.getString("dpGr.name"),
                                            rs.getString("dpGr.dean"),
                                            new Deanery(rs.getInt("dnGr.id"),
                                                    rs.getString("dnGr.address"),
                                                    rs.getString("dnGr.phone_number"))
                                    )
                            )
                    )
            ));
        }
        return list;
    }
}
