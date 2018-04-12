package per.coursework.university.DAO.chair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.chair.interfaces.IChairDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.Chair;
import per.coursework.university.model.Deanery;
import per.coursework.university.model.Department;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChairDAOJDBCImpl implements IChairDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Chair> list = new ArrayList<>();

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
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM chair INNER JOIN department  " +
                "ON department_id = department.id");
        while (rs.next())
        {
            list.add(new Chair(
                    rs.getInt("chair.id"),
                    rs.getString("chair.name"),
                    rs.getString("chair.head_of_chair"),
                    new Department(
                            rs.getInt("department.id"),
                            rs.getString("department.name"),
                            rs.getString("department.dean"),
                            null
                    )
            ));
        }
        return list;
    }
}
