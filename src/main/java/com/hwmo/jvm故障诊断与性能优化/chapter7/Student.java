package com.hwmo.jvm故障诊断与性能优化.chapter7;

import java.util.List;
import java.util.Vector;

public class Student {
    private int id;
    private String name;
    private List<WebPage> history = new Vector<WebPage>();
    public Student(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public void visit(WebPage webPage){
        history.add(webPage);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WebPage> getHistory() {
        return history;
    }

    public void setHistory(List<WebPage> history) {
        this.history = history;
    }
}
