package com.project.easysplit.model;

import jakarta.persistence.*;


@Entity
@Table(name = "group_members")
public class GroupMembers {
    @EmbeddedId
    private GroupMembersId id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Groups group;

    // Constructors
    public GroupMembers() {
    }

    public GroupMembers(GroupMembersId id, Users user, Groups group) {
        this.id = id;
        this.user = user;
        this.group = group;
    }

    // Getters and setters
    public GroupMembersId getId() {
        return id;
    }

    public void setId(GroupMembersId id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }
}
