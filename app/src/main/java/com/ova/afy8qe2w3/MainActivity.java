package com.ova.afy8qe2w3;
import android.app.Activity;import android.app.AlertDialog;import android.os.Bundle;import android.os.Message;import android.content.Intent;import android.webkit.*;
public class MainActivity extends Activity{
WebView w;
void open(android.net.Uri u){try{startActivity(new Intent(Intent.ACTION_VIEW,u));}catch(Exception e){}}
@Override protected void onCreate(Bundle b){super.onCreate(b);w=new WebView(this);setContentView(w);WebSettings s=w.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);s.setMediaPlaybackRequiresUserGesture(false);s.setSupportMultipleWindows(true);s.setJavaScriptCanOpenWindowsAutomatically(true);
w.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView v,WebResourceRequest r){if("file".equals(r.getUrl().getScheme()))return false;open(r.getUrl());return true;}});
w.setWebChromeClient(new WebChromeClient(){
@Override public boolean onJsAlert(WebView v,String u,String m,final JsResult r){new AlertDialog.Builder(MainActivity.this).setMessage(m).setPositiveButton("OK",(d,i)->r.confirm()).setOnCancelListener(d->r.cancel()).show();return true;}
@Override public boolean onCreateWindow(WebView v,boolean d,boolean g,Message m){WebView t=new WebView(MainActivity.this);t.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView x,WebResourceRequest r){open(r.getUrl());return true;}});((WebView.WebViewTransport)m.obj).setWebView(t);m.sendToTarget();return true;}});
w.loadUrl("file:///android_asset/www/index.html");}
@Override public void onBackPressed(){w.evaluateJavascript("window.ovaBack&&window.ovaBack()",new ValueCallback<String>(){public void onReceiveValue(String v){if(!"true".equals(v))finish();}});}
}
