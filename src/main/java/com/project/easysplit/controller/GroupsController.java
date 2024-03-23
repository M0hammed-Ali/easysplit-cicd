package com.project.easysplit.controller;

import com.project.easysplit.model.Groups;
import com.project.easysplit.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/groups")
@CrossOrigin
public class GroupsController {
    private final GroupsService groupsService;

    @Autowired
    public GroupsController(GroupsService groupsService) {
        this.groupsService = groupsService;
    }

    @GetMapping
    public List<Groups> getGroups() {
        return groupsService.getGroups();
    }

    @PostMapping
    public void registerNewGroup(@RequestBody Groups group) {
        groupsService.addNewGroup(group);
    }

    @DeleteMapping(path = "{id}")
    public void deleteGroup(@PathVariable("id") Long id) {
        groupsService.deleteGroup(id);
    }
}
