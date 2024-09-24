package com.ruoyi.web.controller.api;

import com.ruoyi.*;
import com.ruoyi.CgAttendance.domain.CgAttendance;
import com.ruoyi.CgAttendance.service.ICgAttendanceService;
import com.ruoyi.CgDakaHistory.domain.CgDakaHistory;
import com.ruoyi.CgDakaHistory.service.ICgDakaHistoryService;
import com.ruoyi.CgFenHistory.domain.CgFenHistory;
import com.ruoyi.CgFenHistory.service.ICgFenHistoryService;
import com.ruoyi.CgGeographicFence.domain.CgGeographicFence;
import com.ruoyi.CgGeographicFence.service.ICgGeographicFenceService;
import com.ruoyi.CgHeartShi.domain.CgHeartShi;
import com.ruoyi.CgHeartShi.service.ICgHeartShiService;
import com.ruoyi.CgPositioning.domain.CgPositioning;
import com.ruoyi.CgPositioning.service.ICgPositioningService;
import com.ruoyi.CgScheduling.domain.CgScheduling;
import com.ruoyi.CgScheduling.service.ICgSchedulingService;
import com.ruoyi.CgShifouchaochu.domain.CgShifouchaochu;
import com.ruoyi.CgShifouchaochu.service.ICgShifouchaochuService;
import com.ruoyi.CgTeam.domain.CgTeam;
import com.ruoyi.CgTeam.service.ICgTeamService;
import com.ruoyi.CgTreatDoMat.domain.CgTreatDoMat;
import com.ruoyi.CgTreatDoMat.service.ICgTreatDoMatService;
import com.ruoyi.CgUser.domain.CgUser;
import com.ruoyi.CgUser.service.ICgUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/api/cguser")
public class userApi {

    @Autowired
    private ICgUserService cgUserService;
    @Autowired
    private ICgTeamService cgTeamService;
    @Autowired
    private ICgGeographicFenceService cgGeographicFenceService;
    @Autowired
    private ICgSchedulingService cgSchedulingService;
    @Autowired
    private ICgDakaHistoryService cgDakaHistoryService;
    @Autowired
    private ICgAttendanceService cgAttendanceService;
    @Autowired
    private ICgTreatDoMatService cgTreatDoMatService;
    @Autowired
    private ICgHeartShiService cgHeartShiService;
    @Autowired
    private ICgPositioningService cgPositioningService;
    @Autowired
    private ICgShifouchaochuService cgShifouchaochuService;
    @Autowired
    private ICgFenHistoryService cgFenHistoryService;


    @PostMapping("/exportKaoqin")
    public Map<String, Object> exportKaoqin(HttpServletResponse response, CgUser cgUser) throws IOException {
        List<CgUser> listUsers = cgUserService.getKqoqinExcel1(cgUser);
        List<List<String>> listStrs=new ArrayList<List<String>>();

//        表格第一行
        List<String> list1=new ArrayList<>();
//        list1.add("");
        for(int a=0;a<listUsers.size();a++){
            list1.add(listUsers.get(a).getName());
        }

        List<String> list2=new ArrayList<>();
        list2.add("");
        for(int a=0;a<listUsers.size();a++){
            list2.add("上午");
            list2.add("下午");
        }
        listStrs.add(list1);
        listStrs.add(list2);

        String[][] days = DateUtils.getMonthInfos();

        for(int a=0;a<days.length;a++){
            List<String> list3=new ArrayList<>();
            list3.add(days[a][0]);
            for(int b=0;b<listUsers.size();b++){
                if(listUsers.get(b).getCgAttendanceList().get(a).getParams()!=null){
                    if(listUsers.get(b).getCgAttendanceList().get(a).getParams().get("check_in_status")!=null){
                        String statusDaka=listUsers.get(b).getCgAttendanceList().get(a).getParams().get("check_in_status").toString();
                        if(statusDaka.equals("1")){
                            list3.add("正常");
                        }else   if(statusDaka.equals("2")){
                            list3.add("迟到");
                        }else   if(statusDaka.equals("3")){
                            list3.add("早退");
                        }
                    }else{
                        list3.add("缺卡");
                    }
                    if(listUsers.get(b).getCgAttendanceList().get(a).getParams().get("check_out_status")!=null){
                        String statusDaka=listUsers.get(b).getCgAttendanceList().get(a).getParams().get("check_out_status").toString();
                        if(statusDaka.equals("1")){
                            list3.add("正常");
                        }else   if(statusDaka.equals("2")){
                            list3.add("迟到");
                        }else   if(statusDaka.equals("3")){
                            list3.add("早退");
                        }
                    }else{
                        list3.add("缺卡");
                    }
                }else{
                    list3.add("缺卡");
                }
            }
            listStrs.add(list3);
        }

        Main1.hebing2(listStrs);


        Map<String, Object> map = new HashMap<>();
        map.put("data",listStrs);
        return map;
    }


