package org.example.friendapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.friendapp.domain.Friend;
import org.example.friendapp.service.FriendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Slf4j
@Controller
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;
//    친구등록 - 폼    /friend/add    -- GET
    @GetMapping("/add")
    public String addForm(){
        return "friend/addForm";
    }
//    친구등록          /friend/add    -- POST
    @PostMapping("/add")
    public String add(@ModelAttribute Friend friend){

//        이 값을 이용해서 서비스쪽에 친구 저장해줘요..
        Friend savedFriend = friendService.saveFriend(friend);

        log.info("{} Friend saved successfully",savedFriend.getName());

        return "redirect:/friend/list";
    }

//        친구목록보기   /friend/list    -- GET
    @GetMapping("/list")
    public String list(Model model){
        Iterable<Friend> friends = friendService.getFriends();

        model.addAttribute("friends", friends);

        return "friend/list";
    }

//    친구정보보기  /friend/친구id    -- GET
    @GetMapping("/{id}")
    public String view(@PathVariable("id") int id){
        return "friend/view";
    }
//친구정보수정 - 폼   /friend/update/친구id   -- GET
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id){

        return "friend/updateForm";
    }

//    친구정보수정         /friend/update   -- Post
    @PostMapping("/update")
    public String update(){

        return "redirect:/friend/list";
    }
//    친구삭제   /friend/delete  -- GET
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){

        return "redirect:/friend/list";
    }

}
