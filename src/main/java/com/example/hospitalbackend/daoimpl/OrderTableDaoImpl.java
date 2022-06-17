package com.example.hospitalbackend.daoimpl;

import com.example.hospitalbackend.dao.OrderTableDao;
import com.example.hospitalbackend.entity.OrderTable;
import com.example.hospitalbackend.entity.ShiftSchedule;
import com.example.hospitalbackend.repository.OrderTableRespository;
import com.example.hospitalbackend.repository.ShiftScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public OrderTable addNewOrder(int DoctorId, int PatientId, int rsvTime, int ScheduleId) {   /*增加新预约单并返回*/
        ShiftSchedule shiftSchedule = new ShiftSchedule();
        shiftSchedule = shiftScheduleRepository.getById(ScheduleId);
        int oldCapacity;
        if (rsvTime == 1) {
            oldCapacity = shiftSchedule.getTime1();
        } else if (rsvTime == 2) {
            oldCapacity = shiftSchedule.getTime2();
        } else if (rsvTime == 3) {
            oldCapacity = shiftSchedule.getTime3();
        } else oldCapacity = shiftSchedule.getTime4();

        OrderTable newOrder = new OrderTable();
        if (oldCapacity > 0) {
            Date date = shiftSchedule.getDate();
            newOrder.setDoctor_id(DoctorId);
            newOrder.setUser_id(PatientId);
            newOrder.setDate(date);
            newOrder.setTime(rsvTime);
            newOrder.setProcess(1);
            newOrder.setState(1);
            /*process默认为1*/
            /*更新容量*/
            oldCapacity--;
            if (rsvTime == 1) {
                shiftSchedule.setTime1(oldCapacity);
            } else if (rsvTime == 2) {
                shiftSchedule.setTime1(oldCapacity);
            } else if (rsvTime == 3) {
                shiftSchedule.setTime1(oldCapacity);
            } else shiftSchedule.setTime1(oldCapacity);
        }
        else {
            /*前端返回为空则说明容量不足*/
            return null;
        }
        shiftScheduleRepository.save(shiftSchedule);
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
