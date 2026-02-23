package com.skillnext1;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int sem;
    private String department;

    public Student() {}

    public Student(String name,int sem, String department) {
       
        this.name = name;
        this.sem = sem;
        this.department = department;
    }

    // getters & setters
    public int getId() { return id; }
  

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getSem() { return sem; }
    public void setSem(int sem) { this.sem = sem; }

    public String getdepartment() { return department; }
    public void setdepartment(String department) { this.department = department; }
}
