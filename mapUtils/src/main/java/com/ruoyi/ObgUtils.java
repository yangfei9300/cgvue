package com.ruoyi;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObgUtils {
    public  static YuanWeilan strToYuanWeilan(String weilanStr){
        try {
            ObjectMapper mapper = new ObjectMapper();
            YuanWeilan person = mapper.readValue(weilanStr, YuanWeilan.class);
            System.out.println(person.toString());
            return person;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
