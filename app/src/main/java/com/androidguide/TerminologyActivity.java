package com.androidguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;


public class TerminologyActivity extends ActionBarActivity {

    private AutoCompleteTextView termsAC;
    private TextView resultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminology);
        termsAC = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        resultsTextView = (TextView) findViewById(R.id.textView3);
        String[] terms = getResources().getStringArray(R.array.terminology_list);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,terms);
        termsAC.setAdapter(adapter);
        termsAC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {
                String msg = "Term not found.";
                if (termsAC.getText().toString().equals("adb")) msg = "adb stands for android debug bridge. This command gives a developer the tools needed to directly access an android device for debugging purposes. It provides access to many tools such as pushing files, pulling files, sideload and a shell for command line access.";
                if (termsAC.getText().toString().equals("emulator")) msg = "The emulator command lets you start and stop andvoid virtual devices (avd). This is necessary if you want to have a \"fake\" android device to perform debugging on. It is essentially a virtual machine that runs the Android OS.";
                if (termsAC.getText().toString().equals("android")) msg = "his command gives you access to general android tools in relation to your android project. It lets you list and manage sdks, list and manage avds, create and manage projects, and a few others.";
                if (termsAC.getText().toString().equals("screenshot2")) msg = "This command lets you create a screenshot of your android device. (NOTE: In my Windows setup, this command was broken due to \"Use Host GPU\" setting! Please see email for more information.)";
                if (termsAC.getText().toString().equals("gradle")) msg = "This command lets you utilize the package manager for our project. It downloads and maintains all dependencies that your package may have. An example of a command you can use is \"gradle build\" which will not only check dependencies and download any that are needed, but it will also compile your project into an APK for you!";
                if (termsAC.getText().toString().equals("pm")) msg = "pm stands for package manager. It is a command that is found directly within the android shell, instead of on your own OS. It is used for tasks such as listing or removing packages, or getting more information about packages.";
                if (termsAC.getText().toString().equals("lint")) msg = "Lint is a source code analysis tool used to determine any bugs or issues that may be present in your code. When used in this lab,it went over all of my android code and created a report of any bugs, or possible optimizations, that could be found within my project. In this project, we also used a feature of lint that allowed it to create the report in HTML format, for easy viewing.";
                if (termsAC.getText().toString().equals("project")) msg = "A project is a group of code, resources and solutions that are stored together to accomplish a similar goal.It consists of the entire directory tree of the project along with any libraries it may use. It is essentially a completed android app.";
                if (termsAC.getText().toString().equals("panel")) msg = "A panel in android studio is a section of the screen devoted to a single purpose. For example, there is the Project panel, which shows all related files to your project, and there is the Component Tree panel, which shows the drilldown to each element on your device's screen. There are many others.";
                if (termsAC.getText().toString().equals("toolbar")) msg = "A toolbar in android studio contains buttons that lead to certain tools within android studio. Usually each toolbar has buttons to tools that are related. For example, one segment of the main toolbar contains the SDK Manager, the AVD Manager, and the Android Device Monitor.";
                if (termsAC.getText().toString().equals("status bar")) msg = "The status bar is found on an Android Device at the very top of the screen. It shows notifications, battery life, if the volume is off, the time, etc etc. It is a summary of the device's status.";
                if (termsAC.getText().toString().equals("preview pane")) msg = "The preview pane contains a visual representation of how your screen will look, WITHOUT actually running the application. It essentially is a preview of how the screen will render, before it renders.";
                if (termsAC.getText().toString().equals("android pane")) msg = "The android pane essentially shows all aspects of the android project, such as source code files, libraries, and pictures, BUT it limits this view only to files that you commonly want to edit within android studio.  It also shows the Gradle Scripts section in my particular setup. It is essentially a big-picture view of your android project.";
                if (termsAC.getText().toString().equals("project explorer")) msg = "The project explorer gives a view of the project that is far more oriented on the filestructure. It shows all files that are in your project folder, even those that aren't displayed within the android pane. For example, it shows the gradle.build file, while the android pane does not.";
                if (termsAC.getText().toString().equals(".idea folder")) msg = "This folder is responsible for storing metadata specific to android studio, such as gradle information and it also has a libraries folder. In summary it is a folder about android studio that could apply to all related modules.";
                if (termsAC.getText().toString().equals("intellisense")) msg = "Intellisense is the feature of android studio that auto-completes code for you. It is an intelligent interpreter that can try and figure out what it is that you are trying to accomplish and streamline the process for you.";
                if (termsAC.getText().toString().equals("module")) msg = "A module is essentially a building block of an app. An app can consist of several modules. Each module is separately buildable and testable, and usually contains related code to accomplish related tasks.";
                if (termsAC.getText().toString().equals("live layout")) msg = "The live layout feature of Android Studio essentially shows layout changes instantly, as you make them. It removes the need to compile or run any code to see your layout, and you don't have to commit any changes. It simply shows the layout changes instantly as they are made, or \"live\".";
                if (termsAC.getText().toString().equals("init")) msg = "This command initializes a local git repository in the local folder. (Note: Does not appear on github without a push!)";
                if (termsAC.getText().toString().equals("commit")) msg = "The commit command applies any changes that you have made to your local repository.";
                if (termsAC.getText().toString().equals("push")) msg = "The push command applies any commits that you have made to the repository on GitHub. It essentially uploads the most recent code.";
                if (termsAC.getText().toString().equals("add")) msg = "This command adds files to the repository and causes them to be under version control.";
                if (termsAC.getText().toString().equals("pull")) msg = "This downloads any commits that were made to the remote GitHub repository.";
                if (termsAC.getText().toString().equals("branch")) msg = "This allows you to both check which branches exist, and switch to a different branch. Branching is a way for you to change code in your own separate area, and keep it separate until you are ready to merge it back in.";
                if (termsAC.getText().toString().equals("clone")) msg = "This command allows you to copy a github repository and modify it as you please.";
                resultsTextView.setText(msg);
                Toast.makeText(getApplicationContext(),termsAC.getText().toString(), Toast.LENGTH_LONG).show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            showHelp();
            return true;
        }
        else if (id == R.id.action_about) {
            showAbout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showHelp() {
        Intent i = new Intent(getBaseContext(), HelpActivity.class);
        startActivity(i);
    }

    public void showAbout() {
        Intent i = new Intent(getBaseContext(), AboutActivity.class);
        startActivity(i);
    }
}
