package napodev.restclient.sample.view.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.view.BaseActivity;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;
import napodev.framework.bework.utils.helper.PermissionHellper;

/**
 * Created by opannapo on 7/31/17.
 */
public class MainActivity extends BaseActivity implements MainView.ViewImpl {
    MainView view;
    MainWorker worker;

    boolean isOnProgress;

    @Override
    public BaseViewModel getViewModel() {
        return view;
    }

    @Override
    public BaseActivityControl getWorker() {
        return worker;
    }

    @Override
    public void onActivityCreate(Bundle bundle) {
        view = new MainView(this, this, worker);
        worker = new MainWorker(view);

        view.btnPostDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnProgress) return;
                isOnProgress = true;
                view.pPostDefault.setVisibility(View.VISIBLE);
                worker.requestPost();
            }
        });
        view.btnPostMultiPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnProgress) return;

                //CHECK PERMISSION READ EXTERNAL STORAGE
                PermissionHellper.check(thisActivity(), PermissionHellper.PERMISSION.READ_EXTERNAL_STORAGE, new PermissionHellper.Callback() {
                    @Override
                    public void onResult(boolean b) {
                        if (b) {
                            isOnProgress = true;
                            view.pPostMultiPart.setVisibility(View.VISIBLE);
                            worker.requestPostMultipart();
                        } else {
                            //REQUEST PERMISSION READ EXTERNAL STORAGE
                            PermissionHellper.request(thisActivity(), PermissionHellper.PERMISSION.READ_EXTERNAL_STORAGE);
                        }
                    }
                });

            }
        });
        view.btnPostRaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnProgress) return;
                isOnProgress = true;
                view.pPostRaw.setVisibility(View.VISIBLE);
                worker.requestPostRaw();
            }
        });
        view.btnPostAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnProgress) return;
                isOnProgress = true;
                view.pPostAuth.setVisibility(View.VISIBLE);
                worker.requestPostWithAuth();
            }
        });
        view.btnGetParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnProgress) return;
                view.pGetParam.setVisibility(View.VISIBLE);
                isOnProgress = true;
                worker.requestGetWithParam();
            }
        });
        view.btnGetNoParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnProgress) return;
                isOnProgress = true;
                view.pGetNoParam.setVisibility(View.VISIBLE);
                worker.requestGetNoParam();
            }
        });
        view.btnGetAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnProgress) return;
                isOnProgress = true;
                view.pGetAuth.setVisibility(View.VISIBLE);
                worker.requestGetWithAuth();
            }
        });

        new Handler().postDelayed(hiddenProgressbar, 1000);
    }

    @Override
    public void onApiRequestSuccess(String type, final String url, final String res) {
        //This method execute by API Callback, update UI must on UI Thread.
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(hiddenProgressbar, 500);
                Toast.makeText(thisActivity(), "Sucess " + url + "\n" + res, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onApiRequestError(String type, final String url, final String e) {
        //This method execute by API Callback, update UI must on UI Thread.
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(hiddenProgressbar, 500);
                Toast.makeText(thisActivity(), "Error " + url + "\n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onBack() {
        super.onBack();
        finishWithAnim(ANIM_TYPE.LEFT_TO_RIGHT);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PermissionHellper.PERMISSION.READ_EXTERNAL_STORAGE.getCode()) {
            Toast.makeText(thisActivity(), "Permission READ_EXTERNAL_STORAGE " + grantResults, Toast.LENGTH_SHORT).show();
        }
    }

    Runnable hiddenProgressbar = new Runnable() {
        @Override
        public void run() {
            isOnProgress = false;
            view.pPostDefault.setVisibility(View.INVISIBLE);
            view.pPostMultiPart.setVisibility(View.INVISIBLE);
            view.pPostRaw.setVisibility(View.INVISIBLE);
            view.pPostAuth.setVisibility(View.INVISIBLE);
            view.pGetParam.setVisibility(View.INVISIBLE);
            view.pGetNoParam.setVisibility(View.INVISIBLE);
            view.pGetAuth.setVisibility(View.INVISIBLE);
        }
    };
}
