package com.example.wlw.myzuoye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button=(Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=((EditText)findViewById(R.id.user)).getText().toString();
                String pwd=((EditText)findViewById(R.id.pwd)).getText().toString();
                boolean flag=false;
                String index="";
                //通过便利数据的形式判断输入的账号和密码是否正确
                for(int i=0;i<Data.user.length;i++)
                {
                    if (user.equals(Data.user[i][0]))
                    {
                        if (pwd.equals(Data.user[i][0]))
                        {
                            index=Data.user[i][2];
                            flag=true;
                            break;
                        }

                    }
                    if(flag)
                    {

                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("index",Integer.parseInt(index));
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    else
                    {

                        Toast toast=Toast.makeText(LoginActivity.this,"您输入的信息有误",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM,0,0);
                        toast.show();
                    }
                }
            }
        });
    }
}
