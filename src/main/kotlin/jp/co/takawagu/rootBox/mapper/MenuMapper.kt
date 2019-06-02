package jp.co.takawagu.rootBox.mapper

import jp.co.takawagu.rootBox.model.Menu
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface MenuMapper {

    @Select("""
        SELECT
            code, item_name as name, price, kcal, category
        FROM
            menu
        WHERE
            disabled = '0'
    """)
    fun selectAll(): List<Menu>

    @Select("""
        SELECT
            code, item_name as name, price, kcal, category
        FROM
            menu
        WHERE
            code = #{code}
    """)
    fun select(code: String): Menu

}