package com.example.demo.mybatis.po;

import java.util.Date;
import java.util.List;

public class FemaleFormEmployee extends Employee {
    private FeMaleHealthForm feMaleHealthForm=null;

    public FeMaleHealthForm getFeMaleHealthForm() {
        return feMaleHealthForm;
    }

    public void setFeMaleHealthForm(FeMaleHealthForm feMaleHealthForm) {
        this.feMaleHealthForm = feMaleHealthForm;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public String getRealName() {
        return super.getRealName();
    }

    @Override
    public void setRealName(String realName) {
        super.setRealName(realName);
    }

    @Override
    public SexEnum getSex() {
        return super.getSex();
    }

    @Override
    public void setSex(SexEnum sex) {
        super.setSex(sex);
    }

    @Override
    public Date getBirthday() {
        return super.getBirthday();
    }

    @Override
    public void setBirthday(Date birthday) {
        super.setBirthday(birthday);
    }

    @Override
    public String getMobile() {
        return super.getMobile();
    }

    @Override
    public void setMobile(String mobile) {
        super.setMobile(mobile);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(String position) {
        super.setPosition(position);
    }

    @Override
    public String getNote() {
        return super.getNote();
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }

    @Override
    public WorkCard getWorkCard() {
        return super.getWorkCard();
    }

    @Override
    public void setWorkCard(WorkCard workCard) {
        super.setWorkCard(workCard);
    }

    @Override
    public List<EmployeeTask> getEmployeeTaskList() {
        return super.getEmployeeTaskList();
    }

    @Override
    public void setEmployeeTaskList(List<EmployeeTask> employeeTaskList) {
        super.setEmployeeTaskList(employeeTaskList);
    }
}
