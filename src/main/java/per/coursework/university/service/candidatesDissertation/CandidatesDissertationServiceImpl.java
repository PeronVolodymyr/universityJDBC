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
    public CandidatesDissertation insertCandidatesDissertation(CandidatesDissertation candidatesDissertation) {
        return null;
    }

    @Override
    public CandidatesDissertation getCandidatesDissertation(int id) {
        return null;
    }

    @Override
    public CandidatesDissertation updateCandidatesDissertation(CandidatesDissertation candidatesDissertation) {
        return null;
    }

    @Override
    public CandidatesDissertation deleteCandidatesDissertation(int id) {
        return null;
    }

    @Override
    public List<CandidatesDissertation> getAll() throws SQLException {
        return candidatesDissertationDAO.getAll();
    }

}
