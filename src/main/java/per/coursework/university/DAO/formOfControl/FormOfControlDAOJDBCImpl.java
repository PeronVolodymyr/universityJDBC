package per.coursework.university.DAO.formOfControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.formOfControl.interfaces.IFormOfControlDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.FormOfControl;

import java.sql.PreparedStatement;
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
    public FormOfControl insertFormOfControl(FormOfControl formOfControl) throws SQLException {
        String query = "INSERT INTO `newdb`.`form_of_control` (`form`) VALUES (?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, formOfControl.getForm());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return formOfControl;
    }

    @Override
    public FormOfControl getFormOfControl(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`form_of_control` WHERE id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        FormOfControl formOfControl = new FormOfControl(rs.getInt("id"), rs.getString("form"));
        statement.close();
        return formOfControl;
    }

    @Override
    public FormOfControl updateFormOfControl(FormOfControl formOfControl) throws SQLException {
        String query = "UPDATE `newdb`.`form_of_control` SET `form`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1,formOfControl.getForm());
        statement.setInt(2,formOfControl.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return formOfControl;
    }

    @Override
    public void deleteFormOfControl(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`form_of_control` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
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
