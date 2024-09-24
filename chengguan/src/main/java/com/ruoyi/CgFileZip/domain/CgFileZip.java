package com.ruoyi.CgFileZip.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文件对象 cg_file_zip
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
public class CgFileZip extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String filename;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String fileAddress;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFilename(String filename) 
    {
        this.filename = filename;
    }

    public String getFilename() 
    {
        return filename;
    }
    public void setFileAddress(String fileAddress) 
    {
        this.fileAddress = fileAddress;
    }

    public String getFileAddress() 
    {
        return fileAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("filename", getFilename())
            .append("fileAddress", getFileAddress())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .toString();
    }
}
