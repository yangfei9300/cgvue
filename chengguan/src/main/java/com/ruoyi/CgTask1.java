package com.ruoyi;

import com.ruoyi.CgAttendance.controller.DateUtils12;
import com.ruoyi.CgAttendance.domain.CgAttendance;
import com.ruoyi.CgAttendance.service.ICgAttendanceService;
import com.ruoyi.CgFenHistory.domain.CgFenHistory;
import com.ruoyi.CgFenHistory.service.ICgFenHistoryService;
import com.ruoyi.CgMonthKaohe.domain.CgMonthKaohe;
import com.ruoyi.CgMonthKaohe.service.ICgMonthKaoheService;
import com.ruoyi.CgScheduling.domain.CgScheduling;
import com.ruoyi.CgScheduling.service.ICgSchedulingService;
import com.ruoyi.CgShifouchaochu.domain.CgShifouchaochu;
import com.ruoyi.CgShifouchaochu.service.ICgShifouchaochuService;
import com.ruoyi.CgTeamKaohe.domain.CgTeamKaohe;
import com.ruoyi.CgTeamKaohe.service.ICgTeamKaoheService;
import com.ruoyi.CgTreatDoMat.domain.CgTreatDoMat;
import com.ruoyi.CgTreatDoMat.service.ICgTreatDoMatService;
import com.ruoyi.CgUser.domain.CgUser;
import com.ruoyi.CgUser.service.ICgUserService;
import com.ruoyi.CgVastSecond.domain.CgVastSecond;
import com.ruoyi.CgVastSecond.service.ICgVastSecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
//com.ruoyi.CgTask1.newKaoqin

@Component("cgTask1")
public class CgTask1 {

    @Autowired
    private ICgAttendanceService cgAttendanceService;
    @Autowired
    private ICgUserService cgUserService;
    @Autowired
    private ICgShifouchaochuService cgShifouchaochuService;
    @Autowired
    private ICgSchedulingService cgSchedulingService;
    @Autowired
    private ICgVastSecondService cgVastSecondService;
    @Autowired
    private ICgFenHistoryService cgFenHistoryService;
    @Autowired
    private ICgMonthKaoheService cgMonthKaoheService;
    @Autowired
    private ICgTreatDoMatService cgTreatDoMatService;
    @Autowired
    private ICgTeamKaoheService cgTeamKaoheService;

    /* 第二步：注入service 文件，像是在 controller 中一样*/


    /* 第三步：静态初使化当前类*/
    public static CgTask1 cgTask1;

    /* 第四步： 在此方法上加上注解@PostConstruct，这样方法就会在Bean初始化之后被Spring容器执行（注：Bean初始化包括，实例化Bean，并装配Bean的属性（依赖注入））。*/
    @PostConstruct
    public void init() {
        /* 第五步*/
        cgTask1 = this;
        /* 第六步*/
        cgTask1.cgAttendanceService = this.cgAttendanceService;
        cgTask1.cgUserService = this.cgUserService;
        cgTask1.cgShifouchaochuService = this.cgShifouchaochuService;
        cgTask1.cgSchedulingService = this.cgSchedulingService;
        cgTask1.cgVastSecondService = this.cgVastSecondService;
        cgTask1.cgFenHistoryService = this.cgFenHistoryService;
        cgTask1.cgMonthKaoheService = this.cgMonthKaoheService;
        cgTask1.cgTreatDoMatService = this.cgTreatDoMatService;
        cgTask1.cgTeamKaoheService = this.cgTeamKaoheService;



    }

    /*这是你正式使用的方法功能了，上面的属于步骤*/
    public void uploadKuImg() {
        /*第七步：注意注意是从静态对象开始调用service的方法*/
        CgUser cgUser = new CgUser();
        List<CgUser> cgUserList = cgTask1.cgUserService.selectCgUserList(cgUser);
        for (int a = 0; a < cgUserList.size(); a++) {
            CgAttendance cgAttendance = new CgAttendance();
            cgAttendance.setuId(cgUserList.get(a).getId());
            cgAttendance.getParams().put("year", DateUtils12.getYM().split(",")[0]);
            cgAttendance.getParams().put("month", DateUtils12.getYM().split(",")[1]);
            List<CgAttendance> cgAttendanceList = cgTask1.cgAttendanceService.getKqList(cgAttendance);
            if (cgAttendanceList.size() == 0) {
                String[][] monthdays = DateUtils.getMonthInfos();
                for (int b = 0; b < monthdays.length; b++) {
                    CgAttendance cgAttendance2 = new CgAttendance();
                    cgAttendance2.setuId(cgUserList.get(a).getId());
                    System.out.printf("'monthdays[a][0]" + monthdays[b]);
                    cgAttendance2.setAttendDate(DateUtils.strZhaunDate(monthdays[b][0]));
                    cgAttendance2.setWeekNum(monthdays[b][1]);
                    cgTask1.cgAttendanceService.insertCgAttendance(cgAttendance2);
                }
            }
        }
    }

