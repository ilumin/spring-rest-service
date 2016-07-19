package com.ilumin.rest.util;

import com.ilumin.rest.exception.ResourceNotFoundException;

public final class RestPreconditions {

    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }


}
