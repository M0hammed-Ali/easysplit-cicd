package com.project.easysplit.service;

import com.project.easysplit.model.GroupMembers;
import com.project.easysplit.repository.GroupMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMembersService {
    private final GroupMembersRepository groupMembersRepository;

    @Autowired
    public GroupMembersService(GroupMembersRepository groupMembersRepository) {
        this.groupMembersRepository = groupMembersRepository;
    }

    public List<GroupMembers> getAllGroupMembers() {
        return groupMembersRepository.findAll();
    }

    public void addGroupMember(GroupMembers groupMember) {
        groupMembersRepository.save(groupMember);
    }

    public void removeGroupMember(GroupMembers groupMember) {
        groupMembersRepository.delete(groupMember);
    }
}
