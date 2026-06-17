package org.example.restexam.Controller;

import org.example.restexam.Domain.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/memos2")
public class MemoRest2Controller {
    private final Map<Long, Memo> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<Memo> getMemos(){
//        return new ArrayList<>(memos.values()); 가변
        return memos.values().stream().toList(); //불변
    }

    @GetMapping("{id}")
    public Memo getMemo(@PathVariable("id") Long id){
        return memos.getOrDefault(id, null);
    }

    @PostMapping
    public Memo createMemo(@RequestBody Memo memo){
        long id = counter.incrementAndGet();
        memo.setId(id);
        memos.put(id, memo);
        return memo;
    }

    @PutMapping("{id}")
    public String updateMemo(@PathVariable("id")Long id, @RequestBody Memo memo){
        if(!memos.containsKey(id))
            return "memos not found";
        memo.setId(id);
        memos.put(id, memo);
        return "memos update ok";
    }

    @DeleteMapping("{id}")
    public String deleteMemo(@PathVariable("id")Long id){
        if (memos.remove(id) == null)
            return "memos mot found";

        return "memos delete ok";
    }


}
