package Service.impl;

import Service.Database;
import Service.EmptyClass;
import Service.OrderService;
import Service.model.OrderEntity;
import Service.util.ExcelReadUtil;
import Service.util.ExcelWriteUtil;

import javax.jws.WebService;
import java.io.File;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 订单管理系统
 */
@WebService(
        serviceName = "OrderService",
        name = "OrderServiceSoap",
        endpointInterface = "Service.OrderService"
)
public class OrderServiceImpl implements OrderService {
    /**
     * 获取订单信息
     * @param id
     * @return
     */
    public OrderEntity getOrderInfoById(String id) {
        if(Database.tbl_order==null){
            try {
                initTblOrder();
            } catch (URISyntaxException e){
                e.printStackTrace();
            }
        }

        return Database.tbl_order.get(id);
    }

    /**
     * 获取所有订单信息
     * @return
     */

    @Override
    public List<OrderEntity> getAllOrders() {
        if(Database.tbl_order==null){
            try {
                initTblOrder();
            } catch (URISyntaxException e){
                e.printStackTrace();
            }
        }
        List<OrderEntity> tempList = new ArrayList<>();
        for(Map.Entry<String, OrderEntity> entry: Database.tbl_order.entrySet()){
            tempList.add(entry.getValue());
        }
        return tempList;
    }

    /**
     * 插入订单
     * @param order
     * @return
     */

    @Override
    public int insertOrder(OrderEntity order) {
        ArrayList<String> content = new ArrayList<>();
        content.add(order.getId());
        content.add(order.getMaterialId());
        content.add(String.valueOf(order.getNumber()));
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        content.add(format.format(order.getDdl()));
        try{
            String excelFilePath = new EmptyClass().getClass().getClassLoader()
                    .getResource("./excel/order.xlsx").toURI().getPath();
            int result = ExcelWriteUtil.writeExcel(new File(excelFilePath), content);
            return result;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static void initTblOrder() throws URISyntaxException {
        Database.tbl_order = new HashMap<>();
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
                Database.tbl_order.put(tempOrder.getId(), tempOrder);
            }
        }
    }
}
