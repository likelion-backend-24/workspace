package org.example.friendapp.repository;

import org.example.friendapp.domain.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendRepository extends CrudRepository<Friend, Long> {
}
