package cn.itcast.order.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.itcast.order.R;
import cn.itcast.order.utils.SharedPreferencesUtil;

public class LoginActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button login;
    private TextView register;
    private Handler handler;
    private ImageView img_start;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        handler = new Handler(message -> {
            if (message.what == 9000) {
                initView();
            }
            return false;
        });
        handler.sendEmptyMessageDelayed(9000, 3000);
    }

    private void initView() {
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        img_start = findViewById(R.id.img_start);
        icon = findViewById(R.id.icon);

        name.setVisibility(View.VISIBLE);
        password.setVisibility(View.VISIBLE);
        login.setVisibility(View.VISIBLE);
        register.setVisibility(View.VISIBLE);
        img_start.setVisibility(View.GONE);
        icon.setVisibility(View.VISIBLE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = name.getText().toString().trim();
                String s2 = password.getText().toString().trim();
                if (s1.isEmpty() || s2.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "请输入账号或密码", Toast.LENGTH_SHORT).show();
                } else if (s1.equals(SharedPreferencesUtil.getData(LoginActivity.this, "name", "")) && s2.equals(SharedPreferencesUtil.getData(LoginActivity.this, "password", ""))) {
                    Intent intent = new Intent(LoginActivity.this, ShopActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
            }
        });
    }
}