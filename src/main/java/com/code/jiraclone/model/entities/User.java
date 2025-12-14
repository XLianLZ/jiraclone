package com.code.jiraclone.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String profilePhotoUrl;

    @ManyToMany(mappedBy = "members")
    @JsonIgnore
    private Set<Project> projectsList = new HashSet<>();

    @OneToMany(mappedBy = "assignee")
    @JsonIgnore
    private Set<Issue> issuesList = new HashSet<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public void assignIssue(Issue issue){
        if(issue.getAssignedUser()== null){
            issuesList.add(issue);
            issue.setAssignedUser(this);
            log.info("issue "+issue.getCode()+": "+issue.getName()+" has been succesfully added");
        }else{
            throw new IllegalStateException("Issue is already assigned");
        }

    }

    public void removeIssue(Issue issue){
        if (issue.getAssignedUser()!= null && issue.getAssignedUser().equals(this)){
            issuesList.remove(issue);
            issue.setAssignedUser(null);
        }else{
            throw new IllegalStateException("Issue couldn't be removed either because it's assigned to someone else or is yet to be assigned");
        }
    }
}
