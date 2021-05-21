package com.example.mozpertest.sys.di.modules;

import com.example.mozpertest.data.datasources.web.api.WebService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;


@Module(includes = ContextModule.class)
public class NetworkModule {

    public static final int
            CONNECT_TIMEOUT = 300, //TODO JUST FOR DEBUG
            WRITE_TIMEOUT = 300,
            READ_TIMEOUT = 300;

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return loggingInterceptor;
    }

    @Provides
    @Singleton
    public OkHttpClient provideHttpBuilder(HttpLoggingInterceptor logging) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(logging);

        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://demo3535907.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }

    @Provides
    @Singleton
    public WebService provideWebService(Retrofit retrofit) {
        return retrofit.create(WebService.class);
    }
}