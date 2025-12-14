package com.code.jiraclone.repository;

import com.code.jiraclone.model.entities.Issue;
import com.code.jiraclone.model.enums.Priority;
import com.code.jiraclone.model.enums.Status;
import com.code.jiraclone.model.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    Optional<Issue>findByCode(String code);
    List<Issue> findByType(Type type);
    List<Issue> findByPriority(Priority priority);
    List<Issue> findByStatus(Status status);
    List<Issue>findByProjectId(Long projectId);
    List<Issue>findByEpicId(Long epicId);
    List<Issue>findByAssignedUserId(Long assignedUserId);
    List<Issue>findByCreatorId(Long creatorId);

    List<Issue>findByEpicIdIsNull();
    List<Issue>findByAssignedUserIdIsNull();
}
