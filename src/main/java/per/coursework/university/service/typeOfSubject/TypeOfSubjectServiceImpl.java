package per.coursework.university.service.typeOfSubject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.typeOfSubject.TypeOfSubjectDAOJDBCImpl;
import per.coursework.university.model.TypeOfSubject;
import per.coursework.university.service.typeOfSubject.interfaces.ITypeOfSubjectService;

import java.sql.SQLException;
import java.util.List;

@Service
public class TypeOfSubjectServiceImpl implements ITypeOfSubjectService {

    @Autowired
    private TypeOfSubjectDAOJDBCImpl typeOfSubjectDAO;

    @Override
    public TypeOfSubject insertTypeOfSubject(TypeOfSubject typeOfSubject) throws SQLException {

        return typeOfSubjectDAO.insertTypeOfSubject(typeOfSubject);
    }

    @Override
    public TypeOfSubject getTypeOfSubject(int id) throws SQLException {

        return typeOfSubjectDAO.getTypeOfSubject(id);
    }

    @Override
    public TypeOfSubject updateTypeOfSubject(TypeOfSubject typeOfSubject) throws SQLException {

        return typeOfSubjectDAO.updateTypeOfSubject(typeOfSubject);
    }

    @Override
    public void deleteTypeOfSubject(int id) throws SQLException {
        typeOfSubjectDAO.deleteTypeOfSubject(id);
    }

    @Override
    public List<TypeOfSubject> getAll() throws SQLException {
        return typeOfSubjectDAO.getAll();
    }
}
