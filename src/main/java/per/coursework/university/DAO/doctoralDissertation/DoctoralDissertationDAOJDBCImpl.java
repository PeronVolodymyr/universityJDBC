package per.coursework.university.DAO.doctoralDissertation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.doctoralDissertation.interfaces.IDoctoralDissertationDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.*;

import java.sql.Date;
import java.sql.PreparedStatement;
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
    public DoctoralDissertation insertDoctoralDissertation(DoctoralDissertation doctoralDissertation) throws SQLException {
        String query = "INSERT INTO `newdb`.`doctoral_dissertation` (`theme_of_the_dissertation`, `protection_date`, `teacher_id`) VALUES (?,?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, doctoralDissertation.getThemeOfTheDissertation());
        statement.setDate(2, Date.valueOf(doctoralDissertation.getProtectionDate()));
        statement.setInt(3, doctoralDissertation.getTeacher().getId());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return doctoralDissertation;
    }

    @Override
    public DoctoralDissertation getDoctoralDissertation(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`doctoral_dissertation` " +
                "inner join teacher on teacher_id = teacher.id " +
                "inner join category_of_teacher on category_of_teacher_id = category_of_teacher.id " +
                "inner join chair on chair_id = chair.id " +
                "inner join department on department_id = department.id " +
                "inner join deanery on deanery_id = deanery.id WHERE doctoral_dissertation.id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        DoctoralDissertation doctoralDissertation = new DoctoralDissertation(
                rs.getInt("doctoral_dissertation.id"),
                rs.getString("doctoral_dissertation.theme_of_the_dissertation"),
                rs.getDate("doctoral_dissertation.protection_date").toLocalDate(),
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
                )
        );
        statement.close();
        return doctoralDissertation;
    }

    @Override
    public DoctoralDissertation updateDoctoralDissertation(DoctoralDissertation doctoralDissertation) throws SQLException {
        String query = "UPDATE `newdb`.`doctoral_dissertation` SET `theme_of_the_dissertation`=?, `protection_date`=?, `teacher_id`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, doctoralDissertation.getThemeOfTheDissertation());
        statement.setDate(2, Date.valueOf(doctoralDissertation.getProtectionDate()));
        statement.setInt(3, doctoralDissertation.getTeacher().getId());
        statement.setInt(4, doctoralDissertation.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return doctoralDissertation;
    }

    @Override
    public void deleteDoctoralDissertation(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`doctoral_dissertation` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<DoctoralDissertation> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from doctoral_dissertation " +
                "inner join teacher on teacher_id = teacher.id " +
                "inner join category_of_teacher on category_of_teacher_id = category_of_teacher.id " +
                "inner join chair on chair_id = chair.id " +
                "inner join department on department_id = department.id " +
                "inner join deanery on deanery_id = deanery.id " +
                "order by doctoral_dissertation.id");

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
                    )
            ));
        }
        return list;
    }
}
