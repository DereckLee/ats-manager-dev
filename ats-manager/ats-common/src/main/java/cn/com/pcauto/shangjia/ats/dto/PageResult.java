package cn.com.pcauto.shangjia.ats.dto;

import lombok.Data;

import java.util.List;

/**
 *
 * @param <T>
 */
@Data
public class PageResult<T> {
    private int pageNo;
    private int pageSize;
    private int total;
    private List<T> items;
}