    //生成每个月每个人所有的考勤记录
    public void newKaoqin(String params) {
        System.out.println("执行有参方法：" + params);
        uploadKuImg();
    }

    public static Date getTTT(String dateTimeString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 定义日期时间格式
        Date date = null;
        try {
            date = dateFormat.parse(dateTimeString); // 将字符串转换为Date对象

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    //    统计每天旷工多长时间(每天执行)
    public void kuanggongTime(String params) {
//        获取打卡的用户
        CgShifouchaochu cgShifouchaochu = new CgShifouchaochu();
        List<CgShifouchaochu> listCgShifouchaochu = cgTask1.cgShifouchaochuService.getDayids(cgShifouchaochu);
//        搜索用户id
        List<Long> uids = new ArrayList<>();
        for (int a = 0; a < listCgShifouchaochu.size(); a++) {
            CgUser cgUser = new CgUser();
            cgUser = cgTask1.cgUserService.selectCgUserById(listCgShifouchaochu.get(a).getuId());
            uids.add(listCgShifouchaochu.get(a).getuId());
            //获取上班时间段
            CgScheduling cgScheduling = cgTask1.cgSchedulingService.selectCgSchedulingById(cgUser.getWorkTimeId());
            // 获取当前日期
            LocalDate today = LocalDate.now();
            // 获取前一天的日期
//            LocalDate yesterday = today.minusDays(1);
            LocalDate yesterday = today.minusDays(0);
            String startTime = yesterday + " " + cgScheduling.getStartTime();
            String endTime = yesterday + " " + cgScheduling.getEndTime();
            CgShifouchaochu cgShifouchaochu1 = new CgShifouchaochu();
            cgShifouchaochu1.getParams().put("startTime", startTime);
            cgShifouchaochu1.getParams().put("endTime", endTime);
            cgShifouchaochu1.setuId(cgUser.getId());
            List<CgShifouchaochu> listGetDayWaichu = cgTask1.cgShifouchaochuService.getDayWaichu(cgShifouchaochu1);
            int total = 0;
            for (int b = 0; b < listGetDayWaichu.size(); b++) {
                CgVastSecond cgVastSecond = new CgVastSecond();
                cgVastSecond.setuId(cgUser.getId());
                String leave_time = listGetDayWaichu.get(b).getParams().get("leave_time").toString();
                leave_time = leave_time.replace("T", " ");
                cgVastSecond.setStartTime(getTTT(leave_time));
                String return_time = listGetDayWaichu.get(b).getParams().get("return_time").toString();
                return_time = return_time.replace("T", " ");
                cgVastSecond.setEndTime(getTTT(return_time));
                Date date111 = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());
                cgVastSecond.setDay(date111);
                int to = Integer.parseInt(listGetDayWaichu.get(b).getParams().get("miaoTotal").toString());
                cgVastSecond.setVastSecond(to);
                cgTask1.cgVastSecondService.insertCgVastSecond(cgVastSecond);
                total = total + to;
            }
            //  查询这个人当前的考勤记录
            CgAttendance cgAttendance = new CgAttendance();
            cgAttendance.setuId(cgUser.getId());
            Date date111 = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());
            cgAttendance.setAttendDate(date111);
            List<CgAttendance> listCgAttendance = cgTask1.cgAttendanceService.selectCgAttendanceList(cgAttendance);

            if (listCgAttendance.size() > 0) {
                listCgAttendance.get(0).setkSecont(total);//总旷工多少时间
                if (listCgAttendance.get(0).getCheckIn() == null || listCgAttendance.get(0).getCheckOut() == null) {
                    CgFenHistory cgFenHistory = new CgFenHistory();
                    cgFenHistory.setuId(listCgAttendance.get(0).getuId());
                    if (listCgAttendance.get(0).getCheckIn() == null && listCgAttendance.get(0).getCheckOut() == null) {

                        int kuangNum = getIsKgFpour(listCgAttendance.get(a).getuId(), yesterday + "");

                        if (kuangNum > 4) {
                            cgFenHistory.setFen(-5);
                            cgFenHistory.setRemark("一天未打卡旷工处理");
                        } else {
                            cgFenHistory.setFen(-0);
                            cgFenHistory.setRemark("算工休");
                        }
                        cgFenHistory.setFenType("3");
                    } else if (listCgAttendance.get(0).getCheckIn() == null) {
                        cgFenHistory.setFen(-2);
                        cgFenHistory.setRemark("上班未打卡");
                        cgFenHistory.setFenType("4");
                    } else if (listCgAttendance.get(0).getCheckOut() == null) {
                        cgFenHistory.setFen(-2);
                        cgFenHistory.setRemark("下班未打卡");
                        cgFenHistory.setFenType("5");
                    }
                    cgTask1.cgFenHistoryService.insertCgFenHistory(cgFenHistory);
                }
                cgTask1.cgAttendanceService.updateCgAttendance(listCgAttendance.get(0));
            }
        }
//        查询排除上述的用户id的人
        String uidss = uids.stream()
                .map(String::valueOf)  // 将每个 Long 转换为 String
                .collect(Collectors.joining(","));  // 使用逗号拼接
        CgAttendance cgAttendance11 = new CgAttendance();
        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 获取前一天的日期
//            LocalDate yesterday = today.minusDays(1);
        LocalDate yesterday = today.minusDays(0);
        Date date111 = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());
        cgAttendance11.setAttendDate(date111);
        cgAttendance11.getParams().put("paiuids", uidss);
        List<CgAttendance> listCgAttendanceL = cgTask1.cgAttendanceService.selectCgAttendanceList(cgAttendance11);
        for (int a = 0; a < listCgAttendanceL.size(); a++) {
            CgFenHistory cgFenHistory = new CgFenHistory();
            cgFenHistory.setuId(listCgAttendanceL.get(a).getuId());
            if (listCgAttendanceL.get(0).getCheckIn() == null || listCgAttendanceL.get(0).getCheckOut() == null) {
                if (listCgAttendanceL.get(0).getCheckIn() == null && listCgAttendanceL.get(0).getCheckOut() == null) {

                    cgFenHistory.setFenType("3");
                    int kuangNum = getIsKgFpour(listCgAttendanceL.get(a).getuId(), yesterday + "");

                    if (kuangNum > 4) {
                        cgFenHistory.setFen(-5);
                        cgFenHistory.setRemark("一天未打卡旷工处理");
                    } else {
                        cgFenHistory.setFen(-0);
                        cgFenHistory.setRemark("算工休");
                    }


                } else if (listCgAttendanceL.get(0).getCheckIn() == null) {
                    cgFenHistory.setFen(-2);
                    cgFenHistory.setRemark("上班未打卡");
                    cgFenHistory.setFenType("4");
                } else if (listCgAttendanceL.get(0).getCheckOut() == null) {
                    cgFenHistory.setFen(-2);
                    cgFenHistory.setRemark("下班未打卡");
                    cgFenHistory.setFenType("5");
                }
                cgTask1.cgFenHistoryService.insertCgFenHistory(cgFenHistory);
            }
        }
    }


    //    每个月月初计算上个月的考勤(加入到考核表),计算这个月的待办事项扣分情况
    public void numAllUserKaoqin() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(0);
        String nowdate = yesterday + "";
        CgFenHistory cgFenHistory = new CgFenHistory();
        cgFenHistory.getParams().put("year", nowdate.split("-")[0]);
        cgFenHistory.getParams().put("month", nowdate.split("-")[1]);
        //计算考勤
        List<CgFenHistory> listCgFenHistory = cgTask1.cgFenHistoryService.getMonthFens(cgFenHistory);
        for (int a = 0; a < listCgFenHistory.size(); a++) {
            //查询这条考核记录在不在如果不在  新建
            CgMonthKaohe cgMonthKaohe = new CgMonthKaohe();
            cgMonthKaohe.setuId(listCgFenHistory.get(a).getuId());
            cgMonthKaohe.setMonth(nowdate.substring(0, 7));
            List<CgMonthKaohe> listCgMonthKaohe = cgTask1.cgMonthKaoheService.selectCgMonthKaoheList(cgMonthKaohe);
            double fenMoneth = Double.parseDouble(listCgFenHistory.get(a).getParams().get("final_fen").toString());
            if (listCgMonthKaohe.size() <= 0) {
                cgMonthKaohe.setFen1(fenMoneth);
                cgTask1.cgMonthKaoheService.insertCgMonthKaohe(cgMonthKaohe);
            } else {
                listCgMonthKaohe.get(0).setFen1(fenMoneth);
                cgTask1.cgMonthKaoheService.updateCgMonthKaohe(listCgMonthKaohe.get(0));
            }
            System.out.printf("===" + listCgFenHistory.get(a).toString());
        }
    }

    //    每个月统计扣了多少分同步到表里去（月考核表里）
    public void numFenmOnth() {

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(0);
        String nowdate = yesterday + "";

        //获取待办事项扣分
        CgTreatDoMat cgTreatDoMat = new CgTreatDoMat();
        cgTreatDoMat.getParams().put("seldate", nowdate.substring(0, 7));
        List<CgTreatDoMat> listCgTreatDoMat = cgTask1.cgTreatDoMatService.gettotalfenMonth(cgTreatDoMat);
        for (int a = 0; a < listCgTreatDoMat.size(); a++) {
            String doubu = listCgTreatDoMat.get(a).getParams().get("result_total").toString();
            CgMonthKaohe cgMonthKaohe = new CgMonthKaohe();
            cgMonthKaohe.setuId(listCgTreatDoMat.get(a).getuTId());
            cgMonthKaohe.setMonth(nowdate.substring(0, 7));
            List<CgMonthKaohe> listCgMonthKaohe = cgTask1.cgMonthKaoheService.selectCgMonthKaoheList(cgMonthKaohe);
            if (listCgMonthKaohe.size() > 0) {
                listCgMonthKaohe.get(a).setFen2(Double.parseDouble(doubu));
                cgTask1.cgMonthKaoheService.updateCgMonthKaohe(listCgMonthKaohe.get(a));
            } else {
                cgMonthKaohe.setFen2(Double.parseDouble(doubu));
                cgTask1.cgMonthKaoheService.insertCgMonthKaohe(cgMonthKaohe);
            }
        }



    }

