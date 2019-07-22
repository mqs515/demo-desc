package com.test.demo.test;

import com.test.demo.domain.Shop;
import com.test.demo.utils.ExcelExportUtil;
import com.test.demo.utils.ExcelImportUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelOprate {

    /**
     * 文件导入
     */
    @Test
    public void testImport(){
        /**
         * Mock数据，Java对象列表
         */
        List<Shop> shopList = new ArrayList<Shop>();
        for (int i = 0; i < 100; i++) {
            Shop shop = new Shop(true, "商户"+i, (short) i, 1000+i, 10000+i, (float) (1000+i), (double) (10000+i), new Date());
            shopList.add(shop);
        }
        String filePath = "//Users/fenke/Downloads/demo-sheet.xls";

        /**
         * Excel导出：Object 转换为 Excel
         */
        ExcelExportUtil.exportToFile(filePath, shopList);
    }

    /**
     * 文件导出
     */
    @Test
    public void testExport(){
        String filePath = "//Users/fenke/Downloads/demo-sheet.xls";

        /**
         * Excel导入：Excel 转换为 Object
         */
        List<Object> list = ExcelImportUtil.importExcel(filePath, Shop.class);

        list.forEach(a -> System.out.println(a));
    }
}
