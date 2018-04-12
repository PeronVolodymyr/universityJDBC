package per.coursework.university.DAO.formOfControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.formOfControl.interfaces.IFormOfControlDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.FormOfControl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FormOfControlDAOJDBCImpl implements IFormOfControlDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<FormOfControl> list = new ArrayList<>();

    @Override
    public FormOfControl insertFormOfControl(FormOfControl formOfControl) {
        return null;
    }

    @Override
    public FormOfControl getFormOfControl(int id) {
        return null;
    }

    @Override
    public FormOfControl updateFormOfControl(FormOfControl formOfControl) {
        return null;
    }

    @Override
    public FormOfControl deleteFormOfControl(int id) {
        return null;
    }

    @Override
    public List<FormOfControl> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM form_of_control");
        while (rs.next())
        {
            list.add(new FormOfControl(
                    rs.getInt("id"),
                    rs.getString("form")
            ));
        }
        return list;
    }
}
