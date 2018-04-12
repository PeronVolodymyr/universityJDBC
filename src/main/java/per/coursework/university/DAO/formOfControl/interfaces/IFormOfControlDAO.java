package per.coursework.university.DAO.formOfControl.interfaces;

import per.coursework.university.model.DoctoralDissertation;
import per.coursework.university.model.FormOfControl;

import java.sql.SQLException;
import java.util.List;

public interface IFormOfControlDAO {

    public FormOfControl insertFormOfControl(FormOfControl formOfControl);
    public FormOfControl getFormOfControl(int id);
    public FormOfControl updateFormOfControl(FormOfControl formOfControl);
    public FormOfControl deleteFormOfControl(int id);
    public List<FormOfControl> getAll() throws SQLException;
}
