package per.coursework.university.DAO.diploma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.diploma.interfaces.IDiplomaDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.*;

import java.sql.Date;
import java.sql.PreparedStatement;
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
    public Diploma insertDiploma(Diploma diploma) throws SQLException {
        String query = "INSERT INTO `newdb`.`diploma` (`theme_of_the_diploma`, `teacher_id`, `student_id`) VALUES (?,?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, diploma.getThemeOfDiploma());
        statement.setInt(2, diploma.getTeacher().getId());
        statement.setInt(3, diploma.getStudent().getId());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return diploma;
    }

    @Override
    public Diploma getDiploma(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`diploma` " +
                "inner join teacher on teacher_id = teacher.id " +
                "inner join category_of_teacher on category_of_teacher_id = category_of_teacher.id " +
                "inner join chair on chair_id = chair.id " +
                "inner join department on department_id = department.id " +
                "inner join deanery on deanery_id = deanery.id " +
                ///
                "inner join student on student_id = student.id " +
                "inner join newdb.group on group_id = newdb.group.id " +
                "inner join chair stCh on group.chair_id = stCh.id " +
                "inner join department stDp on stCh.department_id = stDp.id " +
                "inner join deanery stDn on stDp.deanery_id = stDn.id WHERE diploma.id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        Diploma diploma = new Diploma(
                rs.getInt("diploma.id"),
                rs.getString("diploma.theme_of_the_diploma"),
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
                                rs.getInt("chair.id"),
                                rs.getString("chair.name"),
                                rs.getString("chair.head_of_chair"),
                                new Department(
                                        rs.getInt("department.id"),
                                        rs.getString("department.name"),
                                        rs.getString("department.dean"),
                                        new Deanery(rs.getInt("deanery.id"),
                                                rs.getString("deanery.address"),
                                                rs.getString("deanery.phone_number"))
                                )
                        )
                ),
                new Student(
                        rs.getInt("student.id"),
                        rs.getString("student.name"),
                        rs.getDate("student.date_of_birth").toLocalDate(),
                        rs.getBoolean("student.children"),
                        rs.getInt("student.scholarship"),
                        new Group(
                                rs.getInt("group.id"),
                                rs.getInt("group.course"),
                                rs.getInt("group.number"),
                                new Chair(
                                        rs.getInt("stCh.id"),
                                        rs.getString("stCh.name"),
                                        rs.getString("stCh.head_of_chair"),
                                        new Department(
                                                rs.getInt("stDp.id"),
                                                rs.getString("stDp.name"),
                                                rs.getString("stDp.dean"),
                                                new Deanery(rs.getInt("stDn.id"),
                                                        rs.getString("stDn.address"),
                                                        rs.getString("stDn.phone_number"))
                                        )
                                )
                        )
                )
        );
        statement.close();
        return diploma;
    }

    @Override
    public Diploma updateDiploma(Diploma diploma) throws SQLException {
        String query = "UPDATE `newdb`.`diploma` SET `theme_of_the_diploma`=?, `teacher_id`=?, `student_id`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, diploma.getThemeOfDiploma());
        statement.setInt(2, diploma.getTeacher().getId());
        statement.setInt(3, diploma.getStudent().getId());
        statement.setInt(4, diploma.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return diploma;
    }

    @Override
    public void deleteDiploma(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`diploma` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<Diploma> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from diploma " +
                "inner join teacher on teacher_id = teacher.id " +
                "inner join category_of_teacher on category_of_teacher_id = category_of_teacher.id " +
                "inner join chair on chair_id = chair.id " +
                "inner join department on department_id = department.id " +
                "inner join deanery on deanery_id = deanery.id " +
                ///
                "inner join student on student_id = student.id " +
                "inner join newdb.group on group_id = newdb.group.id " +
                "inner join chair stCh on group.chair_id = stCh.id " +
                "inner join department stDp on stCh.department_id = stDp.id " +
                "inner join deanery stDn on stDp.deanery_id = stDn.id " +
                "order by diploma.id");
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
                            new CategoryOfTeacher(
                                    rs.getInt("category_of_teacher.id"),
                                    rs.getString("category_of_teacher.category")),
                            new Chair(
                                    rs.getInt("chair.id"),
                                    rs.getString("chair.name"),
                                    rs.getString("chair.head_of_chair"),
                                    new Department(
                                            rs.getInt("department.id"),
                                            rs.getString("department.name"),
                                            rs.getString("department.dean"),
                                            new Deanery(rs.getInt("deanery.id"),
                                                    rs.getString("deanery.address"),
                                                    rs.getString("deanery.phone_number"))
                                    )
                            )
                    ),
                    new Student(
                            rs.getInt("student.id"),
                            rs.getString("student.name"),
                            rs.getDate("student.date_of_birth").toLocalDate(),
                            rs.getBoolean("student.children"),
                            rs.getInt("student.scholarship"),
                            new Group(
                                    rs.getInt("group.id"),
                                    rs.getInt("group.course"),
                                    rs.getInt("group.number"),
                                    new Chair(
                                            rs.getInt("stCh.id"),
                                            rs.getString("stCh.name"),
                                            rs.getString("stCh.head_of_chair"),
                                            new Department(
                                                    rs.getInt("stDp.id"),
                                                    rs.getString("stDp.name"),
                                                    rs.getString("stDp.dean"),
                                                    new Deanery(rs.getInt("stDn.id"),
                                                            rs.getString("stDn.address"),
                                                            rs.getString("stDn.phone_number"))
                                            )
                                    )
                            )
                    )
            ));
        }
        return list;
    }
}
