package com.allenliu.versionchecklib.v2;

import android.content.Context;
import android.content.Intent;

import com.allenliu.versionchecklib.core.http.AllenHttp;
import com.allenliu.versionchecklib.v2.builder.DownloadBuilder;
import com.allenliu.versionchecklib.v2.builder.RequestVersionBuilder;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.ui.VersionService;

import androidx.annotation.Nullable;

/**
 * Created by allenliu on 2018/1/12.
 */

public class AllenVersionChecker {

//    public AllenVersionChecker() {
//        throw new RuntimeException("AllenVersionChecker can not be instantiated from outside");
//    }
    private AllenVersionChecker(){

    }

    public static AllenVersionChecker getInstance() {
        return AllenVersionCheckerHolder.allenVersionChecker;
    }

    private static class AllenVersionCheckerHolder {
        public static final AllenVersionChecker allenVersionChecker = new AllenVersionChecker();
    }

    public void cancelAllMission(Context context) {
        if(VersionService.builder != null && VersionService.builder.getForceUpdateListener() != null){
            return;
        }
        AllenHttp.getHttpClient().dispatcher().cancelAll();
        Intent intent = new Intent(context, VersionService.class);
        VersionService.builder=null;
        context.getApplicationContext().stopService(intent);
    }

    /**
     * @param versionBundle developer should return version bundle ,to use when showing UI page,could be null
     * @return download builder for download setting
     */
    public DownloadBuilder downloadOnly(@Nullable UIData versionBundle) {
        return new DownloadBuilder(null, versionBundle);
    }

    /**
     * use request version function
     * @return requestVersionBuilder
     */
    public RequestVersionBuilder requestVersion() {
        return new RequestVersionBuilder();
    }

}
