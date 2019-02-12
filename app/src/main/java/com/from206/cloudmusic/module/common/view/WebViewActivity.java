package com.from206.cloudmusic.module.common.view;

import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.BaseActivity;
import com.from206.cloudmusic.view.CommonHeaderView;

import butterknife.BindView;

/**
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class WebViewActivity extends BaseActivity {
    @BindView(R.id.head_view)
    CommonHeaderView headerView;
    @BindView(R.id.webview)
    WebView webView;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initViews() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        String url = getIntent().getStringExtra("url");
        Log.e("TAG", "initViews: "+url );
        webView.loadUrl(url);

    }
}
