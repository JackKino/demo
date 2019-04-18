package com.example.demo.mybatis.po;

public class FeMaleHealthForm extends HealthForm {
    private String uterus;
    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public Long getEmpId() {
        return super.getEmpId();
    }

    @Override
    public void setEmpId(Long empId) {
        super.setEmpId(empId);
    }

    @Override
    public String getHeart() {
        return super.getHeart();
    }

    @Override
    public void setHeart(String heart) {
        super.setHeart(heart);
    }

    @Override
    public String getLiver() {
        return super.getLiver();
    }

    @Override
    public void setLiver(String liver) {
        super.setLiver(liver);
    }

    @Override
    public String getSpleen() {
        return super.getSpleen();
    }

    @Override
    public void setSpleen(String spleen) {
        super.setSpleen(spleen);
    }

    @Override
    public String getLung() {
        return super.getLung();
    }

    @Override
    public void setLung(String lung) {
        super.setLung(lung);
    }

    @Override
    public String getKidney() {
        return super.getKidney();
    }

    @Override
    public void setKidney(String kidney) {
        super.setKidney(kidney);
    }

    @Override
    public String getNote() {
        return super.getNote();
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }

    public String getUterus() {
        return uterus;
    }

    public void setUterus(String uterus) {
        this.uterus = uterus;
    }
}
