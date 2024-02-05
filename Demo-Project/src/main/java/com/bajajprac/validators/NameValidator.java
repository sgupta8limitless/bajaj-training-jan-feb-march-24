package com.bajajprac.validators;

import com.bajajprac.validators.TextValidator;

public class NameValidator implements TextValidator {

    @Override
    public boolean validate(String name) {

        if(name!=null && name!="")
        {
            return true;
        }

        return false;

    }
}
