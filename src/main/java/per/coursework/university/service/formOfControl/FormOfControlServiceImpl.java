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
    public FormOfControl insertFormOfControl(FormOfControl formOfControl) {
        return null;
    }

    @Override
    public FormOfControl getFormOfControl(int id) {
        return null;
    }

    @Override
    public FormOfControl updateFormOfControl(FormOfControl formOfControl) {
        return null;
    }

    @Override
    public FormOfControl deleteFormOfControl(int id) {
        return null;
    }

    @Override
    public List<FormOfControl> getAll() throws SQLException {
        return formOfControlDAO.getAll();
    }
}
