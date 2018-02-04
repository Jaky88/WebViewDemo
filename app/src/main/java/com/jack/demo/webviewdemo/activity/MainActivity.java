package com.jack.demo.webviewdemo.activity;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;

import com.jack.demo.webviewdemo.activity.model.ActivityMainModel;
import com.jack.demo.webviewdemo.R;
import com.jack.demo.webviewdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    String header =
            "<html><head>" +
            "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\" />\n" +
            "</head>" +
            "<body>";


    String footer = "</body>" +
            "</html>";
    String content =
            "<div style='font-family:宋体;'><span" +
                    "lang=EN-US style='font-family:" +
                    "\\\"Times New Roman\\\",\\\"serif\\\"'><o:p></o:p></span></p>" +
                    "<table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0" +
                    " style='margin-left:-5.4pt;border-collapse:collapse;mso-table-layout-alt:fixed;" +
                    " mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>" +
                    " <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>" +
                    "  <td width=332 valign=top style='width:249.2pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
                    "  <p class=MsoPlainText style='line-height:150%;tab-stops:212.65pt;layout-grid-mode:" +
                    "  char'><span lang=EN-US style='font-family:\\\"Times New Roman\\\"," +
                    "\\\"serif\\\"'><![if !vml]><img width=102 height=116" +
                    "  src=" +
                    "\\\"http://owiju9mp2.bkt.clouddn.com/Fii2vBwMZ6DCHachp_lTM-99nJcl\\\" alt=图片1 v:shapes=" +
                    "\\\"图片_x0020_21\\\"><![endif]><o:p></o:p></span></p>" +
                    "  </td>" +
                    "  <td width=332 valign=top style='width:249.2pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
                    "  <p class=MsoPlainText style='line-height:150%;tab-stops:212.65pt;layout-grid-mode:" +
                    "  char'><span lang=EN-US style='font-family:\\\"Times New Roman\\\",\\\"serif" +
                    "\\\"'><o:p>&nbsp;</o:p></span></p>" +
                    "  </td>" +
                    " </tr>" +
                    " <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>" +
                    "  <td width=332 valign=top style='width:249.2pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
                    "  <p class=MsoPlainText style='line-height:150%;tab-stops:212.65pt;layout-grid-mode:" +
                    "  char'><span style='mso-ascii-font-family:\\\"Times New Roman\\\";mso-hansi-font-family:" +
                    "  \\\"Times New Roman\\\"'>锌粒和稀硫酸制氢气</span><span lang=EN-US style='font-family:" +
                    "\\\"Times New Roman\\\",\\\"serif\\\"'><o:p></o:p></span></p>  </td>" +
                    "  <td width=332 valign=top style='width:249.2pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
                    "  <p class=MsoPlainText style='line-height:150%;tab-stops:212.65pt;layout-grid-mode:" +
                    "  char'><span lang=EN-US style='font-family:\\\"Times New Roman\\\",\\\"serif" +
                    "\\\"'><o:p>&nbsp;</o:p></span></p>" +
                    "  </td>" +
                    " </tr></table>" +
                    "<p class=MsoPlainText style='line-height:150%;tab-stops:212.65pt;layout-grid-mode:" +
                    "char'><span style='mso-ascii-font-family:\\\"Times New Roman\\\";mso-hansi-font-family:" +
                    "\\\"Times New Roman\\\"'></div>";
    
    String content1 = "<div style='font-family:宋体;'><spanlang=EN-US style='font-family:\\\"Times New Roman\\\",\\\"serif\\\"'><o:p></o:p></span></p><table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 style='margin-left:-5.4pt;border-collapse:collapse;mso-table-layout-alt:fixed; mso-padding-alt:0cm 5.4pt 0cm 5.4pt'> <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>  <td width=332 valign=top style='width:249.2pt;padding:0cm 5.4pt 0cm 5.4pt'>  <p class=MsoPlainText style='line-height:150%;tab-stops:212.65pt;layout-grid-mode:  char'><span lang=EN-US style='font-family:\\\"Times New Roman\\\",\\\"serif\\\"'><![if !vml]><img width=90 height=104  src=\\\"http://owiju9mp2.bkt.clouddn.com/FrA-niADiHETSsljGt6C898_FNF1\\\" alt=图片6 v:shapes=\\\"图片_x0020_23\\\"><![endif]><o:p></o:p></span></p>  </td>  <td width=332 valign=top style='width:249.2pt;padding:0cm 5.4pt 0cm 5.4pt'>  <p class=MsoPlainText style='line-height:150%;tab-stops:212.65pt;layout-grid-mode:  char'><span lang=EN-US style='font-family:\\\"Times New Roman\\\",\\\"serif\\\"'><o:p>&nbsp;</o:p></span></p>  </td> </tr> <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>  <td width=332 valign=top style='width:249.2pt;padding:0cm 5.4pt 0cm 5.4pt'>  <p class=MsoPlainText style='text-indent:10.5pt;mso-char-indent-count:1.0;  line-height:150%;tab-stops:212.65pt;layout-grid-mode:char'><span  style='mso-ascii-font-family:\\\"Times New Roman\\\";mso-hansi-font-family:\\\"Times New Roman\\\"'>萃取分液</span><span  lang=EN-US style='font-family:\\\"Times New Roman\\\",\\\"serif\\\"'><o:p></o:p></span></p>  </td>  <td width=332 valign=top style='width:249.2pt;padding:0cm 5.4pt 0cm 5.4pt'>  <p class=MsoPlainText style='line-height:150%;tab-stops:212.65pt;layout-grid-mode:  char'><span lang=EN-US style='font-family:\\\"Times New Roman\\\",\\\"serif\\\"'><o:p>&nbsp;</o:p></span></p>  </td> </tr></table><p class=MsoPlainText style='line-height:150%;tab-stops:212.65pt;layout-grid-mode:char'><span style='mso-ascii-font-family:\\\"Times New Roman\\\";mso-hansi-font-family:\\\"Times New Roman\\\"'></div>";
    private ActivityMainBinding bindingView;
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingView = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bindingView.setMainBean(new ActivityMainModel());
        bindingView.webTitle.webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        bindingView.webTitle.webview.getSettings().setUseWideViewPort(true);
        bindingView.webTitle.webview.loadDataWithBaseURL("about:blank",header +content+footer
                ,"text/html","UTF-8",null);

        bindingView.webTitle2.webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        bindingView.webTitle2.webview.getSettings().setUseWideViewPort(true);
        bindingView.webTitle2.webview.loadDataWithBaseURL("about:blank",header +content1+footer
                ,"text/html","UTF-8",null);
        FillHomeworkAdapter fillHomeworkAdapter = new FillHomeworkAdapter();
        bindingView.recyclerView.setAdapter(fillHomeworkAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
