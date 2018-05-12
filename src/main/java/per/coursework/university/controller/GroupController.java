package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/group/insert")
    Group insertGroup(@RequestBody Group group) throws SQLException {
        return groupService.insertGroup(group);
    }

    @GetMapping("/group/delete")
    void deleteGroup(@RequestParam("id") int id) throws SQLException {
        groupService.deleteGroup(id);
    }

    @GetMapping("/group/get")
    Group getGroupById(@RequestParam("id") int id) throws SQLException {
        return groupService.getGroup(id);
    }

    @RequestMapping("/group/update")
    Group updateGroup(@RequestBody Group group, @RequestParam("id") int id) throws SQLException {
        group.setId(id);
        return groupService.updateGroup(group);
    }
}
