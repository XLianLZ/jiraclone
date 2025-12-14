package com.code.jiraclone.repository;

import com.code.jiraclone.model.entities.Epic;
import com.code.jiraclone.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpicRepository extends JpaRepository<Epic, Long> {
    List<Epic>findByProjectId(Long projectId);
    List<Epic>findByStatus(Status status);
}