    @PostMapping("/login")
    public Map<String, Object> userlogin(@RequestBody CgUser cgUser) {
        Map<String, Object> map = new HashMap<>();
        if (cgUser.getPhone() == null || cgUser.getPassword() == null) {
            map.put("msg", "登录失败");
            map.put("code", 201);
            return map;
        }
        List<CgUser> list = cgUserService.selectCgUserList(cgUser);
        if (list.size() <= 0) {
            map.put("msg", "登录失败");
            map.put("code", 201);
            return map;
        }
        if (list.size() == 1) {
//           查询上班时刻
            if(list.get(0).getWorkTimeId()!=null){
                CgScheduling cgScheduling=cgSchedulingService.selectCgSchedulingById(list.get(0).getWorkTimeId());
                map.put("cgScheduling", cgScheduling);
            }
            map.put("msg", "登录成功");
            map.put("code", 200);
            map.put("data", list.get(0));
        }
        return map;
    }

    //    修改密码
    @PostMapping("/updatePwd")
    public Map<String, Object> updatePwd(@RequestBody CgUser cgUser) {
        Map<String, Object> map = new HashMap<>();
        if (cgUser.getPhone() == null || cgUser.getPassword() == null || cgUser.getId() == null) {
            map.put("msg", "修改密码失败");
            map.put("code", 201);
            return map;
        }
        CgUser cgUser1 = new CgUser();
        cgUser1.setId(cgUser.getId());
        cgUser1.setPhone(cgUser.getPhone());
        List<CgUser> list = cgUserService.selectCgUserList(cgUser1);
        if (list.size() <= 0) {
            map.put("msg", "修改密码失败");
            map.put("code", 201);
            return map;
        }
        CgUser cgUser2 = new CgUser();
        cgUser2.setId(cgUser.getId());
        cgUser2.setPassword(cgUser.getPassword());
        cgUserService.updateCgUser(cgUser2);
        map.put("msg", "修改密码成功");
        map.put("code", 200);
        return map;
    }

    @PostMapping("/updateUserInfo")
    public Map<String, Object> updateUserInfo(@RequestBody CgUser cgUser) {
        Map<String, Object> map = new HashMap<>();
        if (cgUser.getId() == null) {
            map.put("msg", "修改信息失败");
            map.put("code", 201);
            return map;
        }
        cgUserService.updateCgUser(cgUser);

        map.put("data", cgUser);
        map.put("msg", "修改信息成功");
        map.put("code", 200);
        return map;
    }

    @PostMapping("/getTeamList")
    public Map<String, Object> getTeamList(@RequestBody CgTeam cgTeam) {
        Map<String, Object> map = new HashMap<>();
        List<CgTeam> cgTeamlist = cgTeamService.selectCgTeamList(cgTeam);
        map.put("msg", "操作成功");
        map.put("data", cgTeamlist);
        map.put("code", 200);
        return map;
    }

    @PostMapping("/getTeampeoples")
    public Map<String, Object> getTeamList(@RequestBody CgUser cgUser) {
        Map<String, Object> map = new HashMap<>();
        List<CgUser> cgUserlist = cgUserService.selectCgUserList(cgUser);
        map.put("msg", "操作成功");
        map.put("data", cgUserlist);
        map.put("code", 200);
        return map;
    }

