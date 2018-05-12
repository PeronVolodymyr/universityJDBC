package per.coursework.university.DAO.candidatesDissertation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.candidatesDissertation.interfaces.ICandidatesDissertationDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.*;

import java.sql.Date;
import java.sql.PreparedStatement;
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
    public CandidatesDissertation insertCandidatesDissertation(CandidatesDissertation candidatesDissertation) throws SQLException {
        String query = "INSERT INTO `newdb`.`candidates_dissertation` (`theme_of_the_dissertation`, `protection_date`, `teacher_id`) VALUES (?,?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, candidatesDissertation.getThemeOfTheDissertation());
        statement.setDate(2, Date.valueOf(candidatesDissertation.getProtectionDate()));
        statement.setInt(3, candidatesDissertation.getTeacher().getId());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return candidatesDissertation;
    }

    @Override
    public CandidatesDissertation getCandidatesDissertation(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`candidates_dissertation` " +
                "inner join teacher on teacher_id = teacher.id " +
                "inner join category_of_teacher on category_of_teacher_id = category_of_teacher.id " +
                "inner join chair on chair_id = chair.id " +
                "inner join department on department_id = department.id " +
                "inner join deanery on deanery_id = deanery.id WHERE candidates_dissertation.id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        CandidatesDissertation candidatesDissertation = new CandidatesDissertation(
                rs.getInt("candidates_dissertation.id"),
                rs.getString("candidates_dissertation.theme_of_the_dissertation"),
                rs.getDate("candidates_dissertation.protection_date").toLocalDate(),
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
        return candidatesDissertation;
    }

    @Override
    public CandidatesDissertation updateCandidatesDissertation(CandidatesDissertation candidatesDissertation) throws SQLException {
        String query = "UPDATE `newdb`.`candidates_dissertation` SET `theme_of_the_dissertation`=?, `protection_date`=?, `teacher_id`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, candidatesDissertation.getThemeOfTheDissertation());
        statement.setDate(2, Date.valueOf(candidatesDissertation.getProtectionDate()));
        statement.setInt(3, candidatesDissertation.getTeacher().getId());
        statement.setInt(4, candidatesDissertation.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return candidatesDissertation;
    }

    @Override
    public void deleteCandidatesDissertation(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`candidates_dissertation` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<CandidatesDissertation> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from candidates_dissertation " +
                "inner join teacher on teacher_id = teacher.id " +
                "inner join category_of_teacher on category_of_teacher_id = category_of_teacher.id " +
                "inner join chair on chair_id = chair.id " +
                "inner join department on department_id = department.id " +
                "inner join deanery on deanery_id = deanery.id " +
                "order by candidates_dissertation.id");
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
