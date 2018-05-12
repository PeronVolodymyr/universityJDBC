package per.coursework.university.service.chair.interfaces;

import per.coursework.university.model.Chair;

import java.sql.SQLException;
import java.util.List;

public interface IChairService {

    public Chair insertChair(Chair chair) throws SQLException;
    public Chair getChair(int id) throws SQLException;
    public Chair updateChair(Chair chair) throws SQLException;
    public void deleteChair(int id) throws SQLException;
    public List<Chair> getAll() throws SQLException;
}
