package org.example.friendapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.friendapp.domain.Friend;
import org.example.friendapp.repository.FriendRepository;
import org.example.friendapp.service.FriendService;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @GetMapping("/add")
    public String addFriend() {
        return "/friend/addForm";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Friend friend) {
        Friend savedFriend = friendService.saveFriend(friend);
        log.info("{} saved friend successful",friend.getName());
        return "redirect:/friend/list";
    }

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Friend> friends = friendService.getFriends(pageable);

        model.addAttribute("friends",friends);
        return "/friend/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable("id")Long id) {
        return "/friend/view";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")Long id, Model model) {

        Friend friend = friendService.getFriend(id);

        model.addAttribute("friend",friend);

        return "/friend/updateForm";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Friend friend) {
        friendService.updateFriend(friend);
        return "redirect:/friend/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id) {
        friendService.deleteFriend(id);
        return "redirect:/friend/list";
    }




}
