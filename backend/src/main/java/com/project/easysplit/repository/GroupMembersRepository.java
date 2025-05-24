package com.project.easysplit.repository;

import com.project.easysplit.model.GroupMembers;
import com.project.easysplit.model.GroupMembersId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMembersRepository extends JpaRepository<GroupMembers, GroupMembersId> {
    // Add custom query methods if needed
}
