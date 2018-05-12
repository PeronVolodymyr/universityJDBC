package per.coursework.university.DAO.candidatesDissertation.interfaces;

import per.coursework.university.model.CandidatesDissertation;
import per.coursework.university.model.Chair;

import java.sql.SQLException;
import java.util.List;

public interface ICandidatesDissertationDAO {

    public CandidatesDissertation insertCandidatesDissertation(CandidatesDissertation candidatesDissertation) throws SQLException;
    public CandidatesDissertation getCandidatesDissertation(int id) throws SQLException;
    public CandidatesDissertation updateCandidatesDissertation(CandidatesDissertation candidatesDissertation) throws SQLException;
    public void deleteCandidatesDissertation(int id) throws SQLException;
    public List<CandidatesDissertation> getAll() throws SQLException;
}
