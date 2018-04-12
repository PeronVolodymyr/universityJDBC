package per.coursework.university.DAO.categoryOfTeacher.interfaces;

import per.coursework.university.model.CandidatesDissertation;
import per.coursework.university.model.CategoryOfTeacher;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryOfTeacherDAO {

    public CategoryOfTeacher insertCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher);
    public CategoryOfTeacher getCategoryOfTeacher(int id);
    public CategoryOfTeacher updateCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher);
    public CategoryOfTeacher deleteCategoryOfTeacher(int id);
    public List<CategoryOfTeacher> getAll() throws SQLException;
}
