package per.coursework.university.service.categoryOfTeacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.categoryOfTeacher.CategoryOfTeacherDAOJDBCImpl;
import per.coursework.university.model.CategoryOfTeacher;
import per.coursework.university.service.categoryOfTeacher.interfaces.ICategoryOfTeacherService;

import java.sql.SQLException;
import java.util.List;

@Service
public class CategoryOfTeacherServiceImpl implements ICategoryOfTeacherService {

    @Autowired
    private CategoryOfTeacherDAOJDBCImpl categoryOfTeacherDAO;

    @Override
    public CategoryOfTeacher insertCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher) throws SQLException {

        return categoryOfTeacherDAO.insertCategoryOfTeacher(categoryOfTeacher);
    }

    @Override
    public CategoryOfTeacher getCategoryOfTeacher(int id) throws SQLException {

        return categoryOfTeacherDAO.getCategoryOfTeacher(id);
    }

    @Override
    public CategoryOfTeacher updateCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher) throws SQLException {

        return categoryOfTeacherDAO.updateCategoryOfTeacher(categoryOfTeacher);
    }

    @Override
    public void deleteCategoryOfTeacher(int id) throws SQLException {
        categoryOfTeacherDAO.deleteCategoryOfTeacher(id);
    }

    @Override
    public List<CategoryOfTeacher> getAll() throws SQLException {
        return categoryOfTeacherDAO.getAll();
    }
}
