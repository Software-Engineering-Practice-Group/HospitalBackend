package com.example.hospitalbackend.daoimpl;

import com.example.hospitalbackend.dao.OrderTableDao;
import com.example.hospitalbackend.entity.OrderTable;
import com.example.hospitalbackend.entity.ShiftSchedule;
import com.example.hospitalbackend.repository.OrderTableRespository;
import com.example.hospitalbackend.repository.ShiftScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class OrderTableDaoImpl implements OrderTableDao {
    @Autowired
    private OrderTableRespository orderTableRespository;

    @Autowired
    private ShiftScheduleRepository shiftScheduleRepository;

    /*
     *
     * @Description: 增加订单功能
     * @param DoctorId
     * @param PatientId
     * @param rsvTime
     * @param ScheduleId
     * @param info
     * @return com.example.hospitalbackend.entity.OrderTable
     * @author 赵熙
     * @date 2022/6/01 8:25
     */
    @Transactional(isolation= Isolation.REPEATABLE_READ)
    @Override
    public OrderTable addNewOrder(int DoctorId, int PatientId, int rsvTime, int ScheduleId, String info) {   /*增加新预约单并返回*/
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
        Date date = shiftSchedule.getDate();

        if (isExist(PatientId, date)) {
            return null;
        }
        OrderTable newOrder = new OrderTable();
        /*再次检查容量*/
        if (oldCapacity > 0) {
            newOrder.setDoctor_id(DoctorId);
            newOrder.setUser_id(PatientId);
            newOrder.setDate(date);
            newOrder.setTime(rsvTime);
            newOrder.setProcess(1);
            newOrder.setInfo(info);
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
            /*前端返回为空则说明容量不足，预约失败*/
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

    /*
     *
     * @Description: 判断当前患者是否已经在当天有预约
     * @param userId
     * @param date
     * @return boolean
     * @author 赵熙
     * @date 2022/6/18 1:37
     */
    public boolean isExist(Integer userId, Date date) {
        List<OrderTable> orderTables = getOrderByUser(userId);
        for (OrderTable orderTable : orderTables) {
            if (orderTable.getDate() == date) return true;
        }
        return false;
    }
}
