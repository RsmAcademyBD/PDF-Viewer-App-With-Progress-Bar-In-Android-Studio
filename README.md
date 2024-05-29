# PDF Viewer App With ProgressBar In Android Studio
# Presenting brand new Article:
 In this article you will learn how to create bottom sheet dialog App in Android Studio. Just follow the steps in the Article.
More article about Android Application Development will uploaded so get in touch with the channel. So you are no more far. You can be 
developer. 

## Step 1: Creating a new project

- Open a new project.
- We will be working on Empty Views Activity with language as Java. Leave all other options unchanged.
- You can change the name of the project at your convenience.
- There will be two default files named activity_main.xml and MainActivity.java.

## Step 2: Navigate to Build scripts > build.gradle(Module) file and add the following dependency to it and Syne Now
```js
implementation 'com.github.barteksc:android-pdf-viewer:3.2.0-beta.1'
```

## Step 3: Navigate to Build scripts > settings.gradle(Project Settings) file and add the following dependency to it and Syne Now
```js
 maven {url('https://jcenter.bintray.com')}
```

## Step 4: Navigate to Build scripts > gradle.proparties(Project Proparties) file and add the following dependency to it and Syne Now
```js
 android.enableJetifier=true
```

## Step 5: Open res -> layout ->activity_main.xml (or) main.xml and add following code:

In this step we open an XML file and add the code :-
```xml
   <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">


    <ProgressBar
        android:id="@+id/progressBar"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />

    <com.github.barteksc.pdfviewer.PDFView
        android:id="@+id/pdfView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</LinearLayout>
```
## Step 6: Open Java -> package – > MainActivity.Java and add following code:

In this step we open an Java file and add the code :-
```java
package com.rsmacademy.pdfviewerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;


/**
 * Created by RSM Developer on 29-05-2024
 * Follow Facebook : https://www.facebook.com/RsmItAcademyBD
 * Subscribe YouTube : https://www.youtube.com/@RsmAcademyBD
 * GitHub : https://github.com/rsmacademybd
 * Developed Your Creativity With RSM Academy BD
 **/

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;
    ProgressBar progressBar;
    public static String pdfUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pdfView = findViewById(R.id.pdfView);
        progressBar = findViewById(R.id.progressBar);

        pdfView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        pdfView.fromAsset(pdfUrl)
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {
                        pdfView.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Total pages: " + nbPages, Toast.LENGTH_SHORT).show();
                    }
                })
                .load();
    }
}
```
## Step 7: Create a New Empty Activity with language as
Java :-Open ->res -> layout ->activity_main2.xml and add following code:

In this step we open an XML file and add the code :-
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    tools:context=".OpenActivity">

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button" />

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button2" />

    <Button
        android:id="@+id/button3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button3" />

    <Button
        android:id="@+id/button4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button4" />
</LinearLayout>
```
## Step 8: Open -> package – > MainActivity2.Java and add the following code.
In this step we open an Java file and add the code :-
```java
package com.rsmacademy.pdfviewerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Method;

public class OpenActivity extends AppCompatActivity {
Button button, button2, button3, button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_open);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pdfUrl = "ck1.pdf";
                Intent intent = new Intent(OpenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//==============================================================
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pdfUrl = "ck2.pdf";
                Intent intent = new Intent(OpenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//        ========================================
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pdfUrl = "ck3.pdf";
                Intent intent = new Intent(OpenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//        ========================================
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pdfUrl = "ck4.pdf";
                Intent intent = new Intent(OpenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//        ========================================


    }
}
```
