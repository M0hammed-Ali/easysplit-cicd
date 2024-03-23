package com.project.easysplit.model;

import java.io.Serializable;
import java.util.Objects;

public class GroupMembersId implements Serializable {
    private Long user_id;
    private Long group_id;

    public GroupMembersId() {
    }

    public GroupMembersId(Long userId, Long groupId) {
        this.user_id = userId;
        this.group_id = groupId;
    }

    public Long getUserId() {
        return user_id;
    }

    public void setUserId(Long userId) {
        this.user_id = userId;
    }

    public Long getGroupId() {
        return group_id;
    }

    public void setGroupId(Long groupId) {
        this.group_id = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupMembersId that = (GroupMembersId) o;
        return Objects.equals(user_id, that.user_id) &&
                Objects.equals(group_id, that.group_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, group_id);
    }
}
