package napodev.restclient.sample.net;

import java.util.concurrent.TimeUnit;

import napodev.framework.bework.restclient.Api;
import napodev.framework.bework.restclient.utils.TimeoutAttr;

/**
 * Created by opannapo on 7/31/17.
 */
public class API extends Api {
    @Override
    public String getBaseUrl() {
        return "http://192.168.0.100:8819";
    }

    @Override
    public TimeoutAttr getConnectTimeout() {
        return new TimeoutAttr(10, TimeUnit.SECONDS);
    }

    @Override
    public TimeoutAttr getWriteTimeout() {
        return new TimeoutAttr(10, TimeUnit.SECONDS);
    }

    @Override
    public TimeoutAttr getReadTimeout() {
        return new TimeoutAttr(30, TimeUnit.SECONDS);
    }


    @Override
    public boolean isLogEnable() {
        return true;
    }


    public static final class UrlCollection {
        public static final String testGet = "/test/get?";
        public static final String testGetNoParam = "/test/get-no-param";
        public static final String testGetAuth = "/test/get-auth";
        public static final String testPostAuth = "/test/post-auth";
        public static final String testPostMultipart = "/test/post-multipart";
        public static final String testPostRaw = "/test/post-raw";
        public static final String testPost = "/test/post";

    }


}
