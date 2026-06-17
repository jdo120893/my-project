package org.example.friendapp.service;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.example.friendapp.domain.Friend;
import org.example.friendapp.repository.FriendRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;

    @Transactional(readOnly = true)
    public Iterable<Friend> getFriends(){
       return friendRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Friend> getFriends(Pageable pageable){
        return friendRepository.findAll(pageable);
    }

    @Transactional
    public Friend saveFriend(Friend friend){
        return friendRepository.save(friend);
    }


    @Transactional(readOnly = true)
    public Friend getFriend(Long id){
        return friendRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Friend updateFriend(Friend friend){
        return friendRepository.save(friend);
    }

    @Transactional
    public void deleteFriend(Long id){
         friendRepository.deleteById(id);
    }
}
