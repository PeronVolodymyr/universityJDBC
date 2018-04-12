package per.coursework.university.DAO.curriculum.interfaces;

import per.coursework.university.model.Chair;
import per.coursework.university.model.Curriculum;

import java.sql.SQLException;
import java.util.List;

public interface ICurriculumDAO {

    public Curriculum insertCurriculum(Curriculum curriculum);
    public Curriculum getCurriculum(int id);
    public Curriculum updateCurriculum(Curriculum curriculum);
    public Curriculum deleteCurriculum(int id);
    public List<Curriculum> getAll() throws SQLException;
}
