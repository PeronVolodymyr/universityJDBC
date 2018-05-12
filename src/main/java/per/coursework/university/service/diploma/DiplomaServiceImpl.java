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
    public Diploma insertDiploma(Diploma diploma) throws SQLException {

        return diplomaDAO.insertDiploma(diploma);
    }

    @Override
    public Diploma getDiploma(int id) throws SQLException {

        return diplomaDAO.getDiploma(id);
    }

    @Override
    public Diploma updateDiploma(Diploma diploma) throws SQLException {
        return diplomaDAO.updateDiploma(diploma);
    }

    @Override
    public void deleteDiploma(int id) throws SQLException {
        diplomaDAO.deleteDiploma(id);
    }

    @Override
    public List<Diploma> getAll() throws SQLException {
        return diplomaDAO.getAll();
    }
}
