package per.coursework.university.service.candidatesDissertation.interfaces;

import per.coursework.university.model.CandidatesDissertation;

import java.sql.SQLException;
import java.util.List;

public interface ICandidatesDissertationService {

    public CandidatesDissertation insertCandidatesDissertation(CandidatesDissertation candidatesDissertation) throws SQLException;
    public CandidatesDissertation getCandidatesDissertation(int id) throws SQLException;
    public CandidatesDissertation updateCandidatesDissertation(CandidatesDissertation candidatesDissertation) throws SQLException;
    public void deleteCandidatesDissertation(int id) throws SQLException;
    public List<CandidatesDissertation> getAll() throws SQLException;
}
