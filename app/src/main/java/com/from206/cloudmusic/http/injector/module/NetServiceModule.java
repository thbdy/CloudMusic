package com.from206.cloudmusic.http.injector.module;


import com.from206.cloudmusic.http.IConverJsonFactory;
import com.from206.cloudmusic.http.NetService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

@Module
public class NetServiceModule {
    private static final String TAG = "TAG";

    @Singleton
    @Provides
    HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder, HttpLoggingInterceptor loggingInterceptor) {
        //设置超时
        builder.connectTimeout(60, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        builder.writeTimeout(60, TimeUnit.SECONDS);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }


    protected Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(IConverJsonFactory.create())
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideNetRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, NetService.BASE_URL);
    }

    @Singleton
    @Provides
    NetService provideNetService(Retrofit retrofit) {
        return retrofit.create(NetService.class);
    }

}
