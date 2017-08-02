package napodev.restclient.sample.view.main;

import android.widget.Button;
import android.widget.ProgressBar;

import napodev.framework.bework.corebase.model.view.BaseViewImpl;
import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.model.view.BaseWorkerImpl;
import napodev.framework.bework.corebase.view.BaseActivity;
import napodev.framework.bework.utils.napoinject.Child;
import napodev.framework.bework.utils.napoinject.FontBold;
import napodev.framework.bework.utils.napoinject.FontDefault;
import napodev.framework.bework.utils.napoinject.FontItalic;
import napodev.framework.bework.utils.napoinject.Root;
import napodev.restclient.sample.R;

/**
 * Created by opannapo on 7/31/17.
 */
@Root(R.layout.activity_main)
@FontDefault("Raleway-Regular.ttf")
@FontItalic("Infinity.ttf")
@FontBold("Raleway-Bold.ttf")
public class MainView extends BaseViewModel {
    @Child(R.id.btnPostDefault)
    Button btnPostDefault;
    @Child(R.id.btnPostMultiPart)
    Button btnPostMultiPart;
    @Child(R.id.btnPostRaw)
    Button btnPostRaw;
    @Child(R.id.btnPostAuth)
    Button btnPostAuth;
    @Child(R.id.btnGetParam)
    Button btnGetParam;
    @Child(R.id.btnGetNoParam)
    Button btnGetNoParam;
    @Child(R.id.btnGetAuth)
    Button btnGetAuth;
    @Child(R.id.pPostDefault)
    ProgressBar pPostDefault;
    @Child(R.id.pPostMultiPart)
    ProgressBar pPostMultiPart;
    @Child(R.id.pPostRaw)
    ProgressBar pPostRaw;
    @Child(R.id.pPostAuth)
    ProgressBar pPostAuth;
    @Child(R.id.pGetParam)
    ProgressBar pGetParam;
    @Child(R.id.pGetNoParam)
    ProgressBar pGetNoParam;
    @Child(R.id.pGetAuth)
    ProgressBar pGetAuth;

    public MainView(BaseActivity activity, BaseViewImpl viewImpl, BaseWorkerImpl workerImpl) {
        super(activity, viewImpl, workerImpl);
    }

    public interface ViewImpl extends BaseViewImpl {
        void onApiRequestSuccess(String type, String url, String res);

        void onApiRequestError(String type, String url, String e);
    }

    public interface WorkerImpl extends BaseWorkerImpl {
        void requestPost();

        void requestPostMultipart();

        void requestPostRaw();

        void requestPostWithAuth();

        void requestGetWithParam();

        void requestGetNoParam();

        void requestGetWithAuth();
    }
}
