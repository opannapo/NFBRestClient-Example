package napodev.restclient.sample.net.req;


import napodev.framework.bework.restclient.ano.BodyType;
import napodev.framework.bework.restclient.ano.PostRawData;
import napodev.framework.bework.restclient.ano.Url;
import napodev.framework.bework.restclient.base.POST;
import napodev.restclient.sample.net.API;

/**
 * Created by opannapo on 5/14/17.
 */
@Url(API.UrlCollection.testPostRaw)
@BodyType(BodyType.POST_RAW)
public class PostRawTest extends POST {
    @PostRawData(POST.TYPE_JSON)
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
