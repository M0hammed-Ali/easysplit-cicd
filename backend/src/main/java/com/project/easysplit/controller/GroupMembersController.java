package com.project.easysplit.controller;

import com.project.easysplit.model.GroupMembers;
import com.project.easysplit.service.GroupMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/groupmembers")
@CrossOrigin
public class GroupMembersController {
    private final GroupMembersService groupMembersService;

    @Autowired
    public GroupMembersController(GroupMembersService groupMembersService) {
        this.groupMembersService = groupMembersService;
    }

    @GetMapping
    public ResponseEntity<List<GroupMembers>> getAllGroupMembers() {
        List<GroupMembers> groupMembers = groupMembersService.getAllGroupMembers();
        return new ResponseEntity<>(groupMembers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addGroupMember(@RequestBody GroupMembers groupMember) {
        groupMembersService.addGroupMember(groupMember);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeGroupMember(@RequestBody GroupMembers groupMember) {
        groupMembersService.removeGroupMember(groupMember);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
