package per.coursework.university.service.formOfControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.formOfControl.FormOfControlDAOJDBCImpl;
import per.coursework.university.model.FormOfControl;
import per.coursework.university.service.formOfControl.interfaces.IFormOfControlService;

import java.sql.SQLException;
import java.util.List;

@Service
public class FormOfControlServiceImpl implements IFormOfControlService {

    @Autowired
    private FormOfControlDAOJDBCImpl formOfControlDAO;

    @Override
    public FormOfControl insertFormOfControl(FormOfControl formOfControl) throws SQLException {

        return formOfControlDAO.insertFormOfControl(formOfControl);
    }

    @Override
    public FormOfControl getFormOfControl(int id) throws SQLException {

        return formOfControlDAO.getFormOfControl(id);
    }

    @Override
    public FormOfControl updateFormOfControl(FormOfControl formOfControl) throws SQLException {
        return formOfControlDAO.updateFormOfControl(formOfControl);
    }

    @Override
    public void deleteFormOfControl(int id) throws SQLException {
        formOfControlDAO.deleteFormOfControl(id);
    }

    @Override
    public List<FormOfControl> getAll() throws SQLException {
        return formOfControlDAO.getAll();
    }
}
