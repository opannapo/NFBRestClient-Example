package napodev.restclient.sample.view.main;

import android.os.Environment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;
import napodev.framework.bework.restclient.base.ExecuteCallback;
import napodev.restclient.sample.net.API;
import napodev.restclient.sample.net.req.GetTest;
import napodev.restclient.sample.net.req.PostAuthTest;
import napodev.restclient.sample.net.req.PostMultiPartTest;
import napodev.restclient.sample.net.req.PostRawTest;
import napodev.restclient.sample.net.req.PostTest;
import okhttp3.Call;

/**
 * Created by opannapo on 7/31/17.
 */
public class MainWorker extends BaseActivityControl implements MainView.WorkerImpl {
    MainView.ViewImpl view;

    public MainWorker(BaseViewModel viewModel) {
        super(viewModel);
        this.view = (MainView.ViewImpl) viewModel.getViewImpl();
    }

    @Override
    public void requestPost() {
        PostTest post = new PostTest();
        post.setParam1("this is param1");
        post.setParam2("this is param2");
        new API().preparePost(post.build()).execute(new ExecuteCallback() {
            @Override
            public void onResponse(String url, Call call, Object o) {
                view.onApiRequestSuccess("POST", url, String.valueOf(o));
            }

            @Override
            public void onFailure(String url, Call call, Object e) {
                view.onApiRequestError("POST", url, String.valueOf(e));
            }
        });
    }

    @Override
    public void requestPostMultipart() {
        String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        String fileName = "image.png";
        File imageFile = new File(baseDir + File.separator + "testFolder" + File.separator + fileName);

        PostMultiPartTest post = new PostMultiPartTest();
        post.setParam1("this is param1");
        post.setParam2("this is param2");
        post.setImage(imageFile.getAbsolutePath());
        new API().preparePost(post.build()).execute(new ExecuteCallback() {
            @Override
            public void onResponse(String url, Call call, Object o) {
                view.onApiRequestSuccess("POST", url, String.valueOf(o));
            }

            @Override
            public void onFailure(String url, Call call, Object e) {
                view.onApiRequestError("POST", url, String.valueOf(e));
            }
        });
    }

    @Override
    public void requestPostRaw() {
        JSONObject data = new JSONObject();
        try {
            data.put("param1", "this is param1");
            data.put("param2", "this is param2");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PostRawTest raw = new PostRawTest();
        raw.setData(data.toString());
        new API().preparePost(raw.build()).execute(new ExecuteCallback() {
            @Override
            public void onResponse(String url, Call call, Object o) {
                view.onApiRequestSuccess("POST RAW", url, String.valueOf(o));
            }

            @Override
            public void onFailure(String url, Call call, Object e) {
                view.onApiRequestError("POST RAW", url, String.valueOf(e));
            }
        });
    }

    @Override
    public void requestPostWithAuth() {
        String jwtExp = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJleHAiOjE1MDE1Nzc5ODIsImlkIjoiNzc4NDEwNzEyMTIyMzMwNCIsImlhdCI6MTUwMTQ5MTU4Mn0" +
                ".CdAbqfuHRNAgovKKoonE8Ac76YwUb1IXU_2CIkPys-c";
        String jwtLongerExp = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJleHAiOjE5MTE3MzQ3OTQsImlkIjoiNzc4NDEwNzEyMTIyMzMwNCIsImlhdCI6MTUwMTQ5MTU4Mn0" +
                ".vL_jxUFVYnVFFF7aWYx3KhNAUjLvRxEqMeZhevI9jsQ";
        PostAuthTest post = new PostAuthTest();
        post.setParam1("this is param1");
        post.setParam2("this is param2");
        new API().authorization("Bearer " + jwtLongerExp)
                .preparePost(post.build())
                .execute(new ExecuteCallback() {
                    @Override
                    public void onResponse(String url, Call call, Object o) {
                        view.onApiRequestSuccess("POST AUTH", url, String.valueOf(o));
                    }

                    @Override
                    public void onFailure(String url, Call call, Object e) {
                        view.onApiRequestError("POST AUTH", url, String.valueOf(e));
                    }
                });
    }

    @Override
    public void requestGetWithParam() {
        GetTest get = new GetTest();
        get.setParam1("this is param1");
        get.setParam2("this is param2");
        new API().prepareGet(get.build()).execute(new ExecuteCallback() {
            @Override
            public void onResponse(String url, Call call, Object o) {
                view.onApiRequestSuccess("GET", url, String.valueOf(o));
            }

            @Override
            public void onFailure(String url, Call call, Object e) {
                view.onApiRequestError("GET", url, String.valueOf(e));
            }
        });
    }

    @Override
    public void requestGetNoParam() {
        new API().prepareGet(API.UrlCollection.testGetNoParam).execute(new ExecuteCallback() {
            @Override
            public void onResponse(String url, Call call, Object o) {
                view.onApiRequestSuccess("GET", url, String.valueOf(o));
            }

            @Override
            public void onFailure(String url, Call call, Object e) {
                view.onApiRequestError("GET", url, String.valueOf(e));
            }
        });
    }

    @Override
    public void requestGetWithAuth() {
        String jwtExp = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJleHAiOjE1MDE1Nzc5ODIsImlkIjoiNzc4NDEwNzEyMTIyMzMwNCIsImlhdCI6MTUwMTQ5MTU4Mn0" +
                ".CdAbqfuHRNAgovKKoonE8Ac76YwUb1IXU_2CIkPys-c";
        String jwtLongerExp = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJleHAiOjE5MTE3MzQ3OTQsImlkIjoiNzc4NDEwNzEyMTIyMzMwNCIsImlhdCI6MTUwMTQ5MTU4Mn0" +
                ".vL_jxUFVYnVFFF7aWYx3KhNAUjLvRxEqMeZhevI9jsQ";
        new API().authorization("Bearer " + jwtLongerExp)
                .prepareGet(API.UrlCollection.testGetAuth)
                .execute(new ExecuteCallback() {
                    @Override
                    public void onResponse(String url, Call call, Object o) {
                        view.onApiRequestSuccess("GET", url, String.valueOf(o));
                    }

                    @Override
                    public void onFailure(String url, Call call, Object e) {
                        view.onApiRequestError("GET", url, String.valueOf(e));
                    }
                });
    }
}
