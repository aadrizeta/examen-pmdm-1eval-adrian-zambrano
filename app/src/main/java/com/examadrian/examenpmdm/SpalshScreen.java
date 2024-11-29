package com.examadrian.examenpmdm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


public class SpalshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spalsh_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        launchLogin();

        Animation anim = AnimationUtils.loadAnimation(SpalshScreen.this, R.anim.gradientanim);
        ImageView logo = findViewById(R.id.logoApp);
        TextView nombre = findViewById(R.id.nombreApp);
        ImageView background = findViewById(R.id.background);
        background.startAnimation(anim);
        logo.startAnimation(anim);
        nombre.startAnimation(anim);

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzF8fG9jZWFub3xlbnwwfHwwfHx8MA%3D%3D")
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .centerCrop()
                .into(background);




    }
    public void launchLogin(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(SpalshScreen.this, Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        },3000);
    }
}