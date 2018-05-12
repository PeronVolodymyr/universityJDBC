package per.coursework.university.DAO.formOfControl.interfaces;

import per.coursework.university.model.DoctoralDissertation;
import per.coursework.university.model.FormOfControl;

import java.sql.SQLException;
import java.util.List;

public interface IFormOfControlDAO {

    public FormOfControl insertFormOfControl(FormOfControl formOfControl) throws SQLException;
    public FormOfControl getFormOfControl(int id) throws SQLException;
    public FormOfControl updateFormOfControl(FormOfControl formOfControl) throws SQLException;
    public void deleteFormOfControl(int id) throws SQLException;
    public List<FormOfControl> getAll() throws SQLException;
}
