package android.example.androidapp;

import android.example.androidapp.model.Blog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class BlogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);
    }

    @Override
    protected void onStart() {
        super.onStart();

        String url = "https://jsonplaceholder.typicode.com/posts";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request
                = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Log.w("Blogs", response);

                Gson gson = new Gson();
                List<Blog> blogs
                        =  gson.fromJson(response,
                            new TypeToken<List<Blog>>(){}.getType());
                for(Blog blog : blogs){
                    Log.w("Blogs", blog.getId()+ "");
                    Log.w("Blogs", blog.getTitle());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w("Blogs", error.getMessage());
            }
        });
        requestQueue.add(request);

    }
}
