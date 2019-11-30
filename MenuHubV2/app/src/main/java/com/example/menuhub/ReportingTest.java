package com.example.test;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static org.junit.Assert.*;

public class ReportingTest {
    private Reporting reporting = new Reporting();
    @Before
    public void setUp() throws Exception {
        Reporting reporting  = new Reporting();
        Bundle savedInstanceState = new Bundle();
        String filename, description;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreateTest() {
        View view = reporting.findViewById(R.id.Name);
        view = reporting.findViewById(R.id.Description);
        view = reporting.findViewById(R.id.submitButton);
        assertNotNull(view);
        assertEquals(Null, reporting.onCreate(savedInstanceState));
    }

    @Test
    public void saveTextTest(){

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);
        try (FileOutputStream output = new FileOutputStream(file)) {
            output.write(description.getBytes());
            assertEquals(Null, reporting.saveText(filename, description));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void onRequestPermissionsResultTest() {
        int requestCode = 1000;
        String[] permissions = {"Permission Granted", "Permission not Granted"};
        int[] grantResults = new int[100];

        assertEquals(Null, reporting.onRequestPermissionsResult(requestCode, permissions,grantResults));

    }
}