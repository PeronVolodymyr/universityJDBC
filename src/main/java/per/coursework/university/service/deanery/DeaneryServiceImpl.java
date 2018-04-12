package per.coursework.university.service.deanery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.deanery.DeaneryDAOJDBCImpl;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.Deanery;
import per.coursework.university.service.deanery.interfaces.IDeaneryService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeaneryServiceImpl implements IDeaneryService {

    @Autowired
    private DeaneryDAOJDBCImpl deaneryDAO;

    @Override
    public Deanery insertDeanery(Deanery deanery) {
        return null;
    }

    @Override
    public Deanery getDeanery(int id) {
        return null;
    }

    @Override
    public Deanery updateDeanery(Deanery deanery) {
        return null;
    }

    @Override
    public Deanery deleteDeanery(int id) {
        return null;
    }

    @Override
    public List<Deanery> getAll() throws SQLException {
       return deaneryDAO.getAll();
    }
}
