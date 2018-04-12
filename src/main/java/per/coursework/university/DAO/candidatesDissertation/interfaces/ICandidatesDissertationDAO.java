package per.coursework.university.DAO.candidatesDissertation.interfaces;

import per.coursework.university.model.CandidatesDissertation;
import per.coursework.university.model.Chair;

import java.sql.SQLException;
import java.util.List;

public interface ICandidatesDissertationDAO {

    public CandidatesDissertation insertCandidatesDissertation(CandidatesDissertation candidatesDissertation);
    public CandidatesDissertation getCandidatesDissertation(int id);
    public CandidatesDissertation updateCandidatesDissertation(CandidatesDissertation candidatesDissertation);
    public CandidatesDissertation deleteCandidatesDissertation(int id);
    public List<CandidatesDissertation> getAll() throws SQLException;
}
