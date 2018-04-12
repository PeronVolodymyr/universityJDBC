package per.coursework.university.service.curriculum.interfaces;

import per.coursework.university.model.Curriculum;

import java.sql.SQLException;
import java.util.List;

public interface ICurriculumService {

    public Curriculum insertCurriculum(Curriculum curriculum);
    public Curriculum getCurriculum(int id);
    public Curriculum updateCurriculum(Curriculum curriculum);
    public Curriculum deleteCurriculum(int id);
    public List<Curriculum> getAll() throws SQLException;
}
