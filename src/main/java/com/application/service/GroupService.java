package com.application.service;

import com.application.model.Group;
import com.application.model.User;
import com.application.model.exception.NotFoundException;
import com.application.repository.GroupRepository;
import com.application.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupService {

  @Autowired
  private GroupRepository groupRepository;

  public Optional<Group> getGroupByName(String name) {
    return groupRepository.findByName(name);
  }

  public Optional<Group> getGroupById(String id) {
    return groupRepository.findById(id);
  }

  public List<User> getUsersByUserStatusPerGroup(User.Status status, String groupName) {
    return groupRepository.findByUserStatus(status, groupName);
  }

  public void createGroup(Group group) {
    groupRepository.save(group);
  }

  public void updateGroup(Group group) {
    Optional<Group> groupById = groupRepository.findById(group.getId());
    if (groupById.isPresent()) {
      groupRepository.save(group);
    } else {
      throw new NotFoundException("Group not found");
    }
  }

  @Transactional
  public void deleteGroup(String id, String newGroupForTransfertId) {
    Group groupById =
        groupRepository.findById(id).orElseThrow(() -> new NotFoundException("Group not found"));
    Group groupByNewId =
        groupRepository
            .findById(newGroupForTransfertId)
            .orElseThrow(() -> new NotFoundException("Group not found"));
    for (User user : groupById.getUsers()) {
      user.setGroup(groupByNewId);
    }
    groupRepository.delete(groupById);
  }
}
