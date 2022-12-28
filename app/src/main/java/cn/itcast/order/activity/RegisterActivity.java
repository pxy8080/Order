package cn.itcast.order.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.itcast.order.R;
import cn.itcast.order.utils.SharedPreferencesUtil;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText re_name=findViewById(R.id.re_name);
        EditText re_password=findViewById(R.id.re_password);
        TextView register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=re_name.getText().toString().trim();
                String b=re_password.getText().toString().trim();
                SharedPreferencesUtil.saveData(RegisterActivity.this,"name",a);
                SharedPreferencesUtil.saveData(RegisterActivity.this,"password",b);
                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}