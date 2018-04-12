package per.coursework.university.DAO.typeOfSubject.interfaces;

import per.coursework.university.model.Teacher;
import per.coursework.university.model.TypeOfSubject;

import java.sql.SQLException;
import java.util.List;

public interface ITypeOfSubjectDAO {

    public TypeOfSubject insertTypeOfSubject(TypeOfSubject typeOfSubject);
    public TypeOfSubject getTypeOfSubject(int id);
    public TypeOfSubject updateTypeOfSubject(TypeOfSubject typeOfSubject);
    public TypeOfSubject deleteTypeOfSubject(int id);
    public List<TypeOfSubject> getAll() throws SQLException;
}
