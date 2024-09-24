package com.ruoyi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;


/**
 * 订单退款Controller
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@RestController
@RequestMapping("/api/gaodemap")
public class XdOrderRefundsController extends BaseController
{

//    @Autowired
//    private IXdOrderRefundsService xdOrderRefundsService;

    /**
     * 查询地址列表
     */
    @PostMapping("/getAddressList")
    public Map<String,String> list(Map<String , Objects> maps) throws Exception {
       Map<String,String> map=  new HashMap<>();
       String url="https://restapi.amap.com/v3/assistant/inputtips?key=899e960e3d93e1f07383d12b7f66b1fc&keywords=济南历下区";
       String url2="https://restapi.amap.com/v3/assistant/inputtips?output=xml&city=010&keywords=招商银行&key=899e960e3d93e1f07383d12b7f66b1fc";
        map.put("a",Request.requestHTTPContent(url2,"GET"));
        return map;
    }

}
