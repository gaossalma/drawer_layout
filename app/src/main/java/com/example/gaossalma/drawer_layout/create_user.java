package com.example.gaossalma.drawer_layout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.gaossalma.drawer_layout.API.ApiRequest;
import com.example.gaossalma.drawer_layout.API.RetroServer;
import com.example.gaossalma.drawer_layout.Model.ResponsModel;

import retrofit2.Call;

public class create_user extends AppCompatActivity{
    EditText id_user, fullname, username, e_mail, password, language, birthday,phone_number;
    Spinner gender, country;
    Button btn_create;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        fullname = (EditText) findViewById(R.id.fullname);
        e_mail = (EditText) findViewById(R.id.create_email);
        username = (EditText) findViewById(R.id.create_username);
        gender = (Spinner) findViewById(R.id.gender);
        country = (Spinner) findViewById(R.id.country);
        language = (EditText) findViewById(R.id.create_language);
        birthday = (EditText) findViewById(R.id.birthday);
        phone_number = (EditText) findViewById(R.id.phone_number);
        password = (EditText) findViewById(R.id.password);
        btn_create = (Button) findViewById(R.id.create_user);

        Intent data = getIntent();
        final String id_data = data.getStringExtra("id_user");
        if(id_data != null) {
            btn_create.setVisibility(View.GONE);
            fullname.setText(data.getStringExtra("fullname"));
            e_mail.setText(data.getStringExtra("e_mail"));
            language.setText(data.getStringExtra("language"));
            birthday.setText(data.getStringExtra("birthday"));
            phone_number.setText(data.getStringExtra("phone_number"));
            password.setText(data.getStringExtra("domisili"));
        }

        pd = new ProgressDialog(this);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setMessage("send data ... ");
                pd.setCancelable(false);
                pd.show();

                String sfullname = fullname.getText().toString();
                String se_mail = e_mail.getText().toString();
                String slanguage = language.getText().toString();
                String sbirthday = birthday.getText().toString();
                String sphone_number = phone_number.getText().toString();
                String spassword = password.getText().toString();

                ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
                //Call<ResponsModel> sendbio = api.sendUser(sfullname, se_mail,slanguage,sbirthday,sphone_number,spassword);

            }
        });

    }
    public void goCreate(View view){
        Intent goCreate = new Intent(create_user.this, MainActivity.class);
        startActivity(goCreate);
    }
private class getcountry extends AsyncTask<Void, Void, Void>{

    @Override
    protected Void doInBackground(Void... voids) {

        return null;
    }
}

}