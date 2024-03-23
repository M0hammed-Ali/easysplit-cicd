package com.project.easysplit.service;

import com.project.easysplit.model.Groups;
import com.project.easysplit.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsService {
    private final GroupsRepository groupsRepository;

    @Autowired
    public GroupsService(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    public List<Groups> getGroups() {
        return groupsRepository.findAll();
    }

    public void addNewGroup(Groups group) {
        groupsRepository.save(group);
    }

    public void deleteGroup(Long id) {
        boolean exists = groupsRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Group with id " + id + " does not exist");
        }
        groupsRepository.deleteById(id);
    }
}
