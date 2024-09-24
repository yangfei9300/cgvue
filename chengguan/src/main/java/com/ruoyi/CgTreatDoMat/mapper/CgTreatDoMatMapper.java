package com.ruoyi.CgTreatDoMat.mapper;

import java.util.List;
import com.ruoyi.CgTreatDoMat.domain.CgTreatDoMat;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 待办事件Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-29
 */

public interface CgTreatDoMatMapper 
{
    /**
     * 查询待办事件
     * 
     * @param id 待办事件主键
     * @return 待办事件
     */
    public CgTreatDoMat selectCgTreatDoMatById(Long id);

    /**
     * 查询待办事件列表
     * 
     * @param cgTreatDoMat 待办事件
     * @return 待办事件集合
     */
    public List<CgTreatDoMat> selectCgTreatDoMatList(CgTreatDoMat cgTreatDoMat);
    public List<CgTreatDoMat> getShijianList(CgTreatDoMat cgTreatDoMat);
    public List<CgTreatDoMat> gettotalfenMonth(CgTreatDoMat cgTreatDoMat);



    /**
     * 新增待办事件
     * 
     * @param cgTreatDoMat 待办事件
     * @return 结果
     */
    public int insertCgTreatDoMat(CgTreatDoMat cgTreatDoMat);

    /**
     * 修改待办事件
     * 
     * @param cgTreatDoMat 待办事件
     * @return 结果
     */
    public int updateCgTreatDoMat(CgTreatDoMat cgTreatDoMat);

    /**
     * 删除待办事件
     * 
     * @param id 待办事件主键
     * @return 结果
     */
    public int deleteCgTreatDoMatById(Long id);

    /**
     * 批量删除待办事件
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgTreatDoMatByIds(Long[] ids);
}
