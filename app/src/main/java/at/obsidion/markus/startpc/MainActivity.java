package at.obsidion.markus.startpc;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCorrectMode();
        setWebViewUrl();
    }
    public void onCheckedChanged(View v) {
        setCorrectMode();
    }
    public void start1click(View v){
        loadWebView("start05.php");
    }
    public void start10click(View v){
        loadWebView("start10.php");
    }
    public void loadWebView(String phpdoc){
        WebView web1 = (WebView) findViewById(R.id.webView);
        web1.loadUrl("http://" + getDomain() + "/" + getFolderString() + "/" + phpdoc);
    }
    public String getDomain(){
        Switch switch3 = (Switch) findViewById(R.id.switch3);
        if(switch3.isChecked()){
            return "<Int. Domain/Host-Name ";
        }
        else{
            return "<Ext. Domain/Host-Name>";
        }
    }

    public String getFolderString(){
        return "<Ordner inkl. Suffix";
    }

    public void setCorrectMode() {
        Switch switch3 = (Switch) findViewById(R.id.switch3);
        TextView tv4 = (TextView) findViewById(R.id.textView4);
        TextView tv5 = (TextView) findViewById(R.id.textView5);
        if (switch3.isChecked()) {
            tv4.setText("Interner Modus:");
            tv5.setText(getDomain());
        } else {
            tv4.setText("Externer Modus:");
            tv5.setText(getDomain());
        }
    }
    public void setWebViewUrl(){
        WebView webView2 = (WebView) findViewById(R.id.webView2);
        webView2.loadUrl("http://" + getDomain() + "/" + getFolderString() + "/" + "pcinfo.php");
        reload();
    }
    public void reload() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setWebViewUrl();
            }
        }, 2000);
    }
}
