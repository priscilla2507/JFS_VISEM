package com.skillnext1;

public class Student {
    private int id;
    private String name;
    private int sem;
    private String department;

    public Student(int id, String name, int sem, String department) {
        this.id = id;
        this.name = name;
        this.sem = sem;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSem() {
        return sem;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Student [id=" + id +
               ", name=" + name +
               ", sem=" + sem +
               ", department=" + department + "]";
    }
}
