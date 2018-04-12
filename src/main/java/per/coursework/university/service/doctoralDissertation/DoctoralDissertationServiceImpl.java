package per.coursework.university.service.doctoralDissertation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.doctoralDissertation.DoctoralDissertationDAOJDBCImpl;
import per.coursework.university.model.DoctoralDissertation;
import per.coursework.university.service.doctoralDissertation.interfaces.IDoctoralDissertationService;

import java.sql.SQLException;
import java.util.List;

@Service
public class DoctoralDissertationServiceImpl implements IDoctoralDissertationService {

    @Autowired
    private DoctoralDissertationDAOJDBCImpl doctoralDissertationDAO;

    @Override
    public DoctoralDissertation insertDoctoralDissertation(DoctoralDissertation doctoralDissertation) {
        return null;
    }

    @Override
    public DoctoralDissertation getDoctoralDissertation(int id) {
        return null;
    }

    @Override
    public DoctoralDissertation updateDoctoralDissertation(DoctoralDissertation doctoralDissertation) {
        return null;
    }

    @Override
    public DoctoralDissertation deleteDoctoralDissertation(int id) {
        return null;
    }

    @Override
    public List<DoctoralDissertation> getAll() throws SQLException {
        return doctoralDissertationDAO.getAll();
    }
}
