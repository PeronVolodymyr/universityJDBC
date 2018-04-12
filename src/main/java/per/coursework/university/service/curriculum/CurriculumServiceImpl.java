package per.coursework.university.service.curriculum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.curriculum.CurriculumDAOJDBCImpl;
import per.coursework.university.model.Curriculum;
import per.coursework.university.service.curriculum.interfaces.ICurriculumService;

import java.sql.SQLException;
import java.util.List;

@Service
public class CurriculumServiceImpl implements ICurriculumService {

    @Autowired
    private CurriculumDAOJDBCImpl curriculumDAO;

    @Override
    public Curriculum insertCurriculum(Curriculum curriculum) {
        return null;
    }

    @Override
    public Curriculum getCurriculum(int id) {
        return null;
    }

    @Override
    public Curriculum updateCurriculum(Curriculum curriculum) {
        return null;
    }

    @Override
    public Curriculum deleteCurriculum(int id) {
        return null;
    }

    @Override
    public List<Curriculum> getAll() throws SQLException {
        return curriculumDAO.getAll();
    }
}
