package per.coursework.university.service.typeOfSubject.interfaces;

import per.coursework.university.model.TypeOfSubject;

import java.sql.SQLException;
import java.util.List;

public interface ITypeOfSubjectService {

    public TypeOfSubject insertTypeOfSubject(TypeOfSubject typeOfSubject) throws SQLException;
    public TypeOfSubject getTypeOfSubject(int id) throws SQLException;
    public TypeOfSubject updateTypeOfSubject(TypeOfSubject typeOfSubject) throws SQLException;
    public void deleteTypeOfSubject(int id) throws SQLException;
    public List<TypeOfSubject> getAll() throws SQLException;
}
