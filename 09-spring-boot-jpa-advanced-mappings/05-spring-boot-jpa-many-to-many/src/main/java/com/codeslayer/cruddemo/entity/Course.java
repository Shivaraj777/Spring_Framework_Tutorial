package com.codeslayer.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    // @manyToOne annotation -> create many-to-one relationship between course and instructor entity
    // @JoinColumn annotation -> used to denote a foreign key column -> instructor_id references the primary key of instructor entity
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // create a one-to-many mapping between Course and Review entity
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    // create a many-to-many relationship between Course and Student entity
    // @JoinTable annotation is used to find the relationship between course and students by using below commented details
    // joinColumns attribute tells hibernate to check course_id to column in current entity of relationship to find the courses
    // inverseJoinColumns attribute tells hibernate to check student_id in inverse/other entity of relationship to find the students
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public Course() { }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }


    // method to add reviews to course
    public void addReview(Review theReview){
        if(reviews == null){
            reviews = new ArrayList<>();
        }

        reviews.add(theReview);
    }


    // method to add a student to a course
    public void addStudent(Student theStudent){
        if(students == null){
            students = new ArrayList<>();
        }

        students.add(theStudent);
    }
}
