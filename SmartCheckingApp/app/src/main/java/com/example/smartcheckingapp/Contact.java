package com.example.smartcheckingapp;


public class Contact {

    private String name;
    private String Enter_type;
    private String state;
    private String Value_motif;
    private String id;
    private String Text_Hours_In;
    private String Text_Hours_Out;
    private int pp ;

    public Contact(String name, String enter_type, String state, String value_motif, String id, String text_Hours_In, String text_Hours_Out, int pp) {
        this.name = name;
        Enter_type = enter_type;
        this.state = state;
        Value_motif = value_motif;
        this.id = id;
        Text_Hours_In = text_Hours_In;
        Text_Hours_Out = text_Hours_Out;
        this.pp = pp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnter_type() {
        return Enter_type;
    }

    public void setEnter_type(String enter_type) {
        Enter_type = enter_type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getValue_motif() {
        return Value_motif;
    }

    public void setValue_motif(String value_motif) {
        Value_motif = value_motif;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText_Hours_In() {
        return Text_Hours_In;
    }

    public void setText_Hours_In(String text_Hours_In) {
        Text_Hours_In = text_Hours_In;
    }

    public String getText_Hours_Out() {
        return Text_Hours_Out;
    }

    public void setText_Hours_Out(String text_Hours_Out) {
        Text_Hours_Out = text_Hours_Out;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}