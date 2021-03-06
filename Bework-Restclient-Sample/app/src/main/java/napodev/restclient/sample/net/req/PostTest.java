package napodev.restclient.sample.net.req;


import napodev.framework.bework.restclient.ano.BodyType;
import napodev.framework.bework.restclient.ano.PostParam;
import napodev.framework.bework.restclient.ano.Url;
import napodev.framework.bework.restclient.base.POST;
import napodev.restclient.sample.net.API;

/**
 * Created by opannapo on 5/14/17.
 */
@Url(API.UrlCollection.testPost)
@BodyType(BodyType.POST_DEFAULT)
public class PostTest extends POST {
    @PostParam(POST.TYPE_TEXT)
    private String param1;
    @PostParam(POST.TYPE_TEXT)
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
