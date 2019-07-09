package com.pc.blog.dao;

/**
 *
 * @author pc
 **/
public interface BaseMapper<T,ID> {

    /**
     * 删除
     * @param id  主键id
     * @return 删除条数
     */
    int delete(ID id);

    /**
     * 添加
     * @param record 新增实体
     * @return 新增个数
     */
    int insert(T record);

    /**
     * 查询
     * @param id 主键id
     * @return T
     */
    T select(ID id);

    /**
     * 更新
     * @param record 更新实体
     * @return 更新条数
     */
    int update(T record);
}

