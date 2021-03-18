package org.ssvv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.ssvv.domain.Nota;
import org.ssvv.domain.Student;
import org.ssvv.domain.Tema;
import org.ssvv.repository.NotaXMLRepository;
import org.ssvv.repository.StudentXMLRepository;
import org.ssvv.repository.TemaXMLRepository;
import org.ssvv.service.Service;
import org.ssvv.validation.NotaValidator;
import org.ssvv.validation.StudentValidator;
import org.ssvv.validation.TemaValidator;
import org.ssvv.validation.Validator;

/**
 * Unit test for simple App.
 */
public class TFAppTest
{
    /**
     * Rigorous Test :-)
     */
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    @Test
    public void tc1_addStudent()
    {
        int result = service.saveStudent("3", "ana", "933");
        assertEquals( 1, result);
        service.deleteStudent("3");
    }

    @Test(expected = Exception.class)
    public void tc2_addStudent()
    {
        int result = service.saveStudent("x", "ana", "933");
        assertEquals( 0, result);
    }
    @Test
    public void tc3_addStudent()
    {
        int result = service.saveStudent("-1", "ana", "933");
        assertEquals( 0, result);
    }

    @Test
    public void tc4_addStudent()
    {
        int result = service.saveStudent("5", null, "933");
        assertEquals( 0, result);
        service.deleteStudent("5");
    }

    @Test
    public void tc5_addStudent()
    {
        int result = service.saveStudent("6", "ana", "933");
        assertEquals( 0, result);
        service.deleteStudent("6");
    }


    @Test
    public void tc6_addStudent()
    {
        int result = service.saveStudent("7", "ana", "933");
        assertEquals( 1, result);
        service.deleteStudent("7");
    }

    @Test
    public void tc7_addStudent()
    {
        int result = service.saveStudent("0", "ana", "933");
        assertEquals( 0, result);
    }
    @Test
    public void tc8_addStudent()
    {
        int result = service.saveStudent("-1", "ana", "933");
        assertEquals( 0, result);
    }

    @Test
    public void tc9_addStudent()
    {
        int result = service.saveStudent(Integer.toString(Integer.MAX_VALUE - 1), "ana", "933");
        assertEquals( 1, result);
        service.deleteStudent(Integer.toString(Integer.MAX_VALUE - 1));
    }

    @Test
    public void tc10_addStudent()
    {
        int result = service.saveStudent(Integer.toString(Integer.MAX_VALUE + 1), "ana", "933");
        assertEquals( 0, result);
    }


    @Test
    public void tc11_addStudent()
    {
        int result = service.saveStudent(Integer.toString(Integer.MAX_VALUE), "ana", "933");
        assertEquals( 1, result);
        service.deleteStudent(Integer.toString(Integer.MAX_VALUE));
    }


    @Test
    public void tc12_addStudent()
    {
        int result = service.saveStudent("8", "ana", "933");
        assertEquals( 1, result);
        service.deleteStudent("8");
    }

    @Test
    public void tc13_addStudent()
    {
        int result = service.saveStudent("9", "...", "933");
        assertEquals( 1, result);
        service.deleteStudent("9");
    }

    @Test
    public void tc14_addStudent()
    {
        int result = service.saveStudent("10", "", "933");
        assertEquals( 1, result);
        service.deleteStudent("10");
    }

    @Test
    public void tc15_addStudent()
    {
        int result = service.saveStudent("11", null, "933");
        assertEquals( 0, result);
    }

    @Test
    public void tc16_addStudent()
    {
        int result = service.saveStudent("12", "ana", "0");
        assertEquals( 0, result);
    }

    @Test
    public void tc17_addStudent()
    {
        int result = service.saveStudent("13", "ana", "-1");
        assertEquals( 0, result);
    }

    @Test
    public void tc18_addStudent()
    {
        int result = service.saveStudent("14", "ana", Integer.toString(Integer.MAX_VALUE - 1));
        assertEquals( 1, result);
        service.deleteStudent("14");
    }

    @Test
    public void tc19_addStudent()
    {
        int result = service.saveStudent("15", "ana", Integer.toString(Integer.MAX_VALUE + 1));
        assertEquals( 0, result);
    }

    @Test
    public void tc20_addStudent()
    {
        int result = service.saveStudent("16", "ana", Integer.toString(Integer.MAX_VALUE));
        assertEquals( 1, result);
        service.deleteStudent("16");
    }

    @Test
    public void tc21_addStudent()
    {
        int result = service.saveStudent("17", "ana", "1");
        assertEquals( 1, result);
        service.deleteStudent("17");
    }
}
