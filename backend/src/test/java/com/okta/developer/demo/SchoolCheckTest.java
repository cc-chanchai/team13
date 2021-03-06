package com.okta.developer.demo;

import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;



@RunWith(SpringRunner.class)
@DataJpaTest
public class SchoolCheckTest {


    @Autowired private ClassroomsRepository classroomsRepository;
    @Autowired private ParentsRepository parentsRepository;
    @Autowired private SchoolCheckRepository schoolCheckRepository;
    @Autowired private StatusRepository statusRepository;
    @Autowired private StudentReporitory studentReporitory;
    @Autowired private GradeReporitory gradeReporitory;
    @Autowired private GpaRepository gpaRepository;
    @Autowired private MajorReporitory majorReporitory;
    @Autowired private ProfessorReporitory professorReporitory;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    //=====================================================================================================================================================================
    //======================--------------------------------------Test Case Sprint#2 Mr.Jirasak Kankrasang B5902644----------------------------------======================
    //=====================================================================================================================================================================
    @Test
    public void testSchoolCheckAllMatch() {
        SchoolCheck sck = new SchoolCheck();
        sck.setParrents("Jirasakk");
        try {
            entityManager.persist(sck);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test School Chec Parent Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testSchoolCheckNull() {
        SchoolCheck sck = new SchoolCheck();
        sck.setParrents(null);
        try {
            entityManager.persist(sck);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test School Check Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }
    @Test
    public void testSchoolCheckOversize(){
        SchoolCheck sck = new SchoolCheck();
        sck.setParrents("Pattaraphonnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnddgdrfsdfsefvsdgssesfesscsefscxdfsfzsdzsfzcdn");
        try {
            entityManager.persist(sck);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test School Check Parent Over Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testSchoolCheckMinsize(){

        SchoolCheck sck = new SchoolCheck();
        sck.setParrents("Pa");
        try {
            entityManager.persist(sck);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test School Check Parent Min Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testSchoolCheckNotPatternMatch(){

        SchoolCheck sck = new SchoolCheck();
        sck.setParrents("&(_#####??&&%$");
        try {
            entityManager.persist(sck);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test School Check Not Pattern Match<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }




    @Test(expected = javax.persistence.PersistenceException.class)
    public void testNameSchoolcheckBeUnique(){
        SchoolCheck st = new SchoolCheck();
        st.setParrents("JiraKan");
        entityManager.persist(st);
        entityManager.flush();

        SchoolCheck st1 = new SchoolCheck();
        st1.setParrents("JiraKan");
        entityManager.persist(st1);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------->> Test Name School Check BeUnique <<-------------------------");
        System.out.println();
        System.out.println();
        System.out.println();


        entityManager.flush();

      //  fail("Should not pass to this line");

    }
    //======================-------------------------------------- Test Case Classroom class entity ----------------------------------======================
    @Test
    public void testClassroomSchoolcheckMatch() {
        Classrooms cl = new Classrooms();
        cl.setClassroom("Anubarn3");
        try {
            entityManager.persist(cl);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Classroom Match <<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();


    }

    @Test
    public void testClassroomSchoolcheckNull() {
        Classrooms cl = new Classrooms();
        cl.setClassroom(null);
        try {
            entityManager.persist(cl);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Classroom School Check null <<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }


    }
    @Test(expected = javax.persistence.PersistenceException.class)
    public void testNameClassroomBeUnique(){
        Classrooms clr = new Classrooms();
        clr.setClassroom("Anubarn2");
        entityManager.persist(clr);
        entityManager.flush();

        Classrooms clr1 = new Classrooms();
        clr1.setClassroom("Anubarn2");
        entityManager.persist(clr1);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------->> Test Name Classroom BeUnique <<-------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

        entityManager.flush();
        fail("Should not pass to this line");

    }
    //======================-------------------------------------- Test Case Student class entity ----------------------------------======================
    @Test
    public void testSchoolcheckkStudentNameSuccessful() {
        Student sss = new Student();
        sss.setStudent_name("Sompong");

        try {
            entityManager.persist(sss);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {



            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test School Check Student Name Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testSchoolcheckkStudentNameNull() {
        Student sss = new Student();
        sss.setStudent_name(null);

        try {
            entityManager.persist(sss);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test School Check Student Name Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }


    }
    @Test(expected = javax.persistence.PersistenceException.class)
    public void testSchoolcheckStudentNameBeUnique(){
        Student sss = new Student();
        sss.setStudent_name("Phiyada");
        entityManager.persist(sss);
        entityManager.flush();

        Student st1 = new Student();
        st1.setStudent_name("Phiyada");;
        entityManager.persist(st1);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------->>Test School Check Student Name BeUnique<<-------------------------");
        System.out.println();
        System.out.println();
        System.out.println();


        entityManager.flush();

        fail("Should not pass to this line");

    }
    //======================-------------------------------------- Test Case Status class entity ----------------------------------======================
    @Test
    public void testSchoolcheckkStatusSuccessful() {
        Status sta = new Status();
        sta.setStstusname("Present");

        try {
            entityManager.persist(sta);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test School Check Status Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testSchoolcheckkStatusNameNull() {
        Status sta = new Status();
        sta.setStstusname(null);


        try {
            entityManager.persist(sta);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test School Check Status Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }


    }

    //======================-------------------------------------- Test Case Parents class entity ----------------------------------======================
    @Test
    public void testSchoolcheckkParentsSuccessful() {
        Parents ps = new Parents();
        ps.setName("Father");

        try {
            entityManager.persist(ps);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test School Check Parents Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testSchoolcheckkParentsNull() {
        Parents ps = new Parents();
        ps.setName(null);


        try {
            entityManager.persist(ps);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test School Check Parents Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }


    }


    //=========================================================================================================================================================================
    //=========================================================================================================================================================================
    //======================--------------------------------- End of Test Case Sprint#2 By. Mr.Jirasak Kankrasang B5902644 ------------------------------======================
    //=========================================================================================================================================================================
    //=========================================================================================================================================================================
}
