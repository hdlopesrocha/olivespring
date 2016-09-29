package com.rochaware.service;

import com.rochaware.exception.ForbiddenException;
import com.rochaware.exception.ServiceException;

import java.util.Random;

public abstract class Service<T> {



    /**
     * Execute.
     *
     * @return the t
     * @throws ServiceException
     *             the service exception
     */
    public T execute() throws ServiceException {
        if (canExecute()) {
            return dispatch();
        } else {
            throw new ForbiddenException();
        }
    }

    /**
     * Dispatch.
     *
     * @return the t
     * @throws ServiceException the service exception
     */
    public abstract T dispatch() throws ServiceException;

    /**
     * Can execute.
     *
     * @return true, if successful
     */
    public abstract boolean canExecute();
}