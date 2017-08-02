package napodev.restclient.sample.net.req;


import napodev.framework.bework.restclient.ano.GetParam;
import napodev.framework.bework.restclient.ano.Url;
import napodev.framework.bework.restclient.base.GET;
import napodev.restclient.sample.net.API;

/**
 * Created by opannapo on 5/14/17.
 */
//@Url("/test/get?")
@Url(API.UrlCollection.testGet)
public class GetTest extends GET {
    @GetParam
    private String param1;
    @GetParam
    private String param2;


    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }
}