    //  获取我队伍的待办事项
    @PostMapping("/getDaibanShiList")
    public Map<String, Object> getDaibanShiList(@RequestBody CgTreatDoMat cgTreatDoMat) {
        Map<String, Object> map = new HashMap<>();
        List<CgTreatDoMat> list = cgTreatDoMatService.getShijianList(cgTreatDoMat);
        map.put("data", list);
        map.put("msg", "操作成功");
        map.put("code", 200);
        return map;
    }

    @PostMapping("/updateShijian")
    public Map<String, Object> updateShijian(@RequestBody CgTreatDoMat cgTreatDoMat) {
        Map<String, Object> map = new HashMap<>();
        cgTreatDoMat.setResultStartTime(new Date());
        cgTreatDoMatService.updateCgTreatDoMat(cgTreatDoMat);
        map.put("msg", "操作成功");
        map.put("code", 200);
        return map;
    }

    public Long getNumTime(Date startTime,Date endTime){
        // 定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        // 计算时间差（毫秒）
        long diffInMillis = endTime.getTime() - startTime.getTime();

        // 将毫秒差转换为分钟
        long diffInMinutes = diffInMillis / (60 * 1000);

        // 输出结果
        System.out.println("两个日期之间的时间差（分钟）：" + diffInMinutes);
        return diffInMinutes;
    }

//    处理反馈
    @PostMapping("/updateShijian2")
    public Map<String, Object> updateShijian2(@RequestBody CgTreatDoMat cgTreatDoMat) {
        Map<String, Object> map = new HashMap<>();
        CgTreatDoMat cgTreatDoMat1=new CgTreatDoMat();
        cgTreatDoMat1=cgTreatDoMatService.selectCgTreatDoMatById(cgTreatDoMat.getId());
//        算出多长时间
        Long fenzhong= getNumTime(cgTreatDoMat1.getEndTime()  , new Date());

        cgTreatDoMat.setResultEndTime(new Date());
        cgTreatDoMat.setWanTime(fenzhong);
        cgTreatDoMatService.updateCgTreatDoMat(cgTreatDoMat);

        map.put("msg", "操作成功");
        map.put("code", 200);
        return map;
    }

    @PostMapping("/getDaibanShiInfo")
    public Map<String, Object> getDaibanShiInfo(@RequestBody CgTreatDoMat cgTreatDoMat) {
        Map<String, Object> map = new HashMap<>();
        CgTreatDoMat cgTreatDoMat1 = cgTreatDoMatService.selectCgTreatDoMatById(cgTreatDoMat.getId());
        if (cgTreatDoMat1 == null) {
            map.put("msg", "事件不存在");
            map.put("code", 201);
            return map;
        }
//      获取提交人姓名
        CgUser cgUser1 = cgUserService.selectCgUserById(cgTreatDoMat1.getuTId());
        CgUser cgUser2 = cgUserService.selectCgUserById(cgTreatDoMat1.getcUId());
        map.put("data", cgTreatDoMat1);
        map.put("tuser", cgUser1);
        map.put("cuser", cgUser2);
        map.put("msg", "操作成功");
        map.put("code", 200);
        return map;
    }

    //    获取我的好人好事
    @PostMapping("/getMyHrhs")
    public Map<String, Object> getMyHrhs(@RequestBody CgHeartShi cgHeartShi) {
        Map<String, Object> map = new HashMap<>();
        List<CgHeartShi> listCgHeartShi = cgHeartShiService.getMyHrhs(cgHeartShi);
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("data", listCgHeartShi);
        return map;
    }

    //    获取好人好事个数获取待办事项个数
    @PostMapping("/getShiCount")
    public Map<String, Object> getShiCount(@RequestBody CgTreatDoMat cgTreatDoMat) {

        Map<String, Object> map = new HashMap<>();
        map.put("msg", "操作成功");
        map.put("code", 200);
        CgTreatDoMat cgTreatDoMat1 = new CgTreatDoMat();
        cgTreatDoMat1.setcUId(cgTreatDoMat.getcUId());
//        我处理的事件的个数
        int myCSjCOunt = cgTreatDoMatService.selectCgTreatDoMatList(cgTreatDoMat1).size();
//        队里的所有事件
        CgTreatDoMat cgTreatDoMat2 = new CgTreatDoMat();
        cgTreatDoMat2.setcUId(cgTreatDoMat.getcTId());
        int myCtCount = cgTreatDoMatService.selectCgTreatDoMatList(cgTreatDoMat1).size();
//        我上传的好人好事个数
        CgHeartShi cgHeartShi = new CgHeartShi();
        cgHeartShi.setuId(cgTreatDoMat.getcUId());
        int myHrhsCount = cgHeartShiService.selectCgHeartShiList(cgHeartShi).size();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("myCSjCOunt", myCSjCOunt);
        map1.put("myHrhsCount", myHrhsCount);
        map1.put("myCtCount", myCtCount);
        map.put("data", map1);
        return map;


    }

