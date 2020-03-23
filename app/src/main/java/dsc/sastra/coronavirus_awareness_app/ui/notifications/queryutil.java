package dsc.sastra.coronavirus_awareness_app.ui.notifications;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class queryutil {
    private static final String LOG_TAG = queryutil.class.getSimpleName();
private queryutil()
{}
private static List<country> extractCOuntryfromJson(String cjson)
{
    if(TextUtils.isEmpty(cjson))
    {
        return null;
    }
    List<country> cn=new ArrayList<country>();
    try
    {
        JSONObject baseresponse=new JSONObject(cjson);
        JSONArray jarr = baseresponse.getJSONArray("countries");
        JSONObject obj=jarr.getJSONObject(0);

        //String cname[]=Object.keys(obj);
        Iterator<String> itr=(Iterator<String>)obj.keys();
     /*  for(int i=0;i<obj.length();i++)
        {
            JSONObject currentobj=obj.getJSONObject(i);
            JSONArray cname=currentobj.names();*/
            while(itr.hasNext()){
                String cnameVal= (String)itr.next();
                JSONObject currentobj=obj.getJSONObject(cnameVal);
                String aff = "Confirmed :"+currentobj.getString("confirmed");
                String death = "Dead :"+currentobj.getString("deaths");
                String rec = "Recovered :"+currentobj.getString("recovered");
                country c = new country(cnameVal, death, aff, rec);
                cn.add(c);
            }
      //  }*/
    }
    catch(Exception e)
    {
        Log.e(LOG_TAG, "Problem retrieving the book JSON results.", e);
    }
    return cn;
}

private static URL createurl(String stringurl)
{
    URL url=null;
    try {

            url=new URL(stringurl);

    }
    catch(Exception e)
    {
        Log.e(LOG_TAG, "Problem retrieving the book JSON results.", e);
    }
    return url;
}

private static String makehttprequest(URL url)
{
    String jresponse="";
    if(url==null)
        return jresponse;
    HttpURLConnection con=null;
    InputStream istream=null;

    try
    {
        con=(HttpURLConnection)url.openConnection();
        con.setReadTimeout(10000);
        con.setConnectTimeout(20000);
        con.setRequestMethod("GET");
        con.connect();

        if(con.getResponseCode()==200)
        {
            istream=con.getInputStream();
            jresponse=readfromstream(istream);
        }

        istream.close();
    }
    catch (Exception e)
    {
       Log.e(LOG_TAG, "Problem retrieving the book JSON results.", e);
    }
    finally
    {
        if(con!=null)
        {
            con.disconnect();
        }

    }
    return jresponse;
}

    private static String readfromstream(InputStream istream)
    {
        StringBuilder sb=new StringBuilder();

        if(istream!=null)
        {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(istream));
                String l;
                while ((l = br.readLine()) != null)
                {
                    sb.append(l);
                }
            }
            catch(Exception e)
            {
                Log.e(LOG_TAG, "Problem retrieving the book JSON results.", e);
            }

        }
        return sb.toString();
    }

    public static List<country> fetchdata(String surl)
    {
        URL url=createurl(surl);
        String res="";
        try {

               res=makehttprequest(url);


        }
        catch (Exception e)
        {
            Log.e(LOG_TAG, "Problem retrieving the book JSON results.", e);
        }
        List<country> con=extractCOuntryfromJson(res);
        return con;
    }

}
