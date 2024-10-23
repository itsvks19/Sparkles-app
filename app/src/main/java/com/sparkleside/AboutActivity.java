package com.sparkleside;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import com.sparkleside.databinding.ActivityAboutBinding;
import com.sparkleside.component.ContributorView;

import java.net.URI;

import com.peekandpop.shalskar.peekandpop.PeekAndPop;

public class AboutActivity extends AppCompatActivity {
    private ActivityAboutBinding binding;
    private Intent intent ;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        configureToolbar();
        configureSuperContributors();
		configureLinks();
		configureContributors();
		
        PeekAndPop peekAndPop = new PeekAndPop.Builder(this)
            .peekLayout(R.layout.about_preview)
            .longClickViews(binding.syn)
            .build();
    }
    
    private void configureToolbar() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        
        binding.toolbar.setNavigationOnClickListener(v -> {
            super.onBackPressed();
        });
    }
    
    private void configureSuperContributors() {
        Glide
            .with(this)
            .load("https://github.com/syntaxspin.png")
            .into(binding.imgSyn);
        Glide
            .with(this)
            .load("https://github.com/hanzodev1375.png")
            .into(binding.imgHanzo);
        Glide
            .with(this)
            .load("https://github.com/trindadedev13.png")
            .into(binding.imgTrindade);
    }
    
    private void configureLinks() {
        binding.tg.setOnClickListener(v->{
            String url = "https://www.telegram.me/sparkleside";
            openURL(url);
        });
        
        binding.github.setOnClickListener(v->{
            String url2 = "https://github.com/sparkleside/sparkles-app";
            openURL(url2);
        });
        
        binding.hanzo.setOnClickListener(v->{
            String url3 = "https://github.com/hanzodev1375";
            openURL(url3);
        });
        
        binding.syn.setOnClickListener(v->{
            String url4 = "https://github.com/syntaxspin";
            openURL(url4);
        });
        
        binding.trindade.setOnClickListener(v->{
            String url5 = "https://github.com/trindadedev13";
            openURL(url5);
        });
    }
    
    private void configureContributors() {
        newContributor(
            "Yamenher",
            "Developer",
            "https://github.com/yamenher",
            true
        );
        
        newContributor(
            "Thiarley Rocha",
            "Developer",
            "https://github.com/thdev-only",
            true
        );
        
        newContributor(
            "Rohit Kushvaha",
            "Developer",
            "https://github.com/RohitKushvaha01",
            true
        );
        
        newContributor(
            "Jaiel Lima Miranda",
            "Developer",
            "https://github.com/jetrom17",
            false
        );
    }
    
    private void newContributor(String name, String description, String url, boolean hasDivider) {
        var c = new ContributorView(this);
        c.setName(name);
        c.setDescription(description);
        c.setImageURL(url + ".png");
        c.setURL(url);
        c.setHasDivider(hasDivider);
        binding.contributors.addView(c);
    }
    
    private void openURL(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
