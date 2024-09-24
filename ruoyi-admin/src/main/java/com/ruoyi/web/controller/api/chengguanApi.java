package com.ruoyi.web.controller.api;

import com.ruoyi.CgBanners.domain.CgBanners;
import com.ruoyi.CgBanners.service.ICgBannersService;
import com.ruoyi.CgEventType.domain.CgEventType;
import com.ruoyi.CgEventType.service.ICgEventTypeService;
import com.ruoyi.CgHeartShi.domain.CgHeartShi;
import com.ruoyi.CgHeartShi.service.ICgHeartShiService;
import com.ruoyi.CgTreatDoMat.domain.CgTreatDoMat;
import com.ruoyi.CgTreatDoMat.domain.OrderIdGenerator;
import com.ruoyi.CgTreatDoMat.service.ICgTreatDoMatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cg")
public class chengguanApi {

    @Autowired
    private ICgBannersService cgBannersService;

    @Autowired
    private ICgEventTypeService cgEventTypeService;
    @Autowired
    private ICgTreatDoMatService cgTreatDoMatService;
    @Autowired
    private ICgHeartShiService cgHeartShiService;
    @PostMapping("/getbanners")
    public Map<String, Object> getbanners(@RequestBody CgBanners cgBanners) {
        Map<String, Object> map = new HashMap<>();
        List<CgBanners> list = cgBannersService.selectCgBannersList(cgBanners);
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("data", list);
        return map;
    }

//    获取事件分类
    @PostMapping("/getCgEventType")
    public Map<String, Object> getCgEventType(@RequestBody CgEventType cgEventType) {
        Map<String, Object> map = new HashMap<>();
        List<CgEventType> list = cgEventTypeService.selectCgEventTypeList(cgEventType);
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("data", list);
        return map;
    }
//    添加事件
    @PostMapping("/addcgTreatDoMat")
    public Map<String, Object> addcgTreatDoMat(@RequestBody CgTreatDoMat cgTreatDoMat) {
        Map<String, Object> map = new HashMap<>();
        OrderIdGenerator orderIdGenerator=new OrderIdGenerator();
        cgTreatDoMat.setpCode(orderIdGenerator.generateOrderId());
        cgTreatDoMatService.insertCgTreatDoMat(cgTreatDoMat);
        map.put("msg", "操作成功");
        map.put("code", 200);
        return map;
    }

    @PostMapping("/addHrhs")
    public Map<String, Object> addHrhs(@RequestBody CgHeartShi cgHeartShi) {
        Map<String, Object> map = new HashMap<>();

        cgHeartShiService.insertCgHeartShi(cgHeartShi);
        map.put("msg", "操作成功");
        map.put("code", 200);
        return map;
    }



}
