package jp.co.takawagu.rootBox.mapper

import jp.co.takawagu.rootBox.model.Menu
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface MenuMapper {

    @Select("""
        SELECT
            item_name as name, price, kcal, category
        FROM
            menu
    """)
    fun selectAll(): List<Menu>

}