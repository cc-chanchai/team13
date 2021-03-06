package com.okta.developer.demo.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@ToString
@EqualsAndHashCode
public class Studytimetable {
 @Id
 @SequenceGenerator(name="No_STT",sequenceName="No_STT")
 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="No_STT")
 @Column(name = "No")
 private @NonNull Long idStudytimetable;

 @NotNull
// @Pattern(regexp = "[a-zA-Z]+")
 @Size(min = 5)
 @Size(max = 20)
 @Column(unique = true)
  private String timedate;


 @NotNull
 //@Pattern(regexp = "[a-zA-Z]+")
 @Size(min = 5)
 @Size(max = 20)
 //@Column(unique = true)
  private String day;


 public Long getIdStudytimetable() {
  return idStudytimetable;
 }

 public void setIdStudytimetable(Long idStudytimetable) {
  this.idStudytimetable = idStudytimetable;
 }

 public String getTimedate() {
  return timedate;
 }

 public void setTimedate(String timedate) {
  this.timedate = timedate;
 }

 public String getDay() {
  return day;
 }

 public void setDay(String day) {
  this.day = day;
 }

 public Major getMajor() {
  return major;
 }

 public void setMajor(Major major) {
  this.major = major;
 }

 public Room getRooms() {
  return rooms;
 }

 public void setRooms(Room rooms) {
  this.rooms = rooms;
 }

 public Personnel getTeachers() {
  return teachers;
 }

 public void setTeachers(Personnel teachers) {
  this.teachers = teachers;
 }
public Studytimetable(){}

 @ManyToOne private Major major;
 @ManyToOne private Room rooms;
 @ManyToOne private Personnel teachers;
public Studytimetable(String timedate, String day, Major major, Room room, Personnel personnel){
 this.timedate = timedate;
 this.day = day;
 this.major = major;
 this.rooms = room;
 this.teachers = personnel;}

}