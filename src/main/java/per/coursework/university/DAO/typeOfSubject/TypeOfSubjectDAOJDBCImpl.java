package per.coursework.university.DAO.typeOfSubject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.typeOfSubject.interfaces.ITypeOfSubjectDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.TypeOfSubject;

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
    public TypeOfSubject insertTypeOfSubject(TypeOfSubject typeOfSubject) {
        return null;
    }

    @Override
    public TypeOfSubject getTypeOfSubject(int id) {
        return null;
    }

    @Override
    public TypeOfSubject updateTypeOfSubject(TypeOfSubject typeOfSubject) {
        return null;
    }

    @Override
    public TypeOfSubject deleteTypeOfSubject(int id) {
        return null;
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