    //    我上传的事件
    @PostMapping("/myUpDbsj")
    public Map<String, Object> myUpDbsj(@RequestBody CgTreatDoMat cgTreatDoMat) {
        Map<String, Object> map = new HashMap<>();
        List<CgTreatDoMat> listCgTreatDoMat = cgTreatDoMatService.getShijianList(cgTreatDoMat);
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("data", listCgTreatDoMat);
        return map;
    }

//    获取我的当月的打卡记录
    @PostMapping("/myDakaHistoryByUid")
    public Map<String, Object> myDakaHistoryByUid(@RequestBody CgAttendance cgAttendance) {
        Map<String, Object> map = new HashMap<>();
        List<CgAttendance> listCgAttendance= cgAttendanceService.getKqHistoryByUid(cgAttendance);
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("data", listCgAttendance);
        return map;
    }
    //    判断是否出了范围
    @PostMapping("/myisweilan")
    public Map<String, Object> myisweilan(@RequestBody CgUser cgUser) throws MessagingException {
        Map<String, Object> map = new HashMap<>();
        if(cgUser.getId()==null){
            map.put("msg", "请先登录");
            map.put("code", 201);
            return map;
        }
        if(cgUser.getId()==null){
            map.put("msg", "请先登录");
            map.put("code", 201);
            return map;
        }
        CgUser cgUser1=cgUserService.selectCgUserById(cgUser.getId());
        CgUser cgUser2=new CgUser();
        cgUser2.setId(cgUser.getId());
        cgUser2.setLat(cgUser.getLat());
        cgUser2.setLng(cgUser.getLng());
        cgUserService.updateCgUser(cgUser2);//更新当前坐标

        if(cgUser1==null){
            map.put("msg", "无此用户");
            map.put("code", 201);
            return map;
        }
        if(cgUser1.getAreaId()==null){
            map.put("msg", "没分配上班区域");
            map.put("code", 201);
            return map;
        }
        //判断是否在上班时间内
        if(cgUser1.getWorkTimeId()==null){
            map.put("msg", "未指定上班时间");
            map.put("code", 201);
            return map;
        }
        CgScheduling cgScheduling=cgSchedulingService.selectCgSchedulingById(cgUser1.getWorkTimeId());
        if(cgScheduling==null){
            map.put("msg", "上班时间无效");
            map.put("code", 201);
            return map;
        }


//        String starttime=UtilsApiApi.getnianyurei()+" "+cgScheduling.getStartTime();
//        String endtime=UtilsApiApi.getnianyurei()+" "+cgScheduling.getEndTime();
//        DateTimeFormatter newTime=UtilsApiApi.getNYRSFM();
//        LocalDateTime start = LocalDateTime.parse(starttime, newTime);
//        LocalDateTime end = LocalDateTime.parse(endtime, newTime);
//        LocalDateTime now = LocalDateTime.now();
//        boolean isInInterval = !now.isBefore(start) && !now.isAfter(end);
//        if(!isInInterval){
//            System.out.printf("不在上班区间内不可以定位");
//            map.put("msg", "");
//            map.put("code", 200);
//            return map;
//        }else{
//            System.out.printf("在区间内可以定位");
//        }




//      获取上班区域
        double[][] ds = null;
        CgGeographicFence cgGeographicFence=cgGeographicFenceService.selectCgGeographicFenceById(cgUser1.getAreaId());
        boolean ishave=false;
        if(cgGeographicFence.getType()==1){
            Point2D.Double pointU=new Point2D.Double();
            pointU.setLocation(cgUser.getLng(),cgUser.getLat());
            ds = UtilsApiApi.strZShuzu(cgGeographicFence.getInfo());
            List<Point2D.Double> pts = new ArrayList<>();
            for (int a = 0; a < ds.length; a++) {
                Point2D.Double point2 = new Point2D.Double(ds[a][0], ds[a][1]);
                pts.add(point2);
            }
            ishave= PolygonUtil.isInPolygon(pointU, pts);

        } else {
            System.out.printf("圆形打卡");
            String weilanObg=cgGeographicFence.getInfo();
            YuanWeilan yuanWeilan= ObgUtils.strToYuanWeilan(weilanObg);
            ishave=PolygonUtil.isInCircle(yuanWeilan.getRadius(),yuanWeilan.getLat(),yuanWeilan.getLon(),cgUser.getLat(), cgUser.getLat());
        }





//        邮箱报警
        CgUser cgUser3=new CgUser();
        cgUser3.setTeamId(cgUser.getTeamId());
        cgUser3.setIsDz(1L);
        List<CgUser> cgUserList=cgUserService.selectCgUserList(cgUser3);
        if(cgUserList.size()>0){
            if(!ishave){
                SendEmailUsingQQMail.toSendEmail(cgUserList.get(0).getEmail(),cgUser1.getName()+"超出工作范围");
            }
        }





//        记录定位信息
        CgPositioning cgPositioning=new CgPositioning();
        cgPositioning.setuId(cgUser.getId());
        cgPositioning.setLat(cgUser.getLat());
        cgPositioning.setLon(cgUser.getLng());
        cgPositioning.setAddress(cgUser.getName());
//        String [] adds=cgUser.getRenark().split(",");
//        cgPositioning.setCountry(adds[0]);
//        cgPositioning.setProvince(adds[1]);
//        cgPositioning.setCity(adds[2]);
//        cgPositioning.setDistrict(adds[3]);
//        cgPositioning.setStreet(adds[4]);
//        cgPositioning.setStreetNum(adds[5]);
//        cgPositioning.setPoiName(adds[6]);
//        cgPositioning.setCityCode(adds[7]);
        cgPositioning.setIsHava(ishave?1L:2L);
        cgPositioningService.insertCgPositioning(cgPositioning);
//      判断上次定位的位置如果和这次一样  没有超出  则不记录  如果不一样（不在范围）则记录下来，用于判断是否矿工
        CgShifouchaochu shifouchaochu=new CgShifouchaochu();
        shifouchaochu.setuId(cgUser.getId());
        List<CgShifouchaochu> listShifouchaochu=cgShifouchaochuService.getNowhistory(shifouchaochu);
        int type=!ishave?2:1;
        if(listShifouchaochu.size()==0||!listShifouchaochu.get(0).getType().equals(""+type)){
            shifouchaochu.setType(type+"");
            cgPositioning.setLat(cgUser.getLat());
            cgPositioning.setLon(cgUser.getLng());
            shifouchaochu.setLat(cgUser.getLat());
            shifouchaochu.setLon(cgUser.getLng());
            cgShifouchaochuService.insertCgShifouchaochu(shifouchaochu);
        }
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("data", ishave);
        return map;
    }

//获取打卡时间/是上班打卡还是下班打卡/通过当前位置获取地址信息
    @PostMapping("/getDakaTImess")
    public Map<String, Object> getDakaTImess(@RequestBody CgDakaHistory cgDakaHistory) {
        Map<String, Object> map = new HashMap<>();
        CgUser cgUser1 = cgUserService.selectCgUserById(cgDakaHistory.getuId());
        if (cgUser1 == null) {
            map.put("msg", "请先登录");
            map.put("code", 201);
            return map;
        }
        //获取用户的打卡时间表
        if (cgUser1.getWorkTimeId() == null) {
            map.put("msg", "未绑定上班时刻,打卡失败");
            map.put("code", 201);
            return map;
        }
        CgScheduling cgScheduling = cgSchedulingService.selectCgSchedulingById(cgUser1.getWorkTimeId());
        if (cgScheduling == null) {
            map.put("msg", "上班时刻不存在，打卡失败");
            map.put("code", 201);
            return map;
        }
//        如果没有考勤记录就生成当前月的
        CgAttendance cgAttendance3=new CgAttendance();
        cgAttendance3.setAttendDate(new Date());
        cgAttendance3.setuId(cgUser1.getId());
        // 获取当前日期
        LocalDate today1 = LocalDate.now();
        cgAttendance3.getParams().put("year",today1.getYear());
        cgAttendance3.getParams().put("month",today1.getMonthValue());
        //判断是否有考勤表
        List<CgAttendance> lustCgAttendance1= cgAttendanceService.getKqList(cgAttendance3);
        if(lustCgAttendance1.size()==0){
            String [][] monthdays= DateUtils.getMonthInfos();
            for(int a=0;a<monthdays.length;a++){
                CgAttendance cgAttendance2=new CgAttendance();
                cgAttendance2.setuId(cgUser1.getId());
                cgAttendance2.setAttendDate(DateUtils.strZhaunDate(monthdays[a][0]));
                cgAttendance2.setWeekNum(monthdays[a][1]);
                cgAttendanceService.insertCgAttendance(cgAttendance2);
            }
        }
        // 获取当前日期
        LocalDate today = LocalDate.now();
//          获取考勤表
        CgAttendance cgAttendance = new CgAttendance();
        cgAttendance.setuId(cgDakaHistory.getuId());
        cgAttendance.setAttendDate(new Date());
        cgAttendance.getParams().put("year", today.getYear());
        cgAttendance.getParams().put("month", today.getMonthValue());
        cgAttendance.getParams().put("day", today.getDayOfMonth());
        //判断是否有考勤表
        List<CgAttendance> lustCgAttendance = cgAttendanceService.getKqList(cgAttendance);

        if (lustCgAttendance.size() <= 0) {
            map.put("msg", "考勤表不存在，打卡失败");
            map.put("code", 201);
            return map;
        }

        LocalTime startTime = LocalTime.parse(cgScheduling.getStartTime());
        LocalTime endTime = LocalTime.parse(cgScheduling.getEndTime());
        LocalTime userTime = LocalTime.parse(UtilsApiApi.strZShuzu());
//            int dakatype= UtilsApiApi.checkPunchTime(startTime,endTime,userTime);//1上班2下班3之间
        int dakatype = UtilsApiApi.compareTimeToWorkHours(userTime, startTime, endTime);
        map.put("sxbType",dakatype);
        map.put("dakTime",cgScheduling);
        map.put("code",200);
        return map;
    }

