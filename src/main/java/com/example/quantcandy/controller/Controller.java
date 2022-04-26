package com.example.quantcandy.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Vector;

@RestController
public class Controller {


    @PostMapping(value = "/candy")
    public StringBuilder getCandies(@RequestBody String input){
        Vector<Character> answer = getCandy(input);
        StringBuilder s =new StringBuilder();
        for (int i = 0; i < answer.size(); ++i){
           s.append(answer.get(i)) ;
        }
        return s;
    }
    static Vector<Character> getCandy(String str)
    {
        Vector<Character> v = new Vector<>();
        for (int i = 0; i < str.length(); ++i)
        {
            v.add(str.charAt(i));
            if (v.size() > 2)
            {
                int sz = v.size();
                if (v.get(sz - 1) == v.get(sz - 2) &&
                        v.get(sz - 2) == v.get(sz - 3))
                {
                    v.setSize(sz - 3);
                }
            }
        }
        return v;
    }
}