//    计算每个队伍的平均分数（前两位）
    public  void jisuanTeamFens(){

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(0);
        String nowdate = yesterday + "";
        CgMonthKaohe cgMonthKaohe=new CgMonthKaohe();
        cgMonthKaohe.setMonth(nowdate.substring(0, 7));
        List<CgMonthKaohe> listCgMonthKaohe= cgTask1.cgMonthKaoheService.getTeamLaohe(cgMonthKaohe);
        for (int a=0;a<listCgMonthKaohe.size();a++){
            System.out.println(listCgMonthKaohe.get(a).toString());
            CgMonthKaohe mg=listCgMonthKaohe.get(a);
            CgTeamKaohe cgTeamKaohe=new CgTeamKaohe();
            cgTeamKaohe.settId(mg.getuId());
            cgTeamKaohe.setMonth(mg.getMonth());
            cgTeamKaohe.setFen1(mg.getFen1());
            cgTeamKaohe.setFen2(mg.getFen2());
            List<CgTeamKaohe> list= cgTask1.cgTeamKaoheService.selectCgTeamKaoheList(cgTeamKaohe);
            if(list.size()>0){
                list.get(0).setFen1(mg.getFen1());
                list.get(0).setFen2(mg.getFen2());
                cgTask1.cgTeamKaoheService.updateCgTeamKaohe(list.get(0));
            }else{
                cgTask1.cgTeamKaoheService.insertCgTeamKaohe(cgTeamKaohe);
            }
        }
    }




    //    获取旷工次数
    public static int getIsKgFpour(Long uid, String selDate) {
        LocalDate today = LocalDate.now();
        // 获取前一天的日期
//            LocalDate yesterday = today.minusDays(1);
        LocalDate yesterday = today.minusDays(0);
        String startTime = yesterday + "";
        System.out.printf("startTime--" + startTime);
        CgFenHistory cgFenHistory = new CgFenHistory();
        cgFenHistory.getParams().put("ct", selDate.substring(0, 7));
        cgFenHistory.setuId(uid);
        cgFenHistory.setFenType("3");//旷工
        List<CgFenHistory> listHi = cgTask1.cgFenHistoryService.selectCgFenHistoryList(cgFenHistory);
        return listHi.size();
    }

}
