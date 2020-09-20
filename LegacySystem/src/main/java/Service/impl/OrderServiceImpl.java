package Service.impl;

import Service.EmptyClass;
import Service.OrderService;
import Service.model.OrderEntity;
import Service.util.ExcelReadUtil;

import javax.jws.WebService;
import java.io.File;
import java.net.URISyntaxException;
import java.util.*;

/**
 * 人事系统
 */
@WebService(
        name = "personnelServiceImpl",
        endpointInterface = "Service.OrderService"
)
public class OrderServiceImpl implements OrderService {

    //模拟一张order表，主键key是订单号
    private static Map<String, OrderEntity> tbl_order;

    /**
     * 获取订单信息
     * @param id
     * @return
     */
    public OrderEntity getOrderInfoById(String id) {
        if(tbl_order==null){
            try {
                initTbl();
            } catch (URISyntaxException e){
                e.printStackTrace();
            }
        }

        return tbl_order.get(id);
    }

    private static void initTbl() throws URISyntaxException {
        tbl_order = new HashMap<>();
        //使用相对路径
        String excelFilePath = new EmptyClass().getClass().getClassLoader()
                .getResource("./excel/order.xlsx").toURI().getPath();
        HashMap<String, ArrayList<ArrayList<String>>> excelReadMap = ExcelReadUtil.readExcel(new File(excelFilePath), 1);
        if(excelReadMap != null){
            ArrayList<ArrayList<String>> target = excelReadMap.get(
                    excelReadMap.keySet().iterator().next()
            );
            for(List<String> row : target){
                OrderEntity tempOrder = new OrderEntity();
                tempOrder.setId(row.get(0));
                tempOrder.setMaterialId(row.get(1));
                tempOrder.setNumber(Long.valueOf(row.get(2)));
                tempOrder.setDdl(new Date(row.get(3)));
                tbl_order.put(tempOrder.getId(), tempOrder);
            }
        }
    }
}
