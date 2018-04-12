package per.coursework.university.DAO.deanery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.deanery.interfaces.IDeaneryDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.Deanery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeaneryDAOJDBCImpl implements IDeaneryDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Deanery> list = new ArrayList<>();

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
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM deanery");
        while (rs.next())
        {
            list.add(new Deanery(
                    rs.getInt("id"),
                    rs.getString("phone_number"),
                    rs.getString("address")
            ));
        }
        return list;
    }
}
