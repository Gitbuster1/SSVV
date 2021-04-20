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

public class TFLab4 {
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    @Test
    public void tc1_addIIStudent()
    {
        int result = service.saveStudent("33", "ana", "933");
        assertEquals( 1, result);
        service.deleteStudent("33");
    }

    @Test
    public void tc2_addIIStudentAssignment()
    {
        int result = service.saveStudent("34", "ana", "933");
        assertEquals( 1, result);
        result = service.saveTema("112", "test", 2, 1);
        assertEquals( 1, result);
        service.deleteTema("112");
        service.deleteStudent("34");
    }

    @Test
    public void tc3_addIIAll()
    {
        int result = service.saveStudent("40", "ana", "933");
        assertEquals( 1, result);
        result = service.saveTema("111", "test", 2, 1);
        assertEquals( 1, result);
        int grade = service.saveNota("40", "111", 2, 1, "feedback");
        assertEquals( 1, grade);
        service.deleteStudent("40");
        service.deleteTema("111");

    }
}
