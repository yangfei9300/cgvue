package com.ruoyi.web.controller.api;

import com.ruoyi.CgPDuiKaohe.domain.CgPDuiKaohe;
import com.ruoyi.CgPDuiKaohe.service.ICgPDuiKaoheService;
import com.ruoyi.CgPHszs.domain.CgPHszs;
import com.ruoyi.CgPHszs.service.ICgPHszsService;
import com.ruoyi.CgPShijian.domain.CgPShijian;
import com.ruoyi.CgPShijian.service.ICgPShijianService;
import com.ruoyi.CgPSsxHistory.domain.CgPSsxHistory;
import com.ruoyi.CgPSsxHistory.service.ICgPSsxHistoryService;
import com.ruoyi.CgScheduling.domain.CgScheduling;
import com.ruoyi.CgUser.domain.CgUser;
import com.ruoyi.cg_p_ssx.domain.CgPSsx;
import com.ruoyi.cg_p_ssx.service.impl.ICgPSsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/p")
public class pianshen {

    @Autowired
    private ICgPShijianService cgPShijianService;
    @Autowired
    private ICgPDuiKaoheService cgPDuiKaoheService;
    @Autowired
    private ICgPHszsService cgPHszsService;
    @Autowired
    private ICgPSsxHistoryService cgPSsxHistoryService;
    @Autowired
    private ICgPSsxService cgPSsxService;

    @PostMapping("/getkoufenxiang")
    public Map<String, Object> getkoufenxiang(@RequestBody CgPSsx cgPSsx) {
        Map<String, Object> map = new HashMap<>();
        List<CgPSsx> lista= cgPSsxService.selectCgPSsxList(cgPSsx);
        map.put("msg","操作成功");
        map.put("data",lista);
        map.put("code",200);
        return map;
    }

//    获取每一项扣费想的分数
    @PostMapping("/getkiufenxiang")
    public Map<String, Object> getkiufenxiang(@RequestBody CgPSsxHistory cgPSsxHistory) {
        Map<String, Object> map = new HashMap<>();
        List<CgPSsxHistory> listCgPSsxHistory=cgPSsxHistoryService.selectCgPSsxHistoryList(cgPSsxHistory);
        map.put("data",listCgPSsxHistory);
        map.put("msg","操作成功");
        map.put("code",200);
        return map;
    }

//    获取华山指数
    @PostMapping("/huashanzhishu")
    public Map<String, Object> huashanzhishu(@RequestBody CgPHszs cgPHszs) {
        Map<String, Object> map = new HashMap<>();
        cgPHszs=cgPHszsService.selectCgPHszsById(1L);
        map.put("msg","操作成功");
        map.put("code",200);
        map.put("data",cgPHszs);
        return map;
    }
//    获取待办事件
    @PostMapping("/pshijian")
    public Map<String, Object> userlogin(@RequestBody CgPShijian cgPShijian) {
        Map<String, Object> map = new HashMap<>();
        List<CgPShijian> list= cgPShijianService.selectCgPShijianList(cgPShijian);
        map.put("data",list);
        map.put("msg","操作成功");
        map.put("code",200);
        return map;
    }
//    获取对于分数
    @PostMapping("/duiwukaoheH")
    public Map<String, Object> duiwukaoheH(@RequestBody CgPDuiKaohe cgPDuiKaohe) {
        Map<String, Object> map = new HashMap<>();
//        获取队name多个
        List<CgPDuiKaohe> lists=cgPDuiKaoheService.qcsall(cgPDuiKaohe);
        List<String> listnames=new ArrayList<>();
        for(int a=0;a<lists.size();a++){
            listnames.add(lists.get(a).getTeamName());
        }
        map.put("duinames",listnames);
//        获取每个队伍的月份和数据
        List<List<CgPDuiKaohe>> listObg=new ArrayList<>();
        for(int a=0;a<listnames.size();a++){
            CgPDuiKaohe cgPDuiKaohe1=new CgPDuiKaohe();
            cgPDuiKaohe1.setTeamName(listnames.get(a));
            List<CgPDuiKaohe> lists2=cgPDuiKaoheService.selectCgPDuiKaoheList(cgPDuiKaohe1);
            listObg.add(lists2);
        }
        map.put("duidata",listObg);
        map.put("code",200);
        return map;
    }

}
