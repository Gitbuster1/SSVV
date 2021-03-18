package org.ssvv.repository;

import org.ssvv.domain.Student;
import org.ssvv.validation.*;

public class StudentRepository extends AbstractCRUDRepository<String, Student> {
    public StudentRepository(Validator<Student> validator) {
        super(validator);
    }
}

