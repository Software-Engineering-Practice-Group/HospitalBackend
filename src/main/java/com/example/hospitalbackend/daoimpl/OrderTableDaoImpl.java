package com.example.hospitalbackend.daoimpl;

import com.example.hospitalbackend.dao.OrderTableDao;
import com.example.hospitalbackend.entity.OrderTable;
import com.example.hospitalbackend.entity.ShiftSchedule;
import com.example.hospitalbackend.repository.OrderTableRespository;
import com.example.hospitalbackend.repository.ShiftScheduleRepository;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Order;
import java.util.List;

@Repository
public class OrderTableDaoImpl implements OrderTableDao {
    @Autowired
    private OrderTableRespository orderTableRespository;

    @Autowired
    private ShiftScheduleRepository shiftScheduleRepository;

    /**
     * @Description: addNewOrder
     * @Param: DoctorId, PatientId, orderNum, ScheduleId
     * @return: OrderTable
     * @Author: 赵熙
     */
    @Transactional
    @Override
    public OrderTable addNewOrder(int DoctorId,int PatientId, int orderNum,int ScheduleId)
    {   /*增加新预约单并返回*/
        ShiftSchedule shiftSchedule=shiftScheduleRepository.getById(ScheduleId);
        int oldCapacity=shiftSchedule.getTime1()+shiftSchedule.getTime2()
                +shiftSchedule.getTime3()+shiftSchedule.getTime4();
        OrderTable newOrder=new OrderTable();

        if(oldCapacity>0){
            newOrder.setDoctor_id(DoctorId);
            newOrder.setUser_id(PatientId);
//            newOrder.setDate(orderNum);
            newOrder.setProcess(1);
            /*process默认为1*/
            oldCapacity--;
        }
        else {
            /*前端返回为空则说明容量不足*/
            return null;
        }
//        ShiftSchedule schedule=new ShiftSchedule();
//        schedule.setId(ScheduleId);
//        schedule.setDoctor_capacity(oldCapacity);
//        shiftScheduleRepository.save(schedule);
        orderTableRespository.save(newOrder);

        return newOrder;
    }

    /**
     * @Description: getOrderByUser
     * @Param: <int>userId
     * @return: List<orderTable>
     * @Author: Kiddo
     */
    @Override
    public List<OrderTable> getOrderByUser(Integer userId) {
        List<OrderTable> orders = orderTableRespository.getOrderByUser(userId);
        System.out.println(orders);
        return orders;
    }
}
