package per.coursework.university.DAO.typeOfSubject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.typeOfSubject.interfaces.ITypeOfSubjectDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.TypeOfSubject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TypeOfSubjectDAOJDBCImpl implements ITypeOfSubjectDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<TypeOfSubject> list = new ArrayList<>();

    @Override
    public TypeOfSubject insertTypeOfSubject(TypeOfSubject typeOfSubject) throws SQLException {
        String query = "INSERT INTO `newdb`.`type_of_subject` (`type`) VALUES (?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, typeOfSubject.getType());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return typeOfSubject;
    }

    @Override
    public TypeOfSubject getTypeOfSubject(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`type_of_subject` WHERE id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        TypeOfSubject typeOfSubject = new TypeOfSubject(rs.getInt("id"), rs.getString("type"));
        statement.close();
        return typeOfSubject;
    }

    @Override
    public TypeOfSubject updateTypeOfSubject(TypeOfSubject typeOfSubject) throws SQLException {

        String query = "UPDATE `newdb`.`type_of_subject` SET `type`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1,typeOfSubject.getType());
        statement.setInt(2,typeOfSubject.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return typeOfSubject;
    }

    @Override
    public void deleteTypeOfSubject(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`type_of_subject` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<TypeOfSubject> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM type_of_subject");
        while (rs.next())
        {
            list.add(new TypeOfSubject(
                    rs.getInt("id"),
                    rs.getString("type")
            ));
        }
        return list;
    }
}
