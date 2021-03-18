package org.ssvv.repository;

import org.ssvv.domain.Tema;
import org.ssvv.validation.*;

public class TemaRepository extends AbstractCRUDRepository<String, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }
}

