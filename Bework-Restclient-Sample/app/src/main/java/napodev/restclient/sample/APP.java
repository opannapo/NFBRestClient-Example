package napodev.restclient.sample;

import napodev.framework.bework.BaseApp;

/**
 * Created by opannapo on 7/31/17.
 */
public class APP extends BaseApp {

    public APP() {
        super("MainActivity");
    }

    @Override
    protected String configPreferenceName() {
        return null;
    }

    @Override
    protected String configPreferenceEncryptKey() {
        return null;
    }

    @Override
    protected boolean configLogEnable() {
        return true;
    }

    @Override
    protected boolean configLogDetailLine() {
        return true;
    }

    @Override
    protected boolean configLogCaller() {
        return true;
    }

    @Override
    protected String configLogTag() {
        return "BeworkClient";
    }
}
