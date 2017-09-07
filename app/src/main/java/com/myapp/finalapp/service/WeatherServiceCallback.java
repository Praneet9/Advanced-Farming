package com.myapp.finalapp.service;

import com.myapp.finalapp.data.Channel;

/**
 * Created by Bhumit on 28-01-2017.
 */

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
