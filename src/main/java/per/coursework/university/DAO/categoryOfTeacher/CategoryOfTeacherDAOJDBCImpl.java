package per.coursework.university.DAO.categoryOfTeacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.categoryOfTeacher.interfaces.ICategoryOfTeacherDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.CategoryOfTeacher;

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
    public CategoryOfTeacher insertCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher) {
        return null;
    }

    @Override
    public CategoryOfTeacher getCategoryOfTeacher(int id) {
        return null;
    }

    @Override
    public CategoryOfTeacher updateCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher) {
        return null;
    }

    @Override
    public CategoryOfTeacher deleteCategoryOfTeacher(int id) {
        return null;
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
