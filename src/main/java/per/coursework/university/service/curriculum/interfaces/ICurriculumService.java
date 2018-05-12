package per.coursework.university.service.curriculum.interfaces;

import per.coursework.university.model.Curriculum;

import java.sql.SQLException;
import java.util.List;

public interface ICurriculumService {

    public Curriculum insertCurriculum(Curriculum curriculum) throws SQLException;
    public Curriculum getCurriculum(int id) throws SQLException;
    public Curriculum updateCurriculum(Curriculum curriculum) throws SQLException;
    public void deleteCurriculum(int id) throws SQLException;
    public List<Curriculum> getAll() throws SQLException;
}