    //    打卡
    @PostMapping("/toUserDaka")
    public Map<String, Object> toUserDaka(@RequestBody CgDakaHistory cgDakaHistory) {
        Map<String, Object> map = new HashMap<>();

        CgUser cgUser1 = cgUserService.selectCgUserById(cgDakaHistory.getuId());
        if (cgUser1 == null) {
            map.put("msg", "打卡失败");
            map.put("code", 201);
            return map;
        }
        CgGeographicFence cgGeographicFence = cgGeographicFenceService.selectCgGeographicFenceById(cgUser1.getAreaId());
        if (cgGeographicFence == null) {
            map.put("msg", "未绑定工作区域,打卡失败");
            map.put("code", 201);
            return map;
        }
        //获取用户的打卡时间表
        if (cgUser1.getWorkTimeId() == null) {
            map.put("msg", "未绑定上班时刻,打卡失败");
            map.put("code", 201);
            return map;
        }
        CgScheduling cgScheduling = cgSchedulingService.selectCgSchedulingById(cgUser1.getWorkTimeId());
        if (cgScheduling == null) {
            map.put("msg", "上班时刻不存在，打卡失败");
            map.put("code", 201);
            return map;
        }

//        如果没有考勤记录就生成当前月的
        CgAttendance cgAttendance3=new CgAttendance();
        cgAttendance3.setAttendDate(new Date());
        cgAttendance3.setuId(cgUser1.getId());
        // 获取当前日期
        LocalDate today1 = LocalDate.now();
        cgAttendance3.getParams().put("year",today1.getYear());
        cgAttendance3.getParams().put("month",today1.getMonthValue());
        //判断是否有考勤表
        List<CgAttendance> lustCgAttendance1= cgAttendanceService.getKqList(cgAttendance3);
        if(lustCgAttendance1.size()==0){
            String [][] monthdays= DateUtils.getMonthInfos();
            for(int a=0;a<monthdays.length;a++){
                CgAttendance cgAttendance2=new CgAttendance();
                cgAttendance2.setuId(cgUser1.getId());
                cgAttendance2.setAttendDate(DateUtils.strZhaunDate(monthdays[a][0]));
                cgAttendance2.setWeekNum(monthdays[a][1]);
                cgAttendanceService.insertCgAttendance(cgAttendance2);
            }
        }









        // 获取当前日期
        LocalDate today = LocalDate.now();

//          获取考勤表
        CgAttendance cgAttendance = new CgAttendance();
        cgAttendance.setuId(cgDakaHistory.getuId());
        cgAttendance.setAttendDate(new Date());
        cgAttendance.getParams().put("year", today.getYear());
        cgAttendance.getParams().put("month", today.getMonthValue());
        cgAttendance.getParams().put("day", today.getDayOfMonth());
        //判断是否有考勤表
        List<CgAttendance> lustCgAttendance = cgAttendanceService.getKqList(cgAttendance);

        if (lustCgAttendance.size() <= 0) {
            map.put("msg", "考勤表不存在，打卡失败");
            map.put("code", 201);
            return map;
        }



        LocalTime startTime = LocalTime.parse(cgScheduling.getStartTime());
        LocalTime endTime = LocalTime.parse(cgScheduling.getEndTime());
        LocalTime userTime = LocalTime.parse(UtilsApiApi.strZShuzu());
//            int dakatype= UtilsApiApi.checkPunchTime(startTime,endTime,userTime);//1上班2下班3之间
        System.out.printf("--"+userTime+"--"+startTime+"--"+endTime);
        int dakatype = UtilsApiApi.compareTimeToWorkHours(userTime, startTime, endTime);

        if (dakatype == 1 || dakatype == 3) {
            cgDakaHistory.setKaType((long) 1);//上班
        } else if (dakatype == 2 || dakatype == 4) {
            cgDakaHistory.setKaType((long) 2);//下班
        } else {
            map.put("msg", "请等待五秒钟重新打卡");
            map.put("code", 201);
            return map;
        }
        if (dakatype == 1 || dakatype == 2) {
            cgDakaHistory.setStatus(1L);//打卡正常
        } else if (dakatype == 3) {
            cgDakaHistory.setStatus(2L);//打卡迟到
        } else if (dakatype == 4) {
            cgDakaHistory.setStatus(3L);//早退
        }

        cgDakaHistory.setKaTime(new Date());
        cgDakaHistory.setTimeId(cgUser1.getWorkTimeId());

        double[][] ds = null;
        boolean isyes = false;
        if (cgGeographicFence.getType() == 1L) {
            ds = UtilsApiApi.strZShuzu(cgGeographicFence.getInfo());
//                Point2D.Double point, List<Point2D.Double> pts
            Point2D.Double point1 = new Point2D.Double(cgDakaHistory.getLon(), cgDakaHistory.getLat());
            List<Point2D.Double> pts = new ArrayList<>();
            for (int a = 0; a < ds.length; a++) {
                Point2D.Double point2 = new Point2D.Double(ds[a][0], ds[a][1]);
                pts.add(point2);
            }
            isyes = PolygonUtil.isInPolygon(point1, pts);

        } else {
            System.out.printf("圆形打卡");
            String weilanObg=cgGeographicFence.getInfo();
            YuanWeilan yuanWeilan= ObgUtils.strToYuanWeilan(weilanObg);
            isyes=PolygonUtil.isInCircle(yuanWeilan.getRadius(),yuanWeilan.getLat(),yuanWeilan.getLon(),cgDakaHistory.getLat(), cgDakaHistory.getLon());
        }

        if (!isyes) {
            map.put("msg", "打卡失败不在打卡范围内");
            map.put("code", 201);
            return map;
        }

        //判断是否打过卡了
        CgAttendance cgAttendance2 = new CgAttendance();
        cgAttendance2.setuId(cgDakaHistory.getuId());
        cgAttendance2.getParams().put("tumes", UtilsApiApi.getnianyurei());

        List<CgAttendance> CgAttendanceList = cgAttendanceService.selectCgAttendanceList(cgAttendance2);
        if (CgAttendanceList.size() == 1) {
            if (cgDakaHistory.getKaType() == 1) {
                if (CgAttendanceList.get(0).getCheckIn() != null) {
                    map.put("msg", "已打卡请勿重复打卡");
                    map.put("code", 201);
                    return map;
                }
            } else if (cgDakaHistory.getKaType() == 2) {
                if (CgAttendanceList.get(0).getCheckOut() != null) {
                    map.put("msg", "已打卡请勿重复打卡");
                    map.put("code", 201);
                    return map;
                }
            }
        }

//          添加打卡记录

        if (cgDakaHistory.getKaType() == 1 && cgDakaHistory.getStatus() == 1) {
            map.put("msg", "上班打卡正常");
        }
        if (cgDakaHistory.getKaType() == 2 && cgDakaHistory.getStatus() == 1) {
            map.put("msg", "下班打卡正常");
        }
        if (cgDakaHistory.getStatus() == 2) {
            map.put("msg", "上班打卡迟到");
//            int dakatype = UtilsApiApi.compareTimeToWorkHours(userTime, startTime, endTime);

            long minutesDifference = Duration.between( startTime,userTime).toMinutes();
            double fendou=UtilsApiApi.getfenByTime((int)minutesDifference);

            CgFenHistory cgFenHistory=new CgFenHistory();
            cgFenHistory.setuId(cgDakaHistory.getuId());
            cgFenHistory.setFen(-fendou);
            cgFenHistory.setFenType("1");
            cgFenHistory.setRemark("上班打卡迟到"+minutesDifference+"分钟");
            cgFenHistoryService.insertCgFenHistory(cgFenHistory);

        }
        if (cgDakaHistory.getStatus() == 3) {
            map.put("msg", "下班打卡早退");

            long minutesDifference = Duration.between( userTime,endTime).toMinutes();
            System.out.println(endTime+"--------------"+userTime);
            double fendou=UtilsApiApi.getfenByTime((int)minutesDifference);
            System.out.println("下班打卡早退"+minutesDifference);

            CgFenHistory cgFenHistory=new CgFenHistory();
            cgFenHistory.setuId(cgDakaHistory.getuId());
            cgFenHistory.setFen(-fendou);
            cgFenHistory.setFenType("2");
            cgFenHistory.setRemark("下班打卡早退"+minutesDifference+"分钟");
            cgFenHistoryService.insertCgFenHistory(cgFenHistory);

        }
        cgDakaHistory.setRenark(map.get("msg").toString());
        cgDakaHistory.setKqId(CgAttendanceList.get(0).getId());
        cgDakaHistoryService.insertCgDakaHistory(cgDakaHistory);
//          修改考勤表
        CgAttendance cgAttendance1 = lustCgAttendance.get(0);
        if (cgDakaHistory.getKaType() == 1) {
            cgAttendance1.setCheckIn(new Date());
            cgAttendance1.setCheckInId(cgDakaHistory.getId());
        } else {
            cgAttendance1.setCheckOut(new Date());
            cgAttendance1.setCheckOutId(cgDakaHistory.getId());
        }
//            如果是下班打卡的话  获取打卡记录
        if (cgDakaHistory.getKaType() == 2) {

            CgDakaHistory cgDakaHistory1 = new CgDakaHistory();
            cgDakaHistory1.setuId(cgDakaHistory.getuId());
            cgDakaHistory1.getParams().put("riqi", new Date());

            List<CgDakaHistory> listCgDakaHistory = cgDakaHistoryService.selectCgDakaHistoryList(cgDakaHistory1);
            String sbtxt = "";
            String xbtxt = "";
            if (listCgDakaHistory.size() > 0) {
                for (int a = 0; a < listCgDakaHistory.size(); a++) {
                    if (listCgDakaHistory.get(a).getKaType() == 1L) {
                        sbtxt = listCgDakaHistory.get(a).getRenark();
                    } else {
                        xbtxt = listCgDakaHistory.get(a).getRenark();
                    }
                }
            }
            cgAttendance1.setRemark(sbtxt + "-" + xbtxt);
        }
        cgAttendanceService.updateCgAttendance(cgAttendance1);




        map.put("code", 200);
        return map;
    }


}
