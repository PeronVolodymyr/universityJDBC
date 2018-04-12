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
        return typeOfSubjectDAO.getAll();
    }
}
