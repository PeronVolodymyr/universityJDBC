package per.coursework.university.DAO.categoryOfTeacher.interfaces;

import per.coursework.university.model.CandidatesDissertation;
import per.coursework.university.model.CategoryOfTeacher;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryOfTeacherDAO {

    public CategoryOfTeacher insertCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher) throws SQLException;
    public CategoryOfTeacher getCategoryOfTeacher(int id) throws SQLException;
    public CategoryOfTeacher updateCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher) throws SQLException;
    public void deleteCategoryOfTeacher(int id) throws SQLException;
    public List<CategoryOfTeacher> getAll() throws SQLException;
}
