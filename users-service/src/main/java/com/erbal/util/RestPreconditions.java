package com.erbal.util;

import com.erbal.exception.ResourceNotFoundException;

public class RestPreconditions {
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }
}