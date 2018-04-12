package per.coursework.university.service.chair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.chair.ChairDAOJDBCImpl;
import per.coursework.university.model.Chair;
import per.coursework.university.service.chair.interfaces.IChairService;

import java.sql.SQLException;
import java.util.List;

@Service
public class ChairServiceImpl implements IChairService {

    @Autowired
    private ChairDAOJDBCImpl chairDAO;

    @Override
    public Chair insertChair(Chair chair) {
        return null;
    }

    @Override
    public Chair getChair(int id) {
        return null;
    }

    @Override
    public Chair updateChair(Chair chair) {
        return null;
    }

    @Override
    public Chair deleteChair(int id) {
        return null;
    }

    @Override
    public List<Chair> getAll() throws SQLException {
        return chairDAO.getAll();
    }
}
