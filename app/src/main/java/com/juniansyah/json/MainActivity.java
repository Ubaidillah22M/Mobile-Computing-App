package com.juniansyah.json;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.juniansyah.json.Adapter.AdapterData;
import com.juniansyah.json.Model.ModelData;
import com.juniansyah.json.Util.AppController;
import com.juniansyah.json.Util.ServerAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mrecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    List<ModelData> mItems;
    Button insert, delete;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        insert = (Button) findViewById(R.id.btninsert);
        delete = (Button) findViewById(R.id.btndelete);
        pd = new ProgressDialog(MainActivity.this);
        mItems = new ArrayList<>();

        loadJson();

        mManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        mrecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterData(MainActivity.this, mItems);
        mrecyclerview.setAdapter(mAdapter);
    }
    private void loadJson() {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();
        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, ServerAPI.URL_DATA, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        pd.cancel();
                        Log.d("volley","response : " + response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelData md = new ModelData();
                                md.setNim(data.getString("nim"));
                                md.setNama(data.getString("nama"));
                                md.setProdi(data.getString("prodi"));
                                md.setFakultas(data.getString("fakultas"));
                                mItems.add(md);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Log.d("volley", "error :" + error.getMessage());
                    }
                });
        AppController.getInstance().addToRequestQueue(reqData);
    }
}
