package per.coursework.university.service.diploma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.diploma.DiplomaDAOJDBCImpl;
import per.coursework.university.model.Diploma;
import per.coursework.university.service.diploma.interfaces.IDiplomaService;

import java.sql.SQLException;
import java.util.List;

@Service
public class DiplomaServiceImpl implements IDiplomaService {

    @Autowired
    private DiplomaDAOJDBCImpl diplomaDAO;

    @Override
    public Diploma insertDiploma(Diploma diploma) {
        return null;
    }

    @Override
    public Diploma getDiploma(int id) {
        return null;
    }

    @Override
    public Diploma updateDiploma(Diploma diploma) {
        return null;
    }

    @Override
    public Diploma deleteDiploma(int id) {
        return null;
    }

    @Override
    public List<Diploma> getAll() throws SQLException {
        return diplomaDAO.getAll();
    }
}
