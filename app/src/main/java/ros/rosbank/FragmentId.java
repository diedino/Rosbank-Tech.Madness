package ros.rosbank;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.AsyncTask;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FragmentId extends Fragment {
    TextView contentView;
    String contentText = null;
    WebView webView;
    public static TextView id;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_id, container, false);
        contentView = (TextView) view.findViewById(R.id.content);
        webView = (WebView) view.findViewById(R.id.webView);

        // если данные ранее были загружены
        if(contentText!=null){
            contentView.setText(contentText);
            webView.loadData(contentText, "text/html; charset=utf-8", "utf-8");
        }

        if(contentText==null){
            contentView.setText("Загрузка...");
            new ProgressTask().execute("https://developer.android.com/index.html");
        }
        return view;
    }

    private class ProgressTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... path) {

            String content;
            try{
                content = getContent(path[0]);
            }
            catch (IOException ex){
                content = ex.getMessage();
            }

            return content;
        }
        @Override
        protected void onPostExecute(String content) {

            contentText=content;
            contentView.setText(content);
            webView.loadData(content, "text/html; charset=utf-8", "utf-8");
            Toast.makeText(getActivity(), "Share Link downloaded", Toast.LENGTH_SHORT)
                    .show();

            id.setText("http://sharelink.com");
        }

        private String getContent(String path) throws IOException {
            BufferedReader reader=null;
            try {
                URL url=new URL(path);
                HttpsURLConnection c=(HttpsURLConnection)url.openConnection();
                c.setRequestMethod("GET");
                c.setReadTimeout(10000);
                c.connect();
                reader= new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder buf=new StringBuilder();
                String line=null;
                while ((line=reader.readLine()) != null) {
                    buf.append(line + "\n");
                }
                return(buf.toString());
            }
            finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
    }
}