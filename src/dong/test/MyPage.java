package dong.test;

import java.util.List;

/**
 * @author Created by xzd on 2017/11/16.
 * @Description 自己写一个实现分批次处理数据的功能
 */
public class MyPage<T> {
    //当前是第几页
    private Integer pageNo;

    //一页读取多少行
    private Integer pageSize;

    //一共多少条记录
    private Integer total;

    //一共多少页
    private Integer totalPageNo;

    //真实记录list存储
    private List<T> rows;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
        int totalPage = total%pageSize == 0 ? total/pageSize : total/pageSize + 1;
        this.setTotalPageNo(totalPage);
    }

    public Integer getTotalPageNo() {
        return totalPageNo;
    }

    public void setTotalPageNo(Integer totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
        this.setTotal(rows.size());
    }
}
