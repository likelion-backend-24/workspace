package org.example.friendapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/friend")
public class FriendController {
//    친구등록 - 폼    /friend/add    -- GET
    @GetMapping("/add")
    public String addForm(){
        return "friend/addForm";
    }
//    친구등록          /friend/add    -- POST
    @PostMapping("/add")
    public String add(){

        return "redirect:/friend/list";
    }

//        친구목록보기   /friend/list    -- GET
    @GetMapping("/list")
    public String list(){

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
