package per.coursework.university.DAO.categoryOfTeacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.categoryOfTeacher.interfaces.ICategoryOfTeacherDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.CategoryOfTeacher;
import per.coursework.university.model.FormOfControl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryOfTeacherDAOJDBCImpl implements ICategoryOfTeacherDAO {
    @Autowired
    private DataStorageJDBC dataStorage;

    private List<CategoryOfTeacher> list = new ArrayList<>();

    @Override
    public CategoryOfTeacher insertCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher) throws SQLException {
        String query = "INSERT INTO `newdb`.`category_of_teacher` (`category`) VALUES (?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, categoryOfTeacher.getCategory());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return categoryOfTeacher;
    }

    @Override
    public CategoryOfTeacher getCategoryOfTeacher(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`category_of_teacher` WHERE id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        CategoryOfTeacher categoryOfTeacher = new CategoryOfTeacher(rs.getInt("id"), rs.getString("category"));
        statement.close();
        return categoryOfTeacher;
    }

    @Override
    public CategoryOfTeacher updateCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher) throws SQLException {
        String query = "UPDATE `newdb`.`category_of_teacher` SET `category`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1,categoryOfTeacher.getCategory());
        statement.setInt(2,categoryOfTeacher.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return categoryOfTeacher;
    }

    @Override
    public void deleteCategoryOfTeacher(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`category_of_teacher` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<CategoryOfTeacher> getAll() throws SQLException {

        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM category_of_teacher");
        while (rs.next())
        {
            list.add(new CategoryOfTeacher(
                    rs.getInt("category_of_teacher.id"),
                    rs.getString("category_of_teacher.category")
            ));
        }
        return list;
    }
}
