package per.coursework.university.DAO.chair.interfaces;

import per.coursework.university.model.CandidatesDissertation;
import per.coursework.university.model.Chair;

import java.sql.SQLException;
import java.util.List;

public interface IChairDAO {

    public Chair insertChair(Chair chair);
    public Chair getChair(int id);
    public Chair updateChair(Chair chair);
    public Chair deleteChair(int id);
    public List<Chair> getAll() throws SQLException;
}
