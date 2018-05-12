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
    public DoctoralDissertation insertDoctoralDissertation(DoctoralDissertation doctoralDissertation) throws SQLException {

        return doctoralDissertationDAO.insertDoctoralDissertation(doctoralDissertation);
    }

    @Override
    public DoctoralDissertation getDoctoralDissertation(int id) throws SQLException {

        return doctoralDissertationDAO.getDoctoralDissertation(id);
    }

    @Override
    public DoctoralDissertation updateDoctoralDissertation(DoctoralDissertation doctoralDissertation) throws SQLException {

        return doctoralDissertationDAO.updateDoctoralDissertation(doctoralDissertation);
    }

    @Override
    public void deleteDoctoralDissertation(int id) throws SQLException {
        doctoralDissertationDAO.deleteDoctoralDissertation(id);
    }

    @Override
    public List<DoctoralDissertation> getAll() throws SQLException {
        return doctoralDissertationDAO.getAll();
    }
}
