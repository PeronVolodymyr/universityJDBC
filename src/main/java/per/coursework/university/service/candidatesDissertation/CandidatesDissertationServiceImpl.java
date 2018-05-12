package per.coursework.university.service.candidatesDissertation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.candidatesDissertation.CandidatesDissertationDAOJDBCImpl;
import per.coursework.university.model.CandidatesDissertation;
import per.coursework.university.service.candidatesDissertation.interfaces.ICandidatesDissertationService;

import java.sql.SQLException;
import java.util.List;

@Service
public class CandidatesDissertationServiceImpl implements ICandidatesDissertationService {

    @Autowired
    private CandidatesDissertationDAOJDBCImpl candidatesDissertationDAO;

    @Override
    public CandidatesDissertation insertCandidatesDissertation(CandidatesDissertation candidatesDissertation) throws SQLException {
        return candidatesDissertationDAO.insertCandidatesDissertation(candidatesDissertation);
    }

    @Override
    public CandidatesDissertation getCandidatesDissertation(int id) throws SQLException {

        return candidatesDissertationDAO.getCandidatesDissertation(id);
    }

    @Override
    public CandidatesDissertation updateCandidatesDissertation(CandidatesDissertation candidatesDissertation) throws SQLException {
        return candidatesDissertationDAO.updateCandidatesDissertation(candidatesDissertation);
    }

    @Override
    public void deleteCandidatesDissertation(int id) throws SQLException {
        candidatesDissertationDAO.deleteCandidatesDissertation(id);
    }

    @Override
    public List<CandidatesDissertation> getAll() throws SQLException {
        return candidatesDissertationDAO.getAll();
    }

}
