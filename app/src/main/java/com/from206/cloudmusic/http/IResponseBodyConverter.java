package com.from206.cloudmusic.http;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created on 2017/7/30.
 */
public class IResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    IResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }
    //

    @Override
    public T convert(ResponseBody value) throws IOException {
        String string = value.string();
        Logger.json(string);
        return adapter.fromJson(string);
    }
}
