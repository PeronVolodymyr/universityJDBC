package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.Group;
import per.coursework.university.service.group.GroupServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GroupController {
    @Autowired
    private GroupServiceImpl groupService;

    @RequestMapping("/groups")
    List<Group> showGroups() throws SQLException {
        return groupService.getAll();
    }
}
